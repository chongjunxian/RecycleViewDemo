package com.example.recycleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val list: List<Student>, private val listener:onitemClickListener) : RecyclerView.Adapter<StudentAdapter.myViewholder>() {

    inner class myViewholder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvId :TextView = itemView.findViewById(R.id.tvId)
        val tvName :TextView = itemView.findViewById(R.id.tvName)
        val tvProgramme :TextView = itemView.findViewById(R.id.tvProgramme)
        val picPhoto : ImageView = itemView.findViewById(R.id.picPhoto)


        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition

            if(position != RecyclerView.NO_POSITION)
            {
                listener.itemClick(position)
            }
        }
    }

    interface onitemClickListener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return myViewholder(itemView)
    }

    override fun onBindViewHolder(holder: myViewholder, position: Int) {
        val currentStudent = list[position]
        holder.tvId.text = currentStudent.id
        holder.tvName.text = currentStudent.name
        holder.tvProgramme.text = currentStudent.programme

        if(currentStudent.gender == "F")
        {
            holder.picPhoto.setImageResource(R.drawable.ic_female)
        }
        else if (currentStudent.gender == "M") {
            holder.picPhoto.setImageResource(R.drawable.ic_male)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}