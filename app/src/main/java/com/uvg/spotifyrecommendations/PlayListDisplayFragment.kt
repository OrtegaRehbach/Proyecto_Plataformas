package com.uvg.spotifyrecommendations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class PlayListDisplayFragment : Fragment(R.layout.fragment_play_list_display) {

    val args: PlayListDisplayFragmentArgs by navArgs()
    private lateinit var playListRecyclerView: RecyclerView
    private lateinit var songList: ArrayList<SongModel>
    private lateinit var imageId : Array<Int>
    private lateinit var songTitles : Array<String>
    private lateinit var artistNames : Array<String>
    private lateinit var songDurations : Array<String>
    private lateinit var listSize : Integer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assigning args to TextViews
        view.findViewById<TextView>(R.id.txtDanceabilityValue).text = args.danceabilityValue
        view.findViewById<TextView>(R.id.txtValenceValue).text = args.valenceValue
        view.findViewById<TextView>(R.id.txtEnergyValue).text = args.energyValue
        view.findViewById<TextView>(R.id.txtTempoValue).text = args.tempoValue

        listSize = Integer(args.playListSize)

        setUpImageIds()
        setUpSongTitles()
        setUpArtistNames()
        setUpSongDurations()

        setUpSongList()

        playListRecyclerView = view.findViewById(R.id.PlayListRecyclerView)
        playListRecyclerView.layoutManager = LinearLayoutManager(context)
        playListRecyclerView.setHasFixedSize(true)
        playListRecyclerView.adapter = MyAdapter(songList) {
            val action = PlayListDisplayFragmentDirections.actionPlayListDisplayFragmentToSongDetailFragment(
                it.songTitle,
                it.artistName,
                it.songDuration
            )
            findNavController().navigate(action)
        }
    }

    private fun setUpImageIds() {
        imageId = arrayOf(
            R.drawable.album_art_placeholder
        )
    }

    private fun setUpSongTitles() {
        songTitles = Array<String>(listSize.toInt()) {
            "Song Title " + (it + 1)
        }
    }

    private fun setUpArtistNames() {
        artistNames = Array<String>(listSize.toInt()) {
            "Artist " + (it + 1)
        }
    }

    private fun setUpSongDurations() {
        songDurations = Array<String>(listSize.toInt()) {
            "3:30"
        }
    }

    private fun setUpSongList() {
        songList = arrayListOf<SongModel>()
        for (i in songTitles.indices) {
            songList.add(SongModel(
                imageId[0],
                songTitles[i],
                artistNames[i],
                songDurations[i]))
        }
    }
}