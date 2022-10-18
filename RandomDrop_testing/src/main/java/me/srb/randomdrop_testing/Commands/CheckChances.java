package me.srb.randomdrop_testing.Commands;

import me.srb.randomdrop_testing.ListOfChances;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Double.parseDouble;

public class CheckChances implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ListOfChances list_chances = new ListOfChances();

        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<String> event;
        String percentage, rare = "";
        StringBuilder nam;
        Double chance_overall = 0.0;

        sender.sendMessage(ChatColor.DARK_GRAY + "------------[ " + ChatColor.GOLD + "Szanse na eventy" + ChatColor.DARK_GRAY + " ]------------");

        for (Integer key : list_chances.mining_events.keySet()) {
            event = list_chances.mining_events.get(key);

            if (Objects.equals(event.get(4), "1")) rare = ChatColor.WHITE + "" + ChatColor.BOLD + "ZWYKŁE";
            else if (Objects.equals(event.get(4), "2")) rare = ChatColor.BLUE + "" + ChatColor.BOLD + "RZADKIE";
            else if (Objects.equals(event.get(4), "3")) rare = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "EPICKIE";
            else if (Objects.equals(event.get(4), "4")) rare = ChatColor.RED + "" + ChatColor.BOLD + "LEGENDARNE";

            if (event.get(1).length() == 3) percentage = ChatColor.AQUA + event.get(1) + "0%";
            else percentage = ChatColor.AQUA + event.get(1) + "%";

            nam = new StringBuilder(event.get(0));
            for (int i = nam.length(); i <= 25; i++) nam.append(" ");
            chance_overall+= parseDouble(event.get(1));

            sender.sendMessage(percentage + ChatColor.WHITE + "   -   " + ChatColor.YELLOW + nam + " " + rare);
        }

        sender.sendMessage(ChatColor.DARK_GRAY + "------------------ " + df.format(chance_overall) + "% ------------------");
        return true;
    }
}
