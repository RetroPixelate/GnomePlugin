package me.retropixelate.gnometest;

import org.bukkit.plugin.java.JavaPlugin;

public final class GnomeTest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
