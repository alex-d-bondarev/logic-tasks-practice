package org.parctice.app.hackerrank.java.data_structures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Java1DArray2 {

    public enum MOVE{FORWARD, BACKWARD, JUMP};

    public static boolean canWin(int leap, int[] game) {
        return firstStrategyWinsTheGame(leap, game) || anotherStrategyWinsTheGame(leap, game);
    }

    private static boolean firstStrategyWinsTheGame(int leap, int[] game){
        boolean canWin = false;
        boolean notStuck = true;
        int currentPosition = 0;
        int movedBackwardsTimes = 0;
        MOVE nextMove = MOVE.FORWARD;

        while (notStuck && !canWin){
            switch (nextMove){
                case FORWARD:
                    if(canWalkForward(currentPosition, game)){
                        currentPosition++;
                    } else {
                        nextMove = MOVE.JUMP;
                    }
                    break;
                case JUMP:
                    if(canJump(currentPosition, leap, game)){
                        currentPosition += leap;
                        movedBackwardsTimes = 0;
                        nextMove = MOVE.FORWARD;
                    } else {
                        nextMove = MOVE.BACKWARD;
                    }
                    break;
                case BACKWARD:
                    if(canWalkBackward(currentPosition, game)){
                        currentPosition--;
                        movedBackwardsTimes++;
                        if(movedBackwardsTimes < leap) {
                            nextMove = MOVE.JUMP;
                        } else {
                            notStuck = false;
                        }
                    } else {
                        notStuck = false;
                    }
            }

            canWin = wonTheGame(currentPosition, leap, game);
        }

        return canWin;
    }

    private static boolean anotherStrategyWinsTheGame(int leap, int[] game){
        boolean canWin = false;
        boolean notStuck = true;
        int currentPosition = 0;
        int movedBackwardsTimes = 0;
        MOVE nextMove = MOVE.FORWARD;

        while (notStuck && !canWin){
            switch (nextMove){
                case JUMP:
                    if(canJump(currentPosition, leap, game)){
                        currentPosition += leap;
                        movedBackwardsTimes = 0;
                        nextMove = MOVE.JUMP;
                    } else {
                        nextMove = MOVE.FORWARD;
                    }
                    break;
                case FORWARD:
                    if(canWalkForward(currentPosition, game)){
                        currentPosition++;
                        nextMove = MOVE.JUMP;
                    } else {
                        nextMove = MOVE.BACKWARD;
                    }
                    break;
                case BACKWARD:
                    if(canWalkBackward(currentPosition, game)){
                        currentPosition--;
                        movedBackwardsTimes++;
                        if(movedBackwardsTimes < leap) {
                            nextMove = MOVE.FORWARD;
                        } else {
                            notStuck = false;
                        }
                    } else {
                        notStuck = false;
                    }
            }
            canWin = wonTheGame(currentPosition, leap, game);
        }

        return canWin;
    }

    private static boolean wonTheGame(int position, int leap,  int[] game){
        return position >= game.length -1 || position + leap >= game.length;
    }

    private static boolean canWalkForward(int position, int[] game){
        return game[position+1]==0;
    }

    private static boolean canWalkBackward(int position, int[] game){
        return position > 0 && game[position-1]==0;
    }

    private static boolean canJump(int position, int leap, int[] game){
        return game[position+leap]==0 && leap > 0;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }



    @Test
    public void needComplexStrategy(){
        int leap = 7;
        int[] game = {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0,
                0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1};

        Assert.assertTrue(Java1DArray2.canWin(leap, game));
    }
}
