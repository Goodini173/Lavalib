package com.lavamen.lavalib.gui.multipage;

import com.lavamen.lavalib.gui.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;

public class MultipageGUIPage implements GUIPage {

    private final GUIManager guiManager;
    private final Inventory inventory;
    private final int prevSlot;
    private final int nextSlot;
    private final int page;
    private final GUIPageListener listener;

    public MultipageGUIPage(GUIManager guiManager,
                            Inventory inventory,
                            int prevSlot,
                            int nextSlot,
                            int page,
                            GUIPageListener listener) {
        this.guiManager = guiManager;
        this.inventory = inventory;
        this.prevSlot = prevSlot;
        this.nextSlot = nextSlot;
        this.page = page;
        this.listener = listener;
    }

    @Nonnull
    @Override
    public GUIManager getManager() {
        return guiManager;
    }

    @Override
    public void open(@Nonnull Player p) {
        p.openInventory(inventory);
        if(listener != null)
            listener.onOpening(p, this);
    }

    @Override
    @Nonnull
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public int getPrevSlot() {
        return prevSlot;
    }

    @Override
    public int getNextSlot() {
        return nextSlot;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void onClosing(@Nonnull InventoryCloseEvent e) {
        if(listener != null)
            listener.onClosing(e, this);
    }

    @Override
    public void onInteraction(@Nonnull InventoryClickEvent e) {
        if(listener != null)
            listener.onInteraction(e, this);
        else
            e.setCancelled(true);
    }
}
