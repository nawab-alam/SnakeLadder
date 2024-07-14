package com.nawab.snakeLadder.service;

import com.nawab.snakeLadder.board.Board;
import com.nawab.snakeLadder.boardEntity.BoardEntity;
import com.nawab.snakeLadder.model.Dice;
import com.nawab.snakeLadder.model.Player;

import java.util.List;

public class SnakeLadderService {
    private Board board;
    private Dice dice;
    private List<Player> players;

    public SnakeLadderService(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }

    public void initialSetup(List<BoardEntity> entities, List<Player> players){
        this.players = players;
        this.board.init(entities);
    }

    public void play(){
        if(players.isEmpty()){
            throw new RuntimeException("No player is available to play!");
        }
        while (true) {
            for (Player person : players) {
                System.out.println("Player Name: " + person.getName() + " current Pos:" + person.getPosition());
                Integer diceNumber = dice.getRandomNumber();
                System.out.println("Dice number:" + diceNumber);
                Integer curPos = person.getPosition() + diceNumber;
                boolean keepPlaying = true;
                while(keepPlaying) {
                    if (curPos == 100) {
                        System.out.println("Hurray you have won!!!");
                        return;
                    } else if (curPos > 100) {
                        System.out.println("Oops going beyond boundary!");
                        keepPlaying = false;
                        continue;
                    } else {
                        System.out.println("Position after this move: " + curPos);

                        if (board.hasLadder(curPos)) {
                            curPos = board.getBoardEntity(curPos).getEndPos();
                            System.out.println("Hurray! There is ladder, You are now moving to: " + curPos);
                        } else if (board.hasSnake(curPos)) {
                            curPos = board.getBoardEntity(curPos).getEndPos();
                            System.out.println("Oops! Got hit by Snake, You are now moving to: " + curPos);
                        } else {
                            keepPlaying = false;
                        }

                    }
                    person.setPos(curPos);
                }
            }
        }
    }
}
