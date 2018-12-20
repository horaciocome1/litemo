package io.github.horaciocome1.litemo.assests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import io.github.horaciocome1.litemo.R
import io.github.horaciocome1.litemo.helpers.robotoLight
import io.github.horaciocome1.litemo.helpers.robotoRegular
import io.github.horaciocome1.litemo.helpers.robotoThin
import jp.wasabeef.picasso.transformations.BlurTransformation

fun FragmentManager.loadProfileFragment() {
    this.beginTransaction().replace(R.id.activity_main_container, ProfileFragment()).commit()
}

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        configFont(view)
        Picasso.with(view.context).load(R.drawable.writer1)
            .transform(BlurTransformation(view.context, 2, 3))
            .into(view.findViewById<ImageView>(R.id.fragment_profile_backgroung_imageview))
        Picasso.with(view.context).load(R.drawable.background)
            .into(view.findViewById<CircleImageView>(R.id.fragment_profile_profile_pic_imageview))
    }

    private fun configFont(view: View) {
        view.findViewById<TextView>(R.id.fragment_profile_description_textview).typeface = view.context.assets.robotoThin()
        view.findViewById<TextView>(R.id.fragment_profile_posts_textview).typeface = view.context.assets.robotoThin()
        view.findViewById<TextView>(R.id.fragment_profile_followers_textview).typeface = view.context.assets.robotoThin()
        view.findViewById<TextView>(R.id.fragment_profile_followers_subtitle_textview).typeface = view.context.assets.robotoThin()
        view.findViewById<TextView>(R.id.fragment_profile_posts_subtitle_textview).typeface = view.context.assets.robotoThin()
        view.findViewById<TextView>(R.id.fragment_profile_town_textview).typeface = view.context.assets.robotoLight()
        view.findViewById<TextView>(R.id.fragment_profile_since_textview).typeface = view.context.assets.robotoLight()
        view.findViewById<TextView>(R.id.fragment_profile_latest_textview).typeface = view.context.assets.robotoLight()
    }

}