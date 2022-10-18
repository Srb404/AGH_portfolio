package me.srb.randomdrop_testing;

import java.util.ArrayList;
import java.util.HashMap;

public class ListOfChances {
    private int startOfChance = 1;
    public final int chance_min = 1;
    public final int chance_max = 10000;


    public HashMap<Integer, ArrayList<String>> mining_events = new HashMap<>();

    public ListOfChances() {
        addEvent(1, "Naładowany Creeper", 0.10, 3);
        addEvent(2, "Gniazdo Rybików", 0.20, 2);
        addEvent(3, "Nietoperek Robercik", 0.20, 2);
        addEvent(300, "Hełm górnika", 0.05, 3);
        addEvent(301, "Napierśnik górnika", 0.05, 3);
        addEvent(302, "Spodnie górnika", 0.05, 3);
        addEvent(303, "Buty górnika", 0.05, 3);
        addEvent(304, "Kilof górnika", 0.05, 3);
        addEvent(305, "Łopata górnika", 0.05, 3);
        addEvent(306, "Siekiera górnika", 0.05, 3);
        addEvent(500, "Zupka Halucynka", 0.01, 4);
        addEvent(1000, "Cząstki expa", 1.00, 1);
    }
    private void addEvent(Integer id, String name, Double chance, int rareity) {
        mining_events.put(id, new ArrayList<>());
        mining_events.get(id).add(name);
        mining_events.get(id).add(chance + "");
        mining_events.get(id).add(startOfChance + "");
        mining_events.get(id).add(0.01 * chance * chance_max + startOfChance + "");
        mining_events.get(id).add(rareity + "");

        startOfChance+=0.01 * chance * chance_max;
    }
}
