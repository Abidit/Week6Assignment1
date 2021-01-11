package Fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.annotation.RequiresApi
import com.example.soft_user_clone.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WebFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WebFragment : Fragment() {

    private lateinit var webb : WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?)
    : View? {

      var view = inflater.inflate(R.layout.fragment_web, container, false)
        webb = view.findViewById(R.id.websitelink)
        webb.apply {
            loadUrl("http://softwarica.edu.np")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
        return view
    }

}