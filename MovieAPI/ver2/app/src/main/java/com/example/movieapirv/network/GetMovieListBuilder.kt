package com.example.movieapirv.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetMovieListBuilder {
    var requestMovieAPI: RequestMovieAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseInfo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        requestMovieAPI = retrofit.create(RequestMovieAPI::class.java)
    }
}