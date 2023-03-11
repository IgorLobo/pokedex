package lobo.igor.pokedex.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.toModel
import lobo.igor.pokedex.data.repository.PokemonRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val pokemonRepository: PokemonRepositoryImpl) : ViewModel() {

    private val _pokemonListItemVOList: MutableLiveData<List<PokemonListItem>> = MutableLiveData()
    val pokemonListItemVOList: LiveData<List<PokemonListItem>> = _pokemonListItemVOList

    init {
        viewModelScope.launch {
            val response = pokemonRepository.getAll()
            _pokemonListItemVOList.postValue(response.body()!!.toModel())
        }
    }

}