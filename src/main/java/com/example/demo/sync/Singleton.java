package com.example.demo.sync;

/**
 * @author liucy
 * @title: ${Name}
 * @projectName demo
 * @description: TODO
 * @date 2019/4/310:44
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    private static Singleton getUniqueInstance() {
        //判读对象是否已经实例过，没有实例才进入加锁代码
        if (uniqueInstance == null) {
            //对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
