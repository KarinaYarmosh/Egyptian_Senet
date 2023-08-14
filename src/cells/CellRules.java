package cells;

import chips.MovesChips;
import main.Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CellRules {

    public static void cellRules(String input_row_now, String input_column_now, String input_row_new, String input_column_new,
                                 String[][] chipsLocation, String[][] grid, String player, String next_player, int stickRoll) throws IOException {

        System.out.println("Cell Rules");

        System.out.println(player + " " + next_player);

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
        checkIfState = checkTheAmountOfChips(gridOneOnlyOneRow, input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int, player, next_player);

        System.out.println("checkIfState: " + checkIfState);

        if(checkIfState >= 3) {
            System.out.println("You can't move, because next player have 3 or more chips in a row");
            Main.game(chipsLocation, grid, player, next_player);
        }
        else if (checkIfState == 2){
            System.out.println("You can't move if your coorinates are the same as the coordinates of the next player's chip, when he has 2 chips near each another");
            if(Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int], next_player)){
                if(Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int+1], next_player) || Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int-1], next_player)){
                    System.out.println("You can't move");
                    Main.game(chipsLocation, grid, player, next_player);
                }
                else{
                    System.out.println("OK, you can move");
                    moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int, player, next_player, chipsLocation, grid);
                }
            } else {
                System.out.println("OK, you can move");
                moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int, player, next_player, chipsLocation, grid);
            }
        }
        else{
            moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int, player, next_player, chipsLocation, grid);
        }

    }

    private static int checkTheAmountOfChips(String[] gridOneOnlyOneRow, int input_row_now_int,
                                             int input_column_now_int, int input_row_new_int,
                                             int input_column_new_int, String player, String next_player) {

        int max_state = 0;
        int numberOFAnoutherPlayerChips = 0;

        int unknown = 0;
        if(input_column_new_int == 1) {
            unknown = 9 - input_row_new_int;
        } else {
            unknown = input_row_new_int;
        }
        int DifOfCells = input_column_now_int * 10 + input_row_now_int - (input_column_new_int * 10 + unknown) + 1;

        System.out.println("liczba: " + Math.abs(DifOfCells));

        //
        int control = 0;
        String[] newArrayOfChips = new String[Math.abs(DifOfCells)];
        for (int i = 0; i < gridOneOnlyOneRow.length; i++) {
            if (i > input_column_now_int * 10 + input_row_now_int && i <= input_column_new_int * 10 + unknown) {
                System.out.println("i: " + i);
                System.out.println("gridOneOnlyOneRow[i]: " + gridOneOnlyOneRow[i]);
                //add the chips to the new array
                newArrayOfChips[i - control] = gridOneOnlyOneRow[i];
            } else {
                control++;
            }
        }
        System.out.println("newArrayOfChips: " + Arrays.toString(newArrayOfChips));

        for (int i = 0; i < newArrayOfChips.length; i++) {
            if (Objects.equals(newArrayOfChips[i], next_player)) {
                numberOFAnoutherPlayerChips++;
                if(numberOFAnoutherPlayerChips >= 3){
                    return numberOFAnoutherPlayerChips;
                }
            } else {
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

    public static void moves(String[] chipsLocationOne, int input_row_now_int, int input_column_now_int,
                             int input_row_new_int, int input_column_new_int, String player, String next_player,
                             String[][] chipsLocation, String[][] grid) {
        if (Objects.equals(chipsLocationOne[input_column_new_int * 10 + input_row_new_int], "0")) {
            System.out.println("OK");
            chipsLocationOne[input_column_new_int * 10 + input_row_new_int] = player;
            chipsLocationOne[input_column_now_int * 10 + input_row_now_int] = "0";
        } else if (Objects.equals(chipsLocationOne[input_column_new_int * 10 + input_row_new_int], next_player)) {
            System.out.println("OK");
            chipsLocationOne[input_column_new_int * 10 + input_row_new_int] = player;
            chipsLocationOne[input_column_now_int * 10 + input_row_now_int] = next_player;
        }

        //made matrix 3 rows 10 colums from chipsLocationOne
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                chipsLocation[i][j] = chipsLocationOne[i * 10 + j];
            }
        }

        System.out.println("");
        System.out.println(Arrays.deepToString(chipsLocation));

        //print grid
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 10; j++) {
                System.out.print(chipsLocation[i][j] + "    ");
            }
        }

        System.out.println("");
        System.out.println("Next Player");
        System.out.println("");
        try {
            Main.game(chipsLocation, grid, player, next_player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
