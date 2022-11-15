package com.example.carethefridge

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.carethefridge.databinding.DeleteDialogBinding

class DeleteDialog(val context: Context) {
    val dialog = Dialog(context)

    fun showDialog(dataFood: DataFood){
        val binding = DeleteDialogBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.tvDDFood.setText(dataFood.name)

        binding.btnDDCancel.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnDDOk.setOnClickListener {
            (context as MainActivity).deliveryFragment.deliveryRecyclerViewAdd(dataFood)
            (context as MainActivity).listFragment.refreshRecycleViewDrop(dataFood)
            dialog.dismiss()
        }
    }
}