package com.example.movieapi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import com.example.movieapi2.Presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UIInterface.View {

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter()
        presenter.setView(this)

        btn_test.setOnClickListener {
            presenter.clickEvent()
        }
    }
    
    override fun sendData(data: String) {
        tv_test.text = data
    }
}