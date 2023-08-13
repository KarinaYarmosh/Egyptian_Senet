package cells;

public class Grid {
    //graphical representation of the grid of cells 10x3
    //        cell size 10*10, 1000*300 grid
    public static void grid(String[][] grid) {

        //consol grid matrix representation of the grid of cells 10x3
        //        cell size 10*10, 1000*300 grid
        //String[][] grid = new String[3][10];

        //fill grid with 0s
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < 10; j++) {

                if ((i == 1) && (j == 5)) {
                    grid[i][j] = "SZ";
                }

                else if (i == 2) {
                    if (j == 5) {
                        grid[i][j] = "SZNM";
                    } else if (j == 6) {
                        grid[i][j] = "DIE";
                    } else if (j == 7) {
                        grid[i][j] = "III";
                    } else if (j == 8) {
                        grid[i][j] = "II";
                    } else if (j == 9) {
                        grid[i][j] = "I";
                    } else {
                        grid[i][j] = "0";
                    }
                }

                else {
                    grid[i][j] = "0";
                }
            }
        }

        //print grid
        for (int i = 0; i < grid.length; i++) {
            System.out.println("");
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + "    ");
            }
        }



    }
}
