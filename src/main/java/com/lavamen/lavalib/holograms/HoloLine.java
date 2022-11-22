package com.lavamen.lavalib.holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.UUID;

public class HoloLine {

    private final Hologram parent;
    private final Vector offset;
    private final HoloListener listener;
    private ArmorStand armorStand;
    private String text;

    public HoloLine(HoloLineDesign design, Hologram parent) {
        this(design.getContent(), design.getOffset(), design.getInteractionListener(), parent);
    }

    public HoloLine(String text, Vector offset, HoloListener listener, Hologram parent) {
        this.text = text;
        this.parent = parent;
        this.offset = offset;
        this.listener = listener;
        this.armorStand = null;
    }

    public void spawn(Location location) {
        if(isAlive()) return;
        location = new Location(location.getWorld(),
                location.getX() + offset.getX(),
                location.getY() + offset.getY(),
                location.getZ() + offset.getZ());
        this.armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        this.armorStand.setAI(false);
        this.armorStand.setGravity(false);
        this.armorStand.setVisible(false);
        this.armorStand.setInvulnerable(true);
        this.armorStand.setCustomNameVisible(true);
        this.armorStand.setCustomName(text);
    }

    public void despawn() {
        if(!isAlive()) return;
        this.armorStand.remove();
        this.armorStand = null;
    }

    public void setText() {
        this.text = text;
        if(isAlive())
            armorStand.setCustomName(text);
    }

    public String getText() {
        return text;
    }

    public @Nullable Location getLocation() {
        return armorStand == null ? null : armorStand.getLocation();
    }

    public @Nullable UUID getId() {
        return isAlive() ? armorStand.getUniqueId() : null;
    }

    public boolean isAlive() {
        return armorStand != null;
    }

    public void interact(PlayerInteractEntityEvent e) {
        assert listener != null;
        listener.onInteraction(e, parent, this);
    }
}
