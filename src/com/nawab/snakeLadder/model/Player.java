package com.nawab.snakeLadder.model;

public class Player {
    private String name;
    private Integer pos;

    public Player(String name) {
        this.name = name;
        this.pos =0;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}
