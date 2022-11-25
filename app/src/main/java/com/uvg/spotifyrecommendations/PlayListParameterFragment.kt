package com.uvg.spotifyrecommendations

import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PlayListParameterFragment : Fragment(R.layout.fragment_play_list_parameter) {
    lateinit var danceabilitySeekBar : SeekBar
    lateinit var valenceSeekBar : SeekBar
    lateinit var energySeekBar : SeekBar
    lateinit var tempoSeekBar : SeekBar
    lateinit var playListSizeEditText : EditText
    lateinit var playListSizeInteger : Integer
    lateinit var minusSizeButton: ImageButton
    lateinit var plusSizeButton: ImageButton
    lateinit var generateButton : Button
    val minSize = 1
    val maxSize = 100
    val increment = 10

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        danceabilitySeekBar = view.findViewById(R.id.danceabilitySeekBar)
        valenceSeekBar = view.findViewById(R.id.valenceSeekBar)
        energySeekBar = view.findViewById(R.id.energySeekBar)
        tempoSeekBar = view.findViewById(R.id.tempoSeekBar)
        minusSizeButton = view.findViewById(R.id.imgBtnMinusSize)
        plusSizeButton = view.findViewById(R.id.imgBtnPlusSize)
        playListSizeEditText = view.findViewById(R.id.editTextPlaylistSize)

        generateButton = view.findViewById(R.id.generatePlaylistButton)

        // Set playListSizeEditText to only accept numbers in 1-100
        playListSizeEditText.filters = arrayOf<InputFilter>(InputFilterMinMax(minSize, maxSize))
        playListSizeInteger = Integer(playListSizeEditText.text.toString())

        playListSizeEditText.addTextChangedListener {
            playListSizeInteger = Integer(playListSizeEditText.text.toString())
        }

        minusSizeButton.setOnClickListener {
            if (playListSizeInteger > increment) {
                playListSizeEditText.setText((playListSizeInteger.toInt() - increment).toString())
            } else {
                playListSizeEditText.setText(minSize.toString())
            }
        }

        plusSizeButton.setOnClickListener {
            if (playListSizeInteger <= maxSize - increment) {
                playListSizeEditText.setText((playListSizeInteger.toInt() + increment).toString())
            } else {
                playListSizeEditText.setText(maxSize.toString())
            }
        }

        generateButton.setOnClickListener {
            val action = PlayListParameterFragmentDirections.actionPlayListParameterFragmentToPlayListDisplayFragment(
                danceabilitySeekBar.progress.toString(),
                valenceSeekBar.progress.toString(),
                energySeekBar.progress.toString(),
                tempoSeekBar.progress.toString(),
                Integer.parseInt(playListSizeEditText.text.toString())
            )
            findNavController().navigate(action)
        }
    }

}