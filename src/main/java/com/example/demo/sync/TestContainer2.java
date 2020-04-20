//package com.example.demo.sync;
//
//
//import java.util.LinkedList;
//import java.util.concurrent.*;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//
///**
// * @author liucy
// * @title: ${Name}
// * @projectName demo
// * @description: TODO
// * @date 2019/4/314:16
// */
//public class TestContainer2<E> {
//    private final LinkedList<E> list = new LinkedList<>();
//    private final int MAX = 10;
//    private int count = 0;
//    private Lock lock = new ReentrantLock();
//    private Condition producer = lock.newCondition();
//    private Condition consumer = lock.newCondition();
//    private static final ThreadPoolExecutor threadPool =
//            new ThreadPoolExecutor(
//                    1, 50, 100, TimeUnit.SECONDS,
//                    new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.DiscardOldestPolicy());
//    private static final ThreadPoolExecutor threadPool2 =
//            new ThreadPoolExecutor(
//                    1, 50, 100, TimeUnit.SECONDS,
//                    new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.DiscardOldestPolicy());
//
//    public int getCount() {
//        return count;
//    }
//
//    public void put(E e) {
//        lock.lock();
//        try {
//            while (list.size() == MAX) {
//                System.out.println(Thread.currentThread().getName() + "产品已生产满，等待被消费");
//                //进入等待队列，释放锁标记
//                //接住条件，进入等待队列
//                producer.await();
//            }
//            System.out.println(Thread.currentThread().getName() + "新一个产品");
//            list.add(e);
//            count++;
//            //唤醒所有的消费者
//            consumer.signalAll();
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public E get() {
//        E e = null;
//        lock.lock();
//        try {
//            while (list.size() == 0) {
//                System.out.println(Thread.currentThread().getName() + "没有产品可以消费，进入等待");
//                //借助条件消费者进入等待队列
//                consumer.await();
//            }
//            System.out.println(Thread.currentThread().getName() + "消费掉一个产品");
//            e = list.removeFirst();
//            count--;
//            //借助条件唤醒所有的生产者
//            producer.signalAll();
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//        return e;
//    }
//
//    public static void main(String[] args) {
//        final TestContainer2<String> c = new TestContainer2<>();
//        for (int i = 0; i < 10; i++) {
//            threadPool.execute(() -> {
//                        for (int j = 0; j < 5; j++) {
//                            System.out.println(c.get());
//                        }
//                    }
//            );
//        }
//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        for (int i = 0; i < 2; i++) {
//            threadPool2.execute(() -> {
//                for (int j = 0; j < 25; j++) {
//                    c.put("container value" + j);
//                }
//            });
//
//
//        }
//
//    }
//
//}
