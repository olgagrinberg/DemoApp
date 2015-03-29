package com.instrument.benchmark;

/**
 * Created by olgagrinberg on 14-01-29.
 */
import java.util.ArrayList;
import java.util.List;
import org.github.jamm.MemoryMeter;
import org.junit.Test;

public class MemoryMeterTest {

    private MemoryMeter meter = new MemoryMeter();

    @Test
    public void shouldMeasureMemoryUsage() {

        String st1 = "This is the string #1";
        measure(st1);

        String st2 = "This is the string #2 and it has more chars.";
        measure(st2);

        List aList = new ArrayList(0);
        measure(aList);

        aList.add(st1);
        measure(aList);

        aList.add(st2);
        measure(aList);

    }

    private void measure(Object anObject) {

        System.out.println("-----------------------------------");
        System.out.printf("size: %d bytes\n", meter.measure(anObject));
        System.out.printf("retained size: %d bytes\n", meter.measureDeep(anObject));
        System.out.printf("inner object count: %d\n", meter.countChildren(anObject));
    }
}
