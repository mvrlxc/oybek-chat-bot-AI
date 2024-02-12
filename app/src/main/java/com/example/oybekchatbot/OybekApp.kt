package com.example.oybekchatbot

import android.content.res.Resources.Theme
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.oybekchatbot.data.GrayO
import com.example.oybekchatbot.model.OybekViewModel
import com.example.oybekchatbot.model.menuScreens
import com.example.oybekchatbot.screens.chat_screen.ChatScreen
import com.example.oybekchatbot.screens.menu_screen.MenuScreen

enum class OybekScreen(val text: String) {
    CHATSCREEN(text = "Oybek Chat Bot"),
    MENUSCREEN(text = "Menu"),
}


@Composable
fun OybekApp(
    viewModel: OybekViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = OybekScreen.valueOf(
        backStackEntry?.destination?.route ?: OybekScreen.CHATSCREEN.name
    )


    // BackHandler(onBack = navigate)
    Scaffold(

        topBar = {
            BottomAppBar(
                containerColor = GrayO,
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()


            ) {
                if (currentScreen == OybekScreen.CHATSCREEN) {
                    Image(
                        painter = painterResource(id = R.drawable.penis_5),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,

                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(38.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                shape = CircleShape,
                                color = Color.White,
                            ),

                        )
                }

                if (currentScreen != OybekScreen.CHATSCREEN) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable(onClick = {
                                viewModel.backNavigation(
                                    navController = navController,
                                    currentScreen = currentScreen,
                                    menuScreen = uiState.menuScreen
                                )
                            })


                    )
                }

                Text(
                    text = currentScreen.text,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    color = Color.White


                )
                if (currentScreen == OybekScreen.CHATSCREEN) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.clickable {

                            viewModel.menuNavigation(
                                navController = navController,

                            )


                        }
                    )

                } else {
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = OybekScreen.CHATSCREEN.name,
        ) {
            composable(OybekScreen.CHATSCREEN.name) {

                ChatScreen(
                    onValueChange = { viewModel.updateTextFieldValue(it) },
                    value = uiState.textFieldValue,
                    onSendClicked = { viewModel.onMessageSent(uiState.textFieldValue) },
                    messageBackGroundColor = uiState.messageBackgroundColor,
                    starColor = uiState.starColor,
                    onStarClicked = { viewModel.onStarClicked() },
                    messagesList = uiState.messages,
                    backgroundColor = uiState.backgroundColor,
                    isSendButtonActive = uiState.isSendButtonActive,
                )


            }
            composable(OybekScreen.MENUSCREEN.name) {
                MenuScreen(
                    menuBackgroundColor = Color.Black,
                    contentColor = GrayO,
                    onClickProfile = { /*TODO*/ },
                    onClickFeatured = { /*TODO*/ },
                    onClickLocked = { /*TODO*/ },
                    onClickSupport = { /*TODO*/ },
                    onClickNews = {},
                    onClickDesign = {viewModel.designNavigation()},
                    currentScreen = uiState.menuScreen ,
                    backgroundColor = uiState.backgroundColor,
                    secondaryColor = uiState.secondaryColor,
                    messageBackgroundColor = uiState.messageBackgroundColor,
                    onColorClick = { viewModel.onColorClick(it) },
                    navHostController = navController,
                    viewModel = viewModel,
                    navName = OybekScreen.CHATSCREEN



                )


            }


        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    OybekApp()
}
