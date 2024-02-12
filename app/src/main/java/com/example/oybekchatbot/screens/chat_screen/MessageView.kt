package com.example.oybekchatbot.screens.chat_screen

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.oybekchatbot.data.Gray1
import com.example.oybekchatbot.model.OybekUiState
import com.example.oybekchatbot.ui.theme.PurpleGrey40
import java.util.Date

data class MessageType(
    var TopStart: Float,
    var TopEnd: Float,
    var alignment: Alignment,
    var arragement: Arrangement.Horizontal,
    var start: Dp,
    var end: Dp,
    var bottom: Dp,
    var paddingStart: Dp,
    var paddingEnd: Dp,
    val textColor: Color,
    val backgroundColor: Color,
)

val To: MessageType =
    MessageType(
        TopStart = 35f,
        TopEnd = 0f,
        alignment = Alignment.TopStart,
        arragement = Arrangement.End,
        start = 8.dp,
        end = 8.dp,
        bottom = 0.dp,
        paddingStart = 32.dp,
        paddingEnd = 0.dp,
        textColor = Color.Black,
        backgroundColor = Color.Gray


    )
val From: MessageType =
    MessageType(
        TopStart = 0f,
        TopEnd = 35f,
        alignment = Alignment.TopEnd,
        arragement = Arrangement.Start,
        start = 0.dp,
        end = 8.dp,
        bottom = 3.dp,
        paddingStart = 0.dp,
        paddingEnd = 32.dp,
        textColor = Color.White,
        backgroundColor = Color.Cyan
    )


@Composable
fun Message(
    modifier: Modifier = Modifier,
    text: String,
    messageBackgroundColor: Color,
    messageType: MessageType,
    timeSent: String

) {
    val isDarkTheme: Boolean = isSystemInDarkTheme()
    val messageBackgroundColor1: Color
    var textColor1: Color = Color.White


    if (messageType == From) {
        messageBackgroundColor1 = messageBackgroundColor
    } else {
        messageBackgroundColor1 = Gray1
    }

    if (isDarkTheme || messageType == To) {
        textColor1 = Color.White
    } else if (messageType == To) {
        textColor1 = Color.Black
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp),
        horizontalArrangement = messageType.arragement,

        ) {

        Card(
            modifier = modifier
                //.fillMaxWidth(0.7f)
                .padding(12.dp)
                .height(IntrinsicSize.Max)
                .width(IntrinsicSize.Max),
            shape = RoundedCornerShape(
                topStart = messageType.TopStart,
                topEnd = messageType.TopEnd,
                bottomStart = 35f,
                bottomEnd = 35f
            ),
            colors = CardDefaults.cardColors(
                containerColor = messageBackgroundColor1
            ),


            ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor1,
                modifier = Modifier
                    .background(messageBackgroundColor1)
                    .padding(8.dp)

            )
            Text(
                text = timeSent,
                style = MaterialTheme.typography.bodySmall,
                color = textColor1,
                modifier = Modifier
                    .background(messageBackgroundColor1)
                    .fillMaxWidth()
                    .padding(
                        start = messageType.start,
                        end = messageType.end,
                        bottom = messageType.bottom,
                    )
                    .wrapContentSize(messageType.alignment)
            )
        }
    }
}



