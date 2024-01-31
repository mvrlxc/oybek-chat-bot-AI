package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oybekchatbot.R


@Composable
fun ChatAvatar(image: Int) {

    Image(
        painterResource(id = image),
        contentDescription = stringResource(id = R.string.ai_picture_description),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(220.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )


    )

}


@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ChatAvatar(image = R.drawable.penis_5)

}