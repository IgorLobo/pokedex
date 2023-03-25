package lobo.igor.pokedex.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lobo.igor.pokedex.PokemonOriginalQuery
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.PokemonListResult
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : PokemonRepository {
    override suspend fun getAll(): Result<PokemonListResult> {
        return withContext(Dispatchers.IO) {
            val response = apolloClient.query(PokemonOriginalQuery()).execute()

            if (!response.hasErrors()) {
                response.data!!.run {
                    val data = PokemonListResult(
                        count = info.total!!.count,
                        results = pokemons.map { PokemonListItem(it.name, it.id) }
                    )
                    Result.success(data)
                }
            } else {
                Result.failure(ApolloException("Failure"))
            }
        }
    }
}