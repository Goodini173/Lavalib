package com.lavamen.lavalib.holograms;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HoloManager implements Listener {

    private final static Map<Plugin, HoloManager> managerMap = new HashMap<>();

    public static HoloManager register(@Nonnull Plugin plugin) {
        HoloManager manager = new HoloManager(plugin);
        managerMap.put(plugin, manager);
        return manager;
    }

    public static HoloManager get(@Nonnull Plugin plugin) {
        return managerMap.get(plugin);
    }

    private final Map<UUID, HoloLine> lineMap = new HashMap<>();
    private final Map<UUID, Hologram> hologramMap = new HashMap<>();

    private HoloManager(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public Hologram getHologram(UUID id) {
        return hologramMap.get(id);
    }

    public void register(Hologram hologram) {
        hologramMap.put(hologram.getId(), hologram);
    }

    public void unregister(Hologram hologram) {
        hologramMap.remove(hologram.getId());
    }

    public void registerLine(HoloLine line) {
        lineMap.put(line.getId(), line);
    }

    public void unregisterLine(HoloLine line) {
        lineMap.remove(line.getId());
    }

    @EventHandler
    public void onInteraction(PlayerInteractEntityEvent e) {
        HoloLine line = lineMap.get(e.getRightClicked().getUniqueId());
        if(line == null) return;
        line.interact(e);
    }

    @EventHandler
    public void onWorldUnload(WorldUnloadEvent e) {
        for (Hologram hologram : hologramMap.values()) {
            if(hologram.getLocation().getWorld().equals(e.getWorld())) {
                hologram.despawn();
                unregister(hologram);
            }
        }
    }
}
