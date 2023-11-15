package org.newskmp.app.data.model.news


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Multimedia(
    @SerialName("caption")
    val caption: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("format")
    val format: String,
    @SerialName("height")
    val height: Int,
    @SerialName("subtype")
    val subtype: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int
)