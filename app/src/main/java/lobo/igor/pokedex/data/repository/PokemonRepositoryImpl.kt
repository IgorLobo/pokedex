package lobo.igor.pokedex.data.repository

import lobo.igor.pokedex.data.api.PokemonApi

class PokemonRepositoryImpl(
    private val api: PokemonApi
    ) : PokemonRepository {

    override suspend fun getAll() = api.getAll()


}