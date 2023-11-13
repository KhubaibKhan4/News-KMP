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
import org.newskmp.app.util.Constant.API
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
        val url = "https://api.nytimes.com/svc/news/v3/content/nyt/world.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getAll(): News {
        val url = "https://api.nytimes.com/svc/news/v3/content/nyt/all.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getBusiness(): News {
        val url = "https://api.nytimes.com/svc/news/v3/content/nyt/business.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getTechnology(): News {
        val url = "https://api.nytimes.com/svc/news/v3/content/nyt/technology.json?api-key=${API}"
        return client.get(url).body()
    }

    suspend fun getSport(): News {
        val url = "https://api.nytimes.com/svc/news/v3/content/nyt/sport.json?api-key=${API}"
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




}