package org.newskmp.app.util

import org.newskmp.app.data.model.News

sealed class NewsState{
    object Loading : NewsState()
    data class Success(val news: News): NewsState()
    data class Error(val error: String): NewsState()
}
