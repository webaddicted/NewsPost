package com.example.myapplication.model.repo

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.global.constant.ApiConstant
import com.example.myapplication.global.apiutils.ApiResponse
import com.example.myapplication.global.apiutils.ApiServices
import com.example.myapplication.global.apiutils.DataFetchCall
import com.example.myapplication.model.bean.SearchReq
import com.example.myapplication.model.bean.SearchRespo
import kotlinx.coroutines.Deferred
import org.koin.core.KoinComponent
import retrofit2.Response
class SearchRepository constructor(private val apiServices: ApiServices) : KoinComponent {
    fun searchPicApi(strUrl: SearchReq, loginResponse: MutableLiveData<ApiResponse<SearchRespo>>) {
        object : DataFetchCall<SearchRespo>(loginResponse) {
            override fun createCallAsync(): Deferred<Response<SearchRespo>> {
                return apiServices.searchApi( ApiConstant.SERVER_KEY,strUrl.text, strUrl.page.toString(),80.toString(),"json","1")
            }

            override fun shouldFetchFromDB(): Boolean {
                return false
            }
        }.execute()
    }
}