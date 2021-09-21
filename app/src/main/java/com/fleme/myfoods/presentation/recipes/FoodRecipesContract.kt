package com.fleme.myfoods.presentation.recipes

import com.fleme.myfoods.model.Recipe

interface FoodRecipesContract {

    interface View {
        fun showRecipes(recipes: MutableList<Recipe>?)
    }

    interface Presenter {
        fun loadRecipes()
    }

}