package lobo.igor.pokedex.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun isVisible(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}