package com.example.workout


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.ListFragment

/**
 * A simple [Fragment] subclass.
 */
class WorkoutListFragment : ListFragment() {

    interface Listener{
        fun itemClicked(id: Long)
    }

    private lateinit var listener: Listener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val names = Array<String>(Workout.workouts.size, {Workout.workouts[it].name})
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names)
        setListAdapter(adapter)



        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.listener = context as Listener
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        if (listener != null) listener.itemClicked(id)
    }


}
