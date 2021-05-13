package com.kolumbo.recipesbookchinese.di

import com.kolumbo.recipesbookchinese.repo.RecipesRepo
import org.koin.dsl.module

val repositoryModule = module {
    factory { RecipesRepo(get(), get()) }
}