package me.tacticaldev.proudnetworkbosses.listeners;
// Plugin created by TacticalDevelopment
// Project Name: Mobs
// Class created on: 19:39 (24/10/2019)
// Time: 19:39

import me.tacticaldev.proudnetworkbosses.ProudBosses;
import me.tacticaldev.proudnetworkbosses.managers.FileManager;
import me.tacticaldev.proudnetworkbosses.managers.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private UserManager userManager = ProudBosses.getInstance().getUserManager();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String playerIP = player.getAddress().getAddress().toString();
        playerIP = playerIP.replaceAll("/", "");
        playerIP = playerIP.replaceAll("\\.", "-");

        userManager.loadUser(player);
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".info.ip", playerIP);
        FileManager.save(ProudBosses.getInstance(), "userdata.yml");
    }
}
