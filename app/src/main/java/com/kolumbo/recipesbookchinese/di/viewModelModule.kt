package com.kolumbo.recipesbookchinese.di

import com.kolumbo.recipesbookchinese.viewmodel.FavouritesRecipeViewModel
import com.kolumbo.recipesbookchinese.viewmodel.SearchRecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchRecipeViewModel(get()) }
    viewModel { FavouritesRecipeViewModel(get()) }
}