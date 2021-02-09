package com.one.bee;

import com.one.common.ui.component.HiBaseApplication;
import com.one.library.log.HiConsolePrinter;
import com.one.library.log.HiLogConfig;
import com.one.library.log.HiLogManager;

/**
 * @author diaokaibin@gmail.com on 2/9/21.
 */
public class HiApplication extends HiBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        HiLogManager.init(new HiLogConfig() {
            @Override
            public JsonParser injectJsonParser() {
                return super.injectJsonParser();
            }

            @Override
            public boolean enable() {
                return true;
            }

            @Override
            public boolean includeThread() {
                return true;
            }

            @Override
            public int stackTraceDepth() {
                return 5;
            }

        },new HiConsolePrinter());
    }
}
