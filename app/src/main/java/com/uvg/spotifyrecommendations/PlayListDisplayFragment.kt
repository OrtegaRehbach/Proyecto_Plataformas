package com.uvg.spotifyrecommendations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PlayListDisplayFragment : Fragment(R.layout.fragment_play_list_display) {

    private lateinit var playListRecyclerView: RecyclerView
    private lateinit var songList: ArrayList<SongModel>
    private lateinit var imageId : Array<Int>
    private lateinit var songTitles : Array<String>
    private lateinit var artistNames : Array<String>
    private lateinit var songDurations : Array<String>
    private val listSize = 50

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpImageIds()
        setUpSongTitles()
        setUpArtistNames()
        setUpSongDurations()

        setUpSongList()

        playListRecyclerView = view.findViewById(R.id.PlayListRecyclerView)
        playListRecyclerView.layoutManager = LinearLayoutManager(context)
        playListRecyclerView.setHasFixedSize(true)
        playListRecyclerView.adapter = MyAdapter(songList)
    }

    private fun setUpImageIds() {
        imageId = arrayOf(
            R.drawable.album_art_placeholder
        )
    }

    private fun setUpSongTitles() {
        songTitles = Array<String>(listSize) {
            "Song Title " + (it + 1)
        }
    }

    private fun setUpArtistNames() {
        artistNames = Array<String>(listSize) {
            "Artist " + (it + 1)
        }
    }

    private fun setUpSongDurations() {
        songDurations = Array<String>(listSize) {
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