package lobo.igor.pokedex

val BASE_URL = "https://pokeapi.co/api/v2/"
val GRAPHQL_BASE_URL = "https://beta.pokeapi.co/graphql/v1beta"
val URL_POKEMON_LIST = "https://pokeapi.co/api/v2/pokemon/"

val IMAGE_URL = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
fun getImageUrlFormatted(id: Int) = "$IMAGE_URL${"%03d".format(id)}.png"

val TOTAL_GENERATIONS = 9