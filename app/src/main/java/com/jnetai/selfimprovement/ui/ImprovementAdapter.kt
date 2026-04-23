package com.jnetai.selfimprovement.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnetai.selfimprovement.databinding.ItemMainBinding
import com.jnetai.selfimprovement.model.Improvement

class ImprovementAdapter(private val onClick: (Improvement) -> Unit) : RecyclerView.Adapter<ImprovementAdapter.VH>() {
    var items: List<Improvement> = emptyList()
    inner class VH(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = items[pos]
        h.databinding.titleText.text = item.title
        h.databinding.subtitleText.text = item.priority + " · " + item.status
        h.databinding.root.setOnClickListener { onClick(item) }
    }
}