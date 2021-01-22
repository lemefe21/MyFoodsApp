package com.fleme.myfoods.presentation.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fleme.myfoods.R
import com.fleme.myfoods.model.Recipe
import kotlinx.android.synthetic.main.fragment_food_recipes.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FoodRecipesFragment : Fragment(), FoodRecipesContract.View {

    private val presenter: FoodRecipesContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.loadRecipes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_recipes, container, false)
    }

    override fun showRecipes(recipes: List<Recipe>?) {
        recipes.let {
            recipes_text.text = recipes.toString()
        }
    }
}