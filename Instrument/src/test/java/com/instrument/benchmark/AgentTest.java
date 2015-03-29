package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-28.
 */
import org.junit.Ignore;
import org.junit.Test;
public class AgentTest {
    //@Ignore
    @Test
    public void shouldInstantiateSleepingInstance() throws InterruptedException {

        SleepingThread sleeping = new SleepingThread();
        sleeping.randomSleep();
    }
}
