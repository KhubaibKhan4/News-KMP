package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Byline(
    @SerialName("organization")
    val organization: String?,
    @SerialName("original")
    val original: String?,
    @SerialName("person")
    val person: List<Person>
)