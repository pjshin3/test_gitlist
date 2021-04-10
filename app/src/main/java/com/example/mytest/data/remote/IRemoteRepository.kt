package com.example.mytest.data.remote

import com.example.mytest.data.remote.model.Repository
import com.example.mytest.data.remote.model.UserInfo
import com.google.gson.JsonObject
import retrofit2.Response

interface IRemoteRepository {
    suspend fun requestUserInfo(userName: String): UserInfo
    suspend fun requestUserRepos(userName: String): List<Repository>
}