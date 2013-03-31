package com.republicasmp.cdm;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CompetentDeathMessages extends JavaPlugin implements Listener {
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("fakekill")) {
			if (sender instanceof Player) {
				
			}
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player victim = event.getEntity();
		String victimName = victim.getDisplayName();
		EntityDamageEvent lastDamageEvent = victim.getLastDamageCause();
		if (lastDamageEvent instanceof EntityDamageByBlockEvent) {
			EntityDamageByBlockEvent blockDamageEvent = (EntityDamageByBlockEvent) lastDamageEvent;
			Material blockType = blockDamageEvent.getDamager().getType();
			event.setDeathMessage(MessageWrapper.getMessage(victimName, blockType));
		} else if (lastDamageEvent instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent entityDamageEvent = (EntityDamageByEntityEvent) lastDamageEvent;
			Entity damager = entityDamageEvent.getDamager();
			if (damager instanceof Player) {
				Player killer = (Player) damager;
				String killerName = killer.getDisplayName();
				Material heldItemType = killer.getItemInHand().getType();
				event.setDeathMessage(MessageWrapper.getMessage(victimName, killerName, heldItemType));
			} else {
				event.setDeathMessage(MessageWrapper.getMessage(victimName, damager.getType()));
			}
		} else {
			DamageCause cause = lastDamageEvent.getCause();
			event.setDeathMessage(MessageWrapper.getMessage(victimName, cause));
		}
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
}
