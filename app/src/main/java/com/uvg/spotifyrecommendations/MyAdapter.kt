package com.uvg.spotifyrecommendations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val songList : ArrayList<SongModel>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val coverArtImage : ImageView = itemView.findViewById(R.id.coverArtImageView)
        val songTitle : TextView = itemView.findViewById(R.id.songTitleTextView)
        val artistName : TextView = itemView.findViewById(R.id.artistNameTextView)
        val songDuration : TextView = itemView.findViewById(R.id.songDurationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = songList[position]
        holder.coverArtImage.setImageResource(currentItem.coverArtImage)
        holder.songTitle.text = currentItem.songTitle
        holder.artistName.text = currentItem.artistName
        holder.songDuration.text = currentItem.songDuration
    }

    override fun getItemCount(): Int {
        return songList.size
    }

}