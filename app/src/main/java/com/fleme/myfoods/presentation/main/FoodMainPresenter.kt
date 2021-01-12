package com.fleme.myfoods.presentation.main

import android.annotation.SuppressLint
import com.fleme.myfoods.data.repository.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FoodMainPresenter(
    private var view: FoodMainContract.View?,
    private val repository: FoodRepository
): FoodMainContract.Presenter {

    @SuppressLint("CheckResult")
    override fun loadRecipes() {
        repository.loadRecipes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view?.showRecipes(response.recipes)
            }, { error ->
                error.printStackTrace()
            })
    }

}