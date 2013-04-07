package com.republicasmp.cdm;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class MessageWrapper {
	
	private static Message getMessage(DamageCause cause, EntityType type, Material item, ItemStack detailedItem) {
		ArrayList<Message> potentialMessages = new ArrayList<Message>();
		for (Message candidate : AllMessages.messages) {
			if (cause == null || cause.equals(candidate.getCause())) {
				if (type == null || type.equals(candidate.getEntityType())) {
					if (item == null || item.equals(candidate.getMaterial())) {
						potentialMessages.add(candidate);
					}
				}
			}
		}
		if (potentialMessages.isEmpty()) {
			if (type != null && type.equals(EntityType.PLAYER) && item != null &&
					detailedItem != null && !item.equals(Material.AIR)) {
				return AllMessages.getFallbackArmedPlayerMessage(detailedItem);
			} else {
				return AllMessages.genericMessage;
			}
		} else {
			Random random = new Random();
			return potentialMessages.get(random.nextInt(potentialMessages
					.size()));
		}
	}
	
	private static Message getMessage(DamageCause cause, EntityType type, Material item) {
		return getMessage(cause, type, item, null);
	}
	
	private static Message getMessage(DamageCause cause, EntityType type, ItemStack item) {
		return getMessage(cause, type, item.getType(), item);
	}
	
	public static String getMessage(String victimName, Material blockKilledBy) {
		return getMessage((DamageCause) null, null, blockKilledBy).instantiate(victimName);
	}
	
	public static String getMessage(String victimName, EntityType murdererType) {
		return getMessage((DamageCause) null, murdererType, (Material) null).instantiate(victimName);
	}
	
	public static String getMessage(String victimName, String killerName, ItemStack heldItem) {
		ItemMeta itemMeta = heldItem.getItemMeta();
		String itemName = itemMeta.hasDisplayName() ? itemMeta.getDisplayName() : "";
		if (itemMeta instanceof BookMeta) {
			System.out.println("Found a book!");
			itemName = ((BookMeta) itemMeta).getTitle();
		}
		String result = "";
		while (result.equals("")) {
			Message message = getMessage((DamageCause) null, EntityType.PLAYER, heldItem);
			result = message.instantiate(victimName, killerName, itemName);
		}
		return result;
	}
	
	public static String getMessage(String victimName, DamageCause cause) {
		return getMessage(cause, null, (Material) null).instantiate(victimName);
	}
	
	public static String getMessage(String victimName, String killerName, DamageCause cause) {
		return getMessage(cause, EntityType.PLAYER, (Material) null).instantiate(victimName, killerName);
	}
}
