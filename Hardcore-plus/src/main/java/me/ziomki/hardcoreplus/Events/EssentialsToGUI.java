package me.ziomki.hardcoreplus.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EssentialsToGUI implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia")) return;
        e.setCancelled(true);
    }
}
