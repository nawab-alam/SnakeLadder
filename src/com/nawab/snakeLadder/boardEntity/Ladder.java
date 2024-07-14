package com.nawab.snakeLadder.boardEntity;

public class Ladder extends BoardEntity{
    public Ladder(Integer startPos, Integer endPos) {
        super(startPos, endPos);
    }

    @Override
    public boolean is_snake() {
        return false;
    }
}
