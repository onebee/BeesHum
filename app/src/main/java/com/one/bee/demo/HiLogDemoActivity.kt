package com.one.bee.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.one.bee.R
import com.one.library.log.HiViewPrinter

class HiLogDemoActivity : AppCompatActivity() {

    var viewPrinter: HiViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)



    }


}