package com.example.movieapirv.network.result

import java.io.Serializable

data class MovieResponse(
    val boxOfficeResult: BoxOfficeResult
): Serializable
