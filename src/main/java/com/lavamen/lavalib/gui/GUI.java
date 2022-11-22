package com.lavamen.lavalib.gui;

import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public interface GUI extends GUIListener {

    @Nonnull
    GUIManager getManager();

    void open(@Nonnull Player p);

    void register();

    void unregister();
}
