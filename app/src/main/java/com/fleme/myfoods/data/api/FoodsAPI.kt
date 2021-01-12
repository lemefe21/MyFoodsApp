package com.fleme.myfoods.data.api

import com.fleme.myfoods.model.RecipeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

private const val RECIPES = "/recipes/complexSearch"

interface FoodsAPI {
    @GET(RECIPES)
    fun loadRecipes(
        @Query("apiKey") apiKey: String
    ) : Observable<RecipeResponse>
}