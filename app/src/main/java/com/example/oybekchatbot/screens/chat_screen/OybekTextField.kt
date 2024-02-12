package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oybekchatbot.data.GrayO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OybekTextField(
    onValueChange: (String) -> Unit,
    value: String,
    onSendClicked: () -> Unit,
    starColor: Color,
    onStarClicked: () -> Unit,
    isSendButtonActive: Boolean,
) {


    Column {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.25.dp)
                .background(GrayO)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GrayO),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Icon(
                Icons.Rounded.Star, contentDescription = null, tint = starColor,
                modifier = Modifier
                    .size(30.dp)
                    .wrapContentSize(Alignment.Center)
                    .clickable(onClick = onStarClicked)
                    .border(1.dp, color = Color.White, CircleShape)

            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = value,
                onValueChange = onValueChange,
                shape = CircleShape,
                colors = (TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    containerColor = GrayO,
                    focusedTextColor = Color.White

                ))


            )

            Icon(
                Icons.Filled.Send, contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .clickable(onClick = onSendClicked, enabled = isSendButtonActive)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun go() {
    OybekTextField(
        onValueChange = {},
        onSendClicked = {},
        starColor = Color.Red,
        value = "1",
        isSendButtonActive = true,
        onStarClicked = {}
    )
}