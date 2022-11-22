package com.lavamen.lavalib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class BaseCommandExecutor implements CommandExecutor, TabCompleter {

    private final CommandObject command;

    public BaseCommandExecutor(CommandObject command) {
        this.command = command;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return this.command.execute(sender, args);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return this.command.tabComplete(sender, args);
    }
}
