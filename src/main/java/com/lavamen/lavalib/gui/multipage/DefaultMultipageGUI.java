package com.lavamen.lavalib.gui.multipage;

import com.lavamen.lavalib.gui.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import java.util.List;

public class DefaultMultipageGUI implements MultipageGUI {

    protected final GUIManager manager;
    protected final List<GUIPage> pages;

    public DefaultMultipageGUI(GUIManager manager,
                               List<GUIPage> pages) {
        if(pages.isEmpty()) throw new IllegalStateException("Cannot create multipage gui without pages");
        this.manager = manager;
        this.pages = pages;
    }

    @Nonnull
    @Override
    public GUIManager getManager() {
        return manager;
    }

    @Nonnull
    @Override
    public Inventory[] getInventories() {
        return pages.stream().map(GUIPage::getInventory).toArray(Inventory[]::new);
    }

    @Override
    public void open(@Nonnull Player p) {
        p.openInventory(pages.get(0).getInventory());
    }

    @Override
    public void onClosing(@Nonnull InventoryCloseEvent e) {
    }

    @Override
    public void onInteraction(@Nonnull InventoryClickEvent e) {
        e.setCancelled(true);
        if(!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        GUIPage currentPage = getPage(e.getClickedInventory());
        assert currentPage != null;
        if(e.getSlot() == currentPage.getNextSlot())
            pages.get((currentPage.getPage() + 1) % pages.size()).open(p);
        else if(e.getSlot() == currentPage.getPrevSlot())
            pages.get((currentPage.getPage() - 1) % pages.size()).open(p);
        else
            currentPage.onInteraction(e);
    }

    protected GUIPage getPage(Inventory inventory) {
        return pages.stream().filter(page -> page.getInventory().equals(inventory)).findAny().orElse(null);
    }
}
