package com.lavamen.lavalib.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class CommandObject {

    protected final String path;
    protected final String name;

    protected CommandObject(String path) {
        this(path, path.contains(" ") ? path.substring(path.lastIndexOf(" ") + 1) : path);
    }

    protected CommandObject(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    protected void help(CommandSender sender) {
        prepareHelp(sender).forEach(sender::sendMessage);
    }

    public abstract boolean execute(CommandSender sender, String[] args);

    public abstract List<String> tabComplete(CommandSender sender, String[] args);

    public abstract List<String> prepareHelp(CommandSender sender);
}
