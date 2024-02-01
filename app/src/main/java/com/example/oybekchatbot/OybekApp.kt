package com.example.oybekchatbot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oybekchatbot.model.OybekViewModel
import com.example.oybekchatbot.screens.chat_screen.ChatScreen

enum class OybekScreen() {
    CHATSCREEN
}


@Composable
fun OybekApp(
    viewModel: OybekViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()


    NavHost(
        navController = navController,
        startDestination = OybekScreen.CHATSCREEN.name,
    ) {
        composable(OybekScreen.CHATSCREEN.name) {
            ChatScreen(
                onValueChange = {viewModel.updateTextFieldValue(it)},
                value = uiState.textFieldValue,
                onSendClicked = {  },
                backGroundColor = uiState.backGroundColor,
                starColor = uiState.starColor,
                onStarClicked = { viewModel.onStarClicked() }
            )


        }
    }
}
