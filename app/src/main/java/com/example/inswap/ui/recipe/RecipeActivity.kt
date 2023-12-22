package com.example.inswap.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inswap.R
import com.example.inswap.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecipeBinding
    private lateinit var rvRecipes : RecyclerView
    private val list = ArrayList<Recipes>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvRecipes = binding.listRecipe
        list.addAll(getListRecipes())
        showRecyclerList()
    }

    private fun getListRecipes(): ArrayList<Recipes> {
        val dataName = resources.getStringArray(R.array.recipe_name)
        val dataDescription = resources.getStringArray(R.array.recipe_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.recipe_photo)
        val listRecipe = ArrayList<Recipes>()
        for (i in dataName.indices) {
            val recipe = Recipes(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listRecipe.add(recipe)
        }
        return listRecipe
    }

    private fun showRecyclerList() {
        rvRecipes.layoutManager = LinearLayoutManager(this)
        val listAlbumAdapter = RecipeAdapter(list)
        rvRecipes.adapter = listAlbumAdapter
    }
}