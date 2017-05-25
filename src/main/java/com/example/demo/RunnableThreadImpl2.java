package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by openc on 25/5/2017.
 */
public class RunnableThreadImpl2 implements Runnable {

Map<Integer,String> emap = new ConcurrentHashMap<>();
    public RunnableThreadImpl2(Map<Integer,String> map){
        this.emap=map;
        new Thread(this,"Impl2").start();
    }

    public void run(){
        for (Map.Entry<Integer,String> e :emap.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());
            emap.put(15, "fifteen");
        }
        try {
              Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
