package com.example.carethefridge

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.carethefridge.databinding.ActivityMainBinding
import com.example.carethefridge.databinding.UsertabButtonBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    lateinit var listFragment: ListFragment
    lateinit var deliveryFragment: DeliveryFragment
    lateinit var recipeFragment: RecipeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.drawer_open,
            R.string.drawer_close
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val pagerAdapter = PagerAdapter(this)
        val title = mutableListOf("List", "Delivery", "Recipe")

        listFragment = ListFragment()
        deliveryFragment = DeliveryFragment()
        recipeFragment = RecipeFragment()

        pagerAdapter.addFragment(listFragment, title[0])
        pagerAdapter.addFragment(deliveryFragment, title[1])
        pagerAdapter.addFragment(recipeFragment, title[2])

        binding.viewpager.adapter = pagerAdapter

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.customView = createTabView(title[position])
        }.attach()

        binding.navigationview.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemList ->{
                    binding.viewpager.currentItem = 0
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    Toast.makeText(applicationContext,"리스트 페이지로 이동합니다",Toast.LENGTH_SHORT).show()
                }
                R.id.itemDelivery -> {
                    binding.viewpager.currentItem = 1
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    Toast.makeText(applicationContext,"주문 페이지로 이동합니다",Toast.LENGTH_SHORT).show()
                }
                R.id.itemRecipe -> {
                    binding.viewpager.currentItem = 2
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    Toast.makeText(applicationContext,"레시피 페이지로 이동합니다",Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun createTabView(title: String): View {
        val userTabBinding = UsertabButtonBinding.inflate(layoutInflater)
        userTabBinding.tvHome.text = title

        when(title){
            "List"-> userTabBinding.ivHome.setImageResource(R.drawable.ic_food_24)
            "Delivery"-> userTabBinding.ivHome.setImageResource(R.drawable.ic_delivery_24)
            "Recipe"-> userTabBinding.ivHome.setImageResource(R.drawable.ic_list_24)
        }
        return userTabBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun viewOnClick(view: View){
        when(view.id){
            R.id.btnOrder ->{
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("https://emart.ssg.com/")
                startActivity(intent)
            }
        }
    }
}