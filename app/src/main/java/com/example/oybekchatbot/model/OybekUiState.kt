package com.example.oybekchatbot.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.oybekchatbot.OybekScreen
import com.example.oybekchatbot.screens.chat_screen.MessageType
import com.example.oybekchatbot.ui.theme.Purple40
import com.example.oybekchatbot.ui.theme.PurpleGrey40

data class Messages(
    val messageType: MessageType,
    val text: String,
    val timeSent: String
)

data class OybekUiState(
    var textFieldValue: String = "",
    val starColor: Color = Color.White,
    val messageBackgroundColor: Color = Color.White,
    var messages: List<Messages> = mutableListOf(),
    val backgroundColor: Color = Color.Black,
    var isSendButtonActive: Boolean = false,
    var topAppBarText: String = "Oybek Chat Bot",
)