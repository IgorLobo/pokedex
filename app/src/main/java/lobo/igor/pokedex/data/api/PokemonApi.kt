package lobo.igor.pokedex.data.api

import lobo.igor.pokedex.BASE_URL
import lobo.igor.pokedex.data.model.PokemonListResultVO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface PokemonApi {

    @GET("pokemon")
    suspend fun getAll(): Response<PokemonListResultVO>

    companion object {
        val instance: PokemonApi by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(PokemonApi::class.java)
        }
    }
}