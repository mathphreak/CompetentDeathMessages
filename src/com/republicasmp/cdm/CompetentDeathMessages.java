package com.republicasmp.cdm;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CompetentDeathMessages extends JavaPlugin implements Listener {
	private HashMap<String, String> lastDamagerMap;
	private HashMap<String, Long> lastTimeDamagedByPlayerMap;
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player victim = event.getEntity();
		String victimName = victim.getDisplayName();
		EntityDamageEvent lastDamageEvent = victim.getLastDamageCause();
		if (lastDamageEvent instanceof EntityDamageByBlockEvent) {
			EntityDamageByBlockEvent blockDamageEvent = (EntityDamageByBlockEvent) lastDamageEvent;
			if (blockDamageEvent.getCause().equals(DamageCause.CONTACT)) {
				Material blockType = blockDamageEvent.getDamager().getType();
				event.setDeathMessage(MessageWrapper.getMessage(victimName, blockType));
				return;
			}
		}
		if (lastDamageEvent instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent entityDamageEvent = (EntityDamageByEntityEvent) lastDamageEvent;
			Entity damager = entityDamageEvent.getDamager();
			System.out.println("Damaged by entity " + damager.getType());
			if (damager instanceof Projectile) {
				damager = ((Projectile) damager).getShooter();
			}
			if (damager instanceof Player) {
				Player killer = (Player) damager;
				String killerName = killer.getDisplayName();
				ItemStack heldItem = killer.getItemInHand();
				event.setDeathMessage(MessageWrapper.getMessage(victimName, killerName, heldItem));
				return;
			} else {
				event.setDeathMessage(MessageWrapper.getMessage(victimName, damager.getType()));
				return;
			}
		}
		DamageCause cause = lastDamageEvent.getCause();
		long now = System.currentTimeMillis();
		Long lastTime = lastTimeDamagedByPlayerMap.get(victimName);
		if (lastTime != null && now - lastTime < 5000) {
			event.setDeathMessage(MessageWrapper.getMessage(victimName, lastDamagerMap.get(victimName), cause));
		} else {
			event.setDeathMessage(MessageWrapper.getMessage(victimName, cause));
		}
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		Entity victim = event.getEntity();
		if (victim instanceof Player) {
			Entity victor = event.getDamager();
			if (victor instanceof Projectile) {
				victor = ((Projectile) victor).getShooter();
			}
			if (victor instanceof Player) {
				lastDamagerMap.put(((Player) victim).getDisplayName(), ((Player) victor).getDisplayName());
				lastTimeDamagedByPlayerMap.put(((Player) victim).getDisplayName(), System.currentTimeMillis());
			}
		}
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		lastDamagerMap = new HashMap<String, String>();
		lastTimeDamagedByPlayerMap = new HashMap<String, Long>();
	}
}
