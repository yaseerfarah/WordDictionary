package com.yasser.features.search.presentation.screens.search.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yasser.common.presentation.extensions.handleEffect
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import com.yasser.common.presentation.navigation.entrypoint.getRootNavigationCoordinator
import com.yasser.common.presentation.sharedcomponent.TopBarWithCenteredTitle
import com.yasser.features.search.presentation.screens.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen() {
    val viewModel: SearchViewModel = hiltViewModel()
    val rootNavigationCoordinator = getRootNavigationCoordinator()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithCenteredTitle(
                title = "Search Screen"
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
        ){
            SearchTextField(
                onSearch = {
                    rootNavigationCoordinator.handleNavigationEvent(
                        RootNavigationEvent.NavigateFromSearchScreenToDetailsScreen(
                            it
                        )
                    )
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn{
                items(viewModel.searchHistoryList.value.size){
                    Row(
                        modifier = Modifier
                            .clickable {
                                rootNavigationCoordinator.handleNavigationEvent(
                                    RootNavigationEvent.NavigateFromSearchScreenToDetailsScreen(
                                        viewModel.searchHistoryList.value[it]
                                    )
                                )
                            }
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(text = viewModel.searchHistoryList.value[it])
                    }
                    HorizontalDivider()

                }
            }
        }
    }



}


@Composable
private fun SearchTextField(
    onSearch: (String) -> Unit
) {

    var searchValue by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchValue,
        onValueChange = {
            searchValue = it
        },
        placeholder = {
            Text(text = "Search...")
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(searchValue)

            }
        )
    )
}
