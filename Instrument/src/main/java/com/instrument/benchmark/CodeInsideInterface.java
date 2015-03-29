package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-29.
 */
public interface CodeInsideInterface {
    public interface Method {
        public void run(Result callback);
    }
    public interface Result {
        public void result(Object answer);
        public void exception(Exception problem);
    }
    Method calculateIQ = new Method() {
        // I always write my data members as final if possible, this catches a
        // lot of bugs at compile time
        private final java.io.BufferedReader stdin = new java.io.BufferedReader(
                new java.io.InputStreamReader(System.in));
        public void run(Result callback) {
            int iq = 100;
            try {
                System.out.print("Do you know Java (y/n)? ");
                if ("y".equals(stdin.readLine())) iq += 20;
                System.out.print("Do you know QuickBasic (y/n)? ");
                if ("y".equals(stdin.readLine())) iq += 20;
                System.out.print("Do you use the Basic GOTO statement (y/n)? ");
                if ("y".equals(stdin.readLine())) iq -= 30;
                System.out.print("Do you frequently use Java reflection (y/n)? ");
                if ("y".equals(stdin.readLine())) iq -= 50;
                callback.result(new Integer(iq));
            } catch(java.io.IOException ex) {
                callback.exception(ex);
            }
        }
    };

    public enum Suit {
        DIAMONDS (1, "Diamonds"),
        CLUBS    (2, "Clubs"   ),
        HEARTS   (3, "Hearts"  ),
        SPADES   (4, "Spades"  );

        private final int value;
        private final String text;
        Suit(int value, String text) {
            this.value = value;
            this.text = text;
        }
        public int value() {return value;}
        public String text() {return text;}
    }

}
