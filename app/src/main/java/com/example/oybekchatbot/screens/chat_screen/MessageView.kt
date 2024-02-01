package com.example.oybekchatbot.screens.chat_screen

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.oybekchatbot.ui.theme.PurpleGrey40
import java.util.Date

data class MessageType(
    var bottomStart: Float,
    var bottomEnd: Float,
    var alignment: Alignment,
    var arragement: Arrangement.Horizontal,
    var start: Dp,
    var end: Dp,
    var bottom: Dp,
)

val To: MessageType =
    MessageType(
        bottomStart = 35f,
        bottomEnd = 0f,
        alignment = Alignment.TopStart,
        arragement = Arrangement.End,
        start = 8.dp,
        end = 0.dp,
        bottom = 3.dp
    )
val From: MessageType =
    MessageType(
        bottomStart = 0f,
        bottomEnd = 35f,
        alignment = Alignment.TopEnd,
        arragement = Arrangement.Start,
        start = 0.dp,
        end = 8.dp,
        bottom = 3.dp
    )

fun currentTime(): String {
    val sdf = SimpleDateFormat("hh:mm")
    val currentDate = sdf.format(Date())
    return currentDate.toString()
}

@Composable
fun Message(
    modifier: Modifier = Modifier,
    text: String,
    timeSent: String = currentTime(),
    backgroundColor: Color,
    messageType: MessageType

) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = messageType.arragement
    ) {

        Card(
            modifier = modifier
                .fillMaxWidth(0.7f)
                .padding(12.dp)
                .height(IntrinsicSize.Max),
            shape = RoundedCornerShape(
                topStart = 35f,
                topEnd = 35f,
                bottomStart = messageType.bottomStart,
                bottomEnd = messageType.bottomEnd
            ),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            ),


            ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .background(backgroundColor)
                    .padding(8.dp)

            )
            Text(
                text = timeSent,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .background(backgroundColor)
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



@Composable
@Preview(showSystemUi = true)
fun prp() {
    Message(
        text = "dwad",
        backgroundColor = PurpleGrey40,
        messageType = From
    )
}