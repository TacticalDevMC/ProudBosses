package me.tacticaldev.proudnetworkbosses.listeners;
// Plugin created by TacticalDevelopment
// Project Name: Mobs
// Class created on: 19:31 (24/10/2019)
// Time: 19:31

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityKillListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if(entity.hasMetadata("ZombieBoss")) {

        }


    }
}
