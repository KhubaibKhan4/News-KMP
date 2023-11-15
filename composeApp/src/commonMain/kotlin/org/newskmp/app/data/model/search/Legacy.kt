package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Legacy(
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("thumbnailheight")
    val thumbnailheight: Int? = null,
    @SerialName("thumbnailwidth")
    val thumbnailwidth: Int? = null,
    @SerialName("wide")
    val wide: String? = null,
    @SerialName("wideheight")
    val wideheight: Int? = null,
    @SerialName("widewidth")
    val widewidth: Int? = null,
    @SerialName("xlarge")
    val xlarge: String? = null,
    @SerialName("xlargeheight")
    val xlargeheight: Int? = null,
    @SerialName("xlargewidth")
    val xlargewidth: Int? = null
)