package com.lavamen.lavalib.gui.multipage;

import com.lavamen.lavalib.gui.GUIManager;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class MultipageGUIBuilder {

    private final List<GUIPage> states = new ArrayList<>();
    private GUIManager manager;

    public MultipageGUIBuilder withManager(GUIManager manager) {
        this.manager = manager;
        return this;
    }

    public MultipageGUIBuilder withPage(Inventory inv, int prevSlot, int nextSlot) {
        return withPage(inv, prevSlot, nextSlot, null);
    }

    public MultipageGUIBuilder withPage(Inventory inv, int prevSlot, int nextSlot, GUIPageListener listener) {
        return withPage(new MultipageGUIPage(manager, inv, prevSlot, nextSlot, states.size(), listener));
    }

    public MultipageGUIBuilder withPage(GUIPage page) {
        states.add(page);
        return this;
    }

    public DefaultMultipageGUI build() {
        if(states.isEmpty()) throw new IllegalStateException("Cannot build gui with no pages");
        if(manager == null) throw new IllegalStateException("Cannot build gui with no manager");
        return new DefaultMultipageGUI(manager, states);
    }
}
