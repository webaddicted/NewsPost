package com.example.myapplication.model.bean

import com.example.myapplication.global.constant.ApiConstant
import com.google.gson.annotations.SerializedName

class SearchReq {
    @SerializedName("api_key")
    var api_key: String = ApiConstant.SERVER_KEY

    @SerializedName("text")
    var text: String = ""

    @SerializedName("format")
    var format: String = "json"

    @SerializedName("nojsoncallback")
    var nojsoncallback: String = "1"
    @SerializedName("page")
    var page: Int = 1
}
