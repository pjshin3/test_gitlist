package com.example.mytest.domain

import com.example.mytest.data.remote.ApiService
import com.example.mytest.data.remote.IRemoteRepository
import com.example.mytest.data.remote.model.RequestError
import com.example.mytest.data.remote.model.RequestState

typealias IRepositoryUseCase = BaseUseCase<String, RequestState>
class RepositoryUseCase(
   private val remoteRepository : IRemoteRepository
):IRepositoryUseCase {
   override suspend fun invoke(pram: String): RequestState {
      remoteRepository.requestUserRepos(pram).also {

      }
      return RequestError()
   }
}