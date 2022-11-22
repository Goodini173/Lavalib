package com.lavamen.lavalib.messages;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

public class TextMessage implements Message{

    private final String text;

    public TextMessage(String text) {
        this.text = text;
    }


    @Override
    public void send(Player p) {
        p.sendMessage(text);
    }

    @Override
    public int getDuration() {
        return 0;
    }
}
