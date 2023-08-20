package cells;

import chips.MoveTheChip;
import chips.MovesChips;
import gridRules.RulesOfGrid;
import skicks.StickMechanics;

import java.io.IOException;
import java.util.Objects;

public class RulesOfTheGame {

    public static void checkState(String[] chipsLocationOne, int input_row_now_int, int input_column_now_int,
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
                    checkFunction(input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int,
                            player, next_player, chipsLocation, grid, checkIfState, stickRoll, gridOneOnlyOneRow,
                            chipsLocationOne);
                }
            }

            else {
                checkFunction(input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int,
                        player, next_player, chipsLocation, grid, checkIfState, stickRoll, gridOneOnlyOneRow,
                        chipsLocationOne);
            }

        }
        else{
            checkFunction(input_row_now_int, input_column_now_int, input_row_new_int, input_column_new_int,
                    player, next_player, chipsLocation, grid, checkIfState, stickRoll, gridOneOnlyOneRow,
                    chipsLocationOne);
        }

    }

    public static void checkFunction(int input_row_now_int, int input_column_now_int,
                                     int input_row_new_int, int input_column_new_int, String player,
                                     String next_player, String[][] chipsLocation, String[][] grid,
                                     int checkIfState, int stickRoll, String[] gridOneOnlyOneRow,
                                     String[] chipsLocationOne) throws IOException {

        System.out.println("OK, you can move");
        //need to check the grid
        if(input_row_new_int == 6 && input_column_new_int == 2){
                System.out.println("It's a lake");
                checkFunction(player, next_player, chipsLocation, grid, stickRoll);
        }

        else {
            boolean check = false;

            check = RulesOfGrid.Rules(input_row_now_int, input_column_now_int, input_row_new_int,
                    input_column_new_int, player, next_player, gridOneOnlyOneRow, grid, stickRoll, chipsLocation);

            System.out.println("check: " + check);

            if (check) {
                System.out.println("Try again");
                MovesChips.move(chipsLocation, grid, player, stickRoll, next_player);
            } else {
                MoveTheChip.moves(chipsLocationOne, input_row_now_int, input_column_now_int, input_row_new_int,
                        input_column_new_int, player, next_player, chipsLocation, grid);
            }
        }

    }


    public static void checkFunction(String player, String next_player, String[][] chipsLocation,
                                     String[][] grid, int stickRoll) throws IOException{

        for(int i = 1; i >= 0; i--){
            String temp = "0";

            if(i == 1) {
                for (int j = 0; j < 5; j++) {
                    if (Objects.equals(chipsLocation[i][j + 5], temp)) {
                        chipsLocation[i][j + 5] = player;
                        int stickRollTemp = StickMechanics.rollStick(stickRoll);
                        //change players!!!!!!
                        MovesChips.moveChips(chipsLocation, grid, stickRollTemp, next_player, player);
                    }
                }
            }

            else {
                for (int j = 9; j > 4; j--) {
                    if (Objects.equals(chipsLocation[i][j], temp)) {
                        chipsLocation[i][j] = player;
                        int stickRollTemp = StickMechanics.rollStick(stickRoll);
                        //change players!!!!!!
                        MovesChips.moveChips(chipsLocation, grid, stickRollTemp, next_player, player);
                    }
                }
            }


        }
    }

}
