package com.example.mytest.data.remote.model

sealed class RequestState()

data class RequestUserInfoSuccess(
    var code: Int = -1,
    var userInfo: UserInfo
): RequestState()

data class RequestRepositorySuccess(
    var code: Int = -1,
    var list : List<Repository>
):RequestState()

data class RequestError(
    var code: Int = -1,
    var msg: String = ""
):RequestState()