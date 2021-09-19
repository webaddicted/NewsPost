package com.example.myapplication.view.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmSearchBinding
import com.example.myapplication.view.adapter.SearchAdapter
import com.example.myapplication.view.base.BaseFragment
import com.example.myapplication.view.login.ProfileFrm

class SearchFrm : BaseFragment(R.layout.frm_search) {
    private lateinit var adapter: SearchAdapter
    private lateinit var mBinding: FrmSearchBinding

    companion object {
        val TAG = SearchFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): SearchFrm {
            val fragment = SearchFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmSearchBinding
        init()
        clickListener()
        setAdapter()
    }

    private fun init() {
    }

    private fun clickListener() {
//        mBinding.txtChangeNo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_change_no, R.id.btn_cancel -> activity?.onBackPressed()
        }
    }

    private fun setAdapter() {
        adapter = SearchAdapter(ArrayList())
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


