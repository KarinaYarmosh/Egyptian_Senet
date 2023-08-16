package chips;

import usableFunctions.CellsDif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MovesChips {
    public static void moveChips(String[][] chipsLocation, String[][] grid, int stickRoll,
                                 String player, String next_player) throws IOException {

        System.out.println("Move Chips");
        System.out.println("Player: " + player);
        move(chipsLocation, grid, player, stickRoll, next_player);

    }

    public static void move(String[][] chipsLocation, String[][] grid, String player,
                            int stickRoll, String next_player) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input_row_now = "0";
        String input_column_now = "0";
        String input_row_new = "0";
        String input_column_new = "0";

        //user input
        System.out.println("Enter the column of the chip you want to move: ");
        input_column_now = bufferedReader.readLine();

        System.out.println("Enter the row of the chip you want to move: ");
        input_row_now = bufferedReader.readLine();


        System.out.println("Your cell: " + chipsLocation[Integer.parseInt(input_column_now)][Integer.parseInt(input_row_now)]);
        System.out.println("player: " + player);

        if (Objects.equals(chipsLocation[Integer.parseInt(input_column_now)][Integer.parseInt(input_row_now)], player)) {
            System.out.println("Enter the column of the cell you want to move to: ");
            input_column_new = bufferedReader.readLine();
            System.out.println("Enter the row of the cell you want to move to: ");
            input_row_new = bufferedReader.readLine();

            simpleRules(input_row_now, input_column_now, input_row_new, input_column_new, chipsLocation, grid,
                    player, stickRoll, next_player);
        }
        else {
            System.out.println("Try Again");
            move(chipsLocation, grid, player, stickRoll, next_player);
        }

    }

    public static void simpleRules(String input_row_now, String input_column_now, String input_row_new,
                                   String input_column_new, String[][] chipsLocation, String[][] grid,
                                   String player, int stickRoll, String next_player) throws IOException {

        System.out.println("Simple Rules");

        int input_row_now_int = Integer.parseInt(input_row_now);
        int input_column_now_int = Integer.parseInt(input_column_now);
        int input_row_new_int = Integer.parseInt(input_row_new);
        int input_column_new_int = Integer.parseInt(input_column_new);

        int DifOfCells = 0;

        if(input_row_now_int > 9 || input_row_new_int > 9 || input_row_now_int < 0 ||
                input_row_new_int < 0 || input_column_now_int > 2 || input_column_new_int > 2 ||
                input_column_now_int < 0 || input_column_new_int < 0) {
            System.out.println("Try Again, you can't move out of the grid");
            move(chipsLocation, grid, player, stickRoll, next_player);
        }
        else {
            int unknown = 0;
            DifOfCells = CellsDif.DifOfCells(DifOfCells, input_row_now_int, input_column_now_int,
                    input_row_new_int, input_column_new_int, unknown);
        }

        if(Math.abs(DifOfCells) != stickRoll) {
            System.out.println("Try Again, you can't move more or less than the stick roll");
            move(chipsLocation, grid, player, stickRoll, next_player);
        }
        else {
            System.out.println("OK");
            if(Objects.equals(chipsLocation[input_column_new_int][input_row_new_int], player)) {
                System.out.println("Try Again, you can't move to a cell with your own chip on it");
                move(chipsLocation, grid, player, stickRoll, next_player);
            }
            else {
                //check rules
                System.out.println("OK");
                cells.CellRules.cellRules(input_row_now, input_column_now, input_row_new, input_column_new,
                        chipsLocation, grid, player, next_player, stickRoll);
            }
        }
    }

}
