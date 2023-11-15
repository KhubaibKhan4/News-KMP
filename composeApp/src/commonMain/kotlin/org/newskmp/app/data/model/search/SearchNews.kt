package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchNews(
    @SerialName("copyright")
    val copyright: String? = null,
    @SerialName("response")
    val response: Response,
    @SerialName("status")
    val status: String? = null
)