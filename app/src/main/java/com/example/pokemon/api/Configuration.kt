package com.example.pokemon.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface Configuration: Pokemon {
    companion object Factory {
        fun create(): Configuration {
            val logging = HttpLoggingInterceptor()
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val httpClient = OkHttpClient().newBuilder()

            httpClient.connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(logging)

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .baseUrl("https://pokeapi.co/api/v2/")
                .build()

            return retrofit.create(Configuration::class.java)
        }
    }

}