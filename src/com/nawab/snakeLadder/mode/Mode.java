package com.nawab.snakeLadder.mode;

import com.nawab.snakeLadder.boardEntity.BoardEntity;
import com.nawab.snakeLadder.boardEntity.Ladder;
import com.nawab.snakeLadder.boardEntity.Snake;
import com.nawab.snakeLadder.model.Player;
import com.nawab.snakeLadder.service.SnakeLadderService;

import java.util.ArrayList;
import java.util.List;

public abstract class Mode {
    private List<BoardEntity> entityList;
    private List<Player> players;
    private SnakeLadderService snakeLadderService;

    public Mode(SnakeLadderService snakeLadderService) {
        this.snakeLadderService = snakeLadderService;
        this.entityList = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void initialSetup(){
        if(entityList.isEmpty()){
            throw new RuntimeException("BoardEntity is Empty!");
        }

        if(players.isEmpty()) {
            throw new RuntimeException("Players details is Empty!");
        }
        snakeLadderService.initialSetup(entityList, players);
    }

    public void startGame(){
        snakeLadderService.play();
    }

    public void setSnakesList(List<String> snakesStr) {
        for(String entity:snakesStr){
            String[] coordinates = entity.split(" ");
            if(coordinates.length!=2) {
                throw new RuntimeException("BoardEntity is invalid size");
            }
            Integer startPoint = Integer.parseInt(coordinates[0]);
            Integer endPoint = Integer.parseInt(coordinates[1]);
            this.entityList.add(new Snake(startPoint,endPoint));
        }
    }

    public void setLadderList(List<String> ladderStr) {
        for(String entity:ladderStr){
            String[] coordinates = entity.split(" ");
            if(coordinates.length!=2) {
                throw new RuntimeException("BoardEntity is invalid size");
            }
            Integer startPoint = Integer.parseInt(coordinates[0]);
            Integer endPoint = Integer.parseInt(coordinates[1]);
            this.entityList.add(new Ladder(startPoint,endPoint));
        }
    }

    public void setPlayers(List<String> playersStr) {
        for(String plyrStr:playersStr){
          players.add(new Player(plyrStr));
        }
    }

    public abstract void getInput();
}
