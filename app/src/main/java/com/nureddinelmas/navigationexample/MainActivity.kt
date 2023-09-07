package com.nureddinelmas.navigationexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nureddinelmas.navigationexample.ui.theme.NavigationExampleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedViewModel: SharedViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            NavigationExampleTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "profile") {
                    composable("profile") { Profile(navController, sharedViewModel) }
                    composable("mainmenu") { MainMenu(navController) }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Profile(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val  transactions = sharedViewModel.state.value
    val materialBlue700 = Color(0xFF1976D2)

    Scaffold(
        topBar = { TopAppBar(title = { Text("Profile Page") }, backgroundColor = materialBlue700) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {
sharedViewModel.insertData(Transaction(0,"Nureddin", "Elmas"))
//                navController.navigate("main-menu") {
//                    popUpTo("profile")
//                }
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "ADD")
            }
        },

        content = {


            LazyColumn(modifier = Modifier.fillMaxSize()) {


                items(items = transactions) { t ->
                    Text(text = t.city)

                }
            }


        },
        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } },
        backgroundColor = Color.Cyan
    )

}

@Composable
fun MainMenu(navController: NavController) {
    val materialBlue700 = Color(0xFF1976D2)
    Scaffold(
        backgroundColor = Color.Green,
        topBar = {
            TopAppBar(
                title = { Text("Main Menu Page") },
                backgroundColor = materialBlue700
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("profile")
            }) {
                Text("X")
            }
        },

        content = { Text("MAIN MENU SIDAN") },
        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )
}