package com.cblanco.beersapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.cblanco.beersapp.R
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.util.extensionfunctions.loadImgFromUrl

class BeerListAdapter(val beerList: List<BeerUiModel>) :
    RecyclerView.Adapter<BeerListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        return BeerListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_beer_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        holder.bind(beerList[position])
    }

    override fun getItemCount(): Int = beerList.size
}

class BeerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivBeerImg = itemView.findViewById<AppCompatImageView>(R.id.ivBeerImg)
    val tvBeerName = itemView.findViewById<TextView>(R.id.tvBeerName)

    fun bind(beer: BeerUiModel){
        ivBeerImg.loadImgFromUrl(beer.image_url ?: "")
        tvBeerName.text = beer.name
    }

}