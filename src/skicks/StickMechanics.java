package skicks;

import java.util.Random;

public class StickMechanics {

    //stick mechanics
    public static int rollStick(int stickRoll) {
        for(int i = 0; i < 4; i++){
            //take random a = 0 or 1
            Random random = new Random();
            int a = random.nextInt(2);
            stickRoll = stickRoll + a;
        }

        if (stickRoll == 0) {
            stickRoll = 5;
        }

        System.out.println("Stick Roll: " + stickRoll);

        return stickRoll;
    }

}
