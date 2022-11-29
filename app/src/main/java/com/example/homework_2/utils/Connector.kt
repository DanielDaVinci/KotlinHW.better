package com.example.homework_2.utils

import android.content.Context
import com.example.homework_2.R
import com.example.homework_2.data.api.ItemRequest
import com.example.homework_2.data.api.createRequest
import com.example.homework_2.data.api.ImageProvider

object Connector
{
    private lateinit var request : ItemRequest
    lateinit var ApplicationContext : Context

    fun initialize(context: Context)
    {
       ApplicationContext = context.applicationContext
       request = createRequest(ApplicationContext.getString(R.string.base_url))
    }

    fun provider(): ImageProvider = ImageProvider(request)
}