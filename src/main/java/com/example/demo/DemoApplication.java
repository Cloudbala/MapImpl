package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//System.out.println("args = " + args);
		SpringApplication.run(DemoApplication.class, args);
		ConcurrentHasMapImpl chi = new ConcurrentHasMapImpl();
		//chi.process();
/**
 *  Implementation of how ConcurrentHasmap works in a multi Threading scenario
 *
 */
       ConcurrentHashMap<Integer,String> ehashmap= new ConcurrentHashMap<>();
//        Map<Integer,String> hmap= new HashMap<>();
//        Map<Integer,String> ehashmap = Collections.synchronizedMap(hmap);
//
//        RunnableThreadImpl t1= new RunnableThreadImpl(ehashmap);
//        RunnableThreadImpl t2= new RunnableThreadImpl(ehashmap);
//        RunnableThreadImpl t3= new RunnableThreadImpl(ehashmap);
//        RunnableThreadImpl t4= new RunnableThreadImpl(ehashmap);
//
//        for (Map.Entry<Integer,String> che:ehashmap.entrySet()) {
//            System.out.println(che.getKey()+":"+che.getValue());
//        }
        /**
         * Implementation of checking Concurrent modification Exception
         */
        ehashmap.put(10,"ten");
        ehashmap.put(11,"eleven");
        ehashmap.put(12,"twelve");
        ehashmap.put(13,"thirteen");
        ehashmap.put(14,"fourteen");

        RunnableThreadImpl2  rimpl2=new RunnableThreadImpl2(ehashmap);

        /**
         *  Thread pool Implementation
         */

        ExecutorService exser= Executors.newFixedThreadPool(2);
        exser.submit(rimpl2);
        try {
            exser.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exser.shutdown();

	}
}
