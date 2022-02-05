package com.wixsite.mupbam1.resume.retrofittest.retrofit

import com.wixsite.mupbam1.resume.retrofittest.PhotoItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServises {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api:retrofitApi by lazy {
        retrofit.create(retrofitApi::class.java)
    }
}