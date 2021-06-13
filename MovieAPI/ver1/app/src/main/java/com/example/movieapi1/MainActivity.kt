package com.example.movieapi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieapi1.results.DailyBoxOfficeList
import com.example.movieapi1.results.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callMovieList()
    }

    fun callMovieList() {
        var getMovieListBuilder = GetMovieListBuilder()
        getMovieListBuilder.requestMovieAPI
            .getMovieList(BaseInfo.MOVIE_API_KEY,
                "20210603"
            )
            .enqueue(object: Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("FAIL MESSAGE", ">>>>>>>>>${t.message}")
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val movieResponse = response.body()
                    val movieList: List<DailyBoxOfficeList>? = movieResponse?.boxOfficeResult?.dailyBoxOfficeList

                    Log.d("SUCCESS: JSON", ">>>>>>>>>$movieList")

                    try {
//                        Log.d("movieList?.get(0)", ">>>>>>>>>${movieList?.get(0)?.rnum}")
                    } catch (e: Exception) {
                        Log.d("Exception1", ">>>>>>>>>$e")
                    }

                    try {
                        tv_rnum         .text = movieList?.get(0)?.rnum
                        tv_rank         .text = movieList?.get(0)?.rank
                        tv_rankInten    .text = movieList?.get(0)?.rankInten
                        tv_rankOldAndNew.text = movieList?.get(0)?.rankOldAndNew
                        tv_movieCd      .text = movieList?.get(0)?.movieCd
                        tv_movieNm      .text = movieList?.get(0)?.movieNm
                        tv_openDt       .text = movieList?.get(0)?.openDt
                        tv_salesAmt     .text = movieList?.get(0)?.salesAmt
                        tv_salesShare   .text = movieList?.get(0)?.salesShare
                        tv_salesInten   .text = movieList?.get(0)?.salesInten
                        tv_salesChange  .text = movieList?.get(0)?.salesChange
                        tv_salesAcc     .text = movieList?.get(0)?.salesAcc
                        tv_audiCnt      .text = movieList?.get(0)?.audiCnt
                        tv_audiInten    .text = movieList?.get(0)?.audiInten
                        tv_audiChange   .text = movieList?.get(0)?.audiChange
                        tv_audiAcc      .text = movieList?.get(0)?.audiAcc
                        tv_scrnCnt      .text = movieList?.get(0)?.scrnCnt
                        tv_showCnt      .text = movieList?.get(0)?.showCnt
                    } catch (e: Exception) {
                        Log.d("Exception2", ">>>>>>>>>$e")
                    }
                }
            })
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

/**
 * 로그에 JSON 들어오는거 잘 확인했으니까, 이제 파싱해서 변수에 데이터 담는것 하면 되겠다.
 * 그 후에 그 변수를 화면에 뿌려주기 하기
 */