package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Legacy(
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnailheight")
    val thumbnailheight: Int?,
    @SerialName("thumbnailwidth")
    val thumbnailwidth: Int?,
    @SerialName("wide")
    val wide: String?,
    @SerialName("wideheight")
    val wideheight: Int?,
    @SerialName("widewidth")
    val widewidth: Int?,
    @SerialName("xlarge")
    val xlarge: String?,
    @SerialName("xlargeheight")
    val xlargeheight: Int?,
    @SerialName("xlargewidth")
    val xlargewidth: Int?
)