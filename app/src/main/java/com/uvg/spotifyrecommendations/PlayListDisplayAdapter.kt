package com.uvg.spotifyrecommendations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PlayListDisplayAdapter(
    private val songList : ArrayList<SongModel>,
    private val listener : (SongModel) -> Unit ) :
    RecyclerView.Adapter<PlayListDisplayAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val coverArtImage : ImageView = itemView.findViewById(R.id.coverArtImageView)
        val songTitle : TextView = itemView.findViewById(R.id.songTitleTextView)
        val artistName : TextView = itemView.findViewById(R.id.artistNameTextView)
        val songDuration : TextView = itemView.findViewById(R.id.songDurationTextView)
        val no : TextView = itemView.findViewById(R.id.NoTextView)
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
        holder.no.text = (position + 1).toString()

        holder.itemView.findViewById<CardView>(R.id.itemCardView).setOnClickListener { listener(currentItem) }
    }

    override fun getItemCount(): Int {
        return songList.size
    }

}