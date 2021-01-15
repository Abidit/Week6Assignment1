package com.example.soft_user_clone

import Fragments.AddData
import Fragments.DisplayFragment
import Fragments.WebFragment
import Model.Student
import android.app.Dialog
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

val listedStudent: ArrayList<Student> = ArrayList<Student>()

fun doo(){ listedStudent.add(Student("Abidit Shrestha",20,"Kapan","Male","https://cdn.onlinewebfonts.com/svg/img_504768.png"))
    listedStudent.add(Student("Meelina Thapa",21,"Airport","Female","https://webstockreview.net/images/woman-icon-png.png"))
    listedStudent.add(Student("Danish Magar",22,"Boudha","Other","https://img.icons8.com/cotton/2x/gender.png"))

}