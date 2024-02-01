package com.example.oybekchatbot.screens.chat_screen

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
import com.example.oybekchatbot.data.MessagesList
import com.example.oybekchatbot.ui.theme.PurpleGrey40

@Composable
fun ChatScreen(
    onValueChange: (String) -> Unit,
    value: String,
    onSendClicked: () -> Unit,
    backGroundColor: Color,
    starColor: Color,
    onStarClicked: () -> Unit
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
                    backGroundColor = backGroundColor,
                    starColor = starColor,
                    onStarClicked = onStarClicked
                )
            }
        ) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {

                itemsIndexed(MessagesList) { _, Info ->
                    Message(
                        text = Info.text,
                        messageType = Info.messageType,
                        backgroundColor = PurpleGrey40
                    )
                }

            }
        }
        LazyColumn() {

            itemsIndexed(MessagesList) { _, Info ->
                Message(
                    text = Info.text,
                    messageType = Info.messageType,
                    backgroundColor = PurpleGrey40
                )
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
        backGroundColor = PurpleGrey40,
        starColor = Color.Cyan
    ) {}

}