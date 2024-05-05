package hu.tb.f1buddy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.tb.f1buddy.presentation.navigation.MainNavigation
import hu.tb.f1buddy.presentation.ui.theme.F1BuddyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1BuddyTheme {
                val navController = rememberNavController()
                Scaffold {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ){
                        MainNavigation(navController = navController)
                    }
                }
            }
        }
    }
}