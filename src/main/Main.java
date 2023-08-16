package main;

import chips.MovesChips;
import gridRules.Grid;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int blackChips = 0;
        int whiteChips = 0;

        String player = "W";
        String next_player = "B";
        String[][] chipsLocation = new String[3][10];
        String[][] grid = new String[3][10];

        System.out.println("Game Start");

        //select game mode
        SelectGameMode.selectGameMode();

        //run Grid class
        Grid.grid(grid);
        System.out.println("");

        //run GameChips class
        chips.GameChips.gameChips(chipsLocation, blackChips, whiteChips);

        //run game
        game(chipsLocation, grid, player, next_player);

    }

    public static void game(String[][] chipsLocation, String[][] grid, String player,
                            String next_player) throws IOException {

        //swap players
        String temp = player;
        player = next_player;
        next_player = temp;

        int stickRoll = 0;

        //run StickMechanics class
        stickRoll = skicks.StickMechanics.rollStick(stickRoll);
        System.out.println("");

        //run MoveChips class with integer checkThePlayerTurn
        MovesChips.moveChips(chipsLocation, grid, stickRoll, player, next_player);

    }

}
