package me.retropixelate.gnometest;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
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

        Entity e = event.getEntity();

        if (event.getDamager().getType() == EntityType.PLAYER) {
            Player p = (Player) event.getDamager();
            ItemStack i = p.getInventory().getItemInMainHand();

            if (i.getType() == Material.IRON_HOE && i.getEnchantmentLevel(ARROW_INFINITE) == 1) {
                Vector v = new Vector(p.getLocation().getX() - e.getLocation().getX(), p.getLocation().getY() - e.getLocation().getY(), p.getLocation().getZ() - e.getLocation().getZ());
                e.setVelocity(v);
            }
        }

        else if (event.getDamager().getType() == EntityType.ARROW) {
            Arrow a = (Arrow) event.getDamager();

            if (a.getShooter() instanceof Player) {
                Player p = (Player) a.getShooter();
                ItemStack i = p.getInventory().getItemInMainHand();

                if (i.getType() == Material.BOW && i.getEnchantmentLevel(KNOCKBACK) == 1) {
                    Vector v = new Vector(p.getLocation().getX() - e.getLocation().getX(), p.getLocation().getY() - e.getLocation().getY(), p.getLocation().getZ() - e.getLocation().getZ());
                    e.setVelocity(v);
                }

            }

        }

    }



    @EventHandler
    public void onArrowLand(ProjectileHitEvent event) {

        if (event.getEntity().getType() == EntityType.ARROW) {
            Arrow a = (Arrow) event.getEntity();

            if (a.getShooter() instanceof Player) {
                Player p = (Player) a.getShooter();
                ItemStack i = p.getInventory().getItemInMainHand();
                ItemStack io = p.getInventory().getItemInOffHand();

                if ((i.getType() == Material.BOW && i.getItemMeta().getDisplayName().equals("Ender Bow") && i.getEnchantmentLevel(PROTECTION_ENVIRONMENTAL) == 2) || (io.getType() == Material.BOW && io.getItemMeta().getDisplayName().equals("Ender Bow") && i.getEnchantmentLevel(PROTECTION_ENVIRONMENTAL) == 1)) {

                    if (event.getHitBlock() != null) {
                        Location l = new Location(event.getHitBlock().getWorld(), event.getHitBlock().getX(), event.getHitBlock().getY() + 1.0, event.getHitBlock().getZ(), p.getLocation().getYaw(),p.getLocation().getPitch());
                        Vector v = p.getVelocity();
                        p.teleport(l);
                        p.setVelocity(v);
                    }

                    else if (event.getHitEntity() != null) {
                        Vector v = p.getVelocity();
                        Location l = new Location(event.getHitEntity().getWorld(), event.getHitEntity().getLocation().getX(), event.getHitEntity().getLocation().getY(), event.getHitEntity().getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                        p.teleport(l);
                        p.setVelocity(v);
                    }
                }
            }
        }
    }

}
