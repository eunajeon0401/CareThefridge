package com.example.carethefridge

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.carethefridge.databinding.AgainaddDialogBinding
import com.example.carethefridge.databinding.DeliveryHolderBinding


class DeliveryAapter (val dataDeliveryList: MutableList<DataFood>) : RecyclerView.Adapter<DeliveryAapter.DeliveryViewHolder>() {
    lateinit var addDialog: AgainAddDialog

    override fun getItemCount(): Int = dataDeliveryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding =
            DeliveryHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val deliveryHolder = DeliveryViewHolder(binding)

        deliveryHolder.itemView.setOnClickListener {
            val position : Int = deliveryHolder.bindingAdapterPosition
            val dataSend = dataDeliveryList.get(position)
            (parent.context as MainActivity).deliveryFragment.deliveryRecycleViewDrop(dataSend)
            true
        }

        binding.btnAgainAdd.setOnClickListener {
            val addBinding = AgainaddDialogBinding.inflate(LayoutInflater.from(parent.context))
            val itemPostion = deliveryHolder.adapterPosition
            val dataSend = dataDeliveryList.get(itemPostion)

            addBinding.tvAddFood.setText(dataSend.name)

            var dataVO : DataFood = DataFood(dataSend.name,dataSend.price,dataSend.gram,dataSend.picture)
            addDialog = AgainAddDialog(parent.context)
            addDialog.showDialog(dataVO)
        }
        return deliveryHolder
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        val binding = (holder as DeliveryViewHolder).binding
        val dataVO = dataDeliveryList.get(position)

        binding.ivFood.setImageResource(dataVO.picture)
        binding.tvFoodname.text = dataVO.name
        binding.tvGram.text = dataVO.gram
        binding.tvPrice.text = dataVO.price
    }
    class DeliveryViewHolder(val binding : DeliveryHolderBinding) :RecyclerView.ViewHolder(binding.root)
}



