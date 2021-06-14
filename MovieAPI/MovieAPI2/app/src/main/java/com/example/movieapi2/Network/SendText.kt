package com.example.movieapi2.Network

import com.example.movieapi2.Network.Model.TestModel
import com.example.movieapi2.Presenter.Presenter

class SendText: SendTextInterface {

    val model: TestModel = TestModel()
    var data: String

    init {
        this.data = model.text
    }

    override fun clickListener() {
        val result = receiveData()
        val presenter = Presenter()
        presenter.sendData(result)
    }

    fun receiveData(): String {
        return data
    }
}