package com.fleme.myfoods.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fleme.myfoods.R
import com.fleme.myfoods.di.FoodModule
import com.fleme.myfoods.extensions.createFragmentTransaction
import com.fleme.myfoods.presentation.recipes.FoodRecipesFragment
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FoodMainActivity : AppCompatActivity() {

    private val module = FoodModule.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        loadKoinModules(module)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            createRecipesFragment()
        }
    }

    private fun createRecipesFragment() {
        createFragmentTransaction {
            add(R.id.main_container, FoodRecipesFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(module)
    }
}