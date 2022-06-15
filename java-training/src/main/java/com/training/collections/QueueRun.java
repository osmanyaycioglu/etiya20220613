package com.training.collections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class QueueRun {
    public static void main(String[] args) {
        Queue<String> stringQueueOld = new ArrayBlockingQueue<>(1_000);
        BlockingQueue<String> stringQueue = new ArrayBlockingQueue<>(1_000);
        PriorityQueue<String> strings = new PriorityQueue<>();
        List<Queue<String>> ourPri = new ArrayList<>();
        // DelayQueue<> strings1 = new DelayQueue<>();

        Deque<String> stringDeque = new ArrayDeque<>(1_000);

        stringQueue.add("osman1");
        stringQueue.add("osman2");
        stringQueue.add("osman3");
        String poll = stringQueue.poll();
        System.out.println(poll);
        String polled = null;
        while ((polled = stringQueue.poll()) == null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }

        try {
            String take = stringQueue.take();
            String poll1 = stringQueue.poll(10,
                                            TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
        }


    }
}
