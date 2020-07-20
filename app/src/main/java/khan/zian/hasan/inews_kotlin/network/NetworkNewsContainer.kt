package khan.zian.hasan.inews_kotlin.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



class NetworkResponse(
    @Json(name = "response")
    var response: Response? = null
)


data class Response(
    @Json(name = "status")
    var status: String? = null,
    @Json(name = "userTier")
    var userTier: String? = null,
    @Json(name = "total")
    var total: Int? = null,
    @Json(name = "startIndex")
    var startIndex: Int? = null,
    @Json(name = "pageSize")
    var pageSize: Int? = null,
    @Json(name = "currentPage")
    var currentPage: Int? = null,
    @Json(name = "pages")
    var pages: Int? = null,
    @Json(name = "orderBy")
    var orderBy: String? = null,
    @Json(name = "results")
    var news: List<News>? = null

)


data class News(
    @Json(name = "id")
    var id: String? = null,
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "sectionId")
    var sectionId: String? = null,
    @Json(name = "sectionName")
    var sectionName: String? = null,
    @Json(name = "webPublicationDate")
    var webPublicationDate: String? = null,
    @Json(name = "webTitle")
    var webTitle: String? = null,
    @Json(name = "webUrl")
    var webUrl: String? = null,
    @Json(name = "apiUrl")
    var apiUrl: String? = null,
    @Json(name = "isHosted")
    var isHosted: Boolean? = null,
    @Json(name = "pillarId")
    var pillarId: String? = null,
    @Json(name = "pillarName")
    var pillarName: String? = null,

    @Json(name = "fields")
    var fields: Fields
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as News

        if (id != other.id) return false
        if (type != other.type) return false
        if (sectionId != other.sectionId) return false
        if (sectionName != other.sectionName) return false
        if (webPublicationDate != other.webPublicationDate) return false
        if (webTitle != other.webTitle) return false
        if (webUrl != other.webUrl) return false
        if (apiUrl != other.apiUrl) return false
        if (isHosted != other.isHosted) return false
        if (pillarId != other.pillarId) return false
        if (pillarName != other.pillarName) return false
        if (fields != other.fields) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (sectionId?.hashCode() ?: 0)
        result = 31 * result + (sectionName?.hashCode() ?: 0)
        result = 31 * result + (webPublicationDate?.hashCode() ?: 0)
        result = 31 * result + (webTitle?.hashCode() ?: 0)
        result = 31 * result + (webUrl?.hashCode() ?: 0)
        result = 31 * result + (apiUrl?.hashCode() ?: 0)
        result = 31 * result + (isHosted?.hashCode() ?: 0)
        result = 31 * result + (pillarId?.hashCode() ?: 0)
        result = 31 * result + (pillarName?.hashCode() ?: 0)
        result = 31 * result + fields.hashCode()
        return result
    }
}

@JsonClass(generateAdapter = true)
data class Fields(
    @Json(name = "byline")
    val authors: String? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null
//    @Json(name = "body")
//    val body: String,
//    @Json(name = "bodyText")
//    val bodyText: String,
//    @Json(name = "bylineHtml")
//    val bylineHtml: String,
//    @Json(name = "charCount")
//    val charCount: String,
//    @Json(name = "firstPublicationDate")
//    val firstPublicationDate: String,
//    @Json(name = "headline")
//    val headline: String,
//    @Json(name = "isInappropriateForSponsorship")
//    val isInappropriateForSponsorship: String,
//    @Json(name = "isLive")
//    val isLive: String,
//    @Json(name = "isPremoderated")
//    val isPremoderated: String,
//    @Json(name = "lang")
//    val lang: String,
//    @Json(name = "lastModified")
//    val lastModified: String,
//    @Json(name = "legallySensitive")
//    val legallySensitive: String,
//    @Json(name = "main")
//    val main: String,
//    @Json(name = "productionOffice")
//    val productionOffice: String,
//    @Json(name = "publication")
//    val publication: String,
//    @Json(name = "shortUrl")
//    val shortUrl: String,
//    @Json(name = "shouldHideAdverts")
//    val shouldHideAdverts: String,
//    @Json(name = "shouldHideReaderRevenue")
//    val shouldHideReaderRevenue: String,
//    @Json(name = "showAffiliateLinks")
//    val showAffiliateLinks: String,
//    @Json(name = "showInRelatedContent")
//    val showInRelatedContent: String,
    //@Json(name = "standfirst")
   // val standfirst: String,
//    @Json(name = "trailText")
//    val trailText: String,
//    @Json(name = "wordcount")
//    val wordcount: String
)

