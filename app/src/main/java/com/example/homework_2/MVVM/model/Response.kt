package com.example.homework_2.MVVM.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Response(
    @SerializedName("data") var data: ArrayList<Item> = arrayListOf()
) : java.io.Serializable
{
    @Parcelize
    data class Item(
        @SerializedName("id") var id: String = "",
        @SerializedName("images") var images: Images = Images()
    ) : Parcelable
    {
        @Parcelize
        data class Images(
            @SerializedName("original") var parameters: Parameters = Parameters()
        ) : Parcelable
        {
            @Parcelize
            data class Parameters(
                @SerializedName("url") var url: String = "",
            ) : Parcelable
        }
    }
}
