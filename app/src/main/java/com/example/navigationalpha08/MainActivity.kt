package com.example.navigationalpha08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.navigationalpha08.ui.theme.NavigationAlpha08Theme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationAlpha08Theme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteScreenA
    ) {
        composable<RouteScreenA> {
            ScreenA(navController)
        }
        composable<RouteScreenB> {
            val (id) = it.toRoute<RouteScreenB>()
            ScreenB(navController, id)
        }
    }
}

@Serializable
object RouteScreenA

@Serializable
data class RouteScreenB(
    val id: Int
)

@Composable
fun ScreenA(
    navController: NavHostController
) {
    Column {
        Text(text = "Screen A")
        Button(onClick = {
            navController.navigate(
                RouteScreenB(id = 1)
            )
        }) {
            Text(text = "Go ScreenB")
        }
    }
}

@Composable
fun ScreenB(
    navController: NavHostController,
    id: Int,
) {
    Column {
        Text(text = "Screen B with id $id")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Go back Screen A")
        }
    }
}