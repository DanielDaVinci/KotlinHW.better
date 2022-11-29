package com.example.homework_2

enum class ResponseParameters(val value : String)
{
    API_KEY("LDcyZ649GUV7Biq7Sucp7aZoNzi1PlhD"),
    Q("jojo bizarre adventure"),
    LIMIT("100"),
    OFFSET("0"),
    RATING("g"),
    LANG("en"),
}

enum class StatusLoad
{
    SUCCESS,
    ERROR
}