package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    @SerialName("firstname")
    val firstname: String? = null,
    @SerialName("lastname")
    val lastname: String? = null,
    @SerialName("middlename")
    val middlename: String? = null,
    @SerialName("organization")
    val organization: String? = null,
    @SerialName("qualifier")
    val qualifier: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("role")
    val role: String? = null,
    @SerialName("title")
    val title: String? = null
)