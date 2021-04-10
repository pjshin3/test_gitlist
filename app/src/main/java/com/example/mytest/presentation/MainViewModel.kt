package com.example.mytest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytest.domain.RepositoryUseCase
import com.example.mytest.domain.UserInfoUseCase
import kotlinx.coroutines.async

class MainViewModel (
    private val userInfoUseCase: UserInfoUseCase,
    private val repositoryUseCase: RepositoryUseCase
) : ViewModel(){

    fun requestDataSource(userName: String){
        viewModelScope.async {
            userInfoUseCase(userName)
            repositoryUseCase(userName)
        }
    }
}