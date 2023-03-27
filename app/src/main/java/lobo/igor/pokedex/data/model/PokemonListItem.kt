package lobo.igor.pokedex.data.model

import lobo.igor.pokedex.getImageUrlFormatted

data class PokemonListItem(val name: String, val number: Int, val types: List<PokemonTypeEnum>) {
    val image: String
        get() = getImageUrlFormatted(number)
}