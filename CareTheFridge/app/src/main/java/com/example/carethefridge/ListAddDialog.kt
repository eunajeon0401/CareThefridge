package com.example.carethefridge

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import com.example.carethefridge.databinding.ListaddDialogBinding
import com.example.carethefridge.databinding.RecipeDialogBinding

class ListAddDialog(val context : Context){
    val dialog = Dialog(context)
    lateinit var dataFood : DataFood

    fun showDailog(){
        val binding = ListaddDialogBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnListAddCancel.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnListAddOK.setOnClickListener {
            val name = binding.edtAddName.text.toString()
            val price = binding.edtAddPrice.text.toString()
            val gram = binding.edtAddGram.text.toString()
            val picture :Int

            if(name.contains("고추")){
                dataFood = DataFood(name,price,gram,R.drawable.chili)
            }else if(name.contains("마늘")){
                dataFood = DataFood(name,price,gram,R.drawable.garlic)
            }else if(name.contains("삼겹살")){
                dataFood = DataFood(name,price,gram,R.drawable.pork)
            }else if(name.contains("치킨너겟")){
                dataFood = DataFood(name,price,gram,R.drawable.chicken)
            }else if(name.contains("계란")){
                dataFood = DataFood(name,price,gram,R.drawable.egg)
            }else if(name.contains("두부")){
                dataFood = DataFood(name,price,gram,R.drawable.tofu)
            }else if(name.contains("소세지")){
                dataFood = DataFood(name,price,gram,R.drawable.sausages)
            }else if(name.contains("애호박")){
                dataFood = DataFood(name,price,gram,R.drawable.pumpkin)
            }else {
                Toast.makeText(context,"재료를 넣을 수 가없습니다",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            (context as MainActivity).listFragment.listRecyclerViewAdd(dataFood)
            dialog.dismiss()
        }
    }
}