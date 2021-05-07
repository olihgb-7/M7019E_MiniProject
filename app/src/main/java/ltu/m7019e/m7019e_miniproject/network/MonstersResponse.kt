package ltu.m7019e.m7019e_miniproject.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ltu.m7019e.m7019e_miniproject.model.Monster

@JsonClass(generateAdapter = true)
class MonstersResponse {
    @Json(name = "count")
    var count: Int = 0

    @Json(name = "results")
    var results: List<Monster> = listOf()
}