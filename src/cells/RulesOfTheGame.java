package cells;

import chips.MoveTheChip;
import chips.MovesChips;

import java.io.IOException;
import java.util.Objects;

public class RulesOfTheGame {

    public static void chechState(String[] chipsLocationOne, int input_row_now_int, int input_column_now_int,
                                  int input_row_new_int, int input_column_new_int, String player, String next_player,
                                  String[][] chipsLocation, String[][] grid, int checkIfState, int stickRoll,
                                  String[] gridOneOnlyOneRow) throws IOException {

        if(checkIfState >= 3) {
            System.out.println("You can't move, because next player have 3 or more chips in a row");
            try {
                MovesChips.move(chipsLocation, grid, player, stickRoll, next_player);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        else if (checkIfState == 2){

            System.out.println("You can't move if your coorinates are the same as the coordinates of the next player's chip, when he has 2 chips near each another");
            if(Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int], next_player)){
                if(Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int+1], next_player)
                        || Objects.equals(gridOneOnlyOneRow[input_column_new_int*10+input_row_new_int-1], next_player)){
                    System.out.println("You can't move");
                    try {
                        MovesChips.move(chipsLocation, grid, player, stickRoll, next_player);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    System.out.println("OK, you can move");
                    MoveTheChip.moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int,
                            input_column_new_int, player, next_player, chipsLocation, grid);
                }
            } else {
                System.out.println("OK, you can move");
                MoveTheChip.moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int,
                        input_column_new_int, player, next_player, chipsLocation, grid);
            }

        }
        else{

            MoveTheChip.moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int,
                    input_column_new_int, player, next_player, chipsLocation, grid);

        }

    }

}
