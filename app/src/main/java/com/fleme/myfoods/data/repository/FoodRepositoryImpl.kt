package com.fleme.myfoods.data.repository

import com.fleme.myfoods.BuildConfig
import com.fleme.myfoods.data.api.FoodsAPI
import com.fleme.myfoods.model.RecipeResponse
import io.reactivex.Observable

class FoodRepositoryImpl(
    private val foodAPI: FoodsAPI
): FoodRepository {

    override fun loadRecipes(): Observable<RecipeResponse> {
        return foodAPI.loadRecipes(BuildConfig.API_KEY, SIZE)
    }

    companion object {
        private const val SIZE = 20
    }

}