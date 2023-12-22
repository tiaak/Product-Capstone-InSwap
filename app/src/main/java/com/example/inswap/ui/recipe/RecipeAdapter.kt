package com.example.inswap.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inswap.databinding.ItemRecipeBinding


class RecipeAdapter(private val listRecipe : ArrayList<Recipes>) : RecyclerView.Adapter<RecipeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, _, photo) = listRecipe[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.recipeImage)
        holder.binding.recipeName.text = name
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listRecipe[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listRecipe.size

    class ListViewHolder(val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Recipes)
    }
}