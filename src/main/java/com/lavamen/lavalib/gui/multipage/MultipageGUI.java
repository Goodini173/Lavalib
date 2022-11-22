package com.lavamen.lavalib.gui.multipage;

import com.lavamen.lavalib.gui.GUI;
import org.bukkit.inventory.Inventory;

public interface MultipageGUI extends GUI {

    Inventory[] getInventories();

    @Override
    default void register() {
        for (Inventory inventory : getInventories()) {
            getManager().register(inventory, this);
        }
    }

    @Override
    default void unregister() {
        for (Inventory inventory : getInventories()) {
            getManager().unregister(inventory);
        }
    }
}
