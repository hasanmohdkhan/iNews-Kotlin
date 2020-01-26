package khan.zian.hasan.inews_kotlin.network

import com.squareup.moshi.Json


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
    var results: List<Result>? = null

)


class Result(
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
    var pillarName: String? = null
)