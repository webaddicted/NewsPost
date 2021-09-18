package com.example.myapplication.view.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmEditProfileBinding
import com.example.myapplication.global.common.GlobalUtility
import com.example.myapplication.global.common.gone
import com.example.myapplication.global.common.visible
import com.example.myapplication.view.adapter.ProfileVideoAdapter
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.login.ProfileFrm

class EditProfileFrm : BaseFragment() {
    private lateinit var adapter: ProfileVideoAdapter
    private lateinit var mBinding: FrmEditProfileBinding

    companion object {
        val TAG = EditProfileFrm::class.java.simpleName
        fun getInstance(bundle: Bundle): EditProfileFrm {
            val fragment = EditProfileFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayout(): Int {
        return R.layout.frm_edit_profile
    }

    override fun initUI(binding: ViewDataBinding) {
        mBinding = binding as FrmEditProfileBinding
        init()
        clickListener()
        setAdapter()
    }

    private fun init() {
    }

    private fun clickListener() {
        mBinding.txtProfile.setOnClickListener(this)
        mBinding.txtVideo.setOnClickListener(this)
        mBinding.llProfile.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_profile -> {
                GlobalUtility.tabSelector(mBinding.txtProfile, mBinding.txtVideo, mBinding.txtVideo)
                mBinding.linearProfile.visible()
                mBinding.rv.gone()
            }
            R.id.txt_video -> {
                GlobalUtility.tabSelector(
                    mBinding.txtVideo,
                    mBinding.txtProfile,
                    mBinding.txtProfile
                )
                mBinding.linearProfile.gone()
                mBinding.rv.visible()
            }
//            R.id.ll_profile->
        }
    }

    private fun setAdapter() {
        adapter = ProfileVideoAdapter(this,ArrayList())
        mBinding.rv.layoutManager = GridLayoutManager(activity, 2)
        mBinding.rv.adapter = adapter
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

    fun newPostVideo() {
        (activity as HomeActivity).checkStoragePermission()
    }

}


