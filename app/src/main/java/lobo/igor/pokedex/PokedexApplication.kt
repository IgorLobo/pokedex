package lobo.igor.pokedex

import android.app.Application
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(DebugTree())
        }
    }
}