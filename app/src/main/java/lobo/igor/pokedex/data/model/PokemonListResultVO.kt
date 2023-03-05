package lobo.igor.pokedex.data.model

data class PokemonListResultVO(val count: Int, val next: String?, val results: List<PokemonListItemVO>)

data class PokemonListItemVO(val name: String, val url: String)