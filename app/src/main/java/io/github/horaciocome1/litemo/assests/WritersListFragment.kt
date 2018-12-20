package io.github.horaciocome1.litemo.assests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import io.github.horaciocome1.litemo.R
import io.github.horaciocome1.litemo.domain.Writer
import io.github.horaciocome1.litemo.helpers.configWritersList

fun FragmentManager.loadWritersListFragment() {
    this.beginTransaction().replace(R.id.activity_main_container, WritersListFragment()).commit()
    fragmentManager = this
}

private lateinit var fragmentManager: FragmentManager


class WritersListFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_writers_list, container, false)
        if (view is RecyclerView) view.configWritersList(writers()) { fragmentManager?.loadProfileFragment() }
        return view
    }

    private fun writers(): ArrayList<Writer> {
        return arrayListOf(
            Writer("Amor, Culture, Cars, Places", "Hilberto Guambe", "Cabo Delgado", R.drawable.writer1, "88%"),
            Writer("Amor", "Francisco Hinas Jonas", "Maputo", R.drawable.background, "6%"),
            Writer("Humanidade, Valores", "Joana Ana", "Maxixe", R.drawable.writer1, "0%"),
            Writer("Culture, Places", "Timeu Anted Ionisio", "Matola", R.drawable.background, "12%"),
            Writer("Amor, Culture, Cars, Places", "Hilberto Guambe", "Cabo Delgado", R.drawable.writer1, "88%"),
            Writer("Amor", "Francisco Hinas Jonas", "Maputo", R.drawable.background, "6%"),
            Writer("Humanidade, Valores", "Joana Ana", "Maxixe", R.drawable.writer1, "0%"),
            Writer("Culture, Places", "Timeu Anted Ionisio", "Matola", R.drawable.background, "12%"),
            Writer("Amor, Culture, Cars, Places", "Hilberto Guambe", "Cabo Delgado", R.drawable.writer1, "88%"),
            Writer("Amor", "Francisco Hinas Jonas", "Maputo", R.drawable.background, "6%"),
            Writer("Humanidade, Valores", "Joana Ana", "Maxixe", R.drawable.writer1, "0%"),
            Writer("Culture, Places", "Timeu Anted Ionisio", "Matola", R.drawable.background, "12%"),
            Writer("Amor", "Hilberto Guambe", "Maputo", R.drawable.writer1, "88%")
        )
    }
}