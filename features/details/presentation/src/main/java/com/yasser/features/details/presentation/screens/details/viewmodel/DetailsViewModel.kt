package com.yasser.features.details.presentation.screens.details.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.domain.entity.network.enums.ExceptionType
import com.yasser.common.presentation.viewmodel.BaseViewModel
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.domain.usecase.GetWordDictionaryInfoUseCase
import com.yasser.features.details.presentation.route.route.DetailsScreenRoute
import com.yasser.features.details.presentation.screens.details.uimodel.enums.ScreenStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getWordDictionaryInfoUseCase: GetWordDictionaryInfoUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<Nothing>() {

     val searchedWord = savedStateHandle.toRoute<DetailsScreenRoute.Details>().word

    val currentScreenStatus = mutableStateOf(ScreenStatus.LOADING)

    val wordInfoItems = mutableStateOf<List<WordInfoEntity>>(emptyList())




    init {
        getWordDictionaryInfo()
    }

     fun getWordDictionaryInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            getWordDictionaryInfoUseCase(searchedWord).collect {responseStatus ->
                withContext(Dispatchers.Main){
                    when(responseStatus){
                        is ResponseStatus.Loading -> currentScreenStatus.value = ScreenStatus.LOADING

                        is ResponseStatus.Error -> {
                            when(responseStatus.exceptionType){
                                ExceptionType.Empty -> currentScreenStatus.value = ScreenStatus.EMPTY
                                ExceptionType.Network -> currentScreenStatus.value = ScreenStatus.NETWORK_ERROR
                                ExceptionType.Unknown -> currentScreenStatus.value = ScreenStatus.UNKNOWN_ERROR
                            }
                        }

                        is ResponseStatus.Success -> {
                            wordInfoItems.value = responseStatus.data
                            if (responseStatus.data.isEmpty())
                                currentScreenStatus.value = ScreenStatus.EMPTY
                            else
                                currentScreenStatus.value = ScreenStatus.SUCCESS
                        }

                    }
                }
            }

            }
    }


}