package com.lavamen.lavalib.example.commands;

import com.lavamen.lavalib.Lavalib;
import com.lavamen.lavalib.commands.CommandExecutorObject;
import com.lavamen.lavalib.example.gui.ExampleSinglepageGUIListener;
import com.lavamen.lavalib.gui.GUI;
import com.lavamen.lavalib.gui.GUIManager;
import com.lavamen.lavalib.gui.singlepage.DefaultGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ExampleSinglepageGUICommand extends CommandExecutorObject {

    private final GUI gui;

    public ExampleSinglepageGUICommand(String path) {
        super(path, "", "Opens singlepage gui", "lavalib.command.example", true);
        gui = new DefaultGUI(GUIManager.get(Lavalib.getInstance()),
                Bukkit.createInventory(null, 27),
                new ExampleSinglepageGUIListener());
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
