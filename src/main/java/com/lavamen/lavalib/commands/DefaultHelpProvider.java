package com.lavamen.lavalib.commands;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultHelpProvider implements HelpProvider{
    @Override
    public List<String> help(CommandNode node, CommandSender sender) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, CommandObject> entry : node.executors.entrySet()) {
            CommandObject commandObject = entry.getValue();
            result.addAll(commandObject.prepareHelp(sender));
        }
        return result;
    }
}
