package com.lavamen.lavalib.holograms;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class Hologram {

    protected final List<HoloLine> lines = new ArrayList<>();
    private final HoloManager manager;
    private final UUID id;
    private HoloDesign design;
    private Location location;
    private boolean alive;

    public Hologram(HoloDesign design, HoloManager manager) {
        this.manager = manager;
        this.design = design;
        this.id = UUID.randomUUID();
        this.location = null;
        this.alive = false;
        manager.register(this);
    }

    public void spawn(Location location) {
        if(alive) return;
        this.location = location;
        for (HoloLineDesign line : design.getLines()) {
            HoloLine holoLine = new HoloLine(line, this);
            lines.add(holoLine);
            holoLine.spawn(location);
            manager.registerLine(holoLine);
        }
        this.alive = true;
    }

    public void despawn() {
        if(!alive) return;
        for (HoloLine line : lines) {
            manager.unregisterLine(line);
            line.despawn();
        }
        this.lines.clear();
        this.location = null;
        this.alive = false;
    }

    public void setDesign(HoloDesign design) {
        setDesign(design, true);
    }

    /**
     * Changes design of this hologram
     * @param design new design
     * @param apply if alive - respawn this hologram with new design
     */
    public void setDesign(HoloDesign design, boolean apply) {
        this.design = design;
        if(isAlive() && apply) {
            Location temp = this.location;
            despawn();
            spawn(temp);
        }
    }

    public HoloManager getManager() {
        return manager;
    }

    public HoloDesign getDesign() {
        return design;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getId() {
        return id;
    }

    public boolean isAlive() {
        return alive;
    }

}
