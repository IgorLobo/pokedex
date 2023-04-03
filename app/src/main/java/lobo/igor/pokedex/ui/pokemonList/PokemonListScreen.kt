package lobo.igor.pokedex.ui.pokemonList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.data.model.PokemonTypeEnum
import lobo.igor.pokedex.util.capitalize
import lobo.igor.pokedex.util.color

@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel = hiltViewModel()) {
    val data = viewModel.pokemons.collectAsLazyPagingItems()

    PokemonList(data)

    when(val state = data.loadState.refresh) {
        is LoadState.Error -> ErrorState(state.error.message.orEmpty())
        is LoadState.Loading -> LoadingState()
        else -> {}
    }

    when (val state = data.loadState.append) {
        is LoadState.Error -> ErrorState(state.error.message.orEmpty())
        is LoadState.Loading -> LoadingState()
        else -> {}
    }
}

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorState(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}

@Composable
fun PokemonList(data: LazyPagingItems<PokemonListItem>) {
    Column {
        Text(
            text = "Pokedex",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(data.itemCount) { index ->
                data[index]?.let { PokemonCard(it) }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: PokemonListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(pokemon.types.first().colorHex.color())
    ) {
        Box {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = pokemon.name.capitalize(),
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyColumn {
                    items(pokemon.types) { type ->
                        PokemonTypeInfoView(type, PaddingValues(bottom = 4.dp))
                    }
                }
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(pokemon.image).crossfade(true).build(),
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomEnd),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SucessPreview() {
    MaterialTheme {
        val pokemonList = listOf(
            PokemonListItem("Bulbassaur", 1, listOf(PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON)),
            PokemonListItem("Ivyssaur", 2, listOf(PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON)),
            PokemonListItem("Venussaur", 3, listOf(PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON)),
            PokemonListItem("Charmander", 4, listOf(PokemonTypeEnum.FIRE)),
            PokemonListItem("Charmeleon", 5, listOf(PokemonTypeEnum.FIRE)),
            PokemonListItem("Charizard", 6, listOf(PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING)),
        )
//        PokemonList(data = pokemonList)
    }
}