package org.parctice.app.hackerrank.java.data_structures;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JavaArrayList {
    public static void main(String[] args) {
        ArrayList<String[]> allLines = new ArrayList<>();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Get all arrays
            int numLines = Integer.parseInt(bReader.readLine());

            for (int n = 0; n < numLines; n++) {
                allLines.add(getSplittedArrayFrom(bReader.readLine()));
            }

            // Parse queries
            int numQueries = Integer.parseInt(bReader.readLine());
            for (int n = 0; n < numQueries; n++) {
                System.out.println(executeQuery(bReader.readLine(), allLines));
            }

        } catch (IOException e) { e.printStackTrace(); }
    }

    private static String executeQuery(String query, ArrayList<String[]> allLines){
        String response = "ERROR!";
        String[] spaceSeparated = query.split(" ");
        int line = Integer.parseInt(spaceSeparated[0]) - 1;
        int position = Integer.parseInt(spaceSeparated[1]) - 1;

        if(line < allLines.size()){
            if(position < allLines.get(line).length){
                response = allLines.get(line)[position];
            }
        }

        return response;
    }

    private static String[] getSplittedArrayFrom(String string){
        String[] spaceSeparated = string.split(" ");

        String[] ints = new String[Integer.parseInt(spaceSeparated[0])];
        if(spaceSeparated.length > 1){
            for (int i = 1; i < spaceSeparated.length; i++) {
                ints[i-1] = spaceSeparated[i];
            }
        }

        return ints;
    }

    private ArrayList<String[]> getTestArrayList(){
        ArrayList<String[]> testArrayList = new ArrayList<>();

        String[] line1 = {"1", "2"};
        String[] line2 = new String[0];
        testArrayList.add(line1);
        testArrayList.add(line2);

        return testArrayList;
    }

    @Test
    public void getValidResponse(){
        String query = "1 2";
        String expectedResponse = "2";
        Assert.assertEquals(expectedResponse, executeQuery(query, getTestArrayList()));
    }

    @Test
    public void getErrorForEmptyList(){
        String query = "2 2";
        String expectedResponse = "ERROR!";
        Assert.assertEquals(expectedResponse, executeQuery(query, getTestArrayList()));
    }

    @Test
    public void getErrorForExtraLine(){
        String query = "3 2";
        String expectedResponse = "ERROR!";
        Assert.assertEquals(expectedResponse, executeQuery(query, getTestArrayList()));
    }

    @Test
    public void getErrorForExtraPosition(){
        String query = "1 3";
        String expectedResponse = "ERROR!";
        Assert.assertEquals(expectedResponse, executeQuery(query, getTestArrayList()));
    }

    @Test
    public void getEmptyArray(){
        String input = "0";
        String[] expected = new String[0];
        String[] actual = getSplittedArrayFrom(input);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getNonEmptyArray(){
        String input = "5 41 77 74 22 44";
        String[] expected = {"41", "77", "74", "22", "44"};
        String[] actual = getSplittedArrayFrom(input);

        Assert.assertArrayEquals(expected, actual);
    }
}
