package com.example.diabet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diabet.adapter.ItemAdapter
import com.example.diabet.data.Datasource
import com.example.diabet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

   // private val fragment1: Fragment = HomeFragment()
   // private val fragment2: Fragment = TestFragment()
  //  private val fragment3: Fragment = MapFragment()
  //  private val fm: FragmentManager = supportFragmentManager
  //  private var active = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.test -> replaceFragment(TestFragment())
                R.id.geo -> replaceFragment(MapFragment())

                else ->{

                }
            }
             true
        }
        val myDataset = Datasource().loadDiabet()

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
  //      recyclerView.adapter = ItemAdapter(this, myDataset)
    //    recyclerView.setHasFixedSize(true)
    }

    private fun replaceFragment(fragment : androidx.fragment.app.Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frames_layout,fragment)
        fragmentTransaction.commit()
    }
}