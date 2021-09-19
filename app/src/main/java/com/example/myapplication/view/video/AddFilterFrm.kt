package com.example.myapplication.view.video

import ViewPagerAdapter
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.databinding.FrmAddFilterBinding
import com.example.myapplication.databinding.ItemTabBinding
import com.example.myapplication.global.common.GlobalUtility
import com.example.myapplication.view.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class AddFilterFrm : BaseFragment(R.layout.frm_add_filter) {
    private lateinit var mBinding: FrmAddFilterBinding
    private val tabTitle = arrayOf("Brand", "Model", "Year", "Variant", "State")

    companion object {
        val TAG = AddFilterFrm::class.qualifiedName
        fun getInstance(bundle: Bundle): AddFilterFrm {
            val fragment = AddFilterFrm()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as FrmAddFilterBinding
        init()
        clickListener()
    }

    private fun init() {
        setupTabIcons()
    }

    private fun clickListener() {
        mBinding.imgClose.setOnClickListener(this)
        mBinding.fabOk.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.img_close -> activity?.onBackPressed()
            R.id.fab_ok->navigateScreen(PostFrm.TAG, Bundle())
        }
    }

    private fun setupTabIcons() {
        mBinding.viewPager.offscreenPageLimit = tabTitle.size
        setupViewPager(mBinding.viewPager)
        TabLayoutMediator(
            mBinding.tab, mBinding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.customView = prepareTabView(position)
        }.attach()
    }

    private fun prepareTabView(pos: Int): View {
        val customBinding: ItemTabBinding = GlobalUtility.getLayoutBinding(
            activity,
            R.layout.item_tab
        ) as ItemTabBinding
        customBinding.txtTitle.text = tabTitle[pos]
        if (pos == 0) {
            customBinding.imgMsg.setColorFilter(
                ContextCompat.getColor(
                    mActivity,
                    R.color.yellow_color
                ), android.graphics.PorterDuff.Mode.SRC_IN
            );
        }
        return customBinding.root
    }

    private fun setupViewPager(viewPager: ViewPager2) {
        val adapter = ViewPagerAdapter(mActivity)
        val frmBrand = BrandFrm()
        val frmModel = ModelFrm()
        val frmYear = YearsFrm()
        val frmVarient = CarVariantFrm()
        val frmState = StateFrm()
        adapter.addFragment(frmBrand, "Brand")
        adapter.addFragment(frmModel, "Model")
        adapter.addFragment(frmYear, "Year")
        adapter.addFragment(frmVarient, "Varient")
        adapter.addFragment(frmState, "State")
        viewPager.adapter = adapter
    }


    /**
     * navigate on fragment
     * @param tag represent navigation activity
     */
    private fun navigateScreen(tag: String?, bundle: Bundle) {
        var frm: Fragment? = null
        when (tag) {
            PostFrm.TAG -> frm = PostFrm.getInstance(Bundle())
//            ZoomImageFrm.TAG -> frm = ZoomImageFrm.gsetInstance(bundle)
        }
        if (frm != null) navigateAddFragment(R.id.container, frm, true)
    }

}


