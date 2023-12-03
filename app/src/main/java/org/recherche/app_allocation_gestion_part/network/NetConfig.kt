package org.recherche.app_allocation_gestion_part.network

import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.time.Duration
import java.util.concurrent.TimeUnit

@RequiresApi(Build.VERSION_CODES.O)

class netObject {

    companion object {
        private val BASE_UAL = "secirt"
        private val interceptor = HttpLoggingInterceptor()
        private val client = OkHttpClient().newBuilder().addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).readTimeout(100, TimeUnit.SECONDS).connectTimeout(100, TimeUnit.SECONDS).callTimeout(100, TimeUnit.SECONDS) .build()

        val retrofitInstance = Retrofit.Builder().baseUrl(BASE_UAL).client(client).addConverterFactory(GsonConverterFactory.create()).build()

        fun getAdminAPI() : AdminAPI{
            return retrofitInstance.create(AdminAPI::class.java)
        }

        fun getUserAPI(): UserAPI {
            return retrofitInstance.create(UserAPI::class.java)
        }

    }



}