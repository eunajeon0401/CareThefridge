package com.example.carethefridge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carethefridge.databinding.RecipeDialogBinding
import com.example.carethefridge.databinding.RecipeHolderBinding

class RecipeAdapter (val dataRecipe: MutableList<DataRecipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>(){

    override fun getItemCount(): Int = dataRecipe.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = RecipeHolderBinding.inflate(LayoutInflater.from(parent.context))
        val recipeViewHolder = RecipeViewHolder(binding)

        recipeViewHolder.itemView.setOnClickListener {
            val position : Int = recipeViewHolder.bindingAdapterPosition
            val dataSend = dataRecipe.get(position)
            (parent.context as MainActivity).recipeFragment.recipeRecycleViewDrop(dataSend)
            true
        }
        return recipeViewHolder
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        val binding = holder.binding
        val dataVO = dataRecipe[position]

        binding.tvCookingTitle2.text = dataVO.title
        binding.tvIngredient2.text = dataVO.ingredient
        binding.tvMenual2.text = dataVO.recipe
    }
    inner class RecipeViewHolder(val binding: RecipeHolderBinding): RecyclerView.ViewHolder(binding.root)
}