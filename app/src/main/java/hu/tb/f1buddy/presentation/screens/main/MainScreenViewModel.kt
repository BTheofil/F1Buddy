package hu.tb.f1buddy.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.network.domain.model.DriverInformation
import hu.tb.network.domain.repository.DriverRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val driverRepository: DriverRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    data class UiState(
        val data: DriverInformation? = null,
        val isLoading: Boolean = false,
        val error: String? = null,
    )

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            driverRepository.getDriverInformation(1, 9158)
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