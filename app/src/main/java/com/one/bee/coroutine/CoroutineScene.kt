package com.one.bee.coroutine

import android.provider.Settings
import android.util.Log
import com.one.bee.concurrent.ConcurrentTest.TAG
import kotlinx.coroutines.*
import kotlin.math.log

/**
 * @author  diaokaibin@gmail.com on 2/12/21.
 */
object CoroutineScene {

    private const val TAG = "hiLog";


    /**
     * 启动一个线程,先执行request1 . 完了之后 同时运行 request2 和 request3 .
     * 这两个并发结束之后才执行 updateUI
     */
    fun startScene2() {
        GlobalScope.launch(Dispatchers.Main) {

            Log.d(TAG, "startScene2: coroutine is running ")

            val result1 = request1()

            val deferred2 = GlobalScope.async {
                request2()
            }

            val deferred3 = GlobalScope.async {
                request3()
            }

            updateUI(deferred2.await() + "  --- " + deferred3.await())

        }

    }


    /**
     * 依次启动三个子线程,以同步的方式拿到返回值 更新UI
     */
    fun startScent1() {

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "startScent1: coroutine is running ")
            val request1 = request1()
            val request2 = request2()
            val request3 = request3()

            updateUI(request1 + request2 + request3)

        }

        Log.d(TAG, "startScent1: coroutine has launched")

    }

    private fun updateUI(s: String) {
        Log.d(TAG, "updateUI: $s" + ", work on ${Thread.currentThread().name}")
    }

    suspend fun request1(): String {
        /**
         * 不会暂停线程,会暂停当前所在的协程
         */
        delay(2 * 1000)
        Log.d(TAG, "request1: work on ${Thread.currentThread().name}")
        return "result from request1"
    }

    suspend fun request2(): String {
        delay(2 * 1000)
        Log.d(TAG, "request2: work on ${Thread.currentThread().name}")
        return "result from request2"
    }

    suspend fun request3(): String {
        delay(2 * 1000)
        Log.d(TAG, "request3: work on ${Thread.currentThread().name}")
        return "result from request3"
    }

}