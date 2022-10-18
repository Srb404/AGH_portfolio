package me.ziomki.hardcoreplus.Schedulers;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Listeners.DangerousDarkness.lightDamage;

public class DarknessScheduler {

    public static void darkness() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HardcorePlus.getInstance(), () -> damagePlayers(), 0, 20);
    }

    public static void damagePlayers() {
        lightDamage.forEach((k, v) -> {
            if (v) {
                Objects.requireNonNull(Bukkit.getPlayer(k.getUniqueId())).damage(1);
                ActionBarMessage.sendActionBarMessage(k, ChatColor.RED + "Jestes w ciemnosci, otrzymujesz obrazenia.");
            }
        });
    }
}
