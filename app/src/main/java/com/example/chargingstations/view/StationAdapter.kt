package com.example.chargingstations.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chargingstations.R
import com.example.chargingstations.model.MyUIData

class StationAdapter(private var uiDataList: ArrayList<MyUIData>) :
    RecyclerView.Adapter<StationAdapter.StationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StationViewHolder(layoutInflater.inflate(R.layout.station_item, parent, false))
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val station = uiDataList[position]

        holder.address.text = StringBuilder(holder.address.hint).append(station.address)
        holder.stationLat.text = StringBuilder(holder.stationLat.hint).append(station.stationLat.toString())
        holder.stationLong.text = StringBuilder(holder.stationLong.hint).append(station.stationLong.toString())
        holder.distance.text = (StringBuilder(holder.distance.hint).append(station.distance.toString()).append(" ").append(station.distanceUnit)).toString()
        holder.stationName.text = StringBuilder(holder.stationName.hint).append(station.stationName)
        holder.isOperational.text = StringBuilder(holder.isOperational.hint).append(station.isOperational).toString()
        holder.connectionCount.text = StringBuilder(holder.connectionCount.hint).append(station.connectionCount).toString()
    }

    override fun getItemCount(): Int {
        return uiDataList.size
    }

    fun submitList(itemsList: ArrayList<MyUIData>) {
        val newData = itemsList
        updateAdapter(itemsList)
        uiDataList = newData
    }

    private fun updateAdapter(newData: ArrayList<MyUIData>) {
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return uiDataList.size
            }

            override fun getNewListSize(): Int {
                return newData.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return uiDataList[oldItemPosition].id == newData[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return uiDataList[oldItemPosition] == newData[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
    }

    class StationViewHolder(itemView: View) : ViewHolder(itemView) {
        val address = itemView.findViewById<TextView>(R.id.address)
        val stationLat = itemView.findViewById<TextView>(R.id.stationLat)
        val stationLong = itemView.findViewById<TextView>(R.id.stationLong)
        val distance = itemView.findViewById<TextView>(R.id.distance)
        val stationName = itemView.findViewById<TextView>(R.id.stationName)
        val isOperational = itemView.findViewById<TextView>(R.id.isoperational)
        val connectionCount = itemView.findViewById<TextView>(R.id.connectionCount)

    }
}