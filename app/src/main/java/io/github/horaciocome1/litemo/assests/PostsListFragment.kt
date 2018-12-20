package io.github.horaciocome1.litemo.assests


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import io.github.horaciocome1.litemo.R
import io.github.horaciocome1.litemo.domain.Post
import io.github.horaciocome1.litemo.helpers.configPostsList
import io.github.horaciocome1.litemo.readIntent

fun FragmentManager.loadPostsListFragment() {
    this.beginTransaction().replace(R.id.activity_main_container, PostsListFragment()).commit()
}

class PostsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_posts_list, container, false)
        val context = view.context
        if (view is RecyclerView)
            view.configPostsList(context, posts()) { startActivity(view.context.readIntent(posts()[it])) }
        return view
    }

    private fun posts(): ArrayList<Post> {
        return arrayListOf(
            Post(1, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(2, R.drawable.writer1, R.drawable.background, "Never Ever Again", "Love", "3m"),
            Post(3, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(4, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(5, R.drawable.writer1, R.drawable.background, "Never Ever Again", "Love", "3m"),
            Post(6, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(7, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(8, R.drawable.writer1, R.drawable.background, "Never Ever Again", "Love", "3m"),
            Post(9, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(10, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(11, R.drawable.writer1, R.drawable.background, "Never Ever Again", "Love", "3m"),
            Post(12, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(13, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k"),
            Post(14, R.drawable.writer1, R.drawable.background, "Never Ever Again", "Love", "3m"),
            Post(15, R.drawable.background, R.drawable.writer1, "A Dor De Um Semut", "Culture", "1.9k")
        )
    }



}
