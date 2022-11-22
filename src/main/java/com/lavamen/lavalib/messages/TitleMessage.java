package com.lavamen.lavalib.messages;

import org.bukkit.entity.Player;

public class TitleMessage implements Message{

    private final String title;
    private final String subtitle;
    private final int fadeIn;
    private final int stay;
    private final int fadeOut;

    public TitleMessage(String title,
                        String subtitle,
                        int fadeIn,
                        int stay,
                        int fadeOut) {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    @Override
    public void send(Player p) {
        p.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @Override
    public int getDuration() {
        return fadeIn + stay + fadeOut;
    }
}
