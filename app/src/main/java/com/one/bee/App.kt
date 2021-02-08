package com.one.bee

import android.app.Application
import com.google.gson.Gson
import com.one.library.log.HiConsolePrinter
import com.one.library.log.HiFilePrinter
import com.one.library.log.HiLogConfig
import com.one.library.log.HiLogManager

/**
 * @author  diaokaibin@gmail.com on 2/8/21.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(
            object : HiLogConfig() {
                override fun injectJsonParser(): JsonParser {
                    return JsonParser { src ->
                        Gson().toJson(src)
                    }
                }

                override fun includeThread(): Boolean {
                    return false
                }

                override fun stackTraceDepth(): Int {
                    return 5
                }
            },
            HiConsolePrinter(),
            HiFilePrinter.getInstance(applicationContext.cacheDir.absolutePath, 0)
        )
    }
}