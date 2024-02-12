package com.example.oybekchatbot.screens.menu_screen

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oybekchatbot.data.GrayO
import com.example.oybekchatbot.screens.chat_screen.From
import com.example.oybekchatbot.screens.chat_screen.Message
import com.example.oybekchatbot.screens.chat_screen.To
import com.example.oybekchatbot.ui.theme.PurpleGrey40
import java.util.Date

private fun getCurrentTime(): String {

    val sdf = SimpleDateFormat("hh:mm")
    val currentDate = sdf.format(Date())
    return currentDate.toString()
}

val colorsList: List<Color> = listOf(
    Color.Cyan,
    Color.Red,
    Color.Green,
    Color.Yellow,
    Color.White
)

@Composable
fun DesignScreen(
    backgroundColor: Color,
    messageBackgroundColor: Color,
    secondaryColor: Color,
    onColorClick: (Color) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
            /// .wrapContentSize(Alignment.Center)


        ) {
            Row(modifier = Modifier.background(secondaryColor)) {
                Message(
                    text = "Привет, Ойбек, Подскажи где можно заказать хороший смузи",
                    messageBackgroundColor = messageBackgroundColor,
                    messageType = To,
                    timeSent = getCurrentTime(),
                    modifier = Modifier.background(secondaryColor)
                )
            }
            Row(modifier = Modifier.background(secondaryColor)) {
                Message(
                    text = "Могу посоветовать сервис \"Достаевский\"",
                    messageBackgroundColor = messageBackgroundColor,
                    messageType = From,
                    timeSent = getCurrentTime(),
                    modifier = Modifier.background(secondaryColor)
                )
            }
            Row(modifier = Modifier.background(secondaryColor)) {
                Message(

                    text = "иди нахуй",
                    messageBackgroundColor = messageBackgroundColor,
                    messageType = To,
                    timeSent = getCurrentTime(),
                    modifier = Modifier.background(secondaryColor)

                )
            }
        }


        LazyRow(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(colorsList) { _, color ->
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color)
                        .border(1.dp, Color.White, CircleShape)
                        .clickable { onColorClick(color) }


                ) {

                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun preview() {
    DesignScreen(
        backgroundColor = Color.Black,
        messageBackgroundColor = PurpleGrey40,
        secondaryColor = GrayO

    ) {}
}