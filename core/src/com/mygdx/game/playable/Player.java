package com.mygdx.game.playable;

import com.mygdx.game.playable.Champs.BotChamp.Caitlyn;
import com.mygdx.game.playable.Champs.BotChamp.Jhin;
import com.mygdx.game.playable.Champs.Champ;
import com.mygdx.game.playable.Enemie.Enemie;
import com.mygdx.game.playable.Enemie.Minions.Var;
import com.mygdx.game.playable.Enemie.StatusEnemie;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Player {
    public double clickDamage = 10;
    public int kill = Var.kill ;
    public double gold = Var.gold;
    public double DpsIdleAll = 0; // par sec

    List<Champ> botChampsOwn = new ArrayList<>();
    public double getDpsIdleAll() {
        return DpsIdleAll;
    }

    public Player(){
        botChampsOwn.add(new Caitlyn());
        botChampsOwn.add(new Jhin());

        setDpsFromChamps();
    }

    public void setDpsFromChamps(){
        DpsIdleAll = 0;
        botChampsOwn.forEach(champ -> DpsIdleAll += champ.DPS);
    }

    public void setGold(double gold) {
        this.gold = gold;
    }
    public void updatePlayer(){
        setDpsFromChamps();
    }
    public void dealIdleDamage(Enemie enemie){
        enemie.takeDamage(getDpsIdleAll());
        if (enemie.status == StatusEnemie.Dead)
            increaseKill();
    }

    public List<Champ> getBotChampsOwn() {
        return botChampsOwn;
    }

    public void clickEnemie(Enemie enemie){
        System.out.println("click");
        boolean statusClick = enemie.takeDamage(clickDamage);
        if (statusClick)
            increaseKill();
    }

    public void increaseKill(){
        kill++;
    }

    public void earnGold(Enemie enemie){
        gold += enemie.lootGold;
    }

    public double getClickDamage() {
        return clickDamage;
    }

    public int getKill() {
        return kill;
    }

    public double getGold() {
        return gold;
    }
    public void spentGold(double spentGold){
        setGold(max(0,gold -= spentGold));
    }
}
