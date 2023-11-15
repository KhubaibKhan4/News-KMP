package org.newskmp.app.data.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Doc(
    @SerialName("abstract")
    val `abstract`: String? = null,
    @SerialName("byline")
    val byline: Byline? = null,
    @SerialName("document_type")
    val documentType: String? = null,
    @SerialName("headline")
    val headline: Headline? = null,
    @SerialName("_id")
    val id: String? = null,
    @SerialName("keywords")
    val keywords: List<Keyword>? = null,
    @SerialName("lead_paragraph")
    val leadParagraph: String? = null,
    @SerialName("multimedia")
    val multimedia: List<Multimedia>? = null,
    @SerialName("news_desk")
    val newsDesk: String? = null,
    @SerialName("print_page")
    val printPage: String? = null,
    @SerialName("print_section")
    val printSection: String? = null,
    @SerialName("pub_date")
    val pubDate: String? = null,
    @SerialName("section_name")
    val sectionName: String? = null,
    @SerialName("snippet")
    val snippet: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("subsection_name")
    val subsectionName: String? = null,
    @SerialName("type_of_material")
    val typeOfMaterial: String? = null,
    @SerialName("uri")
    val uri: String? = null,
    @SerialName("web_url")
    val webUrl: String? = null,
    @SerialName("word_count")
    val wordCount: Int? = null
)