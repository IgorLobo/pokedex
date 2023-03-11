package lobo.igor.pokedex.data.repository

import lobo.igor.pokedex.data.api.PokemonApi
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokemonApi) : PokemonRepository {
    override suspend fun getAll() = api.getAll()
}