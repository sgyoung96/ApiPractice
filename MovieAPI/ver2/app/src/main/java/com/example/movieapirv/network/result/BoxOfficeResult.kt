package com.example.movieapirv.network.result

data class BoxOfficeResult(
    var boxofficeType: String,
    var showRange: String,
    var dailyBoxOfficeList: List<DailyBoxOfficeList> // Array 가 아니라 List 로 하니까 응답이 내가 원하는대로 제대로 안 오던 게 해결됨!
)
/*
boxofficeType	문자열	박스오피스 종류를 출력합니다.
showRange	    문자열	박스오피스 조회 일자를 출력합니다.
 */