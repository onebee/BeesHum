package com.one.bee.coroutine;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author diaokaibin@gmail.com on 2/12/21.
 */
public class CountDowLatchDemo {


    public void count() {

        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {


                    try {
                        Thread.sleep(new Random().nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " 准备好了 ");
                    downLatch.countDown();
                }
            }).start();
        }


        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" All ready go go go ....");
    }
}
