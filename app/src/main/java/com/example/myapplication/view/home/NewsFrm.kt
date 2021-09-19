package com.example.myapplication.view.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmNewsBinding
import com.example.myapplication.global.common.GlobalUtility.Companion.tabSelector
import com.example.myapplication.view.adapter.NewsOfferAdapter
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.login.ProfileFrm

class NewsFrm : BaseFragment(R.layout.frm_news) {
    private lateinit var adapter: NewsOfferAdapter
    private lateinit var mBinding: FrmNewsBinding

    companion object {
        val TAG = NewsFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): NewsFrm {
            val fragment = NewsFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmNewsBinding
        init()
        clickListener()
        setAdapter()
    }

    private fun init() {

    }

    private fun clickListener() {
        mBinding.txtOffer.setOnClickListener(this)
        mBinding.txtNews.setOnClickListener(this)
        mBinding.txtVideo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_offer -> tabSelector(mBinding.txtOffer, mBinding.txtNews, mBinding.txtVideo)
            R.id.txt_news -> tabSelector(mBinding.txtNews, mBinding.txtOffer, mBinding.txtVideo)
            R.id.txt_video -> tabSelector(mBinding.txtVideo, mBinding.txtNews, mBinding.txtOffer)
        }
    }

    private fun setAdapter() {
        adapter = NewsOfferAdapter(ArrayList())
        mBinding.rv.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
        )
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

}


