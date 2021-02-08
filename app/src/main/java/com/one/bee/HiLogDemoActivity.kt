package com.one.bee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.one.library.log.HiLog
import com.one.library.log.HiLogManager

class HiLogDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)

        findViewById<Button>(R.id.btn).setOnClickListener {

            printLog()

        }


    }


    private fun printLog() {
        HiLog.i("this is a  cons log ")

    }
}