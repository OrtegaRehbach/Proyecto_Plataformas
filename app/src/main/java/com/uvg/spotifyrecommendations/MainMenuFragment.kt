package com.uvg.spotifyrecommendations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnGeneratePlaylist).setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToPlayListDisplayFragment()
            findNavController().navigate(action)
        }
    }
}
