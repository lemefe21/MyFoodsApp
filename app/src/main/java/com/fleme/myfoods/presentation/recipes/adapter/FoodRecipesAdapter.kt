package com.fleme.myfoods.presentation.recipes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fleme.myfoods.R
import com.fleme.myfoods.model.Recipe
import com.squareup.picasso.Picasso

class FoodRecipesAdapter(
    val context: Context?,
    val listener: FoodRecipesAdapterListener?
) : RecyclerView.Adapter<FoodRecipesAdapter.FoodRecipesViewHolder>() {

    var recipesList: MutableList<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipes_item_list, parent, false)
        return FoodRecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodRecipesViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener?.onItemClicked(recipesList[position]) }
        holder.bindView(recipesList[position])
    }

    override fun getItemCount() = recipesList.size

    inner class FoodRecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val recipeImage: ImageView = itemView.findViewById(R.id.iv_recipe)
        private val recipeId: TextView = itemView.findViewById(R.id.tv_recipe_id)
        private val recipeTitle: TextView = itemView.findViewById(R.id.tv_recipe_title)

        fun bindView(recipe: Recipe) {
            Picasso.get()
                .load(recipe.image)
                .placeholder(R.drawable.recipe_default)
                .into(recipeImage)

            recipeId.text = recipe.id.toString()
            recipeTitle.text = recipe.title
        }

    }

    interface FoodRecipesAdapterListener {
        fun onItemClicked(recipeItem: Recipe)
    }
}
