package com.oasis.lol.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Enderqura on 28/07/2017 at 20:24.
 */
public class ExpGainEvent extends Event {

    private int amount;
    private Player player;


    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public ExpGainEvent(int amount, Player player){

        this.amount = amount;
        this.player = player;

    }

    public Player getPlayer() {
        return player;
    }

    public int getAmount() {
        return amount;
    }
}
