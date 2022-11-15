package com.example.carethefridge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carethefridge.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    lateinit var binding : FragmentRecipeBinding
    var datalist =mutableListOf<DataRecipe>()
    lateinit var recipeAdapter: RecipeAdapter
    lateinit var recipeDialog: RecipeDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater,container,false)

        datalist.add(DataRecipe("김치볶음밥","김치, 설탕, 간장, 햄, 고추가루, 굴소스","식용류에 다진 김치를 넣고 볶는다 어느 정도 볶아지면 설탕을 넣고 간장 한숟갈 정도 넣고 햄을 넣고 볶는다 " +
                "밥을넣고 굴소스 3/1숟갈을 넣는다 기호에따라 참기름 넣기."))

        val linearLayoutManager = LinearLayoutManager(container?.context)

        recipeAdapter = RecipeAdapter(datalist)

        binding.f3Recyclerview.layoutManager = linearLayoutManager
        binding.f3Recyclerview.adapter = recipeAdapter

        binding.ftbtnRecipe.setOnClickListener {
            recipeDialog = RecipeDialog(binding.root.context)
            recipeDialog.showDailog()
        }
        return binding.root
    }

    fun recipeRecyclerView(dataMenual: DataRecipe){
        datalist.add(dataMenual)
        recipeAdapter.notifyDataSetChanged()
        Toast.makeText(this.context,"레시피가 추가되었습니다", Toast.LENGTH_SHORT).show()
    }

    fun recipeRecycleViewDrop(dataMenual: DataRecipe){
        datalist.remove(dataMenual)
        recipeAdapter.notifyDataSetChanged()
        Toast.makeText(this.context,"레시피가 삭제되었습니다", Toast.LENGTH_SHORT).show()
    }
}