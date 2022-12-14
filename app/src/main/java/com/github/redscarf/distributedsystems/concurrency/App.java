/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.redscarf.distributedsystems.concurrency;

import com.github.redscarf.distributedsystems.concurrency.models.Counter;
import com.github.redscarf.distributedsystems.concurrency.threads.CounterProcessorThread;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) {
        Lock locker = new ReentrantLock();
        Counter counter = new Counter(locker);
        
        Thread firstThread = Executors
                .defaultThreadFactory()
                .newThread(new CounterProcessorThread(counter));
        
        Thread secondThread = Executors
                .defaultThreadFactory()
                .newThread(new CounterProcessorThread(counter));
        
        firstThread.start();
        secondThread.start(); 
    }
}
