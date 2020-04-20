package com.example.demo.sync;

/**
 * @author liucy
 * @title: ${Name}
 * @projectName demo
 * @description: TODO
 * @date 2019/4/310:07
 */
public class SyncMainThread {

    public static void main(String[] args) {
//        SyncThread syncThread = new SyncThread();
//        Thread thread1 = new Thread(syncThread, "SyncThread1");
//        Thread thread2 = new Thread(syncThread, "SyncThread2");
//        Thread thread3 = new Thread(syncThread, "SyncThread3");
//        Thread thread4 = new Thread(syncThread, "SyncThread4");
//        Thread thread5 = new Thread(syncThread, "SyncThread5");
//        Thread thread6 = new Thread(syncThread, "SyncThread6");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
