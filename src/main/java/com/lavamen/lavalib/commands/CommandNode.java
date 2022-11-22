package com.lavamen.lavalib.commands;

import org.bukkit.command.CommandSender;

import java.util.*;

public class CommandNode extends CommandObject {

    protected final Map<String, CommandObject> executors;
    protected final HelpProvider helpProvider;

    public CommandNode(String path, Map<String, CommandObject> executors, HelpProvider helpProvider) {
        super(path);
        this.executors = executors;
        this.helpProvider = helpProvider;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            if(executors.containsKey(null))
                return executors.get(null).execute(sender, args);
            else if(executors.containsKey("help")) {
                executors.get("help").execute(sender, args);
            }
            else {
                help(sender);
                return true;
            }
        }
        String command = args[0];
        if(!executors.containsKey(command)) {
            if(!command.equalsIgnoreCase("help"))
                return false;
            help(sender);
            return true;
        }
        String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
        return executors.get(command).execute(sender, newArgs);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        List<String> result = new ArrayList<>();
        if(args.length <= 1)
            result.addAll(executors.keySet());
        else
            if(executors.containsKey(args[0]))
                result.addAll(executors.get(args[0]).tabComplete(sender,
                        Arrays.copyOfRange(args, 1, args.length)));
        result.remove(null);
        return result;
    }

    @Override
    public List<String> prepareHelp(CommandSender sender) {
        return helpProvider.help(this, sender);
    }

    public Map<String, CommandObject> getExecutors() {
        return Collections.unmodifiableMap(executors);
    }

    public CommandObject getExecutor(String name) {
        return executors.get(name);
    }

    public void register(CommandObject CommandObject) {
        executors.put(CommandObject.getName(), CommandObject);
    }

    @Override
    public String toString() {
        return "CommandNode{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", executors=" + executors +
                '}';
    }
}
