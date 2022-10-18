package me.ziomki.hardcoreplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifficultiesList {
    private static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static Integer ID = 1;
    private final String shortDesc, longDesc;
    private final Double chance;
    private final Material item;
    private final ChatColor color;

    public DifficultiesList(Double chance, Material item, ChatColor color, String shortDesc, String longDesc) {
        this.chance = chance;
        this.item = item;
        this.color = color;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        addEntry();
    }

    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }

    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chance);
        parameters.add(item);
        parameters.add(color);
        parameters.add(shortDesc);
        parameters.add(longDesc);
        getDifficultiesList().put(ID++, parameters);
    }

    public Double getChance() {
        return chance;
    }
}
