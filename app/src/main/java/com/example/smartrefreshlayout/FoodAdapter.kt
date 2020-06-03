package com.example.smartrefreshlayout

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder

val foodName = arrayListOf("鹽酥雞","溫泉蛋","牛肉湯","叉燒包","炒飯","皮蛋豆腐","壽司","拉麵","漢堡","飲料")
val personName = arrayListOf("Name_1","Name_2","Name_3","Name_4","Name_5","Name_6","Name_7","Name_8","Name_9","Name_10")
val foodDrawable = arrayListOf(R.drawable.drawable_1,R.drawable.drawable_2,R.drawable.drawable_3,R.drawable.drawable_4,R.drawable.drawable_5
    ,R.drawable.drawable_6,R.drawable.drawable_7,R.drawable.drawable_8,R.drawable.drawable_9,R.drawable.drawable_10)
var num = 5
class FoodAdapter(
    val context: Context,
    val refreshLayout: SmartRefreshLayout
) : CommonAdapter<String>(context, R.layout.item_food, foodName) {


    override fun getItemCount(): Int {

        var m = refreshLayout.setEnableScrollContentWhenLoaded(true)

        if(m.autoLoadMore()){
            num += 3
        }

        if(num > foodDrawable.size){
            num = foodName.size
        }

        return num
    }

    override fun convert(holder: ViewHolder?, t: String?, position: Int) {


        holder?.setText(R.id.tv_foodName , foodName[position])
        holder?.setText(R.id.tv_peraonName , personName[position])
        val ImageView : ImageView? = holder?.itemView?.findViewById(R.id.iv_food)

        if (ImageView != null) {
            Glide.with(context)
                .load(foodDrawable[position])
                .centerCrop()
                .into(ImageView)
        }

    }


}