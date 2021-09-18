package com.example.myapplication.global.common

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class ValidationHelper {
    companion object {
        fun showSnackBar(parentLayout: View, msg: String) {
            val snackBar = Snackbar.make(parentLayout, msg, Snackbar.LENGTH_SHORT)
            snackBar.setActionTextColor(Color.WHITE)
            val view = snackBar.view
            val tv = view.findViewById(R.id.snackbar_text) as TextView
            tv.setTextColor(Color.WHITE)
            snackBar.show()

        }
    }
}
