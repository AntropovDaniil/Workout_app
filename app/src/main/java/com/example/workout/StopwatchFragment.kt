package com.example.workout


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.postDelayed
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class StopwatchFragment : Fragment(), View.OnClickListener{

    //Seconds on stopwatch
    private var seconds = 0
    //Stopwatch is running
    private var running = false
    private var wasRunning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_stopwatch, container, false)
        runTimer(layout)
        val startButton = layout.findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener(this)
        val stopButton = layout.findViewById<Button>(R.id.stop_button)
        stopButton.setOnClickListener(this)
        val resetButton = layout.findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener(this)

        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) running = true
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    fun onClickStart() {
        running = true
    }

    fun onClickStop(){
        running = false
    }

    fun onClickReset(){
        running = false
        seconds = 0
    }

    private fun runTimer(view: View) {
        val timeView = view.findViewById<TextView>(R.id.time_view)
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                var hours = seconds / 3600
                var minutes = (seconds % 3600) / 60
                var secs = seconds % 60
                var time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)
                timeView.setText(time)
                if (running) seconds++
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }



    }
