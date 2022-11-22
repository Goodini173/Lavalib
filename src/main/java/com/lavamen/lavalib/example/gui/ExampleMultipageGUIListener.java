package com.lavamen.lavalib.example.gui;

import com.lavamen.lavalib.gui.multipage.GUIPage;
import com.lavamen.lavalib.gui.multipage.GUIPageListener;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ExampleMultipageGUIListener implements GUIPageListener {

    @Override
    public void onOpening(Player p, GUIPage page) {
        p.sendMessage("Opened " + page.getPage() + " page");
    }

    @Override
    public void onInteraction(InventoryClickEvent e, GUIPage page) {
        e.getWhoClicked().sendMessage("Clicked " + page.getPage() + " page");
    }

    @Override
    public void onClosing(InventoryCloseEvent e, GUIPage page) {
        e.getPlayer().sendMessage("Closed " + page.getPage() + " page");
    }
}
