package cells;

import main.Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CellRules {

    public static void cellRules(String input_row_now, String input_column_now, String input_row_new, String input_column_new,
                                 String[][] chipsLocation, String[][] grid, String player, String next_player) throws IOException {

        System.out.println("Cell Rules");

        System.out.println(player + " " + next_player);

        int input_row_now_int = Integer.parseInt(input_row_now);
        int input_column_now_int = Integer.parseInt(input_column_now);
        int input_row_new_int = Integer.parseInt(input_row_new);
        int input_column_new_int = Integer.parseInt(input_column_new);

        //made one row from matrix chipsLocation
        String[] chipsLocationOne = new String[30];
        int k = 0;
        for (int i = 0; i < chipsLocation.length; i++) {
            for (int j = 0; j < 10; j++) {
                chipsLocationOne[k] = chipsLocation[i][j];
                k++;
            }
        }
        //System.out.println("chipsLocationOne: " + Arrays.toString(chipsLocationOne));

        if(Objects.equals(chipsLocationOne[input_column_new_int * 10 + input_row_new_int], "0")) {
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
        Main.game(chipsLocation, grid, player, next_player);

    }

}
