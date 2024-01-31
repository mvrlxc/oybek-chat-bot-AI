package com.example.oybekchatbot.screens.chat_screen

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun TextField(
    onValueChange: () -> Unit,
    value: String,
    onSendClicked: () -> Unit,
    backGroundColor: Color,
    starColor: Color
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
            modifier = Modifier.size(30.dp).wrapContentSize(Alignment.Center)

        )

        OutlinedTextField(
            modifier = Modifier,
            value = value,
            onValueChange = {
                onValueChange
            },
            shape = CircleShape
        )

        Icon(
            Icons.Filled.Send, contentDescription = null,
            modifier = Modifier.size(30.dp)
                .clickable { onSendClicked }
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun go() {
    TextField(
        onValueChange = {},
        backGroundColor = Color.Green,
        onSendClicked = {},
        starColor = Color.Red,
        value = "1"
    )
}