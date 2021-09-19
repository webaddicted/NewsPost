package com.example.myapplication.view.login

import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmLoginBinding
import com.example.myapplication.view.base.BaseFragment

class LoginFrm : BaseFragment(R.layout.frm_login) {
    private lateinit var mBinding: FrmLoginBinding

    companion object {
        val TAG = LoginFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): LoginFrm {
            val fragment = LoginFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmLoginBinding
        init()
        clickListener()
    }

    private fun init() {
        val trans4 = TranslateAnimation(-500f, 0f, 0f, 0f)
        trans4.duration = 1500
        mBinding.imgCar.animation = trans4
    }

    private fun clickListener() {
        mBinding.txtVerify.setOnClickListener(this)
        mBinding.btnFb.setOnClickListener(this)
        mBinding.btnGoogle.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_verify -> navigateScreen(OtpFrm.TAG, Bundle())
            R.id.btn_fb -> {}
            R.id.btn_google -> {
            }
        }
    }


    /**
     * navigate on fragment
     * @param tag represent navigation activity
     */
    private fun navigateScreen(tag: String?, bundle: Bundle) {
        var frm: Fragment? = null
        when (tag) {
            OtpFrm.TAG -> frm = OtpFrm.getInstance(Bundle())
//            ZoomImageFrm.TAG -> frm = ZoomImageFrm.getInstance(bundle)
        }
        if (frm != null) navigateAddFragment(R.id.container, frm, true)
    }

    override fun onResume() {
        super.onResume()
//        addBlankSpace(mBinding.bottomSpace)
    }
}


