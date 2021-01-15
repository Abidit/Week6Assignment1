package Adapter

import Fragments.DisplayFragment
import Model.Student
import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.DialogCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soft_user_clone.MainActivity
import com.example.soft_user_clone.R

class Data_Adapter (
    var listStudent: ArrayList<Student>,
    var context: Context

): RecyclerView.Adapter<Data_Adapter.AdapterViewHolder>()
{
    class AdapterViewHolder (view: View) : RecyclerView.ViewHolder(view){
        var name : TextView
        var age : TextView
        var address : TextView
        var gender : TextView
        var delete : ImageView
        var addimg : ImageView
        var update : ImageView

        init {
            name = view.findViewById(R.id.tvname)
            age = view.findViewById(R.id.tvage)
            address = view.findViewById(R.id.tvaddress)
            gender = view.findViewById(R.id.gender)
            delete = view.findViewById(R.id.del)
            addimg = view.findViewById(R.id.imgg)
            update = view.findViewById(R.id.upd)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_layout,parent, false)
        return AdapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val student = listStudent[position]
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.update_layout)
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        val etFn : EditText = dialog.findViewById(R.id.etFn)
        val etAge : EditText = dialog.findViewById(R.id.etAge)
        val etAddress : EditText = dialog.findViewById(R.id.etAddress)
        val rgGroup : RadioGroup = dialog.findViewById(R.id.rgGroup)
        var gender = "Male"
        val btnUpdate : Button = dialog.findViewById(R.id.btnUpdate)
        val btnCancel : Button = dialog.findViewById(R.id.btnCancel)
        holder.update.setOnClickListener {
            etFn.setText(student.name)
            etAge.setText(student.age.toString())
            etAddress.setText(student.address)
            when(student.gender)
            {
                "Male" -> rgGroup.check(R.id.rbMale)
                "Female" -> rgGroup.check(R.id.rbFemale)
                "Others" -> rgGroup.check(R.id.rbOthers)
            }
            dialog.show()
        }

        rgGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId)
            {
                R.id.rbMale ->{
                    gender = "Male"
                }
                R.id.rbFemale ->{
                    gender = "Female"
                }
                R.id.rbOthers ->{
                    gender = "Others"
                }
            }
        }
        btnUpdate.setOnClickListener {
            if(TextUtils.isEmpty(etFn.text))
            {
                etFn.error = "Enter Firstname"
                etFn.requestFocus()
            }
            else if(TextUtils.isEmpty(etAge.text))
            {
                etAge.error = "Enter Age"
                etAge.requestFocus()
            }
            else if(TextUtils.isEmpty(etAddress.text))
            {
                etAddress.error = "Enter Address"
                etAddress.requestFocus()
            }
            else if(!Regex("""[a-z][a-z]+""").matches(etFn.text.toString().toLowerCase().replace(" ","")))
            {
                etAddress.error = "Full name should not contain any numbers"
                etAddress.requestFocus()
            }
            else if(etAge.text.toString().toInt() > 40 || etAge.text.toString().toInt() < 18)
            {
                etAge.error = "Age should be in between 18-40"
                etAge.requestFocus()
            }
            else
            {
                listStudent[position].name = etFn.text.toString()
                listStudent[position].address = etAddress.text.toString()
                listStudent[position].age = etAge.text.toString().toInt()
                listStudent[position].gender = gender
                notifyDataSetChanged()
                dialog.cancel()
            }
        }
        btnCancel.setOnClickListener {
            dialog.cancel()
        }
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