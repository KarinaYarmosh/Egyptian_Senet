package chips;

public class GameChips {
    public static int gameChips(String[][] chipsLocation, int blackChips, int whiteChips) {

        //chips location array
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

        //print chips location array
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

//        System.out.println("");
//        System.out.println("Black Chips: " + blackChips);
//        System.out.println("White Chips: " + whiteChips);

        //check if game is over
        usableFunctions.GameOver.endOfGame(blackChips, whiteChips);

        return blackChips;
    }
}
