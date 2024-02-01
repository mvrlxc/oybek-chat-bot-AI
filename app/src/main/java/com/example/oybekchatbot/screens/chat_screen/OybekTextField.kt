package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OybekTextField(
    onValueChange: (String) -> Unit,
    value: String,
    onSendClicked: () -> Unit,
    backGroundColor: Color,
    starColor: Color,
    onStarClicked: () -> Unit
    ) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backGroundColor),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Icon(
            Icons.Rounded.Star, contentDescription = null, tint = starColor,
            modifier = Modifier.size(30.dp).wrapContentSize(Alignment.Center).clickable(onClick = onStarClicked)

        )

        OutlinedTextField(
            modifier = Modifier,
            value = value,
            onValueChange = onValueChange,
            shape = CircleShape
        )

        Icon(
            Icons.Filled.Send, contentDescription = null,
            modifier = Modifier.size(30.dp)
                .clickable(onClick = onSendClicked)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun go() {
    OybekTextField(
        onValueChange = {},
        backGroundColor = Color.Green,
        onSendClicked = {},
        starColor = Color.Red,
        value = "1"
    ) {}
}