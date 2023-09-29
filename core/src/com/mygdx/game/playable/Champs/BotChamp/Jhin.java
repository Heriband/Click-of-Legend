package com.mygdx.game.playable.Champs.BotChamp;

import com.mygdx.game.playable.Champs.Champ;
import com.mygdx.game.playable.Champs.Lane;
import com.mygdx.game.playable.Enemie.Minions.Var;

public class Jhin extends Champ {
    public Jhin(){
        lane = Lane.Bot;
        level = 1;
        setDPS(Var.JhinDPS );

    }
}
