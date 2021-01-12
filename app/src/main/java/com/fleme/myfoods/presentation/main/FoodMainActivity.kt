package com.fleme.myfoods.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fleme.myfoods.R
import com.fleme.myfoods.di.FoodModule
import com.fleme.myfoods.model.Recipe
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.parameter.parametersOf

class FoodMainActivity : AppCompatActivity(),
        FoodMainContract.View {

    private val presenter: FoodMainContract.Presenter by inject { parametersOf(this) }
    private val module = FoodModule.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        loadKoinModules(module)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadRecipes()
    }

    override fun showRecipes(recipes: List<Recipe>?) {
        recipes.let {
            recipes_text.text = recipes.toString()
        }
    }

    override fun onDestroy() {
        unloadKoinModules(module)
        super.onDestroy()
    }
}