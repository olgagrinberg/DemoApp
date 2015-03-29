package com.instrument.benchmark;

import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

/**
 * Created by olgagrinberg on 14-01-29.
 */
public class MemoryUtil {
    private static final int MegaBytes = 10241024;

    public static void main(String args[]) {

        long freeMemory = Runtime.getRuntime().freeMemory()/MegaBytes;
        long totalMemory = Runtime.getRuntime().totalMemory()/MegaBytes;
        long maxMemory = Runtime.getRuntime().maxMemory()/MegaBytes;

        System.out.println("JVM freeMemory: " + freeMemory);
        System.out.println("JVM totalMemory also equals to initial heap size of JVM : "
                + totalMemory);
        System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "
                + maxMemory);

        ArrayList objects = new ArrayList();

        for (int i = 0; i < 10000000; i++) {
            objects.add(("" + 10 * 2710));
        }

        System.out.println("Dump Stack");
        dumpStack();

        freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
        totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;

        System.out.println("Used Memory in JVM: " + (maxMemory - freeMemory));
        System.out.println("freeMemory in JVM: " + freeMemory);
        System.out.println("totalMemory in JVM shows current size of java heap : "
                + totalMemory);
        System.out.println("maxMemory in JVM: " + maxMemory);

    }

    public static synchronized void  dumpStack() {

        ThreadMXBean theadMxBean = ManagementFactory.getThreadMXBean();

        for (ThreadInfo ti : theadMxBean.dumpAllThreads(true, true)) {
            System.out.print(ti.toString());
            StackTraceElement ste[] = ti.getStackTrace();
            if (ste.length > 8)
            {
                System.out.println("[Extra stack]");
                for (int element = 8; element < ste.length; element++)
                {
                    System.out.println("\tat " + ste[element]);
                    for (MonitorInfo mi : ti.getLockedMonitors()) {
                        if (mi.getLockedStackDepth() == element) {
                            System.out.append("\t-  locked " + mi);
                            System.out.append('\n');
                        }
                    }
                }
                System.out.println("[Extra stack]");
            }
        }
    }

}
