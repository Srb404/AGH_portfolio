package me.srb.randomdrop_testing.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class EatingStuffFromMine implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        System.out.println(e.getItem().getEnchantments());
        if(e.getItem().getType() == Material.MUSHROOM_STEW && !(e.getItem().getEnchantments().isEmpty())) {
            Player p = e.getPlayer();
            ArrayList<PotionEffect> potki = new ArrayList<PotionEffect>();
            potki.add(new PotionEffect(PotionEffectType.SPEED, 20*30, 6));
            potki.add(new PotionEffect(PotionEffectType.CONFUSION, 20*90, 8));
            potki.add(new PotionEffect(PotionEffectType.HEAL, 20*15, 4));
            potki.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*30, 5));
            p.addPotionEffects(potki);
        }
    }
}
