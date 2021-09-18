package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.global.apiutils.ApiResponse
import com.example.myapplication.model.bean.SearchReq
import com.example.myapplication.model.bean.SearchRespo
import com.example.myapplication.model.repo.SearchRepository
import org.koin.core.KoinComponent

class SearchViewModel(private val projectRepository: SearchRepository) : ViewModel(), KoinComponent{
    private var channelResponse = MutableLiveData<ApiResponse<SearchRespo>>()

    fun getSearchPicData(): MutableLiveData<ApiResponse<SearchRespo>> {
        return channelResponse
    }

    fun newsChannelApi(strUrl: SearchReq) {
        projectRepository.searchPicApi(strUrl, channelResponse)
    }

}