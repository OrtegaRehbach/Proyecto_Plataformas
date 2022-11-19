package com.uvg.spotifyrecommendations

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PlayListParameterFragment : Fragment(R.layout.fragment_play_list_parameter) {
    lateinit var seekBar : SeekBar
    lateinit var valueText : TextView
    lateinit var button : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seekBar = view.findViewById(R.id.seekBar)
        valueText = view.findViewById(R.id.textView5)
        button = view.findViewById(R.id.button)

        seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                valueText.text = seekBar.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })

        button.setOnClickListener {
            val action = PlayListParameterFragmentDirections.actionPlayListParameterFragmentToPlayListDisplayFragment()
            findNavController().navigate(action)
        }
    }

}