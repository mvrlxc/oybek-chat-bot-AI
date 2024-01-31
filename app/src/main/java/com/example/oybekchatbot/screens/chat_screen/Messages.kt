package com.example.oybekchatbot.screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.contentValuesOf
import com.example.oybekchatbot.ui.theme.Styles
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MessageFrom(
    modifier: Modifier = Modifier,
    text: String,
    timeSent: String,
    backgroundColor: Color,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.7f)
            .padding(12.dp)
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(
            topStart = 35f,
            topEnd = 35f,
            bottomStart = 0f,
            bottomEnd = 35f
        )


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
                    end = 8.dp,
                    bottom = 3.dp
                )
                .wrapContentSize(Alignment.TopEnd)
        )
    }
}

@Composable
fun MessageTo(
    modifier: Modifier = Modifier,
    text: String,
    timeSent: String,
    backgroundColor: Color,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth(0.7f)
                .wrapContentWidth(Alignment.End)
                .padding(12.dp)
                .height(IntrinsicSize.Max),
            shape = RoundedCornerShape(
                topStart = 35f,
                topEnd = 35f,
                bottomStart = 35f,
                bottomEnd = 0f
            )


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
                        start = 8.dp,
                        bottom = 3.dp
                    )
                    .wrapContentSize(Alignment.TopStart)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun prp() {
    MessageTo(
        text = "sajwfawnfkjlawbfkjawbf" +
                "sajwfawnfkjlawbfkjawbf" +
                "sajwfawnfkjlawbfkjawbf" +
                "sajwfawnfkjlawbfkjawbf" +
                "sajwfawnfkjlawbfkjawbf" +
                "sajwfawnfkjlawbfkjawbf",
        backgroundColor = Color.Gray,
        timeSent = "18:18"
    )
}