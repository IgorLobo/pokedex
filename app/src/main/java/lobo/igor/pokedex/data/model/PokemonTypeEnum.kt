package lobo.igor.pokedex.data.model

enum class PokemonTypeEnum(val colorHex: String) {
    BUG("#AABB22"),
    DARK("#775544"),
    DRAGON("#7766EE"),
    ELECTRIC("#FFCC33"),
    FAIRY("#EE99EE"),
    FIGHTING("#BB5544"),
    FIRE("#FF4422"),
    FLYING("#8899FF"),
    GHOST("#6666BB"),
    GRASS("#77CC55"),
    GROUND("#DDBB55"),
    ICE("#66CCFF"),
    NORMAL("#AAAA99"),
    POISON("#AA5599"),
    PSYCHIC("#FF5599"),
    ROCK("#BBAA66"),
    SHADOW("#000000"),
    STEEL("#AAAABB"),
    UNKNOW("#000000"),
    WATER("#3399FF");

    companion object {
        fun fromName(value: String?) = values().first { it.name.equals(value, true) }
    }
}