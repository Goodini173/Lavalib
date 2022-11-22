package com.lavamen.lavalib.holograms;

import org.bukkit.util.Vector;

public class HoloLineDesign {

    private final Vector offset;
    private final String content;
    private HoloListener interactionListener;

    public HoloLineDesign(Vector offset, String content) {
        this(offset, null, content);
    }

    public HoloLineDesign(Vector offset,
                          HoloListener interactionListener,
                          String content) {
        this.offset = offset;
        this.interactionListener = interactionListener;
        this.content = content;
    }

    public Vector getOffset() {
        return offset.clone();
    }

    public HoloListener getInteractionListener() {
        return interactionListener;
    }

    public String getContent() {
        return content;
    }

    public void setInteractionListener(HoloListener interactionListener) {
        this.interactionListener = interactionListener;
    }
}
