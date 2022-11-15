package com.example.carethefridge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carethefridge.databinding.FragmentDeliveryBinding


class DeliveryFragment : Fragment() {
    lateinit var  binding : FragmentDeliveryBinding
    var dataFood = mutableListOf<DataFood>()
    var deliveryAdapter : DeliveryAapter = DeliveryAapter(dataFood)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeliveryBinding.inflate(inflater,container,false)
        val linearLayoutManager = LinearLayoutManager(container?.context)
        binding.f2Recyclerview.layoutManager = linearLayoutManager
        binding.f2Recyclerview.adapter = deliveryAdapter

        return binding.root
    }

    fun deliveryRecyclerViewAdd(dataVO:DataFood) {
        dataFood.add(dataVO)
        deliveryAdapter.notifyDataSetChanged()
    }

    fun deliveryRecycleViewDrop(dataVO: DataFood){
        dataFood.remove(dataVO)
        deliveryAdapter.notifyDataSetChanged()
        Toast.makeText(this.context,"주문하기에 삭제 되었습니다", Toast.LENGTH_SHORT).show()
    }

}