package com.example.mytest.data.remote

import com.example.mytest.data.remote.model.Repository
import com.example.mytest.data.remote.model.UserInfo
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{username}")
    fun requestUserInfo(@Path ("username") userName :String): Call<UserInfo>
    @GET("/users/{username}/repos")
    fun requestUserRepositoryInfo(@Path ("username") userName :String): Call<List<Repository>>
}