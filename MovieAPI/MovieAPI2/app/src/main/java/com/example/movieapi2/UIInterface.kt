package com.example.movieapi2

import android.view.View

interface UIInterface {

    interface View {
        fun sendData(data: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun clickEvent()
    }
}