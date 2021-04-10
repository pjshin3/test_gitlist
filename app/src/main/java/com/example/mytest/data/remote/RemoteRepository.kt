package com.example.mytest.data.remote

import com.example.mytest.data.remote.model.Repository
import com.example.mytest.data.remote.model.UserInfo
import com.google.gson.JsonObject
import retrofit2.Response

class RemoteRepository(
    private val api: ApiService
):IRemoteRepository {
    override suspend fun requestUserInfo(userName: String): UserInfo {
        return api.requestUserInfo(userName).execute().body() ?: UserInfo()
    }

    override suspend fun requestUserRepos(userName: String): List<Repository> {
        return api.requestUserRepositoryInfo(userName).execute().body() ?: listOf<Repository>()
    }

}