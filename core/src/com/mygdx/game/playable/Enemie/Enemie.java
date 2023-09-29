package com.mygdx.game.playable.Enemie;

import com.mygdx.game.playable.Entity;
import jdk.internal.org.jline.utils.Status;

import static java.lang.Math.max;

public abstract class Enemie extends Entity {

    public StatusEnemie status = StatusEnemie.Normal;
    public double lootGold ;

    /*
        Take Damage
        Return True if die False else
     */
    public boolean takeDamage(double dealDamage){
        setHp(max(hp - dealDamage, 0));
        System.out.println("enemie hp left : " + getHp());
        if (hp <= 0) {
            die();
            return true;
        }
        return  false;
    }

    public void die() {
        System.out.println("enemeie die");
        status = StatusEnemie.Dead;
    }


    public void setLootGold(double gold){
        lootGold = gold;
    };
}
