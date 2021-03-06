package com.kolumbo.recipesbookchinese.repo

import com.kolumbo.recipesbookchinese.api.RecipesService
import com.kolumbo.recipesbookchinese.persitence.RecipeDB
import com.kolumbo.recipesbookchinese.persitence.RecipeDB.Companion.mapList
import com.kolumbo.recipesbookchinese.persitence.RecipeDao

class RecipesRepo(private val recipesService: RecipesService, private val dao: RecipeDao) {

    private suspend fun searchRecipe(query: String, page: Int) =
        recipesService.search(query, page).await()

    suspend fun searchRecipesWithPagination(query: String, page: Int): List<RecipeDB> {
        if (query.isEmpty()) return listOf()

        val request = searchRecipe(query, page)
        return mapList(recipeList = request.items)
    }

    suspend fun saveRecipePersistence(recipe: RecipeDB) {
        dao.insert(recipe)
    }

    suspend fun getAllRecipesPersistence(): List<RecipeDB> {
        return dao.findAllRecipes()
    }

    suspend fun deleteRecipePersistence(recipe: RecipeDB) {
        dao.delete(recipe)
    }
}