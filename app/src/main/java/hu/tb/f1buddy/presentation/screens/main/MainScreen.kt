package hu.tb.f1buddy.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column {
        if (state.isLoading){
            CircularProgressIndicator()
        } else {
            Text(text = state.data!!.fullName)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}