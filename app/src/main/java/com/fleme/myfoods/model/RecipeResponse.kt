package com.fleme.myfoods.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("results") val recipes: MutableList<Recipe>?
)

data class Recipe(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("imageType") val imageType: String
)