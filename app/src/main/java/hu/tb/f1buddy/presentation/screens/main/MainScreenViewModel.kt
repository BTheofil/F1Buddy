package hu.tb.f1buddy.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.network.domain.model.Session
import hu.tb.network.domain.model.SessionParam
import hu.tb.network.domain.repository.OpenF1Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val openF1Repository: OpenF1Repository
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    data class UiState(
        val sessions: List<List<Session>> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null,
    )

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            openF1Repository.getSession(
                sessionParam = SessionParam(
                    year = LocalDate.now(),
                    /*dateParam = DateParam(
                        endData = LocalDate.now(),
                        startDate = LocalDate.of(2024, Month.JANUARY, 1)
                    )*/
                )
            )
                .onSuccess { sessionList ->
                    _state.update {
                        it.copy(
                            sessions = createSessionPack(sessionList),
                            isLoading = false
                        )
                    }
                }
                .onFailure { error ->
                    _state.update {
                        it.copy(
                            error = error.stackTraceToString(),
                            isLoading = false
                        )
                    }
                }
        }
    }

    private fun createSessionPack(sessionList: List<Session>): List<List<Session>> =
        sessionList.groupBy { it.circuitShortName }.values.toList()

}