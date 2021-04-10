package com.example.mytest.di

import com.example.mytest.data.remote.ApiService
import com.example.mytest.data.remote.IRemoteRepository
import com.example.mytest.data.remote.RemoteRepository
import org.koin.android.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val CONNECT_TIMEOUT = 15L
const val WRITE_TIMEOUT = 15L
const val READ_ITEMOUT = 15L
const val BASE_URL = "https://api.github.com"

val networkModule = module {

    single { OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_ITEMOUT, TimeUnit.SECONDS)
        .addInterceptor(Interceptor{ chain ->
            chain.proceed(chain
                .request()
                .newBuilder()
                .header("Accept", "application/json")
                .build()
            )
        })
        .addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG){
                level = HttpLoggingInterceptor.Level.BODY
            }
        })
        .build() }

    single { Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(get())
        .build() }
    single() { get<Retrofit>().create(ApiService::class.java) }

    single<IRemoteRepository> { RemoteRepository(api = get()) }
}
