package com.example.myportfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_view.view.*

class MediaAdapter (val items: List<DataModel> = ArrayList(),
    var listener: onCLickCallBackListener
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MediaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is  MediaViewHolder ->{
            holder.bind(items.get(position), listener)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class MediaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(items: DataModel, action: onCLickCallBackListener){
            itemView.iconText.text = items.mediaName
            itemView.iconImage.setImageResource(items.img)

            itemView.setOnClickListener{
                action.callBack(items, adapterPosition)
            }
        }
    }
}
interface onCLickCallBackListener{
    fun callBack(icon: DataModel, position: Int)
}
