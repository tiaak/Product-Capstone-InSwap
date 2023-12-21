package com.example.inswap.ui.maggot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inswap.R

class ListMaggotAdaptor(private val listMaggot: ArrayList<MaggotFarm>): RecyclerView.Adapter<ListMaggotAdaptor.ListViewHolder>() {
//    private lateinit var onItemClickCallBack: OnItemClickCallback
//    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallback){
//        this.onItemClickCallBack = onItemClickCallBack
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: MaggotFarm)
//    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFarmName: TextView = itemView.findViewById(R.id.farmName)
        val tvAddress: TextView = itemView.findViewById(R.id.location)
        val tvPhoneNum: TextView = itemView.findViewById(R.id.phoneNumber)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_maggot, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListMaggotAdaptor.ListViewHolder, position: Int) {
        val(farmName, address, phoneNum) = listMaggot[position]
        holder.tvFarmName.text = farmName
        holder.tvAddress.text = address
        holder.tvPhoneNum.text = phoneNum

//        holder.itemView.setOnClickListener{onItemClickCallBack.onItemClicked(listMaggot[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return  listMaggot.size
    }
}