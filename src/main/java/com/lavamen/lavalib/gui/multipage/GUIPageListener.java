package com.lavamen.lavalib.gui.multipage;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public interface GUIPageListener {

    void onOpening(Player p, GUIPage page);

    /**
     * This method is called when someone interacts with given gui page.
     * This method is NOT called when someone clicks 'page change' slots
     */
    void onInteraction(InventoryClickEvent e, GUIPage page);

    void onClosing(InventoryCloseEvent e, GUIPage page);
}
