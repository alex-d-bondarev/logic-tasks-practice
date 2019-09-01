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

public class Java1DArray2Test {
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
        String testInput = "4\n" +
                "5 3\n" +
                "0 0 0 0 0\n" +
                "6 5\n" +
                "0 0 0 1 1 1\n" +
                "6 3\n" +
                "0 0 1 1 1 0\n" +
                "3 1\n" +
                "0 1 0";

        String expectedOutput = "YES\n" +
                "YES\n" +
                "NO\n" +
                "NO\n";

        provideInput(testInput);
        Java1DArray2.main(new String[0]);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void complexTest() {
        String testInput = FileHelper.stringFromFile("src/main/resources/1d_array_tests/testInput.txt");
        String expectedOutput = FileHelper.stringFromFile("src/main/resources/1d_array_tests/testOutput.txt");

        provideInput(testInput);
        Java1DArray2.main(new String[0]);

        assertEquals(expectedOutput, getOutput());
    }


    // Test specific canWin() method

    @Test
    public void simpleGameOfZerosWins(){
        int leap = 0;
        int[] game = {0, 0, 0, 0, 0};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void expectedToStuckWithoutJumps(){
        int leap = 0;
        int[] game = {0, 0, 0, 0, 1};

        Assert.assertFalse(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void expectedToStuckWithJumpTooSmall(){
        int leap = 1;
        int[] game = {0, 0, 0, 0, 1};

        Assert.assertFalse(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void expectedToJumpOver(){
        int leap = 2;
        int[] game = {0, 0, 0, 0, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void expectedToJumpOverBiggerObstacle(){
        int leap = 5;
        int[] game = {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void jumpMultipleTimes(){
        int leap = 3;
        int[] game = {0, 1, 1, 0, 1, 1, 0, 1, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void jumpWithWalkingBackwards(){
        int leap = 4;
        int[] game = {0, 1, 1, 0, 0, 1, 1, 0, 1, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void winAComplicatedOne(){
        int leap = 5;
        int[] game = {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void willStuckInTheEnd(){
        int leap = 5;
        int[] game = {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1};

        Assert.assertFalse(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void changeStrategyToWin(){
        int leap = 5;
        int[] game = {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }

    @Test
    public void needComplexStrategy(){
        int leap = 7;
        int[] game = {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0,
                0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }
}
