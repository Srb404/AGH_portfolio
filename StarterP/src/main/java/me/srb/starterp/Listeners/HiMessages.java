package me.srb.starterp.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.ThreadLocalRandom;

public class HiMessages implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        Player p = e.getPlayer();

        switch (randomNum) {
            case 1 -> e.setJoinMessage(ChatColor.RED + "PRZYBYŁ POTEŻNY GEJ, STRZEŻCIE SIĘ " + ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET + ChatColor.RED + "!!!!");
            case 2 -> e.setJoinMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.YELLOW + " dołączył na serwer");
            case 3 -> e.setJoinMessage(ChatColor.DARK_PURPLE + "Uwaga! Przybył " + ChatColor.AQUA + ChatColor.BOLD + "MEGA-HAMPTER, aka " + p.getDisplayName() + ChatColor.RESET + ChatColor.DARK_PURPLE + "!!!!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        Player p = e.getPlayer();

        switch (randomNum) {
            case 1 ->
                    e.setQuitMessage(ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.LIGHT_PURPLE + " opuścił serwer :(");
            case 2 ->
                    e.setQuitMessage(ChatColor.GOLD + p.getDisplayName() + ChatColor.YELLOW + " nie wytrzymał i poszedł sikać :O");
        }

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

    }
}
