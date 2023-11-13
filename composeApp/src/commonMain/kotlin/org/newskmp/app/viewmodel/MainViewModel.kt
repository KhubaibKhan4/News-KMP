package org.newskmp.app.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.newskmp.app.repository.Repository
import org.newskmp.app.util.NewsState

class MainViewModel(private val repository: Repository): ViewModel() {

    //Home
    private val _newHome = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsHome : StateFlow<NewsState> = _newHome

    //World
    private val _newsWorld = MutableStateFlow<NewsState>(NewsState.Loading)
    val newWorld : StateFlow<NewsState> = _newsWorld

    //All
    private val _newsAll = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsAll : StateFlow<NewsState> = _newsAll

    //Business
    private val _newsBusiness = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsBusiness : StateFlow<NewsState> =_newsBusiness

    //Technology
    private val _newsTechnology = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsTechnology : StateFlow<NewsState> = _newsTechnology

    //Politics
    private val _newsPolitics = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsPolitics : StateFlow<NewsState> = _newsPolitics

    //Science
    private val _newsScience = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsScience : StateFlow<NewsState> = _newsScience

    fun getHome(){
        viewModelScope.launch {
            _newHome.value = NewsState.Loading
            try {
                val response = repository.getHome()
                _newHome.value = NewsState.Success(response)
            }catch (e: Exception){
                _newHome.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getWorld(){
        viewModelScope.launch {
            _newsWorld.value = NewsState.Loading
            try {
                val response = repository.getWorld()
                _newsWorld.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsWorld.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getAll(){
        viewModelScope.launch {
            _newsAll.value  = NewsState.Loading
            try {
                val response = repository.getAll()
                _newsAll.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsAll.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getBusiness(){
        viewModelScope.launch {
            _newsBusiness.value = NewsState.Loading
            try {
                val response = repository.getBusiness()
                _newsBusiness.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsBusiness.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getTechnology(){
        viewModelScope.launch {
            _newsTechnology.value = NewsState.Loading
            try {
                val response = repository.getTechnology()
                _newsTechnology.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsTechnology.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getPolitics(){
        viewModelScope.launch {
            _newsPolitics.value = NewsState.Loading
            try {
                val response = repository.getPolitics()
                _newsPolitics.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsPolitics.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getScience(){
        viewModelScope.launch {
            _newsScience.value = NewsState.Loading
            try {
                val response = repository.getScience()
                _newsScience.value = NewsState.Success(response)
            }catch (e: Exception){
                _newsScience.value = NewsState.Error(e.message.toString())
            }
        }
    }
}