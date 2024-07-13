package com.yasser.features.search.presentation.screens.search.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.presentation.viewmodel.BaseViewModel
import com.yasser.features.search.domain.usecase.GetWordSearchHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getWordSearchHistoryUseCase: GetWordSearchHistoryUseCase,
) : BaseViewModel<Nothing>() {



    val searchEditTextValue = mutableStateOf("")

    val searchHistoryList = mutableStateOf<List<String>>(emptyList())


    init {
        getSearchHistory()
    }

    private fun getSearchHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            getWordSearchHistoryUseCase(Unit).collect {
                withContext(Dispatchers.Main) {
                    searchHistoryList.value = it
                }
            }
        }
    }




}