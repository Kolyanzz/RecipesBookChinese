package com.kolumbo.recipesbookchinese.persitence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kolumbo.recipesbookchinese.model.Recipe

@Entity(tableName = "Recipe")
data class RecipeDB(
    @PrimaryKey val title: String,
    @ColumnInfo(name = "href") val href: String?,
    @ColumnInfo(name = "ingredients") val ingredients: String?,
    @ColumnInfo(name = "thumbnail") val thumbnail: String?
) {
    companion object {
        fun map(recipe: Recipe): RecipeDB {
            return RecipeDB(
                title = recipe.title.trim().capitalize(),
                href = recipe.href,
                ingredients = recipe.ingredients.trim().capitalize(),
                thumbnail = recipe.thumbnail
            )
        }

        fun mapList(recipeList: List<Recipe>): List<RecipeDB> {
            val recipePostDBList = mutableListOf<RecipeDB>()
            for (recipe in recipeList) {
                recipePostDBList.add(map(recipe))
            }
            return recipePostDBList
        }
    }
}