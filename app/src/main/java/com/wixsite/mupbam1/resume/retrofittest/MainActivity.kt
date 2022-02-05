package com.wixsite.mupbam1.resume.retrofittest

//https://www.youtube.com/watch?v=5gFrXGbQsc8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wixsite.mupbam1.resume.retrofittest.databinding.ActivityMainBinding
import com.wixsite.mupbam1.resume.retrofittest.retrofit.retrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL="https://jsonplaceholder.typicode.com"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(retrofitApi::class.java)
        val retrofitData=retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<PhotoItem>?> {
            override fun onResponse(
                call: Call<List<PhotoItem>?>,
                response: Response<List<PhotoItem>?>
            ) {
                val responseBody=response.body()!!
                val myStringBuilder=StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append(myData.title)
                    myStringBuilder.append("\n")


                }
                binding.tvTitle.text=myStringBuilder
            }

            override fun onFailure(call: Call<List<PhotoItem>?>, t: Throwable) {
                Log.d("MyLog","onFailer"+t.message)
            }
        })
    }
}