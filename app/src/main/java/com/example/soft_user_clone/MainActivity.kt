package com.example.soft_user_clone

import Adapter.Frag_Adapter
import Fragments.AddData
import Fragments.DisplayFragment
import Fragments.WebFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomm : BottomNavigationView = findViewById(R.id.bottom_nav)
        val homee = DisplayFragment()
        val addd = AddData()
        val abouut = WebFragment()
        doo()

        makeCurrentFrag(homee)

        bottomm.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_display -> makeCurrentFrag(homee)
                R.id.ic_add -> makeCurrentFrag(addd)
                R.id.ic_about -> makeCurrentFrag(abouut)
            }
            true
        }
    }

    private fun makeCurrentFrag(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pager2, fragment)
                commit()
            }

}