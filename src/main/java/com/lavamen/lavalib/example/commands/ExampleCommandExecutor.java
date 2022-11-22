package com.lavamen.lavalib.example.commands;

import com.lavamen.lavalib.Lavalib;
import com.lavamen.lavalib.commands.CommandExecutorObject;
import com.lavamen.lavalib.gui.GUIManager;
import com.lavamen.lavalib.gui.singlepage.DefaultGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleCommandExecutor extends CommandExecutorObject {

    public ExampleCommandExecutor(String path,
                                  String arguments,
                                  boolean hideRestricted) {
        super(path, arguments, "Description", "lavalib.command.example", hideRestricted);
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage("Executed!");
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return Bukkit.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toList());
    }
}
