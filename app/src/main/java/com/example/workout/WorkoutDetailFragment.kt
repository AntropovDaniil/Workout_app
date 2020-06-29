package com.example.workout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_workout_detail.*

/**
 * A simple [Fragment] subclass.
 */
class WorkoutDetailFragment : Fragment() {
    private var workoutId: Long = -1

    override fun onCreateView(
                            inflater: LayoutInflater,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    fun setWorkout(id: Long){
        this.workoutId = id
    }

    override fun onStart() {
        super.onStart()
        val view: View? = getView()
        if (view != null){
            val title = view.findViewById<TextView>(R.id.textTitle)
            val workout: Workout = Workout.workouts[workoutId.toInt()]
            title.setText(workout.name)
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.setText(workout.description)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            val stopwatch = StopwatchFragment()
            val fragmentTransaction = getChildFragmentManager().beginTransaction()
            fragmentTransaction.add(R.id.stopwatch_container, stopwatch)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.commit()
        }
        else workoutId = savedInstanceState.getLong("workoutId")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("workoutId", workoutId)
    }


}
