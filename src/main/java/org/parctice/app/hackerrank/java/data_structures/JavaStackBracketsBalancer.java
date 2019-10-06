package org.parctice.app.hackerrank.java.data_structures;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class JavaStackBracketsBalancer {

    private static final List<Character> openingBrackets = Arrays.asList('{', '[', '(');
    private static final Map<Character, Character> bracketPairs = new HashMap<Character, Character>(){{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};

    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String inputLine = sc.next();
            System.out.println(bracketsAreBalanced(inputLine));
        }

        sc.close();
    }

    public static boolean bracketsAreBalanced(String line){
        boolean balanced = true;
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < line.length() && balanced; i++) {
            char nextChar = line.charAt(i);

            if(openingBrackets.contains(nextChar)){
                charStack.push(nextChar);
            } else if (!charStack.isEmpty() && charStack.peek() == bracketPairs.get(nextChar)){
                charStack.pop();
            } else {
                balanced = false;
            }
        }

        return charStack.isEmpty() && balanced;
    }

    @Test
    public void simpleBalancedBrackets(){
        String input = "()";
        Assert.assertTrue(bracketsAreBalanced(input));
    }

    @Test
    public void allBalancedBrackets(){
        String input = "{[()]}";
        Assert.assertTrue(bracketsAreBalanced(input));
    }

    @Test
    public void balancedBracketsWithDuplicates(){
        String input = "{[(()[[]]())]}";
        Assert.assertTrue(bracketsAreBalanced(input));
    }

    @Test
    public void oneCharCannotBeBalanced(){
        String input = "(";
        Assert.assertFalse(bracketsAreBalanced(input));
    }

    @Test
    public void simpleUnbalancedBrackets(){
        String input = "{}(";
        Assert.assertFalse(bracketsAreBalanced(input));
    }

    @Test
    public void allBracketsAreBalancedExceptForLast(){
        String input = "{[()]}}";
        Assert.assertFalse(bracketsAreBalanced(input));
    }
}
