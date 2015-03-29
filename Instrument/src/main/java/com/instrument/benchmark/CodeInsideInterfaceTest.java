package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-29.
 */
public class CodeInsideInterfaceTest implements CodeInsideInterface {
    public static void main(String[] args) {
        CodeInsideInterfaceTest test = new CodeInsideInterfaceTest();
        test.calculateIQ.run(new CodeInsideInterface.Result() {
            public void result(Object answer) {
                System.out.println("Your IQ is " + answer);
            }
            public void exception(Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
