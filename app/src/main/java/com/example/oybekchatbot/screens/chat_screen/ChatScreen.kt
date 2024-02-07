package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.oybekchatbot.model.Messages
import com.example.oybekchatbot.ui.theme.PurpleGrey40

@Composable
fun ChatScreen(
    onValueChange: (String) -> Unit,
    value: String,
    onSendClicked: () -> Unit,
    messageBackGroundColor: Color,
    backgroundColor: Color,
    starColor: Color,
    onStarClicked: () -> Unit,
    messagesList: List<Messages>,
    isSendButtonActive: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()



    ) {
        Scaffold(
            bottomBar = {
                OybekTextField(
                    onValueChange = onValueChange,
                    value = value,
                    onSendClicked = onSendClicked,
                    starColor = starColor,
                    onStarClicked = onStarClicked,
                    isSendButtonActive = isSendButtonActive
                )
            }
        ) { innerPadding ->
            LazyColumn(


                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Bottom

                    ,

            ) {

                itemsIndexed(messagesList) { _, info ->
                    Message(

                        text = info.text,
                        messageType = info.messageType,
                        messageBackgroundColor = messageBackGroundColor,
                        timeSent = info.timeSent
                    )

                }

            }
        }



    }
}


@Composable
@Preview(showSystemUi = true)
fun bob() {
    ChatScreen(
        onValueChange = { },
        value = "",
        onSendClicked = { },
        messageBackGroundColor = PurpleGrey40,
        starColor = Color.Cyan,
        messagesList = listOf(Messages(messageType = To, text = "11", timeSent = "19:19")),
        onStarClicked = {},
        backgroundColor = Color.Black,
        isSendButtonActive = true,
    )

}