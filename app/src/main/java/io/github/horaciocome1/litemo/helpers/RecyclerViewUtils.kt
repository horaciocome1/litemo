package io.github.horaciocome1.litemo.helpers

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import io.github.horaciocome1.litemo.R
import io.github.horaciocome1.litemo.domain.Post
import io.github.horaciocome1.litemo.domain.Writer
import io.github.horaciocome1.simplerecyclerviewadapter.SimpleRecyclerViewAdapter
import io.github.horaciocome1.simplerecyclerviewadapter.findViewById
import io.github.horaciocome1.litemo.touchlistener.addSimpleTouchListener
import io.github.horaciocome1.litemo.touchlistener.setOnClick
import io.github.horaciocome1.litemo.touchlistener.setOnDoubleClick
import io.github.horaciocome1.litemo.touchlistener.setOnLongPress

fun RecyclerView.configPostsList(context: Context, posts: ArrayList<Post>, startReadActivity: (Int) -> Unit) {
    layoutManager = LinearLayoutManager(this.context)
    adapter = SimpleRecyclerViewAdapter<Post>().apply {
        itemLayout = R.layout.item_post
        list = posts
        setOnBindViewHolder { holder, post ->
            Picasso.with(context).load(post.background)
                .into(holder.findViewById<ImageView>(R.id.item_post_background_imageview))
            Picasso.with(context).load(post.writerPic)
                .into(holder.findViewById<CircleImageView>(R.id.item_post_writer_pic_imageview))
            holder.findViewById<TextView>(R.id.item_post_title_textview).text = post.title
            holder.findViewById<TextView>(R.id.item_post_title_textview).typeface = context.assets.robotoLight()
            holder.findViewById<TextView>(R.id.item_post_category_textview).text = post.category
            holder.findViewById<TextView>(R.id.item_post_category_textview).typeface = context.assets.robotoThin()
            holder.findViewById<TextView>(R.id.item_post_read_count_textview).text = post.readCount
            holder.findViewById<TextView>(R.id.item_post_read_count_textview).typeface = context.assets.robotoThin()
        }
    }
    setOnClick { _, position -> startReadActivity(position) }
    addSimpleTouchListener()
}

fun RecyclerView.configWritersList(writers: ArrayList<Writer>, loadProfileFragment: (Int) -> Unit) {
    layoutManager = LinearLayoutManager(context)
    adapter = SimpleRecyclerViewAdapter<Writer>().apply {
        itemLayout = R.layout.item_writer
        list = writers
        setOnBindViewHolder { holder, writer ->
            holder.findViewById<TextView>(R.id.item_writer_categories_textview).text = writer.categories
            holder.findViewById<TextView>(R.id.item_writer_categories_textview).typeface = context.assets.robotoLight()
            holder.findViewById<TextView>(R.id.item_writer_name_textview).text = writer.name
            holder.findViewById<TextView>(R.id.item_writer_name_textview).typeface = context.assets.robotoRegular()
            holder.findViewById<TextView>(R.id.item_writer_town).text = writer.town
            holder.findViewById<TextView>(R.id.item_writer_town).typeface = context.assets.robotoLight()
            Picasso.with(context).load(writer.profilePic)
                .into(holder.findViewById<CircleImageView>(R.id.item_writer_profile_pic_imageview))
            holder.findViewById<TextView>(R.id.item_writer_percent_textview).text = writer.percent
            holder.findViewById<TextView>(R.id.item_writer_percent_textview).typeface = context.assets.robotoLight()
        }
        setOnClick { _, position -> loadProfileFragment(position) }
    }
}