package com.marciotrindade.mybank.api.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {
    val taskApi = getTask().create(TaskApi::class.java)
    private fun getTask(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bank-app-test.herokuapp.com/api/")
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    private fun getInterceptorClient(): OkHttpClient {

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)

            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(newRequest)
            }

        return interceptor.build()
    }
}
