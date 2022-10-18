package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathEraseItems implements Listener {

    DifficultiesList adding = new DifficultiesList(100.0, Material.CANDLE, ChatColor.DARK_PURPLE, "Bolesna śmierć", "Podczas śmierci połowa przedmiotów znika.");

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        for (int i = 0; i < e.getDrops().size(); i++) {
            if (ChanceCalculator.getChance(50))
                e.getDrops().set(i, new ItemStack(Material.AIR));
        }

    }
}
