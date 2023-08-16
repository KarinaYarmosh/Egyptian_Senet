package usableFunctions;

public class CellsDif {

    //count the difference of cells between two cells
    public static int DifOfCells(int DifOfCells, int input_row_now_int, int input_column_now_int,
                                 int input_row_new_int, int input_column_new_int, int unknown){

        if ((input_column_new_int == 0 && input_column_now_int == 0) ||
                (input_column_new_int == 1 && input_column_now_int == 0)) {
            if (input_column_new_int == 1) {
                unknown = 9 - input_row_new_int;
            } else {
                unknown = input_row_new_int;
            }
            DifOfCells = input_row_now_int - (input_column_new_int * 10 + unknown);
        }

        else if ((input_column_new_int == 1 && input_column_now_int == 1)
                || (input_column_new_int == 2 && input_column_now_int == 2)){
            DifOfCells = input_column_now_int * 10 + input_row_now_int -
                    (input_column_new_int * 10 + input_row_new_int);
        }

        else if(input_column_new_int == 2 && input_column_now_int == 1){
            DifOfCells = input_row_now_int + input_row_new_int + 1;
        }

        else {
            DifOfCells = 1000;
            System.out.println("More than roll stick");
        }

        System.out.println("DifOfCells: " + Math.abs(DifOfCells));

        return DifOfCells;
    }

}
