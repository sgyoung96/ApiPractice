package com.example.movieapirv

import com.example.movieapirv.network.result.DailyBoxOfficeList

interface MovieContract {
    interface View {
        fun sendData(data: List<DailyBoxOfficeList>)
        fun sendMessage(message: String?)
    }
    interface Presenter {
        fun setView(view: View)
        fun getMovieList()
    }
}