package com.one.bee.demo.banner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.bumptech.glide.Glide
import com.one.bee.R
import com.one.ui.banner.HiBanner
import com.one.ui.banner.core.HiBannerMo
import com.one.ui.banner.indicator.HiCircleIndicator
import com.one.ui.banner.indicator.HiIndicator
import com.one.ui.banner.indicator.HiNumIndicator
import kotlinx.android.synthetic.main.activity_hi_banner_demo.*
import java.util.ArrayList

class HiBannerDemoActivity : AppCompatActivity() {

    private var urls = arrayOf(
        "https://www.devio.org/img/beauty_camera/beauty_camera1.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera3.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera4.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera5.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera2.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera6.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera7.jpg",
        "https://www.devio.org/img/beauty_camera/beauty_camera8.jpeg"
    )
    private var hiIndicator: HiIndicator<*>? = null
    private var autoPlay: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_banner_demo)
        banner
        initView(HiCircleIndicator(this), false)
        findViewById<Switch>(R.id.auto_play).setOnCheckedChangeListener { _, isChecked ->
            autoPlay = isChecked
            initView(hiIndicator, autoPlay)
        }
        findViewById<View>(R.id.tv_switch).setOnClickListener {
            //            mHiBanner.setAutoPlay(false)
            if (hiIndicator is HiCircleIndicator) {
                initView(HiNumIndicator(this), autoPlay)
            } else {
                initView(HiCircleIndicator(this), autoPlay)
            }

        }
        
    }

    private fun initView(hiIndicator: HiIndicator<*>?, autoPlay: Boolean) {
        this.hiIndicator = hiIndicator
        val mHiBanner = findViewById<HiBanner>(R.id.banner)
        val moList: MutableList<HiBannerMo> = ArrayList()
        for (i in 0..5) {
            val mo = BannerMo()
            mo.url = urls[i % urls.size]
            moList.add(mo)
        }
        mHiBanner!!.setHiIndicator(hiIndicator)
        mHiBanner.setAutoPlay(autoPlay)
        mHiBanner.setIntervalTime(2000)
        //自定义布局
        mHiBanner.setBannerData(R.layout.banner_item_layout, moList)
        mHiBanner.setBindAdapter { viewHolder, mo, position ->
            val imageView: ImageView = viewHolder.findViewById(R.id.iv_image)
            Glide.with(this@HiBannerDemoActivity).load(mo.url).into(imageView)
            val titleView: TextView = viewHolder.findViewById(R.id.tv_title)
            titleView.text = mo.url
            Log.d("----position:", position.toString() + "url:" + mo.url)
        }

    }
}