package com.example.homework_2.data.api

import com.example.homework_2.ResponseParameters
import com.example.homework_2.data.api.ItemRequest
import com.example.homework_2.MVVM.model.Response
import java.text.FieldPosition

// провайдер для получения картинок из сети
class ImageProvider(private val getRequest : ItemRequest)
{

    suspend fun getItems(offset : Int, limit : Int): Response
    {
        return getRequest.getItems(
            ResponseParameters.API_KEY.value,
            ResponseParameters.Q.value,
            limit,
            offset,
            ResponseParameters.RATING.value,
            ResponseParameters.LANG.value)
    }
}