package com.example.myapplication.view.home

import FileUtils
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.view.base.BaseActivity
import com.example.myapplication.view.login.LoginActivity
import com.example.myapplication.view.video.AddFilterActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : BaseActivity(R.layout.activity_home) {
    private lateinit var mBinding: ActivityHomeBinding
//    lateinit var newsFrm: NewsFrm
//    lateinit var searchFrm: SearchFrm
//    lateinit var notiFrm: NotificationFrm
//    lateinit var editProfile: EditProfileFrm

    companion object {
        val TAG = LoginActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }

        fun newClearLogin(context: Activity?) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
            context?.finish()
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as ActivityHomeBinding
        init()
        clickListener()
        bottomNaviSetup()
    }

    private fun init() {
    }

    private fun clickListener() {
    }

    private fun bottomNaviSetup() {
        navigateScreen(NewsFrm.TAG)
        mBinding.navBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.tab_news -> {
                            navigateScreen(NewsFrm.TAG)
                            return true
                        }
                        R.id.tab_search -> {
                            navigateScreen(SearchFrm.TAG)
                            return true
                        }
                        R.id.tab_add -> {
                            checkStoragePermission()
                            return false
                        }
                        R.id.tab_noti -> {
                            navigateScreen(NotificationFrm.TAG)
                            return true
                        }
                        R.id.tab_profile -> {
                            navigateScreen(EditProfileFrm.TAG)
                            return true
                        }
                    }
                    return false
                }
            }

    override fun onPermissionGranted(mCustomPermission: List<String>) {
        super.onPermissionGranted(mCustomPermission)
        FileUtils.getCaptureImageIntent(this)
        Log.d("TAG", "onPermissionGranted")

    }

    private fun navigateScreen(tag: String?) {
        var frm: Fragment? = null
        when (tag) {
            NewsFrm.TAG -> frm = NewsFrm.getInstance(Bundle())
            SearchFrm.TAG -> frm = SearchFrm.getInstance(Bundle())
            NotificationFrm.TAG -> frm = NotificationFrm.getInstance(Bundle())
            EditProfileFrm.TAG -> frm = EditProfileFrm.getInstance(Bundle())

        }
        if (frm != null) navigateFragment(R.id.container, frm, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            FileUtils.REQUEST_CAMERA_VIDEO -> {
                if (FileUtils.captureVideoFile.exists())
                    AddFilterActivity.newIntent(this, FileUtils.captureVideoFile.absolutePath)
            }
        }
    }
}