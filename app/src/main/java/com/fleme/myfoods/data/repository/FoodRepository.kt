package com.fleme.myfoods.data.repository

import com.fleme.myfoods.model.RecipeResponse
import io.reactivex.Observable

interface FoodRepository {
    fun loadRecipes(): Observable<RecipeResponse>
}