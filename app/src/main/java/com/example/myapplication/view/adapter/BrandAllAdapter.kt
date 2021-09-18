package com.example.myapplication.view.adapter

import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemBrandBinding
import com.example.myapplication.model.bean.SearchRespo
import com.example.myapplication.view.base.BaseAdapter

class BrandAllAdapter(private var dataList: ArrayList<SearchRespo.Photos.Photo>?) : BaseAdapter() {
    override fun getListSize(): Int {
//        if (dataList == null) return 0
//        return dataList?.size
        return 7
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_all_brand
    }

    override fun onBindTo(rowBinding: ViewDataBinding, position: Int) {
        if (rowBinding is ItemBrandBinding) {
        }
    }


    fun notifyAdapter(newsBeanList: ArrayList<SearchRespo.Photos.Photo>) {
        dataList = newsBeanList
        notifyDataSetChanged()
    }
}
