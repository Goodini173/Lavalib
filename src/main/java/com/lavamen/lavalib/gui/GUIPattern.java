package com.lavamen.lavalib.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GUIPattern {

    /**
     * Compiles GUIPattern from given data. Amount of pattern elements must be divisible by 9.
     * @param content Collection of gui lines, each line containing 9 elements delimited by ' '
     * @return Pattern compiled from given content
     */
    public static GUIPattern compile(Collection<String> content) {
        return compile(String.join(" ", content));
    }

    /**
     * Compiles GUIPattern from given data. Amount of pattern elements must be divisible by 9.
     * @param content Array of gui lines, each line containing elements delimited by ' '
     * @return Pattern compiled from given content
     */
    public static GUIPattern compile(String[] content) {
        return compile(String.join(" ", content));
    }

    public static GUIPattern compile(String data) {
        Map<Integer, String> pointers = new HashMap<>();
        String[] elements = data.split(" ");
        if(elements.length % 9 != 0)
            throw new IllegalArgumentException("Cannot compile gui pattern with " + elements.length + " elements");
        for (int i = 0; i < elements.length; i++) {
            pointers.put(i, elements[i]);
        }
        return new GUIPattern(pointers);
    }

    private final Map<Integer, String> pointers;

    private GUIPattern(Map<Integer, String> pointers) {
        assert pointers.size() % 9 == 0;
        this.pointers = pointers;
    }

    public Inventory fill(String name, Map<String, ItemStack> fillers) {
        Inventory inventory = Bukkit.createInventory(null, pointers.size(), name);
        for (Map.Entry<Integer, String> entry : pointers.entrySet()) {
            if(!fillers.containsKey(entry.getValue())) continue;
            inventory.setItem(entry.getKey(), fillers.get(entry.getValue()).clone());
        }
        return inventory;
    }

    public ItemStack[] generateContent(Map<String, ItemStack> fillers) {
        ItemStack[] content = new ItemStack[pointers.size()];
        for (Map.Entry<Integer, String> entry : pointers.entrySet()) {
            if(!fillers.containsKey(entry.getValue())) continue;
            content[entry.getKey()] = fillers.get(entry.getValue()).clone();
        }
        return content;
    }
}
