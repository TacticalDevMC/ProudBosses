package me.tacticaldev.proudnetworkbosses.managers;
// Plugin created by TacticalDevelopment
// Project Name: Mobs
// Class created on: 23:34 (23/10/2019)
// Time: 23:34

import me.tacticaldev.proudnetworkbosses.ProudBosses;
import me.tacticaldev.proudnetworkbosses.utils.Text;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class BossManager {

    private ProudBosses plugin;

    public BossManager(ProudBosses proudBosses) {
        plugin = proudBosses;
    }


    public void spawnSkeletonBoss(Location location) {
        Skeleton skeleton = location.getWorld().spawn(location.add(0.5, 0, 0.5), Skeleton.class);

        skeleton.setCustomName(Text.color("&6Skeleton &3&lBoss"));
        skeleton.setCustomNameVisible(true);
        skeleton.setGlowing(true);

        ItemStack itemStack = new ItemStack(Material.WOOD_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        itemStack.setItemMeta(itemMeta);

        skeleton.getEquipment().setItemInMainHand(itemStack);
        skeleton.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        skeleton.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        skeleton.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        skeleton.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));

        skeleton.setMetadata("SkeletonBoss", new FixedMetadataValue(ProudBosses.getInstance(), "skeletonboss"));
    }

    public void spawnZombieBoss(Location location) {
        Zombie zombie = location.getWorld().spawn(location.add(0.5, 0, 0.5), Zombie.class);

        zombie.setCustomName(Text.color("&6Zombie &3&lBoss"));
        zombie.setCustomNameVisible(true);
        zombie.setGlowing(true);

        ItemStack itemStack = new ItemStack(Material.WOOD_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        itemStack.setItemMeta(itemMeta);

        zombie.getEquipment().setItemInMainHand(itemStack);
        zombie.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
        zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        zombie.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));

        zombie.setMetadata("ZombieBoss", new FixedMetadataValue(ProudBosses.getInstance(), "zombieboss"));
    }
}
