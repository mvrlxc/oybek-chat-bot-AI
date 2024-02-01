package com.example.oybekchatbot.data

import androidx.compose.ui.graphics.Color
import com.example.oybekchatbot.screens.chat_screen.From
import com.example.oybekchatbot.screens.chat_screen.MessageType
import com.example.oybekchatbot.screens.chat_screen.To
import com.example.oybekchatbot.ui.theme.PurpleGrey40

data class Messages(
    val messageType: MessageType,
    val text: String,
    val backgroundColor: Color = PurpleGrey40
)

val MessagesList: List<Messages> = listOf(
    Messages(
        messageType = From,
        text = "huy huy huy",
    ),
    Messages(
        messageType = To,
        text = "huy huy huy",
    ),
    Messages(
        messageType = From,
        text = "huy huy huy",
    ),
    Messages(
        messageType = To,
        text = "huy huy huy",
    ),
    Messages(
        messageType = From,
        text = "huy huy huy",
    ),
    Messages(
        messageType = To,
        text = "huy huy huy",
    ), Messages(
        messageType = To,
        text = "huy huy huy",
    ),
    Messages(
        messageType = From,
        text = "huy huy huy",
    ),
    Messages(
        messageType = To,
        text = "huy huy huy",
    ),
    Messages(
        messageType = From,
        text = "huy huy huy",
    ),
    Messages(
        messageType = To,
        text = "huy huy huy",
    )
)
