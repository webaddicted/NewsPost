package com.example.myapplication.global.common

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.myapplication.R

/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class GlobalUtility {

    companion object {

//    {START HIDE SHOW KEYBOARD}

        /**
         * Method to hide keyboard
         *
         * @param activity Context of the calling class
         */
        fun hideKeyboard(activity: Activity) {
            try {
                val inputManager =
                    activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
            } catch (ignored: Exception) {
                ignored.printStackTrace()
            }

        }

        /***
         * Show SoftInput Keyboard
         * @param activity reference of current activity
         */
        fun showKeyboard(activity: Activity?) {
            if (activity != null) {
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(
                    InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY
                )
            }
        }

//    {END HIDE SHOW KEYBOARD}
        /***
         * To prevent from double clicking the row item and so prevents overlapping fragment.
         */
        fun avoidDoubleClicks(view: View) {
            val CLICK_DELAY: Long = 500
            if (!view.isClickable) {
                return
            }
            view.isClickable = false
            view.postDelayed({ view.isClickable = true }, CLICK_DELAY)
        }

        fun tabSelector(txtSelected: TextView, txtUnSelected: TextView, txtUnSelected1: TextView) {
            /*** Set text color */
            txtSelected.setTextColor(ContextCompat.getColor(txtSelected.context, R.color.white))
            txtUnSelected.setTextColor(ContextCompat.getColor(txtSelected.context, R.color.black))
            txtUnSelected1.setTextColor(ContextCompat.getColor(txtSelected.context, R.color.black))

            /*** Background color */
            txtSelected.setBackgroundColor(
                ContextCompat.getColor(
                    txtSelected.context,
                    R.color.app_color
                )
            )
            txtUnSelected.setBackgroundColor(
                ContextCompat.getColor(
                    txtSelected.context,
                    R.color.transprant
                )
            )
            txtUnSelected1.setBackgroundColor(
                ContextCompat.getColor(
                    txtSelected.context,
                    R.color.transprant
                )
            )

            /*** Set background drawable */
            txtSelected.setBackgroundResource(R.drawable.rectangle_fill)
            txtUnSelected.setBackgroundResource(R.drawable.rectangle_unfill)
            txtUnSelected1.setBackgroundResource(R.drawable.rectangle_unfill)
        }

        fun btnClickAnimation(view: View) {
            val fadeAnimation = AnimationUtils.loadAnimation(view.context, R.anim.fade_in)
            view.startAnimation(fadeAnimation)
        }

        fun getLayoutBinding(context: Context?, layout: Int): ViewDataBinding {
            return DataBindingUtil.inflate(
                LayoutInflater.from(context),
                layout,
                null, false
            )
        }
    }


}
