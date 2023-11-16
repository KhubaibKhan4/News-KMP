package org.newskmp.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.search.SearchNews
import org.newskmp.app.util.Constant.API
import org.newskmp.app.util.Constant.BEGIN_DATE
import org.newskmp.app.util.Constant.END_DATE
import org.newskmp.app.util.Constant.SORT
import org.newskmp.app.util.Constant.TIMEOUT

object NewsClientApi {
    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = false
                coerceInputValues = true
                explicitNulls = true
            })
        }

        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT
            requestTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            filter { request ->
                request.url.host.contains("nytimes.com")
            }
        }
    }

    suspend fun getHome(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getWorld(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/world.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getSports(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/sports.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getBusiness(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/business.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getTechnology(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/technology.json?api-key=${API}"
        return client.get(url).body()
    }


    suspend fun getPolitics(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/politics.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getScience(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/science.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getUs(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/us.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getArts(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getAutoMobiles(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/automobiles.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getBooksReview(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/books/review.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getFashion(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/fashion.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getFood(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/food.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getHealth(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/health.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getInsider(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/insider.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getMagazine(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/magazine.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getMovies(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/movies.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getNYRegion(): News {
        val url = "https://api.nytimes.com/svc/topstories/v2/nyregion.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getObituaries():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/obituaries.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getOpinion():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/opinion.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getRealEstate():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/realestate.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getSundayReview():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/sundayreview.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getTravel():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/travel.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getTheater():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/theater.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getTMagazine():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/t-magazine.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getUpShot():News{
        val url = "https://api.nytimes.com/svc/topstories/v2/upshot.json?api-key=${API}"
        return client.get(url).body()
    }
    suspend fun getSearch(query: String):SearchNews{
        val url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=${query}&api-key=${API}&begin_date=${BEGIN_DATE}&end_date=${END_DATE}&sort=${SORT}&page=1"
        return client.get(url).body()
    }

}