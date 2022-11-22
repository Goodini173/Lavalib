package com.lavamen.lavalib.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface HelpProvider {

    List<String> help(CommandNode node, CommandSender sender);
}
