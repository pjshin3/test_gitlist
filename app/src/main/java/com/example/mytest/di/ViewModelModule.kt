package com.example.mytest.di

import com.example.mytest.data.remote.IRemoteRepository
import com.example.mytest.data.remote.RemoteRepository
import com.example.mytest.domain.RepositoryUseCase
import com.example.mytest.domain.UserInfoUseCase
import com.example.mytest.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { MainViewModel(get(), get()) }
}

val useCaseModule = module {
    single { provideRepositroyUseCase(get()) }
    single { provideUserInfoUseCase(get()) }
}

internal fun provideRepositroyUseCase(remoteRepository: IRemoteRepository): RepositoryUseCase =
    RepositoryUseCase(remoteRepository)

internal fun provideUserInfoUseCase(remoteRepository: IRemoteRepository): UserInfoUseCase =
    UserInfoUseCase(remoteRepository)

