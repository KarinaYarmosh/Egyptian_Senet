package usableFunctions;

public class GameOver {

    public static void endOfGame(int blackChips, int whiteChips){

        if (blackChips == 0) {
            System.out.println("Black Wins");
            System.exit(0);
        }
        else if (whiteChips == 0) {
            System.out.println("White Wins");
            System.exit(0);
        }
        else {
            System.out.println("Game Continues");
        }
    }
}
