package com.nawab.snakeLadder.boardEntity;

public abstract class BoardEntity {
    private Integer startPos;
    private Integer endPos;

    public BoardEntity(Integer startPos, Integer endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Integer getEndPos() {
        return this.endPos;
    }

    public Integer getStartPos() {
        return this.startPos;
    }

    public abstract boolean is_snake();
}
