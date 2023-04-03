package lobo.igor.pokedex.util.navigation

import lobo.igor.pokedex.util.appendParams

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        route.plus(params.joinToString(separator = "", prefix = "/") { "{$it}" })
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    object HomeScreen : NoArgumentsDestination("home")
}

