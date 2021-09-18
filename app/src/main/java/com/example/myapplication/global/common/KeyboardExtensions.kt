package com.example.myapplication.global.common

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
fun Activity.getRootView(): View {
    return findViewById(android.R.id.content)
}
fun Context.convertDpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        this.resources.displayMetrics
    )
}
fun Activity.isKeyboardOpen(): Boolean {
    val visibleBounds = Rect()
    this.getRootView().getWindowVisibleDisplayFrame(visibleBounds)
    val heightDiff = getRootView().height - visibleBounds.height()
    val marginOfError = Math.round(this.convertDpToPx(50F))
    return heightDiff > marginOfError
}
fun Activity.softkeybordHeight(): Int{
    val visibleBounds = Rect()
    this.getRootView().getWindowVisibleDisplayFrame(visibleBounds)
    return getRootView().height - visibleBounds.height()
}

fun Activity.isKeyboardClosed(): Boolean {
    return !this.isKeyboardOpen()
}