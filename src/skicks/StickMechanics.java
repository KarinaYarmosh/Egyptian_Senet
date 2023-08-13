package skicks;

public class StickMechanics {

    public static int rollStick(int stickRoll) {
        stickRoll = (int) (Math.random() * 4 + 1);
        System.out.println("You rolled a " + stickRoll);
        return stickRoll;
    }

}
