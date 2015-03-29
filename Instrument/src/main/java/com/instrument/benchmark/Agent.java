package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-28.
 */
import java.lang.instrument.Instrumentation;

public class Agent {
    private static volatile Instrumentation globalInstrumentation;
    public static void premain(String agentArgs, Instrumentation inst) {

        // registers the transformer
        inst.addTransformer(new SleepingThreadClassFileTransformer());
        globalInstrumentation = inst;
    }

    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object)
    {
        if (globalInstrumentation == null)
        {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }
}
