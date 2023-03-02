package me.retropixelate.gnometest;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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

        if (i.getType() == Material.NETHERITE_HOE && i.getEnchantmentLevel(ARROW_INFINITE) == 1 && event.getAction().isRightClick()) {
            Vector v = new Vector((p.getLocation().getDirection().getX()), (0.2), (p.getLocation().getDirection().getZ()));
            p.setVelocity(v);
        }

    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() == EntityType.PLAYER) {

            Player p = (Player) event.getDamager();
            Entity d = event.getEntity();
            ItemStack i = p.getInventory().getItemInMainHand();

            if (i.getType() == Material.IRON_HOE && i.getEnchantmentLevel(ARROW_INFINITE) == 1) {
                Vector v = new Vector(p.getLocation().getX() - d.getLocation().getX(), p.getLocation().getY() - d.getLocation().getY(), p.getLocation().getZ() - d.getLocation().getZ());
                d.setVelocity(v);
            }

        }
    }

}
