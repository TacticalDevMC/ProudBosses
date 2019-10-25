package me.tacticaldev.proudnetworkbosses.managers;

import me.tacticaldev.proudnetworkbosses.ProudBosses;
import me.tacticaldev.proudnetworkbosses.utils.User;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserManager {

    private List<User> users;

    public UserManager() {
        this.users = new ArrayList();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void addUser(User value) {
        if (!this.users.contains(value)) {
            this.users.add(value);
        }
    }

    public void removeUser(User value) {
        if (this.users.contains(value)) {
            this.users.remove(value);
        }
    }

    public User getUserByPlayer(Player value) {
        return getUserByUuid(value.getUniqueId());
    }

    public User getUserByUuid(UUID value) {
        for (User user : this.users) {
            if (user.getUuid().equals(value)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String value) {
        for (User user : this.users) {
            if (user.getName().equalsIgnoreCase(value)) {
                return user;
            }
        }
        return null;
    }

    private void createUser(Player player) {

        String playerIP = player.getAddress().getAddress().toString();
        playerIP = playerIP.replaceAll("/", "");
        playerIP = playerIP.replaceAll("\\.", "-");

        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".name", player.getName());
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".coins", 0);
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".info.ip", playerIP);

        FileManager.save(ProudBosses.getInstance(), "userdata.yml");
    }

    public void loadUser(Player player) {
        if (FileManager.get("userdata.yml").getString("users." + player.getUniqueId().toString()) != null) {
            User user = new User(player.getUniqueId()
                    , player.getName()
                    , FileManager.get("userdata.yml").getInt("users." + player.getUniqueId().toString() + ".coins"));

            addUser(user);
            user.setPlayer(player);
        } else {
            createUser(player);
            loadUser(player);
        }
    }

    public boolean userExist(Player player) {
        if (FileManager.get("userdata.yml").getString("users." + player.getUniqueId().toString() + ".name") != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void saveUser(Player player) {
        User user = this.getUserByPlayer(player);
        if (user != null) {
            FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".name", player.getName());
            FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".coins", user.getCoins());

            FileManager.save(ProudBosses.getInstance(), "userdata.yml");
        }
    }

    public void removeCoins(Player player, int coins) {
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".coins", getUserByPlayer(player).getCoins() - coins);
        ProudBosses.getInstance().getUserManager().getUserByPlayer(player).setCoins(getUserByPlayer(player).getCoins() - coins);
        FileManager.save(ProudBosses.getInstance(), "userdata.yml");
    }

    public void addCoins(Player player, int coins) {
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".coins", getUserByPlayer(player).getCoins() + coins);
        ProudBosses.getInstance().getUserManager().getUserByPlayer(player).setCoins(getUserByPlayer(player).getCoins() + coins);
        FileManager.save(ProudBosses.getInstance(), "userdata.yml");
    }

    public void setCoins(Player player, int coins) {
        FileManager.get("userdata.yml").set("users." + player.getUniqueId().toString() + ".coins", coins);
        ProudBosses.getInstance().getUserManager().getUserByPlayer(player).setCoins(coins);
        FileManager.save(ProudBosses.getInstance(), "userdata.yml");
    }
}