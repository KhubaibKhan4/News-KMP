package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Headline(
    @SerialName("content_kicker")
    val contentKicker: String?,
    @SerialName("kicker")
    val kicker: String?,
    @SerialName("main")
    val main: String,
    @SerialName("name")
    val name: String?,
    @SerialName("print_headline")
    val printHeadline: String?,
    @SerialName("seo")
    val seo: String?,
    @SerialName("sub")
    val sub: String?
)