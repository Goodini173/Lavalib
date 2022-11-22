package com.lavamen.lavalib.gui.singlepage;

import com.lavamen.lavalib.gui.GUI;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;

public interface SinglepageGUI extends GUI {

    @Nonnull
    Inventory getInventory();

    @Override
    default void register()  {
        getManager().register(getInventory(), this);
    }

    @Override
    default void unregister() {
        getManager().unregister(getInventory());
    }
}
