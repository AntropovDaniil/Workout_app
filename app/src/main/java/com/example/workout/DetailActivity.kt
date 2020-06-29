package com.example.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_detail.*
import kotlin.concurrent.fixedRateTimer

class DetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_WORKOUT_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val workoutFragment: WorkoutDetailFragment = getSupportFragmentManager().findFragmentById(R.id.detail_frag) as WorkoutDetailFragment
        val workoutId = getIntent().getExtras()?.get(EXTRA_WORKOUT_ID) as Int
        workoutFragment.setWorkout(workoutId.toLong())

    }
}
