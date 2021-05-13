package com.kolumbo.recipesbookchinese.ui.adapter.utils

import android.view.View
import com.kolumbo.recipesbookchinese.extension.contains
import com.kolumbo.recipesbookchinese.extension.gone
import com.kolumbo.recipesbookchinese.extension.visible
import com.kolumbo.recipesbookchinese.persitence.RecipeDB
import com.kolumbo.recipesbookchinese.utils.Constants
import com.kolumbo.recipesbookchinese.utils.ImageUtils
import kotlinx.android.synthetic.main.item_recipe.view.*

fun containsLactoseIngredients(ingredients: String?): Boolean {
    return ingredients?.contains(listOf(Constants.CHEESE, Constants.MILK)) ?: false
}

fun setupViews(it: RecipeDB, itemView: View) {
    it.thumbnail?.let { it1 -> ImageUtils.loadImage(it1, itemView.recipe_thumb, itemView.context) }
    itemView.recipe_title.text = it.title
    itemView.recipe_ingredients.text = it.ingredients
    checkLactose(it, itemView)
}

private fun checkLactose(it: RecipeDB, itemView: View) {
    if (containsLactoseIngredients(it.ingredients)) {
        itemView.recipe_label.visible()
    } else {
        itemView.recipe_label.gone()
    }
}