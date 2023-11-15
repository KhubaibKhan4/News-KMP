package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Multimedia(
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("credit")
    val credit: String? = null,
    @SerialName("crop_name")
    val cropName: String? = null,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("legacy")
    val legacy: Legacy? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("subType")
    val subType: String? = null,
    @SerialName("subtype")
    val subtype: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("width")
    val width: Int? = null
)