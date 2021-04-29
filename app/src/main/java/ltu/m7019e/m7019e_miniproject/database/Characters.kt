package ltu.m7019e.m7019e_miniproject.database

import ltu.m7019e.m7019e_miniproject.model.Character

class Characters {
    val list = mutableListOf<Character>()

    init {
        list.add(
            Character(
                1,
                "Vax'ildan",
                "Rogue",
                "Half-Elf",
                14,
                20,
                12,
                16,
                14,
                14,
                127,
                20,
                5,
                30
            )
        )
        list.add(
            Character(
                2,
                "Vex'ahlia",
                "Ranger",
                "Half-Elf",
                7,
                20,
                10,
                14,
                16,
                17,
                142,
                21,
                7,
                30
            )
        )
        list.add(
            Character(
                3,
                "Percival Fredrickstein Von Musel Klossowski De Rolo III",
                "Ranger", // Gunslinger but that isn't a class that I have implemented...
                "Human",
                12,
                22,
                14,
                20,
                16,
                14,
                202,
                18,
                12,
                30
            )
        )
        list.add(
            Character(
                4,
                "Scanlan Shorthalt",
                "Bard",
                "Gnome",
                13,
                11,
                16,
                16,
                7,
                22,
                183,
                16,
                3,
                25
            )
        )
        list.add(
            Character(
                5,
                "Pike Trickfoot",
                "Cleric",
                "Gnome",
                19,
                12,
                14,
                13,
                20,
                14,
                172,
                23,
                0,
                25
            )
        )
        list.add(
            Character(
                6,
                "Grog Strongjaw",
                "Barbarian",
                "Half-Orc", // Goliath but that isn't a race that I have implemented...
                26,
                15,
                22,
                6,
                10,
                13,
                277,
                19,
                2,
                50
            )
        )
        list.add(
            Character(
                7,
                "Keyleth",
                "Druid",
                "Half-Elf",
                14,
                15,
                14,
                15,
                22,
                10,
                147,
                17,
                2,
                30
            )
        )
    }
}