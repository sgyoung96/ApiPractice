package com.example.movieapi1.results

import java.io.Serializable

data class MovieResponse(
    val boxOfficeResult: BoxOfficeResult
): Serializable
