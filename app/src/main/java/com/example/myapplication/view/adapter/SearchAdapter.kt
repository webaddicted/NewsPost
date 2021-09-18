package com.example.myapplication.view.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemSearchBinding
import com.example.myapplication.model.bean.SearchRespo
import com.example.myapplication.view.base.BaseAdapter

class SearchAdapter(private var dataList: ArrayList<SearchRespo.Photos.Photo>?) : BaseAdapter() {
    override fun getListSize(): Int? {
//        if (dataList == null) return 0
//        return dataList?.size
        return 15
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_search
    }

    override fun onBindTo(rowBinding: ViewDataBinding, position: Int) {
        if (rowBinding is ItemSearchBinding) {
//            val source = dataList?.get(position)
//            Glide.with(rowBinding.root.context)
//                .load(ApiConstant.IMG_URL +"${source?.server}/${source?.id}_${source?.secret}.jpg").error(R.color.grey).placeholder(R.color.grey).into(rowBinding.img)
            setAdapter(rowBinding)
        }
    }

    private fun setAdapter(rowBinding: ItemSearchBinding) {
        val adapter = SearchSubTagAdapter(ArrayList())
        rowBinding.rv.layoutManager = LinearLayoutManager(
                rowBinding.rv.context,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        rowBinding.rv.adapter = adapter
    }

    fun notifyAdapter(newsBeanList: ArrayList<SearchRespo.Photos.Photo>) {
        dataList = newsBeanList
        notifyDataSetChanged()
    }
}
