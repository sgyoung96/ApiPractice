package com.example.movieapi2.Presenter

import com.example.movieapi2.Network.Model.TestModel
import com.example.movieapi2.Network.SendText
import com.example.movieapi2.Network.SendTextInterface
import com.example.movieapi2.UIInterface

class Presenter: UIInterface.Presenter, SendTextInterface {

    private lateinit var view: UIInterface.View
    val sendText = SendText()
    private lateinit var data: String

    override fun setView(view: UIInterface.View) {
        this.view = view
    }

    override fun clickEvent() {
        sendText.clickListener()
    }

    override fun clickListener() {
        view.sendData(data) // 여기서 터짐 view = null
    }

    fun sendData(data: String) {
        this.data = data
        clickListener()
    }
}