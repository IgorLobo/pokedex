package lobo.igor.pokedex.data.repository

import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.PokemonListResult
import retrofit2.Response

interface PokemonRepository {
    suspend fun getAll(generation: Int = 1): List<PokemonListItem>
}