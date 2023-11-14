package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Keyword(
    @SerialName("major")
    val major: String,
    @SerialName("name")
    val name: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("value")
    val value: String
)