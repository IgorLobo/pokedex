package lobo.igor.pokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import lobo.igor.pokedex.data.UiState
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.toModel
import lobo.igor.pokedex.data.repository.PokemonRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val pokemonRepository: PokemonRepositoryImpl) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<PokemonListItem>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<PokemonListItem>>> = _uiState

    init {
        viewModelScope.launch {
            val response = pokemonRepository.getAll()
            if (response.isSuccessful) {
                _uiState.emit(UiState.Success(response.body()!!.toModel()))
            } else {
                _uiState.emit(UiState.Error(response.message()))
            }
        }
    }

}