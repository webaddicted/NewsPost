package com.example.myapplication.view.login

import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmOtpBinding
import com.example.myapplication.view.base.BaseFragment

class OtpFrm : BaseFragment(R.layout.frm_otp) {
    private lateinit var mBinding: FrmOtpBinding

    companion object {
        val TAG = OtpFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): OtpFrm {
            val fragment = OtpFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmOtpBinding
        init()
        clickListener()
    }

    private fun init() {
        val trans4 = TranslateAnimation(-500f, 0f, 0f, 0f)
        trans4.duration = 1000
        mBinding.imgCar.animation = trans4
    }

    private fun clickListener() {
        mBinding.txtChangeNo.setOnClickListener(this)
        mBinding.txtResendOtp.setOnClickListener(this)
        mBinding.btnLogin.setOnClickListener(this)
        mBinding.btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_change_no, R.id.btn_cancel -> activity?.onBackPressed()
            R.id.txt_resend_otp -> {
            }
            R.id.btn_login -> navigateScreen(ProfileFrm.TAG, Bundle())
        }
    }


    /**
     * navigate on fragment
     * @param tag represent navigation activity
     */
    private fun navigateScreen(tag: String?, bundle: Bundle) {
        var frm: Fragment? = null
        when (tag) {
            ProfileFrm.TAG -> frm = ProfileFrm.getInstance(Bundle())
//            ZoomImageFrm.TAG -> frm = ZoomImageFrm.getInstance(bundle)
        }
        if (frm != null) navigateAddFragment(R.id.container, frm, true)
    }

}


