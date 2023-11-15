package org.newskmp.app.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.newskmp.app.data.model.news.Multimedia

@Serializable
data class Result(
    @SerialName("abstract")
    val `abstract`: String,
    @SerialName("byline")
    val byline: String,
    @SerialName("created_date")
    val createdDate: String,
    @SerialName("des_facet")
    val desFacet: List<String>,
    @SerialName("geo_facet")
    val geoFacet: List<String>,
    @SerialName("item_type")
    val itemType: String,
    @SerialName("kicker")
    val kicker: String,
    @SerialName("material_type_facet")
    val materialTypeFacet: String,
    @SerialName("multimedia")
    val multimedia: List<Multimedia>?,
    @SerialName("org_facet")
    val orgFacet: List<String>,
    @SerialName("per_facet")
    val perFacet: List<String>,
    @SerialName("published_date")
    val publishedDate: String,
    @SerialName("section")
    val section: String,
    @SerialName("short_url")
    val shortUrl: String?,
    @SerialName("subsection")
    val subsection: String?,
    @SerialName("title")
    val title: String,
    @SerialName("updated_date")
    val updatedDate: String,
    @SerialName("uri")
    val uri: String,
    @SerialName("url")
    val url: String
)