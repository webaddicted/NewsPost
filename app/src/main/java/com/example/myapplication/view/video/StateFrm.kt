package com.example.myapplication.view.video

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmYearBinding
import com.example.myapplication.view.adapter.BrandAllAdapter
import com.example.myapplication.view.adapter.ModelAdapter
import com.example.myapplication.view.base.BaseFragment

class StateFrm : BaseFragment(R.layout.frm_year) {
    private lateinit var mAllBrandAdapter: BrandAllAdapter
    private lateinit var mBrandAdapter: ModelAdapter
    private lateinit var mBinding: FrmYearBinding

    companion object {
        val TAG = StateFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): StateFrm {
            val fragment = StateFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmYearBinding
        init()
        clickListener()
    }

    private fun init() {
        setBrandAdapter()
    }

    private fun clickListener() {
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_change_no, R.id.btn_cancel -> activity?.onBackPressed()
        }
    }

    private fun setBrandAdapter() {
        mBrandAdapter = ModelAdapter(ArrayList())
        mBinding.rvAllBrand.layoutManager = GridLayoutManager(activity, 3)
        mBinding.rvAllBrand.adapter = mBrandAdapter
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


