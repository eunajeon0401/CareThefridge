package com.example.carethefridge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carethefridge.databinding.FragmentListBinding


class ListFragment : Fragment() {
    lateinit var binding : FragmentListBinding
    var dataFood = mutableListOf<DataFood>()
    lateinit var listAdapter: ListAdapter
    lateinit var listAddDialog: ListAddDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        for(i in 1 ..8){
            when(i){
                1 -> dataFood.add(DataFood("청양고추","4,800원","200g",R.drawable.chili))
                2 -> dataFood.add(DataFood("치킨너겟","9,980원","480g",R.drawable.chicken))
                3 -> dataFood.add(DataFood("계란","6,780원","30개입",R.drawable.egg))
                4 -> dataFood.add(DataFood("삼겹살","2,780원","100g",R.drawable.pork))
                5 -> dataFood.add(DataFood("두부","2,140원","500g",R.drawable.tofu))
                6 -> dataFood.add(DataFood("마늘","4,980원","300g",R.drawable.garlic))
                7 -> dataFood.add(DataFood("애호박","2,624원","250g",R.drawable.pumpkin))
                8 -> dataFood.add(DataFood("비엔나소세지","9,480원","640g",R.drawable.sausages))

            }
        }

        val linearLayoutManager = LinearLayoutManager(container?.context)

        listAdapter = ListAdapter(dataFood)
        binding.f1Recyclerview.layoutManager =linearLayoutManager
        binding.f1Recyclerview.adapter = listAdapter

        binding.f1btnadd.setOnClickListener {
            listAddDialog = ListAddDialog(binding.root.context)
            listAddDialog.showDailog()
        }
        return binding.root
    }

    fun refreshRecycleViewDrop(dataVO: DataFood){
        Toast.makeText(binding.root.context,"냉장고 리스트에 삭제합니다", Toast.LENGTH_SHORT).show()
        dataFood.remove(dataVO)
        listAdapter.notifyDataSetChanged()
    }

    fun refreshRecycleViewAdd(dataVO: DataFood){
        Toast.makeText(binding.root.context,"냉장고 리스트에 추가합니다", Toast.LENGTH_SHORT).show()
        dataFood.add(dataVO)
        listAdapter.notifyDataSetChanged()
    }

    fun listRecyclerViewAdd(dataVO: DataFood){
        dataFood.add(dataVO)
        listAdapter.notifyDataSetChanged()
        Toast.makeText(binding.root.context,"냉장고 리스트에 추가합니다", Toast.LENGTH_SHORT).show()
    }
}