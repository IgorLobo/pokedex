package lobo.igor.pokedex.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.repository.PokemonRepository
import javax.inject.Inject

class PokemonDataSource @Inject constructor(
    private val repository: PokemonRepository
) : PagingSource<Int, PokemonListItem>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonListItem>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonListItem> {
        return try {
            val genNumber = params.key ?: 1
            val response = repository.getAll(genNumber)

            LoadResult.Page(
                data = response,
                prevKey = if (genNumber == 1) null else genNumber.minus(1),
                nextKey = if (response.isEmpty()) null else genNumber.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}