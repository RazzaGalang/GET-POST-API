package com.example.getpostapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.getpostapi.mvvm.ui.main.view.RecyclerFragment
import com.example.getpostapi.mvvm.ui.main.view.RegisterFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(RegisterFragment())
        changeFragmentClick()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun changeFragmentClick (){
        val change = findViewById<FloatingActionButton>(R.id.changeFragment)
        change.setOnClickListener {
            replaceFragment(RecyclerFragment())
        }
    }
}