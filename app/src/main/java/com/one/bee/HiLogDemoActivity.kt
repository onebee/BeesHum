package com.one.bee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.one.library.log.HiLog
import com.one.library.log.HiLogManager
import com.one.library.log.HiViewPrinter

class HiLogDemoActivity : AppCompatActivity() {

    var viewPrinter: HiViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)

        viewPrinter = HiViewPrinter(this)

        findViewById<Button>(R.id.btn).setOnClickListener {

            printLog()

        }
        viewPrinter!!.viewProvider.showFloatingView()


    }


    private fun printLog() {

        HiLogManager.getInstance().addPrinter(viewPrinter)

        var s = "{\"customer\":{\n" +
                "\"name\":\"Mr A\",\n" +
                "\"age\":\"33\",\n" +
                "\"country\":\"USA\",\n" +
                "\"tel\":[\"111111111\",\"9999999999\"]\n" +
                "}}"
        HiLog.i(s)

    }
}