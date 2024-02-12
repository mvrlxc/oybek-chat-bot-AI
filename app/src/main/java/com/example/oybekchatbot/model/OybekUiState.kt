package com.example.oybekchatbot.model

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.oybekchatbot.OybekScreen
import com.example.oybekchatbot.data.GrayO
import com.example.oybekchatbot.screens.chat_screen.MessageType
import com.example.oybekchatbot.ui.theme.Purple40
import com.example.oybekchatbot.ui.theme.PurpleGrey40

data class Messages(
    val messageType: MessageType,
    val text: String,
    val timeSent: String
)

enum class menuScreens {
    MainScreen(),
    DesignScreen(),
}

data class OybekUiState(
    //chat
    var textFieldValue: String = "",
    var messages: List<Messages> = mutableListOf(),
    var isSendButtonActive: Boolean = false,

    //nav
    val menuScreen: menuScreens = menuScreens.MainScreen,
    var topAppBarText: String = "Oybek Chat Bot",

    //colors
    val messageBackgroundColor: Color = Color.Cyan,
    val backgroundColor: Color = Color.Black,
    val secondaryColor: Color = GrayO,
    val starColor: Color = Color.White,
)