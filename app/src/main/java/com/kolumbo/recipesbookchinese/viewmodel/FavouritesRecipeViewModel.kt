package com.kolumbo.recipesbookchinese.viewmodel

import androidx.lifecycle.MutableLiveData
import com.kolumbo.recipesbookchinese.base.BaseViewModel
import com.kolumbo.recipesbookchinese.persitence.RecipeDB
import com.kolumbo.recipesbookchinese.repo.RecipesRepo
import kotlinx.coroutines.launch

class FavouritesRecipeViewModel(private val repo: RecipesRepo) : BaseViewModel() {

    var recipes = MutableLiveData<List<RecipeDB>>()

    fun loadRecipesPersistence() {
        ioScope.launch {
            val listRetrieved = repo.getAllRecipesPersistence()
            mainScope.launch {
                recipes.value = listRetrieved
            }
        }
    }

    fun deleteRecipePersistence(recipeDB: RecipeDB) {
        ioScope.launch {
            repo.deleteRecipePersistence(recipeDB)
            loadRecipesPersistence() //Reload data
        }
    }
}