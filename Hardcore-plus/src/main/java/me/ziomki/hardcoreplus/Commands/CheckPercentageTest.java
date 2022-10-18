package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CheckPercentageTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0)
            return false;
        try { Double.parseDouble(args[0]); }
        catch(NumberFormatException e) { return false; }
        boolean a = ChanceCalculator.getChance(Double.parseDouble(args[0]));
        if (a)
            sender.sendMessage("True");
        else
            sender.sendMessage("False");
        return true;
    }
}
