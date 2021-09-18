package com.example.myapplication.view.adapter

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemProfileVideoBinding
import com.example.myapplication.global.common.gone
import com.example.myapplication.global.common.visible
import com.example.myapplication.model.bean.SearchRespo
import com.example.myapplication.view.base.BaseAdapter
import com.example.myapplication.view.home.EditProfileFrm

class ProfileVideoAdapter(
    private var edtProfile: EditProfileFrm,
    private var dataList: ArrayList<SearchRespo.Photos.Photo>?
) : BaseAdapter() {
    override fun getListSize(): Int {
//        if (dataList == null) return 0
//        return dataList?.size
        return 2
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_profile_video
    }

    override fun onBindTo(rowBinding: ViewDataBinding, position: Int) {
        if (rowBinding is ItemProfileVideoBinding) {
            Log.d("TAG", "VIEW $position")
            if (position == 1) {
                rowBinding.linearView.gone()
                rowBinding.imgAdd.visible()
            } else {
                rowBinding.linearView.visible()
                rowBinding.imgAdd.gone()
            }
        onClickListener(rowBinding,rowBinding.imgAdd,position)
        }
    }

    override fun getClickEvent(mRowBinding: ViewDataBinding, view: View?, position: Int) {
        super.getClickEvent(mRowBinding, view, position)
        when(view?.id){
            R.id.img_add->edtProfile.newPostVideo()
        }
    }


    fun notifyAdapter(newsBeanList: ArrayList<SearchRespo.Photos.Photo>) {
        dataList = newsBeanList
        notifyDataSetChanged()
    }
}
