package com.example.movieapirv.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapirv.R
import com.example.movieapirv.network.result.DailyBoxOfficeList

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tv_rnum          = itemView.findViewById<TextView>(R.id.tv_rnum         )
    var tv_rank          = itemView.findViewById<TextView>(R.id.tv_rank         )
    var tv_rankInten     = itemView.findViewById<TextView>(R.id.tv_rankInten    )
    var tv_rankOldAndNew = itemView.findViewById<TextView>(R.id.tv_rankOldAndNew)
    var tv_movieCd       = itemView.findViewById<TextView>(R.id.tv_movieCd      )
    var tv_movieNm       = itemView.findViewById<TextView>(R.id.tv_movieNm      )
    var tv_openDt        = itemView.findViewById<TextView>(R.id.tv_openDt       )
    var tv_salesAmt      = itemView.findViewById<TextView>(R.id.tv_salesAmt     )
    var tv_salesShare    = itemView.findViewById<TextView>(R.id.tv_salesShare   )
    var tv_salesInten    = itemView.findViewById<TextView>(R.id.tv_salesInten   )
    var tv_salesChange   = itemView.findViewById<TextView>(R.id.tv_salesChange  )
    var tv_salesAcc      = itemView.findViewById<TextView>(R.id.tv_salesAcc     )
    var tv_audiCnt       = itemView.findViewById<TextView>(R.id.tv_audiCnt      )
    var tv_audiInten     = itemView.findViewById<TextView>(R.id.tv_audiInten    )
    var tv_audiChange    = itemView.findViewById<TextView>(R.id.tv_audiChange   )
    var tv_audiAcc       = itemView.findViewById<TextView>(R.id.tv_audiAcc      )
    var tv_scrnCnt       = itemView.findViewById<TextView>(R.id.tv_scrnCnt      )
    var tv_showCnt       = itemView.findViewById<TextView>(R.id.tv_showCnt      )

    fun bind(data: DailyBoxOfficeList) {
        tv_rnum         .text = data.rnum
        tv_rank         .text = data.rank
        tv_rankInten    .text = data.rankInten
        tv_rankOldAndNew.text = data.rankOldAndNew
        tv_movieCd      .text = data.movieCd
        tv_movieNm      .text = data.movieNm
        tv_openDt       .text = data.openDt
        tv_salesAmt     .text = data.salesAmt
        tv_salesShare   .text = data.salesShare
        tv_salesInten   .text = data.salesInten
        tv_salesChange  .text = data.salesChange
        tv_salesAcc     .text = data.salesAcc
        tv_audiCnt      .text = data.audiCnt
        tv_audiInten    .text = data.audiInten
        tv_audiChange   .text = data.audiChange
        tv_audiAcc      .text = data.audiAcc
        tv_scrnCnt      .text = data.scrnCnt
        tv_showCnt      .text = data.showCnt
    }

}