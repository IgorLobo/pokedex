package lobo.igor.pokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import lobo.igor.pokedex.data.PokemonDataSource
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val dataSource: PokemonDataSource) : ViewModel() {

    val pokemons = Pager(PagingConfig(1)) {
        dataSource
    }.flow

}