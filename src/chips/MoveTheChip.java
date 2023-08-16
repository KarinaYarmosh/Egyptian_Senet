package chips;

import main.Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class MoveTheChip {

    //move the chip if the chip can move
    public static void moves(String[] chipsLocationOne, int input_row_now_int, int input_column_now_int,
                             int input_row_new_int, int input_column_new_int, String player, String next_player,
                             String[][] chipsLocation, String[][] grid) {

        if (Objects.equals(chipsLocationOne[input_column_new_int * 10 + input_row_new_int], "0")) {
            System.out.println("OK");
            chipsLocationOne[input_column_new_int * 10 + input_row_new_int] = player;
            chipsLocationOne[input_column_now_int * 10 + input_row_now_int] = "0";
        }

        else if (Objects.equals(chipsLocationOne[input_column_new_int * 10 + input_row_new_int], next_player)) {
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

        //print chipsLocation matrix
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

        //new player
        try {
            Main.game(chipsLocation, grid, player, next_player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
