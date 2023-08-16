package usableFunctions;

public class FillNewArrayOfChips {

    public static String[] fillArray(int DifOfCells, int input_row_now_int, int input_column_now_int,
                                     String[] gridOneOnlyOneRow, String[] newArrayOfChips, int control, int controlLength) {

        for (int i = 0; i < gridOneOnlyOneRow.length; i++) {
            if (i > input_column_now_int * 10 + input_row_now_int) {
                if(controlLength >= Math.abs(DifOfCells) + 2){
                    break;
                } else {
                    System.out.println("i: " + i);
                    System.out.println("gridOneOnlyOneRow[i]: " + gridOneOnlyOneRow[i]);
                    //add the chips to the new array
                    newArrayOfChips[i - control] = gridOneOnlyOneRow[i];
                    controlLength++;
                }
            } else {
                control++;
            }
        }

        return newArrayOfChips;
    }
}
