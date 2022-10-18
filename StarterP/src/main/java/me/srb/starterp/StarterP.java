package me.srb.starterp;

import me.srb.starterp.Commands.GamemodeShortcuts;
import me.srb.starterp.Commands.Suicide;
import me.srb.starterp.Listeners.ChatBeautify;
import me.srb.starterp.Listeners.HiMessages;
import me.srb.starterp.Listeners.SilkTouchHelper;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class StarterP extends JavaPlugin {

    @Override
    public void onEnable() {
        addListener(new HiMessages());
        addListener(new SilkTouchHelper());
        addListener(new ChatBeautify());
        addCommand("suicide", new Suicide());
        addCommand("gm", new GamemodeShortcuts());
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
