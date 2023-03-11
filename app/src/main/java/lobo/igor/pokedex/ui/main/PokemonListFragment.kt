package lobo.igor.pokedex.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import lobo.igor.pokedex.data.UiState
import lobo.igor.pokedex.databinding.FragmentPokemonListBinding

@AndroidEntryPoint
class PokemonListFragment : Fragment() {
    private val viewModel: PokemonListViewModel by viewModels()
    private lateinit var binding: FragmentPokemonListBinding
    private val adapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentPokemonListBinding.inflate(layoutInflater, container, false)
        this.binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.uiState.collect {
                when(it) {
                    is UiState.Success -> {
                        adapter.submitList(it.data)
                        hideProgress()
                    }
                    is UiState.Error -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                        hideProgress()
                    }
                    is UiState.Loading -> showProgress()
                }
            }
        }
    }

    private fun showProgress() {
        binding.progress.isVisible = true
    }

    private fun hideProgress() {
        binding.progress.isVisible = false
    }
}