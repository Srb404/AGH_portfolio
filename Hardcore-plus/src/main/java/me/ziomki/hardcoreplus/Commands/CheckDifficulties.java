package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.DifficultiesList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckDifficulties implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) return true;
        Inventory hardcoreMenu = Bukkit.createInventory(p, 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");
        AtomicInteger firstGap = new AtomicInteger(10);

        // Szklane fillery
        ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta voidGlassMeta = voidGlass.getItemMeta();
        voidGlassMeta.setDisplayName("");
        voidGlass.setItemMeta(voidGlassMeta);
        for (int i = 0; i < hardcoreMenu.getSize(); i++)
            hardcoreMenu.setItem(i, voidGlass);

        // 0 - chance, 1 - material, 2 - color, 3 - shortDesc, 4 - longDesc

        DifficultiesList.getDifficultiesList().forEach((k, v) -> {
            // Przypisanie wartości
            Double chance = (Double) v.get(0);
            Material material = (Material) v.get(1);
            ChatColor color = (ChatColor) v.get(2);
            String shortDesc = (String) v.get(3), longDesc = (String) v.get(4);
            // Tworzenie przedmiotu do menu
            ItemStack diffItem = new ItemStack(material, 1);
            ItemMeta diffMeta = diffItem.getItemMeta(); assert diffMeta != null;
            diffMeta.setDisplayName(color + shortDesc);
            diffMeta.setLore(WordWrapLore(longDesc, k));
            diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            diffItem.setItemMeta(diffMeta);
            // Ustawianie go na odpowiednim polu
            hardcoreMenu.setItem(firstGap.get(), diffItem);
            if (firstGap.get() == 16 || firstGap.get() == 24 || firstGap.get() == 34) firstGap.addAndGet(4);
            else if (firstGap.get() > 43) firstGap.addAndGet(0);
            else firstGap.addAndGet(2);
        });


        p.openInventory(hardcoreMenu);
        return true;
    }

    public List<String> WordWrapLore(String string, Integer id)
    {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + string + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        if (DifficultiesList.getDifficultiesList().get(id).get(0).equals(100.0)) sb.append("\n" + ChatColor.GOLD + "Efekt permamentny");
        else sb.append("\n" + ChatColor.YELLOW + "Szansa wystąpienia: " + ChatColor.GOLD).append(DifficultiesList.getDifficultiesList().get(id).get(0))
                .append("0%");;
        return Arrays.asList(sb.toString().split("\n"));
    }
}
