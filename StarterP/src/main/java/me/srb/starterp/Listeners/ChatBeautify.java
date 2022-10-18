package me.srb.starterp.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatBeautify implements Listener {

    @EventHandler
    public void chatBeautify(AsyncPlayerChatEvent e) {
        e.setFormat(ChatColor.YELLOW + e.getPlayer().getDisplayName() + ": " + ChatColor.WHITE + e.getMessage());
    }
}
