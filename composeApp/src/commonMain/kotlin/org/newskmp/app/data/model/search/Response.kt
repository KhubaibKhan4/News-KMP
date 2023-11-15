package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("docs")
    val docs: List<Doc?>,
    @SerialName("meta")
    val meta: Meta? = null
)