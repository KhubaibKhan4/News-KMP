package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Keyword(
    @SerialName("major")
    val major: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("value")
    val value: String? = null
)