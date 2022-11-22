package com.lavamen.lavalib.messages;

import org.bukkit.entity.Player;

public class ActionbarMessage implements Message{

    private final String message;

    public ActionbarMessage(String message) {
        this.message = message;
    }

    @Override
    public void send(Player p) {
        p.sendActionBar(message);
    }

    @Override
    public int getDuration() {
        // TODO: find actionbar duration
        return 0;
    }
}
