package lobo.igor.pokedex.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lobo.igor.pokedex.data.api.PokemonApi
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.toModel

class PokemonListViewModel(/*private val pokemonRepository: PokemonApi*/) : ViewModel() {

    private val _pokemonListItemVOList: MutableLiveData<List<PokemonListItem>> = MutableLiveData()
    val pokemonListItemVOList = _pokemonListItemVOList

    init {
        viewModelScope.launch {
            val response = PokemonApi.instance.getAll()
            _pokemonListItemVOList.postValue(response.body()!!.toModel())
        }
    }

}