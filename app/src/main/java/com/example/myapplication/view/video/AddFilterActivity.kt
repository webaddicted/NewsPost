package com.example.myapplication.view.video

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCommonBinding
import com.example.myapplication.view.base.BaseActivity
import java.io.File

class AddFilterActivity : BaseActivity() {
    private lateinit var mBinding: ActivityCommonBinding

    companion object {
        val TAG: String = AddFilterActivity::class.java.simpleName
        val VIDEO_PATH = "VideoPath"
        fun newIntent(activity: Activity, videoPath: String) {
            val intent = Intent(activity, AddFilterActivity::class.java)
            intent.putExtra(VIDEO_PATH, videoPath)
            activity.startActivity(intent)
        }

        fun newClearLogin(context: Activity?) {
            val intent = Intent(context, AddFilterActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
            context?.finish()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_common
    }

    override fun initUI(binding: ViewDataBinding) {
        mBinding = binding as ActivityCommonBinding
        init()
        clickListener()
    }

    private fun init() {
        navigateScreen(AddFilterFrm.TAG)
//        navigateScreen(ProfileFrm.TAG)
    }

    private fun clickListener() {
    }

    private fun navigateScreen(tag: String) {
        var frm: Fragment? = null
        when (tag) {
            AddFilterFrm.TAG -> frm = AddFilterFrm.getInstance(Bundle())
        }
        if (frm != null) navigateFragment(R.id.container, frm, false)
    }
}