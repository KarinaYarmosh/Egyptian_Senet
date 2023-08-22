package gridRules;

import chips.MovesChips;

import java.io.IOException;
import java.util.Objects;

public class RulesOfGrid {

     public static boolean Rules(int input_row_now_int, int input_column_now_int, int input_row_new_int,
                                 int input_column_new_int, String player, String next_player,
                                 String[] gridOneOnlyOneRow, String[][] grid, int stickRoll,
                                 String[][] chipsLocation) throws IOException {

          //grid coordinates: row - 1, column - 5
          System.out.println("YOUR CELL: " + chipsLocation[input_column_new_int][input_row_new_int]);

          if(input_column_new_int == 1 && input_row_new_int == 5){
          System.out.println("YOUR NEW COORDINATES");
               if(Objects.equals(chipsLocation[input_column_new_int][input_row_new_int - 1], next_player)){
                    System.out.println("You can't move, because next player is sitting on the grid");
                    return true;
               }
          }

          else if(input_column_new_int == 2 && input_row_new_int == 5){
               if(Objects.equals(chipsLocation[input_column_new_int][input_row_new_int], next_player)){
                    System.out.println("You can't move, because next player is sitting on the grid");
                    return true;
               }
          }

          else if((input_column_new_int == 2 && input_row_new_int == 9) ||
                  (input_column_new_int == 2 && input_row_new_int == 8) ||
                  (input_column_new_int == 2 && input_row_new_int == 7)){
               System.out.println("Coordinates need to check");
               if(Objects.equals(chipsLocation[input_column_now_int][input_row_now_int], player) &&
                       (input_column_now_int == 2 && input_row_now_int == 5)){
                    if(Objects.equals(chipsLocation[input_column_new_int][input_row_new_int], next_player)){
                         System.out.println("You can't move, because you are not sitting on the right grid");
                         return true;
                    }
               }
               else{
                    System.out.println("You can't move, because you are not sitting on the right grid");
                    return true;
               }
          }

          return false;
     }
}
