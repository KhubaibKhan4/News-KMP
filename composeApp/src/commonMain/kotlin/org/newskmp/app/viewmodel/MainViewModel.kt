package org.newskmp.app.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.newskmp.app.repository.Repository
import org.newskmp.app.util.NewsState

class MainViewModel(private val repository: Repository): ViewModel() {
    private val _newsAll = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsAll : StateFlow<NewsState> = _newsAll


    fun getNewsAll(){
        viewModelScope.launch {
            _newsAll.value = NewsState.Loading
            try {
                val response = repository.getNewsAll()
                _newsAll.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsAll.value = NewsState.Error(e.message.toString())
            }
        }
    }
}