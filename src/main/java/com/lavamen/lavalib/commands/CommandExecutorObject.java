package com.lavamen.lavalib.commands;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommandExecutorObject extends CommandObject {

    protected final String arguments;
    protected final String description;
    protected final String permission;
    protected final boolean hideRestricted;

    public CommandExecutorObject(String path,
                                 String arguments,
                                 String description,
                                 String permission,
                                 boolean hideRestricted) {
        super(path);
        this.arguments = arguments;
        this.description = description;
        this.permission = permission;
        this.hideRestricted = hideRestricted;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public List<String> prepareHelp(CommandSender sender) {
        if(hideRestricted && !sender.hasPermission(permission))
            return Collections.emptyList();
        StringBuilder builder = new StringBuilder();
        builder.append("/").append(path);
        if(arguments != null)
            builder.append(" ").append(arguments);
        if(description != null)
            builder.append(" - ").append(description);
        return Collections.singletonList(builder.toString());
    }

    public String getArguments() {
        return arguments;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isHideRestricted() {
        return hideRestricted;
    }

    @Override
    public String toString() {
        return "CommandExecutorObject{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", usage='" + arguments + '\'' +
                ", description='" + description + '\'' +
                ", permission='" + permission + '\'' +
                ", hideRestricted=" + hideRestricted +
                '}';
    }
}
