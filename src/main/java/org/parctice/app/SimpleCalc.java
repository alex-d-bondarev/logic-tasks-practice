package org.parctice.app;

import java.text.DecimalFormat;

public class SimpleCalc {

    private static final String INVALID_DATA = "INVALID DATA";

    // Test
    public static void main(String[] args) {
        double firstInput = 15;
        double secondInput = 13.1249;
        codingAssignment(firstInput, secondInput);
    }

    /**
     * @param in1   double, first number from assignment
     * @param in2   double, second number from assignment
     */
    public static void codingAssignment(double in1, double in2){
        if(inputIsCorrect(in1) && inputIsCorrect(in2)){
            executeAddition(in1, in2);
            executeSubtraction(in1, in2);
            executeMultiplication(in1, in2);
            executeDivision(in1, in2);
        } else {
            wrongInput();
        }
    }

    // self-explanatory
    private static void executeAddition(double param1, double param2){
        String result = updateResultsFormat(param1 + param2);
        System.out.println("Addition " + result);
    }

    // self-explanatory
    private static void executeSubtraction(double param1, double param2){
        String result = updateResultsFormat(param1 - param2);
        System.out.println("Subtraction " + result);
    }

    // self-explanatory
    private static void executeMultiplication(double param1, double param2){
        String result = updateResultsFormat(param1 * param2);
        System.out.println("Multiplication " + result);
    }

    // self-explanatory
    private static void executeDivision(double param1, double param2){
        String result = param2 == 0 ? INVALID_DATA :
                updateResultsFormat(param1 / param2);
        System.out.println("Division " + result);
    }

    /**
     * @param input double, param to check
     * @return      boolean, true if input is between 0 and 99, else false
     */
    private static boolean inputIsCorrect(double input){
        return !(input < 0 || input > 99);
    }

    /**
     * @param result double, execution result
     * @return       String, result with maximum 2 places for decimals
     */
    private static String updateResultsFormat(double result){
        DecimalFormat dFormat = new DecimalFormat("#.##");
        return dFormat.format(result);
    }

    /**
     * Print "INVALID DATA" for incorrect input
     */
    private static void wrongInput(){
        System.out.println(INVALID_DATA);
    }
}
