package com.example.homeworkfromezis

import android.media.RouteListingPreference.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homeworkfromezis.databinding.ItemBinding

class RvAdapter(private val items: List<CarModel>, private val onClick: OnClick) :
    RecyclerView.Adapter<RvAdapter.CarViewHolder>() {

    class CarViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CarModel) {
            binding.img.load(item.img)
            binding.tvName.text = item.model
            binding.tvPrice.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClick.onItemClick(item) }
    }
}