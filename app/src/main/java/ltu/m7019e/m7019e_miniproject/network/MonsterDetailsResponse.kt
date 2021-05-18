package ltu.m7019e.m7019e_miniproject.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MonsterDetailsResponse {
    @Json(name = "index")
    var index: String = ""

    @Json(name = "name")
    var name: String = ""

    @Json(name = "size")
    var size: String = ""

    @Json(name = "type")
    var type: String = ""

    @Json(name = "alignment")
    var alignment: String = ""

    @Json(name = "strength")
    var strength: String = ""

    @Json(name = "dexterity")
    var dexterity: String = ""

    @Json(name = "constitution")
    var constitution: String = ""

    @Json(name = "intelligence")
    var intelligence: String = ""

    @Json(name = "wisdom")
    var wisdom: String = ""

    @Json(name = "charisma")
    var charisma: String = ""

    @Json(name = "hit_points")
    var hitPoints: String = ""

    @Json(name = "speed")
    lateinit var speed: Speed

    @Json(name = "armor_class")
    var armorClass: String = ""

    @Json(name = "actions")
    var actions: List<Action> = listOf()

}

@JsonClass(generateAdapter = true)
data class Action(
    var damage: List<Damage>,
    var name: String,
)

@JsonClass(generateAdapter = true)
data class Damage(
    var damage_dice: String,
    var damage_type: DamageType
)

@JsonClass(generateAdapter = true)
data class DamageType(
    var name: String
)

@JsonClass(generateAdapter = true)
data class Speed(
    var swim: String,
    var walk: String
)
