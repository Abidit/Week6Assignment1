package Fragments

import Model.Student
import android.location.Address
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.example.soft_user_clone.R
import com.example.soft_user_clone.listedStudent

class AddData : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var etName : EditText
    private lateinit var etAge : EditText
    private lateinit var etAddress : EditText
    private lateinit var btnSave : Button
    private lateinit var rgGEN : RadioGroup
    private lateinit var gender : String
    private lateinit var image : String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_data, container, false)
        etName = view.findViewById(R.id.etFullname)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        btnSave = view.findViewById(R.id.btnSave)
        rgGEN = view.findViewById(R.id.rgGender)

        btnSave.setOnClickListener {
                if (validate()) {
                rbg()
                Toast.makeText(context,"The user is added.",Toast.LENGTH_SHORT).show()
                    clear()

            }
        }
        return view
    }
    private fun validate() : Boolean{
        if(TextUtils.isEmpty(etName.text)) {
            etName.error = "Full Name must not be empty."
            etName.requestFocus()
            return false
        }
        else if(TextUtils.isEmpty(etAddress.text)) {
            etAddress.error = "Address must not be empty."
            etAddress.requestFocus()
            return false
        } else if(TextUtils.isEmpty(etAge.text)) {
            etAge.error = "Age must not be empty."
            etAge.requestFocus()
            return false
        }
        else
            return true
    }
    private fun clear(){
        etName.setText("")
        etAge.setText("")
        etAddress.setText("")
        rgGEN.clearCheck()

    }
    private fun rbg() {
        val id = rgGEN.checkedRadioButtonId
        when(id){
            R.id.rbMale -> gender = "Male"
            R.id.rbFemale -> gender = "Female"
            R.id.rbOther -> gender = "Other"
        }
        if (gender == "Male"){
            image = "https://cdn.onlinewebfonts.com/svg/img_504768.png"
        }
        if(gender == "Female"){
            image = "https://webstockreview.net/images/woman-icon-png.png"
        }
        if (gender == "Other")
        {
            image = "https://img.icons8.com/cotton/2x/gender.png"
        }
        val name = etName.text.toString()
        val age = etAge.text.toString().toInt()
        val address = etAddress.text.toString()
        listedStudent.add(Student("$name", age, "$address","$gender","$image"))

    }

}