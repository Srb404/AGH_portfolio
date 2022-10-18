package me.srb.randomdrop_testing;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class ListOfEvents {

    public static void doStuff(int id, String name, String chance, BlockBreakEvent e) {

        Location playerLoc = e.getPlayer().getLocation();
        Location blockLoc = e.getBlock().getLocation();
        int randomNum = ThreadLocalRandom.current().nextInt(3, 20 + 1);
        //e.getPlayer().sendMessage(ChatColor.DARK_GRAY + "[DEBUG] Szansa na to zdarzenie wynosiła: " + chance + "%   " + name);

        switch (id) {
            case 1 -> {
                blockLoc.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, blockLoc, 3);
                Creeper crep = (Creeper) playerLoc.getWorld().spawnEntity(playerLoc, EntityType.CREEPER);
                crep.setPowered(true);
            }
            case 2 -> {
                blockLoc.getWorld().spawnParticle(Particle.WHITE_ASH, blockLoc, 5);
                for (int i = 0; i < randomNum; i++) Objects.requireNonNull(blockLoc.getWorld()).spawnEntity(blockLoc, EntityType.SILVERFISH);
                e.getPlayer().sendMessage(ChatColor.RED + "O nie! To " + ChatColor.DARK_RED + "gniazdo rybików cukrowych" + ChatColor.RED + "!");
            }
            case 3 -> {
                blockLoc.getWorld().spawnParticle(Particle.HEART, blockLoc, 3);
                Bat nietoperek = (Bat) playerLoc.getWorld().spawnEntity(playerLoc, EntityType.BAT);
                PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*300, 20);
                nietoperek.addPotionEffect(drug);
                nietoperek.setCustomName(ChatColor.GOLD + "Nietoperek Robercik");
                e.getPlayer().sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "WOW! " + ChatColor.RESET + ChatColor.YELLOW + "To " + ChatColor.GOLD + "nietoperek Robercik" + ChatColor.YELLOW + "!!");
            }
            // Set górnika
            case 300 -> {
                ItemStack reward = itemMaker(Material.CHAINMAIL_HELMET, name);
                itemEnchant(reward, Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
                rewardMaker(reward, e);
            }
            case 301 -> {
                ItemStack reward = itemMaker(Material.CHAINMAIL_CHESTPLATE, name);
                itemEnchant(reward, Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
                rewardMaker(reward, e);
            }
            case 302 -> {
                ItemStack reward = itemMaker(Material.CHAINMAIL_LEGGINGS, name);
                itemEnchant(reward, Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
                rewardMaker(reward, e);
            }
            case 303 -> {
                ItemStack reward = itemMaker(Material.CHAINMAIL_BOOTS, name);
                itemEnchant(reward, Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
                rewardMaker(reward, e);
            }
            case 304 -> {
                ItemStack reward = itemMaker(Material.STONE_PICKAXE, name);
                itemEnchant(reward, Enchantment.DIG_SPEED, 7, true);
                rewardMaker(reward, e);
            }
            case 305 -> {
                ItemStack reward = itemMaker(Material.STONE_SHOVEL,name);
                itemEnchant(reward, Enchantment.DIG_SPEED, 5, true);
                rewardMaker(reward, e);
            }
            case 306 -> {
                ItemStack reward = itemMaker(Material.STONE_AXE,name);
                itemEnchant(reward, Enchantment.DIG_SPEED, 6, true);
                rewardMaker(reward, e);
            }
            // Zupka halucynka
            case 500 -> {
                String stew_name =
                        ChatColor.WHITE + "" + ChatColor.MAGIC + "I " +
                                ChatColor.RED + "Z" +
                                ChatColor.YELLOW + "U" +
                                ChatColor.DARK_BLUE + "P" +
                                ChatColor.AQUA + "K" +
                                ChatColor.WHITE + "A " +
                                ChatColor.GREEN + "H" +
                                ChatColor.DARK_RED + "A" +
                                ChatColor.BLUE + "L" +
                                ChatColor.GRAY + "U" +
                                ChatColor.DARK_BLUE + "C" +
                                ChatColor.DARK_GREEN + "Y" +
                                ChatColor.GOLD + "N" +
                                ChatColor.DARK_AQUA + "K" +
                                ChatColor.DARK_GRAY + "A" +
                                ChatColor.BOLD + ChatColor.DARK_PURPLE + " :O " +
                                ChatColor.RESET + ChatColor.WHITE + "" + ChatColor.MAGIC + "I";

                ItemStack halucynka = itemMaker(Material.MUSHROOM_STEW, stew_name);
                itemEnchant(halucynka, Enchantment.KNOCKBACK, 1, false);
                ItemMeta halucynka_meta = halucynka.getItemMeta();

                ArrayList<String> lore = new ArrayList<>();
                lore.add("");
                lore.add(ChatColor.YELLOW + "Niezły odlot!");
                halucynka_meta.setLore(lore);
                halucynka.setItemMeta(halucynka_meta);

                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), halucynka);
            }
            case 1000 -> {
                ExperienceOrb exp = (ExperienceOrb) blockLoc.getWorld().spawnEntity(blockLoc, EntityType.EXPERIENCE_ORB);
                exp.setExperience(randomNum * 2);
                e.getPlayer().sendMessage(ChatColor.GREEN + "Natrafiłeś na " + ChatColor.AQUA + randomNum * 2 + " cząstek expa" + ChatColor.GREEN + "!");
            }
        }
    }

    static void rewardMaker(ItemStack reward, BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();

        String name = "Skarb górnika";

        block.setType(Material.CHEST);
        Chest reward_chest = (Chest) block.getState();
        reward_chest.setCustomName(ChatColor.GOLD + name);
        reward_chest.update();
        reward_chest.getBlockInventory().setItem(13, reward);
        block.getWorld().spawnParticle(Particle.TOTEM, block.getLocation(), 3);
        p.sendMessage(ChatColor.GREEN + "Bingo! Znalazłeś " + ChatColor.YELLOW + name + ChatColor.GREEN + "!");

        e.setCancelled(true);
    }

    static void itemEnchant(ItemStack item, Enchantment ench, int lvl, boolean random) {
        if(random) lvl = ThreadLocalRandom.current().nextInt(2, lvl + 1);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.addEnchant(ench, lvl, true);
        item.setItemMeta(item_meta);
    }

    static ItemStack itemMaker(Material item, String name) {
        ItemStack prize = new ItemStack(item);
        ItemMeta prize_meta = prize.getItemMeta();
        assert prize_meta != null;
        prize_meta.setDisplayName(ChatColor.DARK_GRAY + name);
        prize.setItemMeta(prize_meta);
        return prize;
    }
}
