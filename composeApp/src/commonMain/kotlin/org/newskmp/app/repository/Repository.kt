package org.newskmp.app.repository

import org.newskmp.app.data.model.News
import org.newskmp.app.data.remote.NewsClientApi

class Repository {

    suspend fun getNewsAll(): News {
        return NewsClientApi.getNewsAll()
    }

}