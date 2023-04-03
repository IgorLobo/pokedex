package lobo.igor.pokedex.util

fun String.color() = android.graphics.Color.parseColor(this)

fun String.capitalize() = this.replaceFirstChar { it.titlecase() }

internal fun String.appendParams(vararg params: Pair<String, Any?>): String =
    this.plus(params.joinToString(separator = "", prefix = "/") { it.second.toString() })