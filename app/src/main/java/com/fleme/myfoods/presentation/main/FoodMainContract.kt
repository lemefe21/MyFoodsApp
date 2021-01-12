package com.fleme.myfoods.presentation.main

import com.fleme.myfoods.model.Recipe

interface FoodMainContract {

    interface View {
        fun showRecipes(recipes: List<Recipe>?)
    }

    interface Presenter {
        fun loadRecipes()
    }

}