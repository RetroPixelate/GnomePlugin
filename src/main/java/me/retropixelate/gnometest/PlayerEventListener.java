package me.retropixelate.gnometest;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.util.*;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.enchantments.Enchantment.*;

public class PlayerEventListener implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {

        Player p = event.getPlayer();
        ItemStack i = event.getItem();

        if (i.getType() == Material.NETHERITE_HOE && i.getEnchantmentLevel(ARROW_INFINITE) == 1) {
            Vector v = new Vector((p.getVelocity().getX()), (p.getVelocity().getY() + 1.0), (p.getVelocity().getZ()));
            p.setVelocity(v);
        }

    }

}
