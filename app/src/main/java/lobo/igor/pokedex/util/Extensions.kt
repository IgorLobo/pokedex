package lobo.igor.pokedex.util

fun String.color() = android.graphics.Color.parseColor(this)

fun String.capitalize() = this.replaceFirstChar { it.titlecase() }