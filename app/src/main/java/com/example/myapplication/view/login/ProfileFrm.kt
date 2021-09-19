package com.example.myapplication.view.login

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmProfileBinding
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.home.HomeActivity

class ProfileFrm : BaseFragment(R.layout.frm_profile) {
    private lateinit var animZoom: Animation
    private lateinit var mBinding: FrmProfileBinding

    companion object {
        val TAG = ProfileFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): ProfileFrm {
            val fragment = ProfileFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmProfileBinding
        init()
        clickListener()
    }

    private fun init() {
        animZoom = AnimationUtils.loadAnimation(mActivity, R.anim.zoom_out)
        mBinding.parent.startAnimation(animZoom)
    }

    private fun clickListener() {
        mBinding.imgBack.setOnClickListener(this)
        mBinding.imgCapture.setOnClickListener(this)
        mBinding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.img_back -> mActivity.onBackPressed()
            R.id.img_capture -> {
            }
            R.id.btn_submit -> HomeActivity.newClearLogin(mActivity)
        }
    }


    /**
     * navigate on fragment
     * @param tag represent navigation activity
     */
    private fun navigateScreen(tag: String, bundle: Bundle) {
        val frm: Fragment? = null
        when (tag) {
//            ProfileFrm.TAG -> frm = ProfileFrm.getInstance(Bundle())
//            ZoomImageFrm.TAG -> frm = ZoomImageFrm.getInstance(bundle)
        }
        if (frm != null) navigateFragment(R.id.container, frm, false)
    }

}


