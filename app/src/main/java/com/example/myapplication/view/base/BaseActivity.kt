package com.example.myapplication.view.base

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.global.common.GlobalUtility
import com.example.myapplication.global.common.PermissionHelper

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener,
    PermissionHelper.Companion.PermissionListener {

    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

    abstract fun getLayout(): Int

    abstract fun initUI(binding: ViewDataBinding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val layoutResId = getLayout()
        val binding: ViewDataBinding?
        if (layoutResId != 0) {
            try {
                binding = DataBindingUtil.setContentView(this, layoutResId)
                initUI(binding)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun isNetworkAvailable():Boolean{
        val connectivityManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
    fun navigateFragment(layoutContainer: Int, fragment: Fragment, isEnableBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out, R.anim.trans_right_in, R.anim.trans_right_out)
//        fragmentTransaction.setCustomAnimations(
//            R.animator.fragment_slide_left_enter,
//            R.animator.fragment_slide_left_exit,
//            R.animator.fragment_slide_right_enter,
//            R.animator.fragment_slide_right_exit
//        )
        fragmentTransaction.replace(layoutContainer, fragment)
        if (isEnableBackStack)
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        fragmentTransaction.commitAllowingStateLoss()

    }

    fun navigateAddFragment(layoutContainer: Int, fragment: Fragment, isEnableBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out, R.anim.trans_right_in, R.anim.trans_right_out)
//        fragmentTransaction.setCustomAnimations(
//            R.animator.fragment_slide_left_enter,
//            R.animator.fragment_slide_left_exit,
//            R.animator.fragment_slide_right_enter,
//            R.animator.fragment_slide_right_exit
//        )
        fragmentTransaction.add(layoutContainer, fragment)
        if (isEnableBackStack)
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        fragmentTransaction.commitAllowingStateLoss()
    }
    override fun onClick(v: View) {
        GlobalUtility.hideKeyboard(this)
        GlobalUtility.avoidDoubleClicks(v)
        GlobalUtility.btnClickAnimation(v)
    }

    fun checkStoragePermission() {
        val multiplePermission = ArrayList<String>()
        multiplePermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        multiplePermission.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        multiplePermission.add(Manifest.permission.CAMERA)
        if (PermissionHelper.checkMultiplePermission(this, multiplePermission)) {
            FileUtils.createApplicationFolder(this)
            onPermissionGranted(multiplePermission)
        } else
            PermissionHelper.requestMultiplePermission(this, multiplePermission, this)
    }

    override fun onPermissionGranted(mCustomPermission: List<String>) {
        FileUtils.createApplicationFolder(this)
    }


    override fun onPermissionDenied(mCustomPermission: List<String>) {
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}