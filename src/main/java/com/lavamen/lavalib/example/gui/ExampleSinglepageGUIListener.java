package com.lavamen.lavalib.example.gui;

import com.lavamen.lavalib.gui.GUIListener;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class ExampleSinglepageGUIListener implements GUIListener {

    @Override
    public void onClosing(@Nonnull InventoryCloseEvent e) {
        e.getPlayer().sendMessage("You closed custom gui");
    }

    @Override
    public void onInteraction(@Nonnull InventoryClickEvent e) {
        e.setCurrentItem(new ItemStack(Material.DIAMOND_BLOCK));
    }
}
