package lobo.igor.pokedex.data.repository

import lobo.igor.pokedex.data.model.PokemonListResultVO
import retrofit2.Response

interface PokemonRepository {
    suspend fun getAll(): Response<PokemonListResultVO>
}