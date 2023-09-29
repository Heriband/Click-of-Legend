package com.mygdx.game.playable;

public abstract class Entity {

    public double hp;
    public String name;

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
