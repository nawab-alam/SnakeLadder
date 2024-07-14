package com.nawab.snakeLadder.boardEntity;

public class Snake extends BoardEntity{
    public Snake(Integer startPos, Integer endPos) {
        super(startPos, endPos);
    }

    @Override
    public boolean is_snake() {
        return true;
    }
}
