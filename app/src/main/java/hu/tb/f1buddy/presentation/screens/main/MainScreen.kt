package hu.tb.f1buddy.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hu.tb.f1buddy.presentation.screens.main.components.SessionItem

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(state.sessions) { sessionPack ->
                    SessionItem(
                        dateStart = sessionPack.first().dateStart,
                        dateEnd = sessionPack.last().dateEnd
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}