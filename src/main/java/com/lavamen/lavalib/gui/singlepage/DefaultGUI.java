package com.lavamen.lavalib.gui.singlepage;

import com.lavamen.lavalib.gui.GUIListener;
import com.lavamen.lavalib.gui.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;

public class DefaultGUI implements SinglepageGUI {

    protected final GUIManager manager;
    protected final Inventory inventory;
    protected final GUIListener listener;

    public DefaultGUI(GUIManager manager, Inventory inventory) {
        this(manager, inventory, null);
    }

    public DefaultGUI(GUIManager manager, Inventory inventory, GUIListener listener) {
        this.manager = manager;
        this.inventory = inventory;
        this.listener = listener;
    }

    @Nonnull
    @Override
    public GUIManager getManager() {
        return manager;
    }

    @Nonnull
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void open(@Nonnull Player p) {
        p.openInventory(inventory);
    }

    @Override
    public void onClosing(@Nonnull InventoryCloseEvent e) {
        if(listener != null)
            listener.onClosing(e);
    }

    @Override
    public void onInteraction(@Nonnull InventoryClickEvent e) {
        if(listener != null)
            listener.onInteraction(e);
        else
            e.setCancelled(true);
    }
}
