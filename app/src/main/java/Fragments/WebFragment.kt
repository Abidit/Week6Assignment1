package Fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.soft_user_clone.R


class WebFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?)
    : View? {

      var view = inflater.inflate(R.layout.fragment_web, container, false)
        var webb: WebView = view.findViewById(R.id.website_link)
        webb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        webb.loadUrl("https://softwarica.edu.np/")

        return view
    }

}