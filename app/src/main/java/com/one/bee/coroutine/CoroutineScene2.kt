package com.one.bee.coroutine

import android.util.Log
import kotlinx.coroutines.delay

/**
 * @author  diaokaibin@gmail.com on 2/12/21.
 */
object CoroutineScene2 {

    var TAG = "hiLog"
   suspend fun request2(): String {
        Log.d(TAG, "request2 completed ")
       delay(2*1000)
        return "result from request2"
    }

}