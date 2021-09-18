package com.example.myapplication.global.apiutils

import com.example.myapplication.model.bean.SearchRespo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
interface ApiServices {
    @GET("rest/?method=flickr.photos.search")
    fun searchApi(
        @Query("api_key") api_key: String,
        @Query("text") text: String,
        @Query("page") page: String,
        @Query("per_page") per_page: String,

        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String
    ): Deferred<Response<SearchRespo>>
}