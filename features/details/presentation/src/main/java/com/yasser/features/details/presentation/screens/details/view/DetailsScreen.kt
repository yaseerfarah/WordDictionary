package com.yasser.features.details.presentation.screens.details.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.entrypoint.getRootNavigationCoordinator
import com.yasser.common.presentation.R
import com.yasser.common.presentation.sharedcomponent.TopBarWithCenteredTitle
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.presentation.screens.details.uimodel.enums.ScreenStatus
import com.yasser.features.details.presentation.screens.details.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen() {

    val viewmodel: DetailsViewModel = hiltViewModel()
    val rootNavigation = getRootNavigationCoordinator()
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithCenteredTitle(
                title = "Details Screen",
                onBackClick = {
                    rootNavigation.handleNavigationEvent(RootNavigationEvent.NavigateBack)
                }
            )
        }
    ){innerPadding ->
        when(viewmodel.currentScreenStatus.value){

            ScreenStatus.LOADING -> {
                LoadingProgressIndicator(
                    modifier = Modifier.padding(innerPadding)
                )
            }
            ScreenStatus.SUCCESS -> {
                ScreenBody(
                    modifier = Modifier.padding(innerPadding),
                    wordInfoItems = viewmodel.wordInfoItems.value
                )
            }
            ScreenStatus.EMPTY -> {
                FullScreenStatus(
                    imageResourceId = R.drawable.ic_empty_state,
                    message = "No results found",
                    buttonText = "Try New Search",
                    onButtonClick = {
                        rootNavigation.handleNavigationEvent(RootNavigationEvent.NavigateBack)
                    }
                )
            }
            ScreenStatus.UNKNOWN_ERROR -> {
                FullScreenStatus(
                    imageResourceId = R.drawable.ic_unknown_error_state,
                    message = "Something went wrong",
                    buttonText = "Try Again",
                    onButtonClick = {
                        viewmodel.getWordDictionaryInfo()
                    }
                )
            }
            ScreenStatus.NETWORK_ERROR -> {
                FullScreenStatus(
                    imageResourceId = R.drawable.ic_network_error_state,
                    message = "No Internet Connection",
                    buttonText = "Try Again",
                    onButtonClick = {
                        viewmodel.getWordDictionaryInfo()
                    }
                )
            }
        }

    }

}



@Composable
fun ScreenBody(
    modifier: Modifier = Modifier,
    wordInfoItems: List<WordInfoEntity>,
){
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(wordInfoItems.size) { i ->
            val wordInfo = wordInfoItems[i]
            if(i > 0) {
                Spacer(modifier = Modifier.height(8.dp))
            }
            WordInfoItem(wordInfo = wordInfo)
            if(i < wordInfoItems.size - 1) {
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun LoadingProgressIndicator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun FullScreenStatus(
    imageResourceId: Int,
    message: String,
    buttonText: String? = null,
    onButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                style = TextStyle(fontSize = 18.sp, color = Color.Gray)
            )
            buttonText?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onButtonClick) {
                    Text(text = buttonText)
                }
            }

        }
    }
}





