package com.lavamen.lavalib;

import com.lavamen.lavalib.commands.BaseCommandExecutor;
import com.lavamen.lavalib.commands.CommandBuilder;
import com.lavamen.lavalib.example.commands.ExampleCommandExecutor;
import com.lavamen.lavalib.example.commands.ExampleHologramCommand;
import com.lavamen.lavalib.example.commands.ExampleMultipageGUICommand;
import com.lavamen.lavalib.example.commands.ExampleSinglepageGUICommand;
import com.lavamen.lavalib.gui.GUIManager;
import com.lavamen.lavalib.holograms.HoloManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lavalib extends JavaPlugin {

    private static Lavalib instance;

    public static Lavalib getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        GUIManager.register(this);
        HoloManager.register(this);
        CommandBuilder builder = new CommandBuilder();
        getCommand("lavalib").setExecutor(new BaseCommandExecutor(builder
                .withName("lavalib")
                .withCommand(new ExampleHologramCommand("example hologram"))
                .withCommand(new ExampleSinglepageGUICommand("example gui singlepage"))
                .withCommand(new ExampleMultipageGUICommand("example gui multipage"))
                .withCommand(new ExampleCommandExecutor("example example",
                        "<example1> <example2/example3>",
                        false))
                .build()));
    }

    @Override
    public void onDisable() {

    }
}
