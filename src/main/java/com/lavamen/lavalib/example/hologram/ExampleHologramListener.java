package com.lavamen.lavalib.example.hologram;

import com.lavamen.lavalib.holograms.HoloListener;
import com.lavamen.lavalib.holograms.HoloLine;
import com.lavamen.lavalib.holograms.Hologram;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ExampleHologramListener implements HoloListener {
    @Override
    public void onInteraction(PlayerInteractEntityEvent e, Hologram hologram, HoloLine holoLine) {
        e.getPlayer().sendMessage("Clicked hologram");
    }
}
