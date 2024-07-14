package com.nawab.snakeLadder.mode;

import com.nawab.snakeLadder.service.SnakeLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMode extends Mode{

    public ConsoleMode(SnakeLadderService snakeLadderService) {
        super(snakeLadderService);
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        //Read snakes details
        int numberOfSnakes = Integer.parseInt(scanner.nextLine());
        List<String> snakesStr = new ArrayList<>();
        for(int i=0;i<numberOfSnakes;i++){
            snakesStr.add(scanner.nextLine());
        }
        //Read Ladder details.
        int numberOfLadders = Integer.parseInt(scanner.nextLine());
        List<String> ladderStr = new ArrayList<>();
        for(int i=0;i<numberOfLadders;i++){
            ladderStr.add(scanner.nextLine());
        }

        //Read players details.
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        List<String> playerStr = new ArrayList<>();
        for(int i=0;i<numberOfPlayers;i++){
            playerStr.add(scanner.nextLine());
        }

        //Set Snakes details
        super.setSnakesList(snakesStr);

        //set Ladder details
        super.setLadderList(ladderStr);

        //set player details
        super.setPlayers(playerStr);
        scanner.close();
    }
}
