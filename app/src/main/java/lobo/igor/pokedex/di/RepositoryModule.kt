package lobo.igor.pokedex.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lobo.igor.pokedex.data.repository.PokemonRepository
import lobo.igor.pokedex.data.repository.PokemonRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}