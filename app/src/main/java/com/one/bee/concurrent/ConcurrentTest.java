package com.one.bee.concurrent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author diaokaibin@gmail.com on 2/11/21.
 */
public class ConcurrentTest {

    public static final String TAG = "hiLog";
    private static final int MSG_WHAT_1 = 1;

    static volatile boolean hasNotify;

    public  void test() {

        LooperThread looperThread = new LooperThread("looper - thread ");
        looperThread.start();

        Handler handler = new Handler(looperThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                     Log.i(TAG,"handleMessage : "+ msg.what);
                Log.i(TAG, "handleMessage : " + Thread.currentThread().getName());
            }
        };
        handler.sendEmptyMessage(MSG_WHAT_1);

    }

    class LooperThread extends Thread{
        private Looper looper;

        public LooperThread(String s) {
            super(s);
        }

        public Looper getLooper() {
            synchronized (this) {
                if (looper == null && isAlive()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
            return looper;
        }

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            synchronized (this) {
                looper = Looper.myLooper();
                notifyAll();

            }
            Looper.loop();
        }
    }


}
