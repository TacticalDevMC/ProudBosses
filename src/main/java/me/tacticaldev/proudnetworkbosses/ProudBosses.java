package me.tacticaldev.proudnetworkbosses;

import lombok.Getter;
import me.tacticaldev.proudnetworkbosses.commands.BleadNightCommand;
import me.tacticaldev.proudnetworkbosses.listeners.DamageEntityListener;
import me.tacticaldev.proudnetworkbosses.managers.BossManager;
import me.tacticaldev.proudnetworkbosses.managers.UserManager;
import me.tacticaldev.proudnetworkbosses.utils.base.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class ProudBosses extends JavaPlugin {

    @Getter
    private static ProudBosses instance;
    @Getter
    private static ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Getter
    private static BossManager bossManager;
    @Getter
    private UserManager userManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        console.sendMessage("[" + this.getDescription().getName() + "] Plugin staat aan! Author(s): " + this.getDescription().getAuthors() + " V:" + this.getDescription().getVersion());

        // commands
        registerCommands(
                new BleadNightCommand("bleadnight")
        );

        // listeners
        registerListeners(
                new DamageEntityListener()
        );

        // manager
        bossManager = new BossManager(this);
        userManager = new UserManager();

        for (Player all : Bukkit.getOnlinePlayers()) {
            getUserManager().loadUser(all);

            Board.showScoreboard(all);
            Bukkit.getScheduler().runTaskTimer(ProudBosses.getInstance(), new Runnable() {
                public void run() {
                    Board.showScoreboard(all);
                }
            }, 10, 50L);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        console.sendMessage("[" + this.getDescription().getName() + "] Plugin staat uit! Author(s): " + this.getDescription().getAuthors() + " V:" + this.getDescription().getVersion());

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (userManager.getUserByPlayer(all) != null) userManager.saveUser(all);
        }
    }

    private void registerCommands(CommandBase... commands) {
        Arrays.stream(commands).forEach((command -> {
            getCommand(command.getCommand()).setExecutor(command);
            getCommand(command.getCommand()).setTabCompleter(command);
        }));
    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach((listener -> {
            getServer().getPluginManager().registerEvents(listener, this);
        }));
    }

}
