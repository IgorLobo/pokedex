package lobo.igor.pokedex.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lobo.igor.pokedex.PokemonOriginalQuery
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.PokemonTypeEnum
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : PokemonRepository {
    override suspend fun getAll(generation: Int): List<PokemonListItem> {
        return withContext(Dispatchers.IO) {
            val response = apolloClient.query(PokemonOriginalQuery(generation)).execute()

            if (response.hasErrors().not()) {
                response.data!!.pokemons.map {
                    PokemonListItem(
                        it.name,
                        it.id,
                        it.detail.first().types.map { type -> PokemonTypeEnum.fromName(type.type?.name) }
                    )
                }
            } else {
                throw ApolloException(response.errors?.joinToString { it.message } ?: "Generic error")
            }
        }
    }
}