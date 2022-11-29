package com.example.homework_2.utils

import android.app.Application

// получение контекста приложения по необходимости
class MainApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        Connector.initialize(this)
    }

    companion object
    {
        val ApplicationContext = this
    }
}