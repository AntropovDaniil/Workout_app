package com.example.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class TempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
       if (savedInstanceState == null){
            val stopwatch = StopwatchFragment()
            val fragmentTransaction = getSupportFragmentManager().beginTransaction()
            fragmentTransaction.add(R.id.stopwatch_container, stopwatch)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.commit()
        }
    }
}
