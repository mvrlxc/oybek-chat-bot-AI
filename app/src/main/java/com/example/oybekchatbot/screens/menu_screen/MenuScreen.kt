package com.example.oybekchatbot.screens.menu_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.oybekchatbot.OybekScreen
import com.example.oybekchatbot.data.Gray1
import com.example.oybekchatbot.data.GrayO
import com.example.oybekchatbot.model.OybekViewModel
import com.example.oybekchatbot.model.menuScreens
import kotlin.system.exitProcess

data class MenuItemViewContent(
    val text: String,
    val icon: ImageVector,
    val color: Color = GrayO,
    val onClick: () -> Unit,
    val isLinked: Boolean = false,
)

fun paramsListFirst(
    onClickProfile: () -> Unit,
    onClickFeatured: () -> Unit,
): List<MenuItemViewContent> {
    return listOf(
        MenuItemViewContent(
            text = "Профиль",
            icon = Icons.Filled.AccountCircle,
            onClick = onClickProfile
        ),
        MenuItemViewContent(
            text = "Избранное",
            icon = Icons.Filled.Favorite,
            onClick = onClickFeatured
        ),
    )
}

fun paramsListSecond(
    onClickLocked: () -> Unit,
    onClickDesign: () -> Unit,
    onClickNotifications: () -> Unit,
): List<MenuItemViewContent> {
    return listOf(
        MenuItemViewContent(
            text = "Тарифы",
            icon = Icons.Filled.ShoppingCart,
            onClick = onClickLocked
        ),
        MenuItemViewContent(
            text = "Способы оплаты",
            icon = Icons.Filled.Add,
            onClick = onClickLocked
        ),
        MenuItemViewContent(
            text = "Виджеты и уведомления",
            icon = Icons.Filled.Notifications,
            onClick = onClickNotifications
        ),
        MenuItemViewContent(
            text = "Внешний вид",
            icon = Icons.Filled.Build,
            onClick = onClickDesign,
        ),
    )
}

fun paramsListThird(
    onClickLocked: () -> Unit,
    onClickSupport: () -> Unit,
    onClickNews: () -> Unit,
): List<MenuItemViewContent> {
    return listOf(
        MenuItemViewContent(
            text = "Обновления",
            icon = Icons.Filled.Info,
            onClick = onClickLocked
        ),
        MenuItemViewContent(
            text = "Поддержка",
            icon = Icons.Filled.Face,
            onClick = onClickSupport,
            isLinked = true
        ),
        MenuItemViewContent(
            text = "Новости",
            icon = Icons.Filled.MailOutline,
            onClick = onClickNews,
            isLinked = true
        ),
    )
}

@Composable
fun MenuItemView(
    text: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
    isLinked: Boolean,
) {
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(color)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Start,

        ) {
        Icon(
            icon, null,
            tint = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentSize()
                .padding(4.dp)
        )
        if (isLinked) {
            Icon(
                Icons.Filled.Send,
                null,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterEnd)
                    .padding(8.dp)
            )
        }
    }
}


@Composable
fun MenuCardView(
    paramsList: List<MenuItemViewContent>,
    contentColor: Color
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                end = 24.dp,
                start = 24.dp,
                top = 16.dp
            ),


        ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(paramsList) { _, info ->
                MenuItemView(
                    text = info.text,
                    icon = info.icon,
                    color = info.color,
                    onClick = info.onClick,
                    isLinked = info.isLinked
                )
            }
        }
    }
}

@Composable
fun MenuScreen(
    currentScreen: menuScreens,
    menuBackgroundColor: Color,
    contentColor: Color,
    backgroundColor: Color,
    messageBackgroundColor: Color,
    secondaryColor: Color,
    onClickProfile: () -> Unit,
    onClickFeatured: () -> Unit,
    onClickLocked: () -> Unit,
    onClickSupport: () -> Unit,
    onClickNews: () -> Unit,
    onClickDesign: () -> Unit,
    onColorClick: (Color) -> Unit,
    navHostController: NavHostController,
    navName: OybekScreen,
    viewModel: OybekViewModel,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(menuBackgroundColor)
    ) {


        MenuScreens(
            currentScreen = currentScreen,
            backgroundColor = backgroundColor,
            messageBackgroundColor = messageBackgroundColor,
            secondaryColor = secondaryColor,
            onColorClick = onColorClick,
            navHostController = navHostController,

            viewModel = viewModel

        )

        MenuCardView(
            contentColor = contentColor,
            paramsList = paramsListFirst(
                onClickProfile = onClickProfile,
                onClickFeatured = onClickFeatured,
            )
        )
        MenuCardView(
            contentColor = contentColor,
            paramsList = paramsListSecond(
                onClickLocked = {},
                onClickDesign = onClickDesign,
                onClickNotifications = {},
            )
        )
        MenuCardView(
            contentColor = contentColor,
            paramsList = paramsListThird(
                onClickLocked = onClickLocked,
                onClickSupport = onClickSupport,
                onClickNews = onClickNews
            )
        )
        Text(
            text = "OYBEK CHAT BOT AI 2.2.8",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
                .padding(16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun MenuScreens(
    currentScreen: menuScreens,
    backgroundColor: Color,
    messageBackgroundColor: Color,
    secondaryColor: Color,
    onColorClick: (Color) -> Unit,
    navHostController: NavHostController,
    viewModel: OybekViewModel

) {
    BackHandler {
        if (currentScreen == menuScreens.MainScreen) {
            navHostController.navigate(OybekScreen.CHATSCREEN.name) {
                popUpTo(OybekScreen.CHATSCREEN.name) {
                    inclusive = true
                }
            }
        } else if (currentScreen == menuScreens.DesignScreen) {
            viewModel.toMenuNavigation()
            navHostController.navigate(OybekScreen.MENUSCREEN.name) {
                popUpTo(OybekScreen.MENUSCREEN.name) {
                    inclusive = true
                }
            }
        } else {
            exitProcess(-1)
        }
    }
    when (currentScreen) {

        menuScreens.MainScreen -> {

        }

        menuScreens.DesignScreen -> {
            DesignScreen(
                backgroundColor = backgroundColor,
                messageBackgroundColor = messageBackgroundColor,
                secondaryColor = secondaryColor,
                onColorClick = onColorClick
            )


        }
    }
}

/*
@Composable
@Preview(showSystemUi = true)
fun Previe() {
    MenuItemView(
        icon = Icons.Filled.AccountBox,
        text = "bob",
        color = Color.Black
    )
}
*/

@Composable
@Preview(showSystemUi = true)
fun Preview() {


    MenuScreen(
        currentScreen = menuScreens.DesignScreen,
        menuBackgroundColor = Color.Black,
        contentColor = GrayO,
        backgroundColor = Color.Black,
        messageBackgroundColor = Gray1,
        secondaryColor = Gray1,
        onClickProfile = { /*TODO*/ },
        onClickFeatured = { /*TODO*/ },
        onClickLocked = { /*TODO*/ },
        onClickSupport = { /*TODO*/ },
        onClickNews = { /*TODO*/ },
        onClickDesign = { /*TODO*/ },
        onColorClick = {},
        navName = OybekScreen.CHATSCREEN,
        navHostController = null!!,
        viewModel = viewModel()

    )
}
