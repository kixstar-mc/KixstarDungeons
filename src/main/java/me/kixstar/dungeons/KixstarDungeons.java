package me.kixstar.dungeons;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class KixstarDungeons extends JavaPlugin {
    private static final Plugin instance = Bukkit.getServer().getPluginManager().getPlugin("KixstarDungeons");
    private MultiverseCore multiverse_core;

    public void onEnable() {
        if(!this.setupMultiverse()) {
            this.getLogger().severe("Multiverse-Core is missing and unfortunately, not optional.");
            this.getServer().getPluginManager().disablePlugin(this);

            return;
        }

        this.setupConfig();
    }

    public void onDisable() {

    }

    private void setupConfig() {
        this.getConfig().options().copyDefaults();
        this.saveConfig();
    }

    /**
     *
     * Verify multiverse is present and fetch it's JavaPlugin instance for later use.
     *
     * **
     *
     * @return true if setup succeeded, false if it didn't.
     */
    private boolean setupMultiverse() {
        Plugin multiverse_plugin = Bukkit.getPluginManager().getPlugin("Multiverse-Core");

        if (null == multiverse_plugin) {
            return false;
        }

        this.setMultiveseCore((MultiverseCore) multiverse_plugin);

        return true;
    }

    /**
     * Retrieve the instance of the plugin from Bukkit's Plugin Manager
     *
     * @return KixstarDungeons instance
     */
    public static KixstarDungeons getInstance() {
        return null == instance ? null : (KixstarDungeons) instance;
    }

    public MultiverseCore getMultiverseCore() {
        return this.multiverse_core;
    }

    private void setMultiveseCore(MultiverseCore multiverse_core) {
        this.multiverse_core = multiverse_core;
    }
}
