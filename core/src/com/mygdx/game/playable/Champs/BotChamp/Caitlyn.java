package com.mygdx.game.playable.Champs.BotChamp;

import com.mygdx.game.playable.Champs.Champ;
import com.mygdx.game.playable.Champs.Lane;
import com.mygdx.game.playable.Enemie.Minions.Var;

public class Caitlyn extends Champ {
    public Caitlyn(){
        setDPS(Var.CaitlynDPS);
        lane = Lane.Bot;
        level = 1;
    }
}
