package me.tacticaldev.proudnetworkbosses.commands;
// Plugin created by TacticalDevelopment
// Project Name: Mobs
// Class created on: 23:05 (23/10/2019)
// Time: 23:05

import me.tacticaldev.proudnetworkbosses.ProudBosses;
import me.tacticaldev.proudnetworkbosses.utils.Text;
import me.tacticaldev.proudnetworkbosses.utils.base.CommandBase;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BleadNightCommand extends CommandBase {


    public BleadNightCommand(String command) {
        super(command);
    }

    @Override
    public boolean executeCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (player.getLocation().getBlock().getType() == Material.AIR) {
            player.getLocation().getBlock().setType(Material.CHEST);

            Chest chest = (Chest) player.getLocation().getBlock().getState();

            ItemStack itemStack = new ItemStack(Material.BOW);

            ItemMeta itemMeta = itemStack.getItemMeta();

            itemMeta.setDisplayName(Text.color("&6&lPower &3&l5 &6&lBoog"));
            itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 5, false);

            itemStack.setItemMeta(itemMeta);

            chest.getInventory().addItem(itemStack);

            Location locationBoss1 = chest.getLocation();

            locationBoss1.setX(chest.getLocation().getX() + 1);

            Location locationBoss2 = chest.getLocation();

            locationBoss2.setX(chest.getLocation().getX() - 1);

            // spawn bosses
            ProudBosses.getBossManager().spawnSkeletonBoss(locationBoss1);
            ProudBosses.getBossManager().spawnZombieBoss(locationBoss2);
        }

        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return null;
    }
}
