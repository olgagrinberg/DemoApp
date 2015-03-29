package com.instrument.benchmark;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
/**
 * Created by olgagrinberg on 14-01-28.
 */
public class SleepingThreadClassFileTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        byte[] byteCode = classfileBuffer;

        if (className.equals("com/instrument/benchmark/SleepingThread")) {

            try {
                ClassPool cp = ClassPool.getDefault();
                CtClass cc = cp.get("com.instrument.benchmark.SleepingThread");
                CtMethod m = cc.getDeclaredMethod("randomSleep");
                m.addLocalVariable("elapsedTime", CtClass.longType);
                m.insertBefore("elapsedTime = System.currentTimeMillis();");
                m.insertAfter("{elapsedTime = System.currentTimeMillis() - elapsedTime;"
                        + "System.out.println(\"Method Executed in ms: \" + elapsedTime);"
                        + "System.out.println(\"Object of type SleepingThread has size of \" + com.instrument.benchmark.Agent.getObjectSize(this) + \" bytes.\");"
                        +"}");
                byteCode = cc.toBytecode();
                cc.detach();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return byteCode;
    }
}



