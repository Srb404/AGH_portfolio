package me.srb.randomdrop_testing.Listeners;

import me.srb.randomdrop_testing.ListOfChances;
import me.srb.randomdrop_testing.ListOfEvents;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MiningSurprise implements Listener {



    @EventHandler
    public void stoneSurprise(BlockBreakEvent e) {
        if (
                !(e.getBlock().getType() == Material.STONE) &&
                !(e.getBlock().getType() == Material.DEEPSLATE) &&
                !(e.getBlock().getType() == Material.TUFF)
        ) return;
        ListOfChances list_chances = new ListOfChances();
        int min, max, randomNum = ThreadLocalRandom.current().nextInt(list_chances.chance_min, list_chances.chance_max + 1);
        ArrayList<String> event;
        for (Integer key : list_chances.mining_events.keySet()) {
            event = list_chances.mining_events.get(key);
            min = (int) Math.floor(Double.parseDouble(event.get(2)));
            max = (int) Math.floor(Double.parseDouble(event.get(3)));
            if (randomNum >= min && randomNum < max) {
                ListOfEvents.doStuff(key, event.get(0), event.get(1), e);
                return;
            }
        }
    }
}
