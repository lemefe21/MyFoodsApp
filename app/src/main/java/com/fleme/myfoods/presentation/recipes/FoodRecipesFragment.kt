package com.fleme.myfoods.presentation.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.fleme.myfoods.R
import com.fleme.myfoods.model.Recipe
import com.fleme.myfoods.presentation.recipes.adapter.FoodRecipesAdapter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class FoodRecipesFragment :
    Fragment(),
    FoodRecipesContract.View,
    FoodRecipesAdapter.FoodRecipesAdapterListener {

    private val presenter: FoodRecipesContract.Presenter by inject { parametersOf(this) }

    private lateinit var recipesAdapter: FoodRecipesAdapter

    private var recipesList: RecyclerView? = null
    private var recipeCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipesAdapter = FoodRecipesAdapter(context, this)

        presenter.loadRecipes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.run {
            recipesList = findViewById(R.id.rv_recipes)
            recipeCount = findViewById(R.id.tv_recipes_count)
        }
    }

    override fun showRecipes(recipes: MutableList<Recipe>?) {
        recipes?.let {
            recipesList?.adapter = recipesAdapter
            recipesAdapter.run {
                recipesList.addAll(it)
                setRecipeViewCount(recipesList.size)
                notifyDataSetChanged()
            }
        }
    }

    private fun setRecipeViewCount(listCount: Int) {
        recipeCount?.visibility = View.VISIBLE
        recipeCount?.text = context?.resources?.getString(
            R.string.total_recipes, listCount.toString()
        )
    }

    override fun onItemClicked(recipeItem: Recipe) {
        Toast.makeText(context, recipeItem.id.toString(), Toast.LENGTH_SHORT).show()
    }
}