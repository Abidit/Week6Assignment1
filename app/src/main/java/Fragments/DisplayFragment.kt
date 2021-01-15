package Fragments

import Adapter.Data_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soft_user_clone.R
import com.example.soft_user_clone.listedStudent

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_display, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)

        val adapter = container?.let { Data_Adapter(listedStudent, it.context) }
        recyclerView.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)
        recyclerView.adapter = adapter

        return view

    }

}