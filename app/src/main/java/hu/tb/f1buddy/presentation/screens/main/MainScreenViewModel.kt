package hu.tb.f1buddy.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.network.domain.model.DateParam
import hu.tb.network.domain.model.DriverInfo
import hu.tb.network.domain.model.SessionParam
import hu.tb.network.domain.repository.OpenF1Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val openF1Repository: OpenF1Repository
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    data class UiState(
        val data: DriverInfo? = null,
        val isLoading: Boolean = false,
        val error: String? = null,
    )

    init {
        viewModelScope.launch {
            openF1Repository.getSession(sessionParam = SessionParam(
                dateParam = DateParam(
                    endData = LocalDate.now(),
                    startDate = LocalDate.of(2024, Month.JANUARY, 1)
                )
            ))
                .onSuccess {
                    it.forEach {
                        Log.d("MYTAG", it.toString())
                    }
                }
                .onFailure {
                    Log.d("MYTAG", it.stackTraceToString())
                }
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            openF1Repository.getDriverInformation(1, 9158)
                .onSuccess { data ->
                    _state.update {
                        it.copy(
                            data = data,
                            isLoading = false,
                        )
                    }
                }
                .onFailure {
                    _state.update { it.copy(error = "Can not fetch data") }
                }
        }
    }
}