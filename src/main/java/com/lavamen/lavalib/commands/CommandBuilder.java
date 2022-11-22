package com.lavamen.lavalib.commands;

import javax.annotation.Nonnull;
import java.util.*;

public class CommandBuilder {

    private String name;
    private List<CommandExecutorObject> commands = new ArrayList<>();
    private HelpProvider helpProvider = new DefaultHelpProvider();

    public CommandBuilder withName(@Nonnull String name) {
        this.name = name;
        return this;
    }

    public CommandBuilder withCommand(@Nonnull CommandExecutorObject command) {
        commands.add(command);
        return this;
    }

    public CommandBuilder withHelpProvider(@Nonnull HelpProvider helpProvider) {
        this.helpProvider = helpProvider;
        return this;
    }

    public CommandNode build() {
        if(name == null) throw new IllegalStateException("Cannot build command without a name");
        return build(new String[0]);
    }

    private CommandNode build(String[] path) {
        Map<String, CommandObject> commandsMap = new HashMap<>();
        CommandNode node = new CommandNode(name + " " + String.join(" ", path),
                commandsMap, helpProvider);
        for (CommandExecutorObject command : commands) {
            String[] commandPath = command.getPath().split(" ");
            if(!isSamePath(path, commandPath)) continue;
            if(commandPath.length == path.length) {
                commandsMap.put(null, command);
                continue;
            }
            String commandName = commandPath[path.length];
            String[] newPath = Arrays.copyOf(path, path.length + 1);
            newPath[path.length] = commandName;
            commandsMap.put(commandName, build(newPath));
        }
        return node;
    }

    /**
     * Checks whether command path is original path/it's child or not
     * @param origPath original path
     * @param commandPath command path
     */
    private boolean isSamePath(String[] origPath, String[] commandPath) {
        if(origPath.length > commandPath.length) return false;
        for (int i = 0; i < origPath.length; i++) {
            if(!Objects.equals(origPath[i], commandPath[i])) return false;
        }
        return true;
    }
}
