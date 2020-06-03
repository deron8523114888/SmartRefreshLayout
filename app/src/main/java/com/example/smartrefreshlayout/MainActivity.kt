package com.example.smartrefreshlayout

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.header.BezierRadarHeader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()


    }

    fun init() {


        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        // 設置 Heeader 加載樣式
        refreshLayout.setRefreshHeader(BezierRadarHeader(this))
        refreshLayout.setRefreshFooter(BallPulseFooter(this))

        // 設置 RecyclerView 的 layoutManager
        rv_food.layoutManager = linearLayoutManager

        // 設置 RecyclerView 的 Adapter
        rv_food.adapter = FoodAdapter(this,refreshLayout)




    }


}
