package org.parctice.app.hackerrank.java.data_structures;

import java.util.Scanner;

public class Java1DArray2 {

    public static boolean canWin(int leap, int[] game) {

        CELL_STATE[] gameWithStates = convertToGameWithStates(game);
        boolean won = false;
        boolean notStuck = true;
        boolean lookingForNewState;

        while (!won && notStuck){
            lookingForNewState = true;

            for (int i = game.length - 1; i >= -1 && lookingForNewState; i--) {
                if(i == -1){
                    notStuck = false;
                } else if(gameWithStates[i].equals(CELL_STATE.ACCESSIBLE)){
                    won = wonTheGame(i, leap, gameWithStates);
                    if(!won){
                        gameWithStates = getNewAccessibleStatesFrom(i, leap, gameWithStates);
                    }
                    lookingForNewState = false;
                }
            }
        }

        return won;
    }

    private static CELL_STATE[] getNewAccessibleStatesFrom(int i, int leap, CELL_STATE[] gameWithStates) {
        if(canWalkForward(i, gameWithStates)){
            gameWithStates[i+1] = CELL_STATE.ACCESSIBLE;
        }
        if(canWalkBackward(i, gameWithStates)){
            gameWithStates[i-1] = CELL_STATE.ACCESSIBLE;
        }
        if(canJump(i, leap, gameWithStates)){
            gameWithStates[i+leap] = CELL_STATE.ACCESSIBLE;
        }

        gameWithStates[i] = CELL_STATE.CALCULATED;
        return gameWithStates;
    }

    private static boolean wonTheGame(int position, int leap,  CELL_STATE[] game){
        return position >= game.length -1 || position + leap >= game.length;
    }

    private static boolean canWalkForward(int position, CELL_STATE[] game){
        return game[position+1].equals(CELL_STATE.OPEN);
    }

    private static boolean canWalkBackward(int position, CELL_STATE[] game){
        return position > 0 && game[position-1].equals(CELL_STATE.OPEN);
    }

    private static boolean canJump(int position, int leap, CELL_STATE[] game){
        return game[position+leap].equals(CELL_STATE.OPEN) && leap > 0;
    }


    private static CELL_STATE[] convertToGameWithStates(int[] game) {
        CELL_STATE[] gameWithStates = new CELL_STATE[game.length];

        for (int i = 0; i < game.length; i++) {
            gameWithStates[i] = (game[i] == 1 ? CELL_STATE.BLOCKED : CELL_STATE.OPEN);
        }

        gameWithStates[0] = CELL_STATE.ACCESSIBLE;
        return gameWithStates;
    }

    private enum CELL_STATE{OPEN, BLOCKED, ACCESSIBLE, CALCULATED};


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
}
