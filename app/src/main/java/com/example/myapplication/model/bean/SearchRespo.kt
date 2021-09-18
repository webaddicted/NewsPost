package com.example.myapplication.model.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class SearchRespo : Serializable {
    @SerializedName("stat")
    var stat: String? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("photos")
    var photos: Photos? = null

    class Photos {
        @SerializedName("perpage")
        var perpage: String? = null

        @SerializedName("total")
        var total: String? = null

        @SerializedName("pages")
        var pages: String? = null

        @SerializedName("photo")
        var photo = ArrayList<Photo>()

        @SerializedName("page")
        var page: String? = null

        class Photo {
            @SerializedName("owner")
            var owner: String? = null

            @SerializedName("server")
            var server: String? = null

            @SerializedName("ispublic")
            var ispublic: String? = null

            @SerializedName("sourisfriendces")
            var isfriend: String? = null

            @SerializedName("farm")
            var farm: String? = null

            @SerializedName("id")
            var id: String? = null

            @SerializedName("secret")
            var secret: String? = null

            @SerializedName("title")
            var title: String? = null

            @SerializedName("isfamily")
            var isfamily: String? = null
        }
    }
}