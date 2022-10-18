package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VeryFastMonsters implements Listener {

    DifficultiesList adding = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    @EventHandler
    public void onAttack(EntityTargetEvent e) {
        if (!(e.getEntity() instanceof Monster entity)) return;
        PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*20, 2);
        entity.addPotionEffect(drug);
    }
}
