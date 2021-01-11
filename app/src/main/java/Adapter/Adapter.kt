package Adapter

import Fragments.DisplayFragment
import Model.Student
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soft_user_clone.R

class Adapter (
    var listStudent: ArrayList<Student>,
    var context: DisplayFragment

): RecyclerView.Adapter<Adapter.AdapterViewHolder>()
{
    class AdapterViewHolder (view: View) : RecyclerView.ViewHolder(view){
        var name : TextView
        var age : TextView
        var address : TextView
        var gender : TextView
        var delete : ImageView
        var addimg : ImageView

        init {
            name = view.findViewById(R.id.tvname)
            age = view.findViewById(R.id.tvage)
            address = view.findViewById(R.id.tvaddress)
            gender = view.findViewById(R.id.gender)
            delete = view.findViewById(R.id.del)
            addimg = view.findViewById(R.id.imgg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_layout,parent, false)
        return AdapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val student = listStudent[position]

        holder.name.text = student.name
        holder.age.text = student.age.toString()
        holder.address.text = student.address
        holder.gender.text = student.gender
        Glide.with(
            holder.itemView.context
        ).load(
            student.image
        ).into(holder.addimg)
        holder.delete.setOnClickListener {
            listStudent.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
       return listStudent.size
    }


}