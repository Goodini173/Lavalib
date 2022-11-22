package com.lavamen.lavalib.holograms;

import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class HoloDesign {

    /**
     * @param content Content of this design
     * @param yOffset Distance between lines, distance between first and N-th lines is N * yOffset
     * @return Flat hologram design
     */
    public static HoloDesign flatDesign(String[] content, double yOffset) {
        return dimensionalDesign(content, new Vector(0, yOffset, 0));
    }

    public static HoloDesign dimensionalDesign(String[] content, Vector linesOffset) {
        return customDesign(content, i -> linesOffset.clone().multiply(i));
    }

    public static HoloDesign customDesign(String[] content, Function<Integer, Vector> function) {
        List<HoloLineDesign> lines = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            Vector offset = function.apply(i);
            lines.add(new HoloLineDesign(offset, content[i]));
        }
        return new HoloDesign(lines);
    }

    private final List<HoloLineDesign> lines;

    public HoloDesign(List<HoloLineDesign> lines) {
        this.lines = lines;
    }

    public List<HoloLineDesign> getLines() {
        return lines;
    }

    public HoloLineDesign getLine(int i) {
        return lines.size() > i ? lines.get(i) : null;
    }

    public HoloDesign mash(HoloDesign other) {
        List<HoloLineDesign> newLines = new ArrayList<>();
        newLines.addAll(lines);
        newLines.addAll(other.lines);
        return new HoloDesign(newLines);
    }
}
