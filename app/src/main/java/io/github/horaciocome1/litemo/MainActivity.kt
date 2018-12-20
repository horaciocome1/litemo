package io.github.horaciocome1.litemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import io.github.horaciocome1.litemo.assests.loadAboutFragment
import io.github.horaciocome1.litemo.assests.loadPostsListFragment
import io.github.horaciocome1.litemo.assests.loadProfileFragment
import io.github.horaciocome1.litemo.assests.loadWritersListFragment
import io.github.horaciocome1.litemo.helpers.showProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private lateinit var bottomProgressBar: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        bottomProgressBar = showProgressBar(layoutInflater)
        setSupportActionBar(activity_main_bottomappbar)
        supportFragmentManager.loadPostsListFragment()
        activity_main_fab.setOnClickListener {
            handleFilter()
        }
    }

    private fun handleFilter() {
        BottomSheetDialog(this).apply {
            setContentView(layoutInflater.inflate(R.layout.bottom_filter, null, false))
            show()
        }
    }

    private fun handleDrawer() {
        val drawer = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_navigation_drawer, null, false)
        (view as NavigationView).setNavigationItemSelectedListener { menuItem ->
            drawer.dismiss()
            when (menuItem.itemId) {
                R.id.bottomdrawer_menu_home -> supportFragmentManager.loadPostsListFragment()
                R.id.bottomdrawer_menu_writers -> supportFragmentManager.loadWritersListFragment()
                R.id.bottomdrawer_menu_profile -> supportFragmentManager.loadProfileFragment()
                R.id.bottomdrawer_menu_about -> supportFragmentManager.loadAboutFragment()
            }
            true
        }
        drawer.setContentView(view)
        drawer.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                handleDrawer()
                true
            }
            R.id.main_bottomappbar_menu_search -> {
                handleSearch()
                true
            }
            R.id.main_bottomappbar_menu_write -> {
                startActivity(WriteIntent())
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun handleSearch() {
        BottomSheetDialog(this).apply {
            setContentView(layoutInflater.inflate(R.layout.bottom_search, null, false))
            show()
        }
    }
}
