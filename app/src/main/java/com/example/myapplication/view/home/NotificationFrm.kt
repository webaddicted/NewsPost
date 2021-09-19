package com.example.myapplication.view.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmNotiBinding
import com.example.myapplication.view.activity.AirtelActivity
import com.example.myapplication.view.activity.MainActivity
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.login.ProfileFrm

class NotificationFrm : BaseFragment(R.layout.frm_noti) {
    private lateinit var mBinding: FrmNotiBinding

    companion object {
        val TAG = NotificationFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): NotificationFrm {
            val fragment = NotificationFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmNotiBinding
        init()
        clickListener()
    }

    private fun init() {
    }

    private fun clickListener() {
        mBinding.txtOpenAirtel.setOnClickListener(this)
        mBinding.txtOpenPic.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_open_airtel -> {
                AirtelActivity.newIntent(mActivity)
            }
            R.id.txt_open_pic -> {
                MainActivity.newIntent(mActivity)
            }
            R.id.txt_change_no, R.id.btn_cancel -> mActivity.onBackPressed()
        }
    }


    /**
     * navigate on fragment
     * @param tag represent navigation activity
     */
    private fun navigateScreen(tag: String, bundle: Bundle) {
        var frm: Fragment? = null
        when (tag) {
            ProfileFrm.TAG -> frm = ProfileFrm.getInstance(Bundle())
//            ZoomImageFrm.TAG -> frm = ZoomImageFrm.getInstance(bundle)
        }
        if (frm != null) navigateFragment(R.id.container, frm, true)
    }

}


