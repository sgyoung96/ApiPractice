package com.example.movieapirv

import android.util.Log
import com.example.movieapirv.network.BaseInfo
import com.example.movieapirv.network.GetMovieListBuilder
import com.example.movieapirv.network.result.DailyBoxOfficeList
import com.example.movieapirv.network.result.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter: MovieContract.Presenter {

    private var view: MovieContract.View? = null
    var getMovieListBuilder: GetMovieListBuilder? = null

    var data = listOf<DailyBoxOfficeList>()

    override fun setView(view: MovieContract.View) {
        this.view = view
    }

    override fun getMovieList() {
        getMovieListBuilder = GetMovieListBuilder()

        getMovieListBuilder?.requestMovieAPI?.getMovieList(BaseInfo.MOVIE_API_KEY, "20210603")?.enqueue(object: Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("FAIL MESSAGE", ">>>>>>>>>${t.message}")

                    view?.sendMessage(t.message)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val movieResponse = response.body()
                    val movieList: List<DailyBoxOfficeList>? = movieResponse?.boxOfficeResult?.dailyBoxOfficeList
                    data = movieList!!
                    Log.d("SUCCESS: JSON", ">>>>>>>>>$movieList")

                    view?.sendData(data)
                }
            })
    }
}