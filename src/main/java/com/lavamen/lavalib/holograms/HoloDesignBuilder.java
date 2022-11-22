package com.lavamen.lavalib.holograms;

import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class HoloDesignBuilder {

    private final List<HoloLineDesign> lines = new ArrayList<>();

    public HoloDesignBuilder with(String content, Vector offset) {
        return with(content, offset, null);
    }

    public HoloDesignBuilder with(String content, Vector offset, HoloListener listener) {
        return with(new HoloLineDesign(offset, listener, content));
    }

    public HoloDesignBuilder with(HoloLineDesign line) {
        lines.add(line);
        return this;
    }

    public HoloDesignBuilder with(HoloDesign design) {
        lines.addAll(design.getLines());
        return this;
    }

    public HoloDesign build() {
        return new HoloDesign(lines);
    }
}
