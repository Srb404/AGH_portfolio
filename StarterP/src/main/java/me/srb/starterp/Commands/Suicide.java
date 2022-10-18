package me.srb.starterp.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return true;
        p.sendMessage(ChatColor.RED + "Rest in pepperonii");
        p.spawnParticle(Particle.DAMAGE_INDICATOR, p.getLocation(), 3);
        p.setHealth(0);
        return true;
    }
}
