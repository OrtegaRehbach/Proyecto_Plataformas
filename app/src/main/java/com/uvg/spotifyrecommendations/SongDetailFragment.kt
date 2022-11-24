package com.uvg.spotifyrecommendations

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class SongDetailFragment : Fragment(R.layout.fragment_song_detail) {

    val args: SongDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.txtViewSongNameDisp).text = args.songName
        view.findViewById<TextView>(R.id.txtViewArtistNameDisp).text = args.artistName
        view.findViewById<TextView>(R.id.txtViewSongDurationDisp).text = args.songDuration
    }
}