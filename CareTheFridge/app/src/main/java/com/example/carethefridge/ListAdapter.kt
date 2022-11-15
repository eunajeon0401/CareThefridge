package com.example.carethefridge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carethefridge.databinding.DeleteDialogBinding
import com.example.carethefridge.databinding.ItemHolderBinding

class ListAdapter(val dataList: MutableList<DataFood>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){
    lateinit var deleteDialog: DeleteDialog
    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val listViewHolder = ListViewHolder(binding)

        listViewHolder.itemView.setOnClickListener {
            val deleteBinding = DeleteDialogBinding.inflate(LayoutInflater.from(parent.context))
            val itemPostion = listViewHolder.adapterPosition
            val dataSend = dataList.get(itemPostion)

            deleteBinding.tvDDFood.setText(dataSend.name)

            var dataVO : DataFood = DataFood(dataSend.name,dataSend.price,dataSend.gram,dataSend.picture)
            deleteDialog = DeleteDialog(parent.context)
            deleteDialog.showDialog(dataVO)
        }
        return listViewHolder
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val binding = holder.binding
        val dataVO = dataList[position]

        binding.ivFood.setImageResource(dataVO.picture)
        binding.tvFoodname.text = dataVO.name
        binding.tvGram.text =dataVO.gram
        binding.tvPrice.text = dataVO.price
    }
    inner class ListViewHolder(val binding: ItemHolderBinding): RecyclerView.ViewHolder(binding.root)
}