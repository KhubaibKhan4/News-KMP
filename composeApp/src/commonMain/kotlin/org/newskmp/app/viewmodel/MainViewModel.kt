package org.newskmp.app.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.newskmp.app.repository.Repository
import org.newskmp.app.util.NewsState

class MainViewModel(private val repository: Repository) : ViewModel() {

    //Home
    private val _newHome = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsHome: StateFlow<NewsState> = _newHome

    //World
    private val _newsWorld = MutableStateFlow<NewsState>(NewsState.Loading)
    val newWorld: StateFlow<NewsState> = _newsWorld

    //Sports
    private val _newsSports = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsSports: StateFlow<NewsState> = _newsSports

    //Business
    private val _newsBusiness = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsBusiness: StateFlow<NewsState> = _newsBusiness

    //Technology
    private val _newsTechnology = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsTechnology: StateFlow<NewsState> = _newsTechnology

    //Politics
    private val _newsPolitics = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsPolitics: StateFlow<NewsState> = _newsPolitics

    //Science
    private val _newsScience = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsScience: StateFlow<NewsState> = _newsScience

    //US
    private val _newsUS = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsUs: StateFlow<NewsState> = _newsUS

    //Arts
    private val _newsArts = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsArts: StateFlow<NewsState> = _newsArts

    //AutoMobiles
    private val _newsAutoMobiles = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsAutoMobiles: StateFlow<NewsState> = _newsAutoMobiles

    //BookReviews
    private val _newsBookReviews = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsBookReviews: StateFlow<NewsState> = _newsBookReviews

    //Fashion
    private val _newsFashion = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsFashion: StateFlow<NewsState> = _newsFashion

    //Food
    private val _newsFood = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsFood: StateFlow<NewsState> = _newsFood

    //Health
    private val _newsHealth = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsHealth: StateFlow<NewsState> = _newsHealth

    //Insider
    private val _newsInsider = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsInsider: StateFlow<NewsState> = _newsInsider

    //Magazine
    private val _newsMagazine = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsMagazine: StateFlow<NewsState> = _newsMagazine

    //Movies
    private val _newsMovies = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsMovies: StateFlow<NewsState> = _newsMovies

    //NYRegion
    private val _newsNYRegion = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsNYRegion: StateFlow<NewsState> = _newsNYRegion

    //Obituaries
    private val _newsObituaries = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsObituaries: StateFlow<NewsState> = _newsObituaries

    //Opinion
    private val _newsOpinion = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsOpinion: StateFlow<NewsState> = _newsOpinion

    //RealEstate
    private val _newsRealEstate = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsRealEstate: StateFlow<NewsState> = _newsRealEstate

    //SundayReview
    private val _newsSundayReview = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsSundayReview: StateFlow<NewsState> = _newsSundayReview

    //Travel
    private val _newsTravel = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsTravel: StateFlow<NewsState> = _newsTravel

    //Theater
    private val _newsTheater = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsTheater: StateFlow<NewsState> = _newsTheater

    //TMagazine
    private val _newsTMagazine = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsTMagazine: StateFlow<NewsState> = _newsTMagazine

    //TMagazine
    private val _newsUpShot = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsUpShot: StateFlow<NewsState> = _newsUpShot

    fun getHome() {
        viewModelScope.launch {
            _newHome.value = NewsState.Loading
            try {
                val response = repository.getHome()
                _newHome.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newHome.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getWorld() {
        viewModelScope.launch {
            _newsWorld.value = NewsState.Loading
            try {
                val response = repository.getWorld()
                _newsWorld.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsWorld.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getSports() {
        viewModelScope.launch {
            _newsSports.value = NewsState.Loading
            try {
                val response = repository.getSports()
                _newsSports.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsSports.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getBusiness() {
        viewModelScope.launch {
            _newsBusiness.value = NewsState.Loading
            try {
                val response = repository.getBusiness()
                _newsBusiness.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsBusiness.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getTechnology() {
        viewModelScope.launch {
            _newsTechnology.value = NewsState.Loading
            try {
                val response = repository.getTechnology()
                _newsTechnology.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsTechnology.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getPolitics() {
        viewModelScope.launch {
            _newsPolitics.value = NewsState.Loading
            try {
                val response = repository.getPolitics()
                _newsPolitics.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsPolitics.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getScience() {
        viewModelScope.launch {
            _newsScience.value = NewsState.Loading
            try {
                val response = repository.getScience()
                _newsScience.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsScience.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getUs() {
        viewModelScope.launch {
            _newsUS.value = NewsState.Loading
            try {
                val response = repository.getUs()
                _newsUS.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsUS.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getArts() {
        viewModelScope.launch {
            _newsArts.value = NewsState.Loading
            try {
                val response = repository.getArts()
                _newsArts.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsArts.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getAutoMobiles() {
        viewModelScope.launch {
            _newsAutoMobiles.value = NewsState.Loading
            try {
                val response = repository.getAutoMobiles()
                _newsAutoMobiles.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsAutoMobiles.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getBookReviews() {
        viewModelScope.launch {
            _newsBookReviews.value = NewsState.Loading
            try {
                val response = repository.getBookReviews()
                _newsBookReviews.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsBookReviews.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getFashion() {
        viewModelScope.launch {
            _newsFashion.value = NewsState.Loading
            try {
                val response = repository.getFashion()
                _newsFashion.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsFashion.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getFood() {
        viewModelScope.launch {
            _newsFood.value = NewsState.Loading
            try {
                val response = repository.getFood()
                _newsFood.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsFood.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getHealth() {
        viewModelScope.launch {
            _newsHealth.value = NewsState.Loading
            try {
                val response = repository.getHealth()
                _newsHealth.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsHealth.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getInsider() {
        viewModelScope.launch {
            _newsInsider.value = NewsState.Loading
            try {
                val response = repository.getInsider()
                _newsInsider.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsInsider.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getMagazine() {
        viewModelScope.launch {
            _newsMagazine.value = NewsState.Loading
            try {
                val response = repository.getMagazine()
                _newsMagazine.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsMagazine.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getMovies() {
        viewModelScope.launch {
            _newsMovies.value = NewsState.Loading
            try {
                val response = repository.getMovies()
                _newsMovies.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsMovies.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getNYRegion() {
        viewModelScope.launch {
            _newsNYRegion.value = NewsState.Loading
            try {
                val response = repository.getNYRegion()
                _newsNYRegion.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsNYRegion.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getObituaries() {
        viewModelScope.launch {
            _newsObituaries.value = NewsState.Loading
            try {
                val response = repository.getObituaries()
                _newsObituaries.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsObituaries.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getOpinion() {
        viewModelScope.launch {
            _newsOpinion.value = NewsState.Loading
            try {
                val response = repository.getOpinion()
                _newsOpinion.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsOpinion.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getRealEstate() {
        viewModelScope.launch {
            _newsRealEstate.value = NewsState.Loading
            try {
                val response = repository.getRealEstate()
                _newsRealEstate.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsRealEstate.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getSundayReview() {
        viewModelScope.launch {
            _newsSundayReview.value = NewsState.Loading
            try {
                val response = repository.getSundayReview()
                _newsSundayReview.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsSundayReview.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getTravel() {
        viewModelScope.launch {
            _newsTravel.value = NewsState.Loading
            try {
                val response = repository.getTravel()
                _newsTravel.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsTravel.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getTheater() {
        viewModelScope.launch {
            _newsTheater.value = NewsState.Loading
            try {
                val response = repository.getTheater()
                _newsTheater.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsTheater.value = NewsState.Error(e.message.toString())
            }
        }
    }
    fun getTMagazine() {
        viewModelScope.launch {
            _newsTMagazine.value = NewsState.Loading
            try {
                val response = repository.getTMagazine()
                _newsTMagazine.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsTMagazine.value = NewsState.Error(e.message.toString())
            }
        }
    }

    fun getUpShot() {
        viewModelScope.launch {
            _newsUpShot.value = NewsState.Loading
            try {
                val response = repository.getUpShot()
                _newsUpShot.value = NewsState.Success(response)
            } catch (e: Exception) {
                _newsUpShot.value = NewsState.Error(e.message.toString())
            }
        }
    }
}