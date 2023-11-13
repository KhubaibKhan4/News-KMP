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

    suspend fun getSports():News{
        return NewsClientApi.getSports()
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
    suspend fun getUs():News{
        return NewsClientApi.getUs()
    }
    suspend fun getArts():News{
        return NewsClientApi.getArts()
    }
    suspend fun getAutoMobiles():News{
        return NewsClientApi.getAutoMobiles()
    }

    suspend fun getBookReviews():News{
        return NewsClientApi.getBooksReview()
    }
    suspend fun getFashion():News{
        return NewsClientApi.getFashion()
    }
    suspend fun getHealth():News{
        return NewsClientApi.getHealth()
    }

    suspend fun getFood():News{
        return NewsClientApi.getFood()
    }
    suspend fun getInsider():News{
        return NewsClientApi.getInsider()
    }
    suspend fun getMagazine():News{
        return NewsClientApi.getMagazine()
    }
    suspend fun getMovies():News{
        return NewsClientApi.getMovies()
    }
    suspend fun getNYRegion():News{
        return NewsClientApi.getNYRegion()
    }
    suspend fun getObituaries():News{
        return NewsClientApi.getObituaries()
    }
    suspend fun getOpinion():News{
        return NewsClientApi.getOpinion()
    }
    suspend fun getRealEstate():News{
        return NewsClientApi.getRealEstate()
    }
    suspend fun getSundayReview():News{
        return NewsClientApi.getSundayReview()
    }

    suspend fun getTravel():News{
        return NewsClientApi.getTravel()
    }
    suspend fun getTheater():News{
        return NewsClientApi.getTheater()
    }

    suspend fun getTMagazine():News{
        return NewsClientApi.getTMagazine()
    }
    suspend fun getUpShot():News{
        return NewsClientApi.getUpShot()
    }

}