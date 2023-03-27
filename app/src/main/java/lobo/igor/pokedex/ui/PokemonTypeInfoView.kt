package lobo.igor.pokedex.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import lobo.igor.pokedex.R
import lobo.igor.pokedex.data.model.PokemonTypeEnum
import lobo.igor.pokedex.util.capitalize

@Composable
fun PokemonTypeInfoView(type: PokemonTypeEnum, paddingValues: PaddingValues) {
    Text(
        text = type.name.lowercase().capitalize(),
        color = Color.White,
        modifier = Modifier
            .padding(paddingValues)
            .background(
                shape = RoundedCornerShape(30.dp),
                color = colorResource(R.color.pokemon_type_info)
            )
            .padding(start = 12.dp, end = 12.dp, top = 2.dp, bottom = 2.dp)
    )
}