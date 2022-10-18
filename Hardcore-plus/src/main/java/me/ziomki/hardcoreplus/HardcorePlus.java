package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.CheckDifficulties;
import me.ziomki.hardcoreplus.Commands.CheckPercentageTest;
import me.ziomki.hardcoreplus.Events.EssentialsToGUI;
import me.ziomki.hardcoreplus.Listeners.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Schedulers.DarknessScheduler.darkness;

public class HardcorePlus extends JavaPlugin {

    private static HardcorePlus instance;

    public static HardcorePlus getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        addListener(new VeryFastMonsters());
        addListener(new DeathEraseItems());
        addListener(new BrokenLegEvent());
        addListener(new FastBreakingTools());
        addListener(new FoodLevelDowngrade());
        addListener(new SpawnPoweredCreepers());
        addListener(new DangerousDarkness());
        addListener(new EpicLightningTarget());

        addCommand("chance", new CheckPercentageTest());
        addCommand("utrudnienia", new CheckDifficulties());

        addListener(new EssentialsToGUI());

        darkness();
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
