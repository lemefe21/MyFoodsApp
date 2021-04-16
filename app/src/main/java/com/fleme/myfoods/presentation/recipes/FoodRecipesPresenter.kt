package com.fleme.myfoods.presentation.recipes

import android.annotation.SuppressLint
import com.fleme.myfoods.data.repository.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FoodRecipesPresenter(
    private var view: FoodRecipesContract.View?,
    private val repository: FoodRepository
) : FoodRecipesContract.Presenter {

    @SuppressLint("CheckResult")
    override fun loadRecipes() {
        repository.loadRecipes()
            .doOnSubscribe { }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { }
            .subscribe({ response ->
                view?.showRecipes(response.recipes)
            }, { error ->
                error.printStackTrace()
            })
    }

}