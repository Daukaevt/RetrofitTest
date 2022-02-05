package com.wixsite.mupbam1.resume.retrofittest.retrofit

import com.wixsite.mupbam1.resume.retrofittest.PhotoItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface retrofitApi {
    @GET("photos")
    fun getData():Call<List<PhotoItem>>
}