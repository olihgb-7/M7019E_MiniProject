package ltu.m7019e.m7019e_miniproject.model

data class Character (
        var id: Long,
        var name: String,
        var dndClass: String,
        var race: String,
        var str: Int,
        var dex: Int,
        var con: Int,
        var int: Int,
        var wis: Int,
        var cha: Int,
        var hp: Int,
        var ac: Int,
        var initiative: Int,
        var speed: Int
        )