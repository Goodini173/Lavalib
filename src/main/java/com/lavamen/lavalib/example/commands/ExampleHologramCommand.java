package com.lavamen.lavalib.example.commands;

import com.lavamen.lavalib.Lavalib;
import com.lavamen.lavalib.commands.CommandExecutorObject;
import com.lavamen.lavalib.example.hologram.ExampleHologramListener;
import com.lavamen.lavalib.holograms.HoloDesign;
import com.lavamen.lavalib.holograms.HoloDesignBuilder;
import com.lavamen.lavalib.holograms.HoloManager;
import com.lavamen.lavalib.holograms.Hologram;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class ExampleHologramCommand extends CommandExecutorObject {

    private final Hologram hologram;

    public ExampleHologramCommand(String path) {
        super(path, "", "Spawns example hologram", "lavalib.command.example", true);
        hologram = new Hologram(new HoloDesignBuilder()
                .with("first line", new Vector(0, 0, 0), new ExampleHologramListener())
                .with("second line", new Vector(0, -0.3, 0), new ExampleHologramListener())
                .with("third line", new Vector(0, -0.6, 0), new ExampleHologramListener())
                .build(),
                HoloManager.get(Lavalib.getInstance()));
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(!(sender instanceof Player))
            return false;
        if(hologram.isAlive()) hologram.despawn();
        hologram.spawn(((Player) sender).getLocation());
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
