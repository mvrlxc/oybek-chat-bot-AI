package com.example.oybekchatbot.model

import android.icu.text.SimpleDateFormat
import androidx.activity.compose.BackHandler
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.oybekchatbot.OybekScreen
import com.example.oybekchatbot.data.OybekColors
import com.example.oybekchatbot.screens.chat_screen.To
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date
import kotlin.system.exitProcess
import android.os.Bundle
import android.app.Activity

class OybekViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OybekUiState())
    val uiState: StateFlow<OybekUiState> = _uiState.asStateFlow()


    fun updateTextFieldValue(input: String) {
        _uiState.update { currentState ->
            currentState.copy(
                textFieldValue = input,
                isSendButtonActive = input.isNotEmpty(),
            )
        }


        //_uiState.value = OybekUiState(textFieldValue = input.toString())
    }

    fun onStarClicked() {
        _uiState.update { currentState ->
            currentState.copy(
                starColor = OybekColors.StarColors.random()
            )
        }
    }

    private fun getCurrentTime(): String {

        val sdf = SimpleDateFormat("hh:mm")
        val currentDate = sdf.format(Date())
        return currentDate.toString()
    }


    fun onMessageSent(messageText: String) {
        _uiState.update { currentState ->
            currentState.copy(
                messages = _uiState.value.messages.plus(
                    Messages(text = messageText, messageType = To, timeSent = getCurrentTime())
                ),
                textFieldValue = "",
                isSendButtonActive = false
            )
        }
    }

    fun onColorClick(color: Color) {
        _uiState.update { currentState ->
            currentState.copy(
                messageBackgroundColor = color,
            )
        }
    }

    fun backNavigation(
        navController: NavHostController,
        currentScreen: OybekScreen,
        menuScreen: menuScreens,
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                menuScreen = menuScreens.MainScreen
            )

        }
        if (currentScreen == OybekScreen.MENUSCREEN && menuScreen == menuScreens.MainScreen) {
            navController.navigate(OybekScreen.CHATSCREEN.name) {
                popUpTo(OybekScreen.CHATSCREEN.name) {
                    inclusive = true
                }
            }


        } else if (currentScreen == OybekScreen.CHATSCREEN) {
            _uiState.update { currentState ->
                currentState.copy(
                    menuScreen = menuScreens.MainScreen
                )

            }
            navController.navigate(OybekScreen.MENUSCREEN.name) {
                popUpTo(OybekScreen.MENUSCREEN.name) {
                    inclusive = true
                }

            }
        }
    }

    fun menuNavigation(
        navController: NavHostController,

        ) {
        navController.navigate(OybekScreen.MENUSCREEN.name) {
            popUpTo(OybekScreen.CHATSCREEN.name) {
                inclusive = false
            }
        }
    }

    fun designNavigation(

    ) {
        _uiState.update { currentState ->
            currentState.copy(
                menuScreen = menuScreens.DesignScreen
            )

        }
    }


    fun toMenuNavigation(

    ) {
        _uiState.update { currentState ->
            currentState.copy(
                menuScreen = menuScreens.MainScreen
            )

        }
    }



    fun backHandler(navController: NavHostController){
        navController.navigate(OybekScreen.CHATSCREEN.name){
            popUpTo(OybekScreen.CHATSCREEN.name) {
                inclusive = false
            }
        }
    }
}







