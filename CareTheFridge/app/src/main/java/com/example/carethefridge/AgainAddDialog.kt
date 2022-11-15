package com.example.carethefridge

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.carethefridge.databinding.AgainaddDialogBinding

class AgainAddDialog(val context : Context) {
    val dialog = Dialog(context)

    fun showDialog(dataFood: DataFood){
        val binding = AgainaddDialogBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
        )

        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.tvAddFood.setText(dataFood.name)

        binding.btnAddCancel.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnAddOk.setOnClickListener {
            (context as MainActivity).listFragment.refreshRecycleViewAdd(dataFood)
            dialog.dismiss()
        }
    }
}