package com.instrument.benchmark;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by olgagrinberg on 14-02-02.
 */
public class DeadlockDetector {
    private static void test1() {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        final Thread thread1 = new Thread() {
            @Override public void run() {
                synchronized (lock1) {
                    System.out.println(getId()+" Thread acquired lock1");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ignore) {System.out.println(getId()+" interrupted");}
                    synchronized (lock2) {
                        System.out.println(this+" Thread acquired lock2");
                    }
                }
            }

        };
        threadHashMap.put(thread1.getId(), thread1);
        thread1.start();

        Thread thread2 = new Thread() {
            @Override public void run() {
                synchronized (lock2) {
                    System.out.println(getId()+" Thread acquired lock2");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ignore) {System.out.println(getId()+" interrupted");}
                    synchronized (lock1) {
                        System.out.println(this+" Thread acquired lock1");
                    }
                }
            }
        };
        threadHashMap.put(thread2.getId(), thread2);
        thread2.start();

        // Wait a little for threads to deadlock.
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ignore) {System.out.println("all interrupted");}
    }

    private static void test2() {
        final ReentrantLock lock1 = new ReentrantLock();
        final ReentrantLock lock2 = new ReentrantLock();

        Thread thread3 = new Thread() {
            @Override public void run() {
                try {
                    //threadHashMap.put()
                    lock1.lock();
                    System.out.println(getId()+" Thread acquired lock1");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ignore) {System.out.println(getId()+" interrupted");}
                    lock2.lock();
                    System.out.println(getId()+" Thread acquired lock2");
                }
                finally {
                    lock2.unlock();
                    lock1.unlock();
                }
            }
        };
        threadHashMap.put(thread3.getId(), thread3);
        thread3.start();

        Thread thread4 = new Thread() {
            @Override public void run() {
                try {
                    lock2.lock();
                    System.out.println(getId()+" Thread acquired lock2");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ignore) {System.out.println(getId()+" interrupted");}
                    lock1.lock();
                    System.out.println(getId()+" Thread acquired lock1");
                }
                finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        };
        threadHashMap.put(thread4.getId(), thread4);
        thread4.start();

        // Wait a little for threads to deadlock.
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ignore) {System.out.println("all interrupted");}

    }

    private static void detectDeadlock() {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadBean.findDeadlockedThreads();
        int deadlockedThreads = threadIds != null? threadIds.length : 0;
        System.out.println("Number of deadlocked threads: " + deadlockedThreads);
        for(long id : threadIds){
            System.out.println(id);

            //if(threadHashMap.get(id)!=null)
                //threadHashMap.get(id).interrupt();

        }
    }

    private static HashMap<Long, Thread> threadHashMap = new HashMap<Long, Thread>();
    public static void main(String args[]) {
        test1();
        test2();
        detectDeadlock();

    }

    }
