package com.lavamen.lavalib.messages;

import org.bukkit.entity.Player;

public interface Message {

    void send(Player p);

    /**
     * @return Duration of this message
     */
    int getDuration();
}
