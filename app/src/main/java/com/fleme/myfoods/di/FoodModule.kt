package com.fleme.myfoods.di

import com.fleme.myfoods.data.api.FoodsAPI
import com.fleme.myfoods.data.repository.FoodRepository
import com.fleme.myfoods.data.repository.FoodRepositoryImpl
import com.fleme.myfoods.presentation.recipes.FoodRecipesContract
import com.fleme.myfoods.presentation.recipes.FoodRecipesPresenter
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object FoodModule {

    val instance = module {
        single<Retrofit> { createRetrofit() }
        single { get<Retrofit>().newBuilder().build().create(FoodsAPI::class.java) }
        single<FoodRepository> { FoodRepositoryImpl(foodAPI = get()) }

        factory<FoodRecipesContract.Presenter> { (view: FoodRecipesContract.View) ->
            FoodRecipesPresenter(view, repository = get())
        }
    }

    private fun createRetrofit() =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.spoonacular.com")
            .build()
}