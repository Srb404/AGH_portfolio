package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class EpicLightningTarget implements Listener {

    DifficultiesList adding = new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.");

    @EventHandler
    public void onLightning(LightningStrikeEvent e) {
        if (e.getCause() == LightningStrikeEvent.Cause.CUSTOM) return;
        if (ChanceCalculator.getChance(adding.getChance())) {
            World w = e.getWorld();
            e.setCancelled(true);
            Player randomPlayer = Bukkit.getOnlinePlayers().stream().findAny().get(); //czy na pewno daje randomowego playera?
            w.strikeLightning(Bukkit.getPlayer(randomPlayer.getUniqueId()).getLocation());
        }
    }
}
