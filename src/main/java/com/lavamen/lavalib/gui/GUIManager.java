package com.lavamen.lavalib.gui;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class GUIManager implements Listener {

    private final static Map<Plugin, GUIManager> managers = new HashMap<>();

    public static GUIManager register(@Nonnull Plugin plugin) {
        assert !managers.containsKey(plugin);
        managers.put(plugin, new GUIManager(plugin));
        return managers.get(plugin);
    }

    public static GUIManager get(@Nonnull Plugin plugin) {
        if(!managers.containsKey(plugin))
            register(plugin);
        return managers.get(plugin);
    }

    private final Map<Inventory, GUIListener> guiMap = new HashMap<>();

    public GUIManager(@Nonnull Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void register(Inventory inventory, GUIListener gui) {
        guiMap.put(inventory, gui);
    }

    public void unregister(Inventory inventory) {
        guiMap.remove(inventory);
    }

    @EventHandler
    public void onInteraction(InventoryClickEvent e) {
        GUIListener gui = guiMap.get(e.getClickedInventory());
        if(gui == null) return;
        gui.onInteraction(e);
    }

    @EventHandler
    public void onClosing(InventoryCloseEvent e) {
        GUIListener gui = guiMap.get(e.getInventory());
        if(gui == null) return;
        gui.onClosing(e);
    }
}
