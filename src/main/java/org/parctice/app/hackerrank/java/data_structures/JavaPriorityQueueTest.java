package org.parctice.app.hackerrank.java.data_structures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.parctice.app.helpers.FileHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JavaPriorityQueueTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    // Test entire solution
    // Credit to https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing

    @Test
    public void simpleTest() {
        String testInput = "12\n" +
                "ENTER John 3.75 50\n" +
                "ENTER Mark 3.8 24\n" +
                "ENTER Shafaet 3.7 35\n" +
                "SERVED\n" +
                "SERVED\n" +
                "ENTER Samiha 3.85 36\n" +
                "SERVED\n" +
                "ENTER Ashley 3.9 42\n" +
                "ENTER Maria 3.6 46\n" +
                "ENTER Anik 3.95 49\n" +
                "ENTER Dan 3.95 50\n" +
                "SERVED";

        String expectedOutput = "Dan\n" +
                "Ashley\n" +
                "Shafaet\n" +
                "Maria\n";

        provideInput(testInput);
        JavaPriorityQueue.main(new String[0]);

        assertEquals(expectedOutput, getOutput());
    }
}
