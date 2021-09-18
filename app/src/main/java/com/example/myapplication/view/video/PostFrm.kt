package com.example.myapplication.view.video

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmPostBinding
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.home.HomeActivity

class PostFrm : BaseFragment() {
    private lateinit var mBinding: FrmPostBinding

    companion object {
        val TAG = PostFrm::class.java.simpleName
        fun getInstance(bundle: Bundle): PostFrm {
            val fragment = PostFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayout(): Int {
        return R.layout.frm_post
    }

    override fun initUI(binding: ViewDataBinding) {
        mBinding = binding as FrmPostBinding
        init()
        clickListener()
    }

    private fun init() {
    }

    private fun clickListener() {
        mBinding.imgClose.setOnClickListener(this)
        mBinding.btnDraft.setOnClickListener(this)
        mBinding.btnPost.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.img_close -> activity?.onBackPressed()
            R.id.btn_post, R.id.btn_draft -> HomeActivity.newClearLogin(activity)
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
        if (frm != null) navigateAddFragment(R.id.container, frm, true)
    }

}


