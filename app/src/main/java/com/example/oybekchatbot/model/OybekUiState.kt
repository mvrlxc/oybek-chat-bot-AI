package com.example.oybekchatbot.model

import androidx.compose.ui.graphics.Color
import com.example.oybekchatbot.ui.theme.Purple40

data class OybekUiState(
    val textFieldValue: String = "",
    val starColor: Color = Color.White,
    val backGroundColor: Color = Purple40,
)