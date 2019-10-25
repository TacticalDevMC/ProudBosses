package me.tacticaldev.proudnetworkbosses.utils;

import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private Player player;
    private UUID uuid;
    private String name;
    private Integer coins;

    public User(UUID uuid, String name, Integer coins) {
        this.uuid = uuid;
        this.name = name;
        this.coins = coins;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }
}
