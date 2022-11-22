package com.lavamen.lavalib.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import javax.annotation.Nonnull;

public interface GUIListener {

    /**
     * This should be called when player closes inventory, but it's not working properly,
     * maybe cuz of some core issues
     */
    void onClosing(@Nonnull InventoryCloseEvent e);

    void onInteraction(@Nonnull InventoryClickEvent e);
}
