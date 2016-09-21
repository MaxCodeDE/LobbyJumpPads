package me.minemax.JumpPads;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class JumpPads extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		
		System.out.println("PeopleCraft-JumpPads erfolgreich aktiviert!");
		
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvents(this, this);
		
	}
	
	@EventHandler
	public void PlayerMove(PlayerMoveEvent event) {
		
		final Player p = event.getPlayer();
		if (p.getLocation().getWorld().getName().equalsIgnoreCase("lobby")) {
		if (p.getLocation().getBlock().getType() == Material.STONE_PLATE) {
		if (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.EMERALD_BLOCK) {
			Vector v = p.getLocation().getDirection().multiply(10D).setY(0.8D);
			p.setVelocity(v);
			p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 3, 2);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

				@Override
				public void run() {
					Vector v = p.getLocation().getDirection().multiply(10D).setY(0.5D);
					p.setVelocity(v);
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 3, 2);
				}
			}, 20L);
		}
		}
		}
		
		
	}
	
	@Override
	public void onDisable() {
		
		// Nichts.. :c
		
	}
	
}
