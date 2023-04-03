package lobo.igor.pokedex.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import lobo.igor.pokedex.ui.pokemonList.PokemonListScreen
import lobo.igor.pokedex.ui.theme.ComposeTheme
import lobo.igor.pokedex.util.navigation.Destination
import lobo.igor.pokedex.util.navigation.NavHost
import lobo.igor.pokedex.util.navigation.NavigationEffects
import lobo.igor.pokedex.util.navigation.composable

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = mainViewModel.navigationChannel,
        navHostController = navController
    )
    ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navController,
                startDestination = Destination.HomeScreen
            ) {
                composable(Destination.HomeScreen) {
                    PokemonListScreen()
                }
            }
        }
    }
}

