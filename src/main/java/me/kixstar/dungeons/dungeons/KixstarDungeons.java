package me.kixstar.dungeons.dungeons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class KixstarDungeons extends JavaPlugin {
    private static final Plugin instance = Bukkit.getServer().getPluginManager().getPlugin("KixstarDungeons");


    public void onEnable() {

    }

    public void onDisable() {

    }

    /**
     * Retrieve the instance of the plugin from Bukkit's Plugin Manager
     *
     * @return KixstarDungeons instance
     */
    public static KixstarDungeons getInstance() {
        return null == instance ? null : (KixstarDungeons) instance;
    }
}
