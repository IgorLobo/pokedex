package lobo.igor.pokedex.data.api

import lobo.igor.pokedex.data.model.PokemonListResultVO
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon")
    suspend fun getAll(): Response<PokemonListResultVO>
}