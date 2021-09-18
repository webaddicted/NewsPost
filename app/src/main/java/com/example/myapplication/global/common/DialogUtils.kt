package com.example.myapplication.global.common

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import androidx.core.content.ContextCompat

/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class DialogUtil {
    companion object {
        private val TAG = DialogUtil::class.java.simpleName
//    {START SHOW DIALOG STYLE}
//    apply on resume method

        /**
         * show dialog with transprant background
         *
         * @param activity reference of activity
         * @param dialog   reference of dialog
         */
        fun modifyDialogBounds(activity: Activity?, dialog: Dialog) {
            dialog.window!!.setBackgroundDrawable(
                    ColorDrawable(
                            ContextCompat.getColor(
                                    activity!!,
                                    android.R.color.transparent
                            )
                    )
            )
            dialog.window?.decorView?.background = ColorDrawable(Color.TRANSPARENT)
            val lp = WindowManager.LayoutParams()
            val window = dialog.window
            lp.copyFrom(window!!.attributes)
            //This makes the dialog take up the full width
            //lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.width = (dialog.context.resources.displayMetrics.widthPixels * 0.83).toInt()
            //  lp.height = (int) (dialog.getContext().getResources().getDisplayMetrics().heightPixels * 0.55);
            window.attributes = lp
        }

    }
}
