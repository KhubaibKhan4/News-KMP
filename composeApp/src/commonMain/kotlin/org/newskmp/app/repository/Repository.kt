package org.newskmp.app.repository

import org.newskmp.app.data.model.News
import org.newskmp.app.data.remote.NewsClientApi

class Repository {

    suspend fun getHome(): News {
        return NewsClientApi.getHome()
    }
    suspend fun getWorld():News{
        return NewsClientApi.getWorld()
    }

    suspend fun getAll():News{
        return NewsClientApi.getAll()
    }

    suspend fun getBusiness():News{
        return NewsClientApi.getBusiness()
    }
    suspend fun getTechnology():News{
        return NewsClientApi.getTechnology()
    }
    suspend fun getPolitics(): News{
        return NewsClientApi.getPolitics()
    }
    suspend fun getScience():News{
        return NewsClientApi.getScience()
    }
}