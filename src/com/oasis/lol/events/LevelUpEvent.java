package com.oasis.lol.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Enderqura on 28/07/2017 at 20:24.
 */

public class LevelUpEvent extends Event {

    private int newlevel, oldlevel;
    private Player player;


    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public LevelUpEvent(int newlevel, int oldlevel, Player player) {

        this.oldlevel = oldlevel;
        this.newlevel = newlevel;
        this.player = player;

    }

    public int getNewlevel() {
        return newlevel;
    }

    public int getOldlevel() {
        return oldlevel;
    }

    public Player getPlayer() {
        return player;
    }
}

