package com.example.carethefridge

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.carethefridge.databinding.RecipeDialogBinding

class RecipeDialog (val context : Context){
    val dialog = Dialog(context)


    fun showDailog(){
        val binding = RecipeDialogBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnRDCancel.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnRDOk.setOnClickListener {
            val title = binding.edtRDTitle.text.toString()
            val ingredient = binding.edtRDIngredient.text.toString()
            val recipe = binding.edtRDMenual.text.toString()
            var dataSent : DataRecipe

            dataSent = DataRecipe(title,ingredient,recipe)
            (context as MainActivity).recipeFragment.recipeRecyclerView(dataSent)
            dialog.dismiss()
        }
    }
}