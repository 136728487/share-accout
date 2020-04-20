package com.example.demo.sync;

/**
 * @author liucy
 * @title: ${Name}
 * @projectName demo
 * @description: TODO
 * @date 2019/4/310:23
 */
public class Sync2Thread implements Runnable {
    private static int count;

    public Sync2Thread() {
        count = 0;
    }


    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }
}
