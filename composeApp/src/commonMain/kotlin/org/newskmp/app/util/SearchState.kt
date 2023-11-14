package org.newskmp.app.util

import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.search.SearchNews

sealed class SearchState {
    object Loading : SearchState()
    data class Success(val searchNews: SearchNews): SearchState()
    data class Error(val error: String): SearchState()
}