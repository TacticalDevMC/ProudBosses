package me.tacticaldev.proudnetworkbosses.listeners;
// Plugin created by TacticalDevelopment
// Project Name: Mobs
// Class created on: 23:54 (23/10/2019)
// Time: 23:54

import me.tacticaldev.proudnetworkbosses.utils.Icons;
import me.tacticaldev.proudnetworkbosses.utils.Text;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class DamageEntityListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Skeleton && event.getDamager() instanceof Player) {
            if (entity.hasMetadata("SkeletonBoss")) {
                int random = ThreadLocalRandom.current().nextInt(20);
                if (random < 5) {
                    event.setCancelled(true);
                    Player player = (Player) event.getDamager();
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                    player.sendMessage(Text.color("&4&l" + Icons.CROSS + " &c&lUw attack is geblokkeerd!"));
                }
            }
        } else if (entity instanceof Zombie && event.getDamager() instanceof Player) {
            if (entity.hasMetadata("ZombieBoss")) {
                int random = ThreadLocalRandom.current().nextInt(20);
                if (random < 5) {
                    event.setCancelled(true);
                    Player player = (Player) event.getDamager();
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 10);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 2));
                    player.sendMessage(Text.color("&4&l" + Icons.CROSS + " &c&lUw attack is geblokkeerd!"));
                }
            }
        }

        if (event.getDamager() instanceof Skeleton && entity instanceof Player) {
            if (event.getDamager().hasMetadata("SkeletonBoss")) {
                int random = ThreadLocalRandom.current().nextInt(10);
                if (random < 5) {
                    event.setCancelled(true);

                    Player player = (Player) event.getEntity();

                    player.setVelocity(new Vector(0, 2, 0));
                    player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                    player.sendMessage(Text.color("&6&l" + Icons.DIAMOND + " &c&lSkeleton take you in to the air!"));
                }
            }
        } else if (event.getDamager() instanceof Zombie && entity instanceof Player) {
            if (event.getDamager().hasMetadata("ZombieBoss")) {
                int random = ThreadLocalRandom.current().nextInt(10);
                if (random < 5) {
                    event.setCancelled(true);

                    Player player = (Player) event.getEntity();

                    player.setVelocity(new Vector(0, 2, 2));
                    player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                    player.sendMessage(Text.color("&6&l" + Icons.DIAMOND + " &c&lZombie take you away!"));
                }
            }
        }
    }
}
