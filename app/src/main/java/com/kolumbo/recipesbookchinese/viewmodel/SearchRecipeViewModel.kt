package com.kolumbo.recipesbookchinese.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.LivePagedListBuilder
import com.kolumbo.recipesbookchinese.api.NetworkState
import com.kolumbo.recipesbookchinese.base.BaseViewModel
import com.kolumbo.recipesbookchinese.datasource.RecipeDataSourceFactory
import com.kolumbo.recipesbookchinese.persitence.RecipeDB
import com.kolumbo.recipesbookchinese.repo.RecipesRepo
import com.kolumbo.recipesbookchinese.utils.pagedListConfig

class SearchRecipeViewModel(repo: RecipesRepo) : BaseViewModel() {

    private val recipeDataSource = RecipeDataSourceFactory(repository = repo, scope = ioScope)

    val recipes = LivePagedListBuilder(recipeDataSource, pagedListConfig()).build()
    val networkState: LiveData<NetworkState>? = switchMap(recipeDataSource.source) { it.getNetworkState() }

    fun fetchRecipesByIngredients(query: String) {
        val search = query.trim()
        recipeDataSource.updateQuery(search)
    }

    fun refreshFailedRequest() =
        recipeDataSource.getSource()?.retryFailedQuery()

    fun refreshAllList() =
        recipeDataSource.getSource()?.refresh()

    fun getCurrentQuery() =
        recipeDataSource.getQuery()

    fun saveRecipePersistent(recipe: RecipeDB?) {
        recipeDataSource.saveRecipePersistence(recipe)
    }
}