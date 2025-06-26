package com.example.modsentaskskonstantin.di

import com.example.modsentaskskonstantin.data.network.IServiceApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofitModule() = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(IServiceApi::class.java) }
}
