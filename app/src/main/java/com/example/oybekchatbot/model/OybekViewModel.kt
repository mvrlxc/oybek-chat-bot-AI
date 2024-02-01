package com.example.oybekchatbot.model

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.oybekchatbot.data.OybekColors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OybekViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OybekUiState())
    val uiState: StateFlow<OybekUiState> = _uiState.asStateFlow()


    fun updateTextFieldValue(input: String) {
        _uiState.update {currentState ->
            currentState.copy(
                textFieldValue = input
            )
        }
        //_uiState.value = OybekUiState(textFieldValue = input.toString())
    }

    fun onStarClicked() {
        _uiState.update {currentState ->
            currentState.copy(
                starColor = OybekColors.StarColors.random()
            )
        }
    }
}


