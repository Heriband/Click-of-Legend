package com.mygdx.game.playable.Champs;

import com.mygdx.game.playable.Enemie.Enemie;
import com.mygdx.game.playable.Player;

public abstract class Champ {
    public double DPS ;
    public Lane lane ;
    public int level ;
    public double requiredGoldToLevelUp = 100;
    public void  setDPS(double dps){
        DPS = dps;
        System.out.println(DPS);
    }

    public double getDPS() {
        return DPS;
    }

    public Lane getLane() {
        return lane;
    }

    public int getLevel() {
        return level;
    }
    public void tryLevelUp(Player player){
        if (player.getGold() >= requiredGoldToLevelUp){
            player.spentGold(requiredGoldToLevelUp);
            levelUp();
        }
        else
            System.out.println("Not Enough gold");
    }
    public void levelUp(){
        System.out.println("levelUP");
        level++;
        setDPS(getDPS() * level);
        System.out.println(getDPS());
    }
}
