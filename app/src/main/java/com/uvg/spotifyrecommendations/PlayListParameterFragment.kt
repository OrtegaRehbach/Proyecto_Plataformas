package com.uvg.spotifyrecommendations

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PlayListParameterFragment : Fragment(R.layout.fragment_play_list_parameter) {
    lateinit var danceabilitySeekBar : SeekBar
    lateinit var valenceSeekBar : SeekBar
    lateinit var energySeekBar : SeekBar
    lateinit var tempoSeekBar : SeekBar
    lateinit var valueText : TextView
    lateinit var generateButton : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        danceabilitySeekBar = view.findViewById(R.id.danceabilitySeekBar)
        valenceSeekBar = view.findViewById(R.id.valenceSeekBar)
        energySeekBar = view.findViewById(R.id.energySeekBar)
        tempoSeekBar = view.findViewById(R.id.tempoSeekBar)
        valueText = view.findViewById(R.id.valueTestTextView)
        generateButton = view.findViewById(R.id.generatePlaylistButton)

        danceabilitySeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                valueText.text = danceabilitySeekBar.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })

        generateButton.setOnClickListener {
            val action = PlayListParameterFragmentDirections.actionPlayListParameterFragmentToPlayListDisplayFragment(
                danceabilitySeekBar.progress.toString(),
                valenceSeekBar.progress.toString(),
                energySeekBar.progress.toString(),
                tempoSeekBar.progress.toString()
            )
            findNavController().navigate(action)
        }
    }

}