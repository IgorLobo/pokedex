package lobo.igor.pokedex.data.model

import lobo.igor.pokedex.URL_POKEMON_LIST

fun PokemonListResultVO.toModel() = results.map { it.toModel() }

fun PokemonListItemVO.toModel(): PokemonListItem {
    return PokemonListItem(
        name = name,
        number = url.removePrefix(URL_POKEMON_LIST).removeSuffix("/").toInt()
    )//TODO: Alterar para GraphQL e remover a necessidade dessa regra para pegar o ID do pokemon
}