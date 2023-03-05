package lobo.igor.pokedex.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import lobo.igor.pokedex.R
import lobo.igor.pokedex.data.model.PokemonListItem
import lobo.igor.pokedex.databinding.ItemPokemonBinding

class PokemonAdapter: ListAdapter<PokemonListItem, PokemonAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<PokemonListItem>() {
        override fun areItemsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonListItem) {
            binding.apply {
                title.text = item.name
                number.text = "#${item.number}"
                image.load(item.image)
            }
        }
    }

}