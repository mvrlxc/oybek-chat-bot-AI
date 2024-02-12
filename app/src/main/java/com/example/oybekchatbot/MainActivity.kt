package com.example.oybekchatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalViewConfiguration
import com.example.oybekchatbot.data.GrayO
import com.example.oybekchatbot.screens.chat_screen.ChatScreen
import com.example.oybekchatbot.ui.theme.OybekchatbotTheme
import com.example.oybekchatbot.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            OybekchatbotTheme {
                window.statusBarColor = getColor(R.color.gray)
                window.navigationBarColor = getColor(R.color.gray)

                OybekApp()

            }
        }
    }
}




