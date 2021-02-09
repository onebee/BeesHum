package com.one.bee.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.one.bee.R
import com.one.common.ui.component.HiBaseActivity
import com.one.ui.refresh.HiOverView
import com.one.ui.refresh.HiRefresh
import com.one.ui.refresh.HiRefreshLayout
import com.one.ui.refresh.HiTextOverView

class HiRefreshDemoActivity : HiBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_refresh_demo)

        val refreshLayout = findViewById<HiRefreshLayout>(R.id.refresh_layout)
        var overView = HiTextOverView(this)

        refreshLayout.setRefreshOverView(overView)
        refreshLayout.setRefreshListener(object : HiRefresh.HiRefreshListener {
            override fun onRefresh() {

                Handler().postDelayed({
                    refreshLayout.refreshFinished()
                },1000)
            }

            override fun enableRefresh(): Boolean {
                return true
            }

        })
    }


}