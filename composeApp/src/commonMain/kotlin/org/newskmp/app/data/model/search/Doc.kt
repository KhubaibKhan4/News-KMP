package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Doc(
    @SerialName("abstract")
    val `abstract`: String,
    @SerialName("byline")
    val byline: Byline,
    @SerialName("document_type")
    val documentType: String,
    @SerialName("headline")
    val headline: Headline,
    @SerialName("_id")
    val id: String,
    @SerialName("keywords")
    val keywords: List<Keyword>,
    @SerialName("lead_paragraph")
    val leadParagraph: String,
    @SerialName("multimedia")
    val multimedia: List<Multimedia>,
    @SerialName("news_desk")
    val newsDesk: String,
    @SerialName("print_page")
    val printPage: String?,
    @SerialName("print_section")
    val printSection: String?,
    @SerialName("pub_date")
    val pubDate: String,
    @SerialName("section_name")
    val sectionName: String,
    @SerialName("snippet")
    val snippet: String,
    @SerialName("source")
    val source: String,
    @SerialName("subsection_name")
    val subsectionName: String?,
    @SerialName("type_of_material")
    val typeOfMaterial: String?,
    @SerialName("uri")
    val uri: String,
    @SerialName("web_url")
    val webUrl: String,
    @SerialName("word_count")
    val wordCount: Int
)