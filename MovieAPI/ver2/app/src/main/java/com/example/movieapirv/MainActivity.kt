package com.example.movieapirv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapirv.network.BaseInfo
import com.example.movieapirv.network.GetMovieListBuilder
import com.example.movieapirv.network.result.DailyBoxOfficeList
import com.example.movieapirv.network.result.MovieResponse
import com.example.movieapirv.recyclerview.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity(), MovieContract.View {

    var adapter: MovieAdapter? = null
    var data: DailyBoxOfficeList? = null

    var presenter: MoviePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movie_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        adapter = MovieAdapter(this)
        rv_movie_list.adapter = adapter

        presenter = MoviePresenter()

        presenter?.setView(this)
        presenter?.getMovieList()


//        callMovieList()
    }

//    fun callMovieList() {
//        var getMovieListBuilder = GetMovieListBuilder()
//        getMovieListBuilder.requestMovieAPI
//            .getMovieList(
//                BaseInfo.MOVIE_API_KEY,
//                "20210603"
//            )
//            .enqueue(object: Callback<MovieResponse> {
//                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                    Log.d("FAIL MESSAGE", ">>>>>>>>>${t.message}")
//                }
//
//                override fun onResponse(
//                    call: Call<MovieResponse>,
//                    response: Response<MovieResponse>
//                ) {
//                    val movieResponse = response.body()
//                    val movieList: List<DailyBoxOfficeList>? = movieResponse?.boxOfficeResult?.dailyBoxOfficeList
//
//                    data = movieList!!
//
//                    Log.d("SUCCESS: JSON", ">>>>>>>>>$movieList")
//
//                    initRecycler()
//                }
//            })
//    }
//
//    fun initRecycler() {
//
//        rv_movie_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
//        adapter = MovieAdapter(this)
//
//        adapter?.data = data
//        adapter?.notifyDataSetChanged()
//
//        rv_movie_list.adapter = adapter
//    }

    override fun sendData(data: List<DailyBoxOfficeList>) {
        adapter?.setDataList(data)
    }

    override fun sendMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
    }
}

/*
getMovieList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String,
        @Query("itemPerPage") itemPerPage: String,
        @Query("multiMovieYn") multiMovieYn: String,
        @Query("repNationCd") repNationCd: String,
        @Query("wideAreaCd") wideAreaCd: String
*/

/*
[요청 파라미터 샘플 값]
key	            문자열(필수)	발급받은키 값을 입력합니다.
targetDt	    문자열(필수)	조회하고자 하는 날짜를 yyyymmdd 형식으로 입력합니다.
itemPerPage	    문자열	    결과 ROW 의 개수를 지정합니다.(default : “10”, 최대 : “10“)
multiMovieYn	문자열	    다양성 영화/상업영화를 구분지어 조회할 수 있습니다. “Y” : 다양성 영화 “N” : 상업영화 (default : 전체)
repNationCd	    문자열	    한국/외국 영화별로 조회할 수 있습니다. “K: : 한국영화 “F” : 외국영화 (default : 전체)
wideAreaCd	    문자열	    상영지역별로 조회할 수 있으며, 지역코드는 공통코드 조회 서비스에서 “0105000000” 로서 조회된 지역코드입니다. (default : 전체)
*/

/*
JSON 응답 예시
http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101
 */