package com.kolumbo.recipesbookchinese.model

import com.google.gson.annotations.SerializedName

data class NetworkResult(
    @SerializedName("results") val items: List<Recipe>
)