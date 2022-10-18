package me.srb.starterp.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeShortcuts implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) return true;
        if (!(p.isOp())) return true;
        if (args.length != 1) return true;
        if (args[0].equalsIgnoreCase("0")) p.setGameMode(GameMode.SURVIVAL);
        if (args[0].equalsIgnoreCase("1")) p.setGameMode(GameMode.CREATIVE);
        return true;
    }
}
