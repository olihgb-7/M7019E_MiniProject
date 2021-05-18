package ltu.m7019e.m7019e_miniproject.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharacterRaceResponse {
    @Json(name = "index")
    var index: String = ""

    @Json(name = "alignment")
    var alignment: String = ""

    @Json(name = "age")
    var age: String = ""

    @Json(name = "size_description")
    var sizeDescription: String = ""
}