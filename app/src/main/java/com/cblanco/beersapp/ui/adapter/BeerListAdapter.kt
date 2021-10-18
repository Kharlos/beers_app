package com.cblanco.beersapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cblanco.beersapp.R
import com.cblanco.beersapp.data.model.ui.BeerUiModel
import com.cblanco.beersapp.util.extensionfunctions.loadImgFromUrl

interface OnClickBeerItem {
    fun onClickItem(beerId: Int)
}

class BeerListAdapter(val beerList: List<BeerUiModel>, val interactor: OnClickBeerItem) :
    RecyclerView.Adapter<BeerListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        return BeerListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_beer_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        var beer = beerList[position]
        holder.bind(beer)
        holder.beerItem.setOnClickListener { interactor.onClickItem(beer.id ?: 0) }
    }

    override fun getItemCount(): Int = beerList.size
}

class BeerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val beerItem = itemView.findViewById<CardView>(R.id.beerItem)
    val ivBeerImg = itemView.findViewById<AppCompatImageView>(R.id.ivBeerImg)
    val tvBeerName = itemView.findViewById<TextView>(R.id.tvBeerName)

    fun bind(beer: BeerUiModel) {
        ivBeerImg.loadImgFromUrl(beer.image_url ?: "")
        tvBeerName.text = beer.name

    }

}