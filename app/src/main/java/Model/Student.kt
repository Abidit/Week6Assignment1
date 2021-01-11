package Model

import android.os.Parcel
import android.os.Parcelable

data class Student(

    val name: String?,
    val age: Int?,
    val address: String?,
    val gender: String?,
    var image : String?
)