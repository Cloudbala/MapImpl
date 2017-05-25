package com.example.demo;

import java.util.Map;

/**
 * Created by openc on 25/5/2017.
 */
public class RunnableThreadImpl implements Runnable {

    Map<Integer, String> emap;


    public RunnableThreadImpl(Map<Integer, String> map) {
        this.emap = map;
        new Thread(this, "RunnableThreadImpl").start();
    }

    public void run() {
        emap.put(1, "balaji");

        try {
            System.out.println("sleeping");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
