package com.nawab.snakeLadder.mode;

import com.nawab.snakeLadder.service.SnakeLadderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMode extends Mode{
    private String fileName;
    public FileMode(SnakeLadderService snakeLadderService, String fileName) {
        super(snakeLadderService);
        this.fileName = fileName;
    }

    @Override
    public void getInput() {
//        String fileName = args[0];
//        String fileName = "input.txt";
//        String fileName = Paths.get("").toAbsolutePath().resolve("../input.txt").toString();
        BufferedReader br = null;
        try  {
            br = new BufferedReader(new FileReader(fileName));
            //Read snakes details
            int numberOfSnakes = Integer.parseInt(br.readLine().trim());
            List<String> snakesStr = new ArrayList<>();
            for (int i = 0; i < numberOfSnakes; i++) {
                snakesStr.add(br.readLine());
            }

            //Read ladder details
            int numberOfLadders = Integer.parseInt(br.readLine().trim());
            List<String> ladderStr = new ArrayList<>();
            for (int i = 0; i < numberOfLadders; i++) {
                ladderStr.add(br.readLine());
            }

            //Read Player details
            int numberOfPlayers = Integer.parseInt(br.readLine().trim());
            List<String> playerStr = new ArrayList<>();
            for (int i = 0; i < numberOfPlayers; i++) {
                playerStr.add(br.readLine());
            }

            //Set Snakes details
            super.setSnakesList(snakesStr);

            //set Ladder details
            super.setLadderList(ladderStr);

            //set player details
            super.setPlayers(playerStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
