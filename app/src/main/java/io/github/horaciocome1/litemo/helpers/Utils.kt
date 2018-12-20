package io.github.horaciocome1.litemo.helpers

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.github.horaciocome1.litemo.R
import io.github.horaciocome1.litemo.helpers.Constants.ROBOTO_LIGHT_PATH
import io.github.horaciocome1.litemo.helpers.Constants.ROBOTO_REGULAR_PATH
import io.github.horaciocome1.litemo.helpers.Constants.ROBOTO_THIN_PATH

fun Context.showProgressBar(inflater: LayoutInflater): BottomSheetDialog {
    val view = inflater.inflate(R.layout.progressbar, null, false)
    val bottomProgressBar = BottomSheetDialog(this)
    bottomProgressBar.setContentView(view)
//    bottomProgressBar.setCancelable(false)
    bottomProgressBar.show()
    return bottomProgressBar
}

fun Context.toast(message: String) { Toast.makeText(this, message, Toast.LENGTH_LONG).show() }

fun String.toast(context: Context) { Toast.makeText(context, this, Toast.LENGTH_LONG).show() }

fun AssetManager.robotoThin(): Typeface {
    return Typeface.createFromAsset(this, ROBOTO_THIN_PATH)
}

fun AssetManager.robotoLight(): Typeface {
    return Typeface.createFromAsset(this, ROBOTO_LIGHT_PATH)
}

fun AssetManager.robotoRegular(): Typeface {
    return Typeface.createFromAsset(this, ROBOTO_REGULAR_PATH)
}