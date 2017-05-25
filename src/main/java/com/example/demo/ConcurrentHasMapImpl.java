package com.example.demo;

import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * We use ConcurrentHashMap when a high level of concurrency is required. But already SynchronizedMap is present so what advantages
 * does ConcurrentHashMap have over synchronized map.Both are thread safe. The major advantage is in case of synchronizedMap
 * every write operation acquires lock on entire SynchronizedMap while in case of ConcurrentHashMap the lock is only on one of the segments.
 * Created by Balaji on 25/5/2017.
 */
public class ConcurrentHasMapImpl {

    public void process() {

        /**
         * Create a concurrent Hash Map and add random values
         */
        ConcurrentHashMap<Integer, UUID> cmap1 = new ConcurrentHashMap<>();
        for (int j = 0; j < 50; j++) {
            cmap1.put(j, UUID.randomUUID());
        }

        /**
         * Write general utility functions
         */

        System.out.println(cmap1.size());





        /**
         *  Use Search () to  search an integer in the map with 3 threads spanned for the task
         */
        Integer sessionId = 10;
        String searchResult = cmap1.search(3, (k, v) -> {
            if (k.equals(sessionId)) {
                return new String(k + ":" + v);
            } else {
                return null;
            }
        });
        System.out.println(searchResult);

        /**
         * User SearchEntries() to search the key value in map with 3 Threads spanned for this task
         */
        String searchEntriesResult = cmap1.searchEntries(3, (e) -> {
            if (e.getValue().toString().contains("ab")) {
                return new String(e.getKey() + "" + e.getValue());
            } else {
                return null;
            }
        });
        System.out.println(searchEntriesResult);
        /**
         * Use searchKeys() to search a key in the map
         */
        String searchKeyResult = cmap1.searchKeys(3, (k) -> {
            if (k.equals(15)) {
                return new String(k + "");
            } else {
                return null;
            }
        });
        System.out.println("searchKeyResult = " + searchKeyResult);
        /**
         * Use searchValues() to search a values in the map
         */
        String searchValuesResult = cmap1.searchValues(3, (v) -> {
            if (v.toString().contains("ee")) {
                return new String(v + "");
            } else {
                return null;
            }

        });
        System.out.println("searchValuesResult = " + searchValuesResult);

        /**
         * Create a ConcurrentHashMap and provide some key and values 
         */
        ConcurrentHashMap<String, String> cmap2 = new ConcurrentHashMap<>();
        cmap2.put("Microsoft", "Azure");
        cmap2.put("Amazon", "AWS");
        cmap2.put("Google", "Chrome");
        cmap2.put("Oracle", "Weblogic");

        /**
         * Implement reduce() to get the key values of a map and to transform it to required format and aggregate the results with a delimiter
         */
        String reduceResult = cmap2.reduce(2, (k, v) -> k + "-" + v, (r1, r2) -> r1 + "," + r2);
        System.out.println("ReduceResult = " + reduceResult);


        /**
         * Implement reduceKeys() to aggregate the keys of a map with a delimiter
         */
        String reduceKeysResult = cmap2.reduceKeys(2, (r1, r2) -> r1 + "," + r2);
        System.out.println("reduceKeysResult = " + reduceKeysResult);


    }
}
