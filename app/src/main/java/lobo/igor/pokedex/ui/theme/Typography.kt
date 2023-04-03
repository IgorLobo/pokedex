package lobo.igor.pokedex.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import lobo.igor.pokedex.R

// Font's variations
object Kanit {
    val Medium = Font(R.font.kanit_medium, FontWeight.Medium)
    val SemiBold = Font(R.font.kanit_semibold, FontWeight.SemiBold)
    val Bold = Font(R.font.kanit_bold, FontWeight.Bold)
}


// Font family
val ArtifaktFontFamily = FontFamily(listOf(Kanit.Medium, Kanit.SemiBold, Kanit.Bold))


// Finally our Typography
val Typography = Typography(
    defaultFontFamily = ArtifaktFontFamily,
)