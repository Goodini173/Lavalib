package com.lavamen.lavalib.example.commands;

import com.lavamen.lavalib.Lavalib;
import com.lavamen.lavalib.commands.CommandExecutorObject;
import com.lavamen.lavalib.example.gui.ExampleMultipageGUIListener;
import com.lavamen.lavalib.gui.GUI;
import com.lavamen.lavalib.gui.GUIManager;
import com.lavamen.lavalib.gui.GUIPattern;
import com.lavamen.lavalib.gui.multipage.MultipageGUIBuilder;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleMultipageGUICommand extends CommandExecutorObject {

    private final GUI gui;

    public ExampleMultipageGUICommand(String path) {
        super(path, "", "", "lavalib.command.example", true);
        Map<String, ItemStack> buttons = new HashMap<>();
        buttons.put("p", new ItemStack(Material.REDSTONE_BLOCK));
        buttons.put("n", new ItemStack(Material.EMERALD_BLOCK));
        gui = new MultipageGUIBuilder()
                .withManager(GUIManager.get(Lavalib.getInstance()))
                .withPage(GUIPattern.compile(
                                new String[]{"p o o o o o o o n",
                                        "o o o o o o o o o",
                                        "o o o o o o o o o"}).fill("GUI", buttons),
                        0,
                        8,
                        new ExampleMultipageGUIListener())
                .withPage(GUIPattern.compile(
                                new String[]{"p o o o o o o o n",
                                        "o o o o o o o o o",
                                        "o o o o o o o o o"}).fill("GUI", buttons),
                        0,
                        8,
                        new ExampleMultipageGUIListener())
                .withPage(GUIPattern.compile(
                                new String[]{"p o o o o o o o n",
                                        "o o o o o o o o o",
                                        "o o o o o o o o o"}).fill("GUI", buttons),
                        0,
                        8,
                        new ExampleMultipageGUIListener())
                .build();
        gui.register();
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(!(sender instanceof Player)) return false;
        gui.open((Player) sender);
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
