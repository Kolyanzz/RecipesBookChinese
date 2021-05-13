package com.kolumbo.recipesbookchinese

import android.app.Application
import com.kolumbo.recipesbookchinese.di.networkModule
import com.kolumbo.recipesbookchinese.di.repositoryModule
import com.kolumbo.recipesbookchinese.di.roomModule
import com.kolumbo.recipesbookchinese.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecipesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger() // Koin Logger
            androidContext(this@RecipesApplication)
            modules(listOf(roomModule, viewModelModule, networkModule, repositoryModule))
        }
    }
}