package com.example.homework_2.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.homework_2.R
import com.example.homework_2.data.api.ItemRequest
import com.example.homework_2.data.api.createRequest
import com.example.homework_2.data.api.ImageProvider

@SuppressLint("StaticFieldLeak")
object ConnectorContextProvider
{
    private lateinit var request : ItemRequest

    fun initialize(context: Context)
    {
       request = createRequest(context.applicationContext.getString(R.string.base_url))
    }

    fun provider(): ImageProvider = ImageProvider(request)
}