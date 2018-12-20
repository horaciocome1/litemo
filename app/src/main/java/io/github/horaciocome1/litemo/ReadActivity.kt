package io.github.horaciocome1.litemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import io.github.horaciocome1.litemo.domain.Post
import io.github.horaciocome1.litemo.helpers.robotoLight
import io.github.horaciocome1.litemo.helpers.robotoRegular
import io.github.horaciocome1.litemo.helpers.robotoThin
import jp.wasabeef.picasso.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_read.*

fun Context.readIntent(post: Post): Intent {
    return Intent(this, ReadActivity::class.java).apply { putExtra(INTENT_POST_ID, post.id) }
}

private const val INTENT_POST_ID = "post_id"

class ReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        init()
    }

    private fun init() {
        activity_read_message_textview.typeface = assets.robotoLight()
        activity_read_title_textview.typeface = assets.robotoRegular()
        activity_read_category_textview.typeface = assets.robotoThin()
        activity_read_percent_textview.typeface = assets.robotoThin()

        setSupportActionBar(activity_read_bottomappbar)

        Picasso.with(this).load(R.drawable.writer1)
            .transform(BlurTransformation(this, 2, 3))
            .into(activity_read_backround_imageview)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.read_bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}