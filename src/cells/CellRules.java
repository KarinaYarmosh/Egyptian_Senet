package cells;

import usableFunctions.CellsDif;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CellRules {

    public static void cellRules(String input_row_now, String input_column_now, String input_row_new, String input_column_new,
                                 String[][] chipsLocation, String[][] grid, String player,
                                 String next_player, int stickRoll) throws IOException {

        int input_row_now_int = Integer.parseInt(input_row_now);
        int input_column_now_int = Integer.parseInt(input_column_now);
        int input_row_new_int = Integer.parseInt(input_row_new);
        int input_column_new_int = Integer.parseInt(input_column_new);

        //made one row from matrix chipsLocation
        String[] chipsLocationOne = new String[30];
        chipsLocationOne = oneRowFunction(chipsLocationOne, chipsLocation);
        System.out.println("chipsLocationOne: " + Arrays.toString(chipsLocationOne));

        String[][] gridOne = new String[3][10];
        gridOne = matrixRotate(chipsLocation);

        String[] gridOneOnlyOneRow = new String[30];
        gridOneOnlyOneRow = oneRowFunction(gridOneOnlyOneRow, gridOne);
        System.out.println("gridOneOnlyOneRow: " + Arrays.toString(gridOneOnlyOneRow));

        int checkIfState = 0;
        checkIfState = checkTheAmountOfChips(gridOneOnlyOneRow, input_row_now_int, input_column_now_int,
                input_row_new_int, input_column_new_int, player, next_player);

        RulesOfTheGame.checkState(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int,
                input_column_new_int, player, next_player, chipsLocation, grid, checkIfState, stickRoll, gridOneOnlyOneRow);

    }

    private static int checkTheAmountOfChips(String[] gridOneOnlyOneRow, int input_row_now_int,
                                             int input_column_now_int, int input_row_new_int,
                                             int input_column_new_int, String player, String next_player) {

        int numberOFAnoutherPlayerChips = 0;

        int unknown = 0;
        int DifOfCells = 0;

        DifOfCells = CellsDif.DifOfCells(DifOfCells, input_row_now_int, input_column_now_int,
                input_row_new_int, input_column_new_int, unknown);

        System.out.println("liczba: " + Math.abs(DifOfCells));

        //
        int control = 0;
        int controlLength = 0;

        String[] newArrayOfChips = new String[Math.abs(DifOfCells) + 2];

        newArrayOfChips = usableFunctions.FillNewArrayOfChips.fillArray(DifOfCells, input_row_now_int, input_column_now_int,
                gridOneOnlyOneRow, newArrayOfChips, control, controlLength);

        try {
            numberOFAnoutherPlayerChips = HowManyChipsInARow(newArrayOfChips, next_player, numberOFAnoutherPlayerChips);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return numberOFAnoutherPlayerChips;
    }

    public static int HowManyChipsInARow(String[] newArrayOfChips, String next_player,
                                         int numberOFAnoutherPlayerChips) throws IOException {

        int max_state = 0;

        for (int i = 0; i < newArrayOfChips.length; i++) {

            if (Objects.equals(newArrayOfChips[i], next_player)) {
                numberOFAnoutherPlayerChips++;
                if(numberOFAnoutherPlayerChips >= 3){
                    return numberOFAnoutherPlayerChips;
                }
            }

            else {
                max_state = Math.max(max_state, numberOFAnoutherPlayerChips);
                numberOFAnoutherPlayerChips = 0;
            }
        }

        return Math.max(max_state, numberOFAnoutherPlayerChips);
    }

    private static String[] oneRowFunction(String[] chipsLocationOne, String[][] chipsLocation) {
        int k = 0;
        for (int i = 0; i < chipsLocation.length; i++) {
            for (int j = 0; j < 10; j++) {
                chipsLocationOne[k] = chipsLocation[i][j];
                k++;
            }
        }
        return chipsLocationOne;
    }

    public static String[][] matrixRotate(String[][] chipsLocation) {

        chipsLocation[1] = inverseRow(chipsLocation[1]);

        return chipsLocation;

    }

    public static String[] inverseRow(String[] row) {
        String[] temp = new String[row.length];
        for (int i = 0; i < row.length; i++) {
            temp[i] = row[row.length - 1 - i];
        }
        return temp;
    }
}