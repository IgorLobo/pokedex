package lobo.igor.pokedex.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lobo.igor.pokedex.databinding.FragmentPokemonListBinding

class PokemonListFragment : Fragment() {
    private lateinit var viewModel: PokemonListViewModel
    private lateinit var binding: FragmentPokemonListBinding
    private val adapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentPokemonListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        binding.recyclerView.adapter = adapter
        viewModel.pokemonListItemVOList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}