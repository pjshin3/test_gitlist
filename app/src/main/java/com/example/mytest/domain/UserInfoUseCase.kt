package com.example.mytest.domain

import android.util.Log
import com.example.mytest.data.remote.IRemoteRepository
import com.example.mytest.data.remote.model.RequestError
import com.example.mytest.data.remote.model.RequestState

typealias IUserInfoUseCase = BaseUseCase<String, RequestState>
class UserInfoUseCase (
    private val remoteRepository: IRemoteRepository
):IUserInfoUseCase {
    override suspend fun invoke(pram: String): RequestState {
        Log.e("philip" ,"${remoteRepository.requestUserInfo(pram)}")
        return RequestError()
    }
}