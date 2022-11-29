package com.example.diabet

//import android.R
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

    val fragment1: Fragment = Home()
    val fragment2: Fragment = Test()
    val fragment3: Fragment = Map()
    val fm: FragmentManager = supportFragmentManager
    var active = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fm.beginTransaction().add(R.id.frames_layout, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.frames_layout, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.frames_layout,fragment1, "1").commit();


        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            if (it.getItemId() == R.id.home) {
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1
            } else if (it.getItemId() == R.id.test) {
                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2
            } else if (it.getItemId() == R.id.geo) {
                fm.beginTransaction().hide(active).show(fragment3).commit()
                active = fragment3
            }

            return@setOnItemSelectedListener true
        }
        val myDataset = Datasource().loadDiabet()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)


        recyclerView.setHasFixedSize(true)
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frames_layout,fragment)
        fragmentTransaction.commit()
    }
}