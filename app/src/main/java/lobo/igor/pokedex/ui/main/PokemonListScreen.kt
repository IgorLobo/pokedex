package lobo.igor.pokedex.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import lobo.igor.pokedex.R
import lobo.igor.pokedex.data.UiState
import lobo.igor.pokedex.data.model.PokemonListItem

@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel = viewModel()) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            PokemonList(state.data)
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }
}

@Composable
fun PokemonList(data: List<PokemonListItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data) { pokemon ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = dimensionResource(id = R.dimen.card_elevation),
            ) {
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "#${pokemon.number}",
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = pokemon.image,
                            modifier = Modifier.size(200.dp),
                            contentDescription = null
                        )
                        Text(
                            text = pokemon.name,
                            style = MaterialTheme.typography.h6
                        )

                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun sucessPreview() {
    MaterialTheme {
        val pokemonList = listOf(
            PokemonListItem("Charmander", 1),
            PokemonListItem("Charmeleon", 1),
            PokemonListItem("Charizard", 1),
            PokemonListItem("Bulbassauro", 1),
        )
        PokemonList(data = pokemonList)
    }
}