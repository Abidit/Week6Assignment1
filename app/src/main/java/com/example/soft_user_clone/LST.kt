package com.example.soft_user_clone

import Fragments.AddData
import Fragments.DisplayFragment
import Fragments.WebFragment
import Model.Student
import androidx.fragment.app.Fragment

val listedStudent: ArrayList<Student> = ArrayList<Student>()

fun doo(){ listedStudent.add(Student("Abidit Shrestha",20,"Kapan","Male","https://cdn.onlinewebfonts.com/svg/img_504768.png"))
    listedStudent.add(Student("Issa STH",21,"Airport","Female","https://webstockreview.net/images/woman-icon-png.png"))
    listedStudent.add(Student("Abijeet STH",22,"Boudha","male","https://img.icons8.com/cotton/2x/gender.png"))}