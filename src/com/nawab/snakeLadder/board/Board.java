package com.nawab.snakeLadder.board;

import com.nawab.snakeLadder.boardEntity.BoardEntity;

import java.util.HashMap;
import java.util.List;

public class Board {
    private HashMap<Integer, BoardEntity>posToEntityMap;

    public Board() {
        posToEntityMap = new HashMap<>();
    }

    public void init(List<BoardEntity> boardEntities) {
        for(BoardEntity entity:boardEntities){
            posToEntityMap.put(entity.getStartPos(), entity);
        }
    }

    public boolean hasSnake(Integer pos){
        return posToEntityMap.get(pos) != null && posToEntityMap.get(pos).is_snake();
    }

    public boolean hasLadder(Integer pos){
        return posToEntityMap.get(pos) != null && !posToEntityMap.get(pos).is_snake();
    }

    public BoardEntity getBoardEntity(Integer pos){
        if(posToEntityMap.get(pos)==null)
            throw new RuntimeException("No board entity exists at this position!");
        return posToEntityMap.get(pos);
    }
}
