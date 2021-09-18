package com.example.myapplication.view.video

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmYearBinding
import com.example.myapplication.view.adapter.BrandAllAdapter
import com.example.myapplication.view.base.BaseFragment

class YearsFrm : BaseFragment() {
    private lateinit var mAllBrandAdapter: BrandAllAdapter
    private lateinit var mBinding: FrmYearBinding

    companion object {
        val TAG = YearsFrm::class.java.simpleName
        fun getInstance(bundle: Bundle): YearsFrm {
            val fragment = YearsFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayout(): Int {
        return R.layout.frm_year
    }

    override fun initUI(binding: ViewDataBinding) {
        mBinding = binding as FrmYearBinding
        init()
        clickListener()
    }

    private fun init() {
        setAllBrandAdapter()
    }

    private fun clickListener() {
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.txt_change_no, R.id.btn_cancel -> activity?.onBackPressed()
        }
    }


    private fun setAllBrandAdapter() {
        mAllBrandAdapter = BrandAllAdapter(ArrayList())
        mBinding.rvAllBrand.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        mBinding.rvAllBrand.adapter = mAllBrandAdapter
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


