package io.github.horaciocome1.litemo.assests

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import io.github.horaciocome1.litemo.R

fun FragmentManager.loadAboutFragment() {
    this.beginTransaction().replace(R.id.activity_main_container, AboutFragment()).commit()
}

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

}