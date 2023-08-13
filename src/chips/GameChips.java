package chips;

public class GameChips {
    public static int gameChips(String[][] chipsLocation, int blackChips, int whiteChips) {
        //System.out.println("Game Chips");

//        int blackChips = 0;
//        int whiteChips = 0;

        //String[][] chipsLocation = new String[3][10];

        for (int i = 0; i < chipsLocation.length; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i == 0) && (j % 2 == 0)) {
                    chipsLocation[i][j] = "B";
                } else if (i == 0) {
                    chipsLocation[i][j] = "W";
                } else {
                    chipsLocation[i][j] = "0";
                }
            }
        }

        for (int i = 0; i < chipsLocation.length; i++) {
            System.out.println("");
            for (int j = 0; j < 10; j++) {
                System.out.print(chipsLocation[i][j] + "    ");
                if (chipsLocation[i][j] == "B") {
                    blackChips = blackChips + 1;
                } else if (chipsLocation[i][j] == "W") {
                    whiteChips = whiteChips + 1;
                }
            }
        }

        System.out.println("");
        System.out.println("Black Chips: " + blackChips);
        System.out.println("White Chips: " + whiteChips);

        if (blackChips == 0) {
            System.out.println("Black Wins");
            return 0;
        }
        else if (whiteChips == 0) {
            System.out.println("White Wins");
            return 0;
        }
        else {
            System.out.println("Game Continues");
        }
        return blackChips;
    }
}
