package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BrokenLegEvent implements Listener {

    DifficultiesList adding = new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na złamanie nogi podczas upadku.");

    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                float fallDistance = e.getEntity().getFallDistance();
                if (fallDistance < 5) {
                    if (ChanceCalculator.getChance(adding.getChance()))
                        boneBreak((Player) e.getEntity(), 40*20, 2);
                }
                else if (fallDistance < 8 && fallDistance > 5) {
                    if (ChanceCalculator.getChance(adding.getChance() * 4))
                        boneBreak((Player) e.getEntity(), 80*20, 2);
                }
                else if (fallDistance < 12 && fallDistance > 8) {
                    if (ChanceCalculator.getChance(adding.getChance() * 8))
                        boneBreak((Player) e.getEntity(), 160*20, 2);
                }
                else {
                    if (ChanceCalculator.getChance(adding.getChance() * 16))
                        boneBreak((Player) e.getEntity(), 320*20, 3);
                }
            }
        }
    }

    public void boneBreak(Player p, int dur, int ampl) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, ampl));
        ActionBarMessage.sendActionBarMessage(p, ChatColor.RED + "Zlamales noge");
    }
}
