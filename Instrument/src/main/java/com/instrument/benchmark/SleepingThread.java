package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-28.
 */
public class SleepingThread {
    public void randomSleep() throws InterruptedException {

        // randomly sleeps between 500ms and 1200s

        long randomSleepDuration = (long) (500 + Math.random() * 700);
        System.out.printf("Sleeping for %d ms ..\n", randomSleepDuration);
        Thread.sleep(randomSleepDuration);
    }
}
