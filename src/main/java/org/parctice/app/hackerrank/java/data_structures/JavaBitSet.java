package org.parctice.app.hackerrank.java.data_structures;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class JavaBitSet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int setSize = sc.nextInt();
        int noOps = sc.nextInt();

        BitSet[] bitSets = new BitSet[]{new BitSet(setSize), new BitSet(setSize)};

        Map<String, BiConsumer<Integer, Integer>> operations = new HashMap<>();
        operations.put("AND", (index1, index2) -> bitSets[index1 - 1].and(bitSets[index2 - 1]));
        operations.put("OR", (index1, index2) ->  bitSets[index1 - 1].or(bitSets[index2 - 1]));
        operations.put("XOR", (index1, index2) -> bitSets[index1 - 1].xor(bitSets[index2 - 1]));
        operations.put("SET", (index1, index2) -> bitSets[index1 - 1].set(index2));
        operations.put("FLIP", (index1, index2) ->bitSets[index1 - 1].flip(index2));

        for (int i = 0; i < noOps; i++) {
            String operation = sc.next();
            int firstInt = sc.nextInt();
            int secondInt = sc.nextInt();
            operations.get(operation).accept(firstInt, secondInt);

            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
