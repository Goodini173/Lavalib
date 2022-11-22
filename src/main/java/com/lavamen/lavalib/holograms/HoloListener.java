package com.lavamen.lavalib.holograms;

import org.bukkit.event.player.PlayerInteractEntityEvent;

public interface HoloListener {

    void onInteraction(PlayerInteractEntityEvent e,
                       Hologram hologram,
                       HoloLine holoLine);
}
