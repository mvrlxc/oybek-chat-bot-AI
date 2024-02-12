package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (messagesList.isEmpty()) {
                        Column {

                            Icon(
                                Icons.Filled.Clear, contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(backgroundColor)
                                    .wrapContentSize(Alignment.Center)
                                    .size(100.dp),
                                tint = Color.White
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(backgroundColor)
                                    .height(300.dp)
                            )
                        }
                    }
                    OybekTextField(
                        onValueChange = onValueChange,
                        value = value,
                        onSendClicked = onSendClicked,
                        starColor = starColor,
                        onStarClicked = onStarClicked,
                        isSendButtonActive = isSendButtonActive
                    )


                }
            }
        ) { innerPadding ->

            LazyColumn(


                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Bottom,

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
        messagesList = mutableListOf<Messages>(),
        onStarClicked = {},
        backgroundColor = Color.Black,
        isSendButtonActive = true,
    )

}