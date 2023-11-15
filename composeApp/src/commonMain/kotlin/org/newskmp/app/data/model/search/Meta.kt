package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("hits")
    val hits: Int? = null,
    @SerialName("offset")
    val offset: Int? = null,
    @SerialName("time")
    val time: Int? = null
)