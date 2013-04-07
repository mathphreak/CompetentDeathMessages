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
	
	private static final Value<DamageCause> NULL_CAUSE = new Value<DamageCause>(null);
	
	private static final Value<EntityType> NULL_TYPE = new Value<EntityType>(null);
	
	private static final Value<Material> NULL_MATERIAL = new Value<Material>(null);

	private static <T extends Object> boolean checkEquality(T a, T b) {
		return a == null ? b == null : a.equals(b);
	}
	
	private static <T extends Object> boolean check(Value<T> a, T b) {
		return !a.cares || checkEquality(a.value, b);
	}
	
	private static Message getMessage(Value<DamageCause> cause,
			Value<EntityType> type, Value<Material> item, ItemStack detailedItem) {
		ArrayList<Message> potentialMessages = new ArrayList<Message>();
		for (Message candidate : AllMessages.messages) {
			if (check(cause, candidate.getCause())) {
				if (check(type, candidate.getEntityType())) {
					if (check(item, candidate.getMaterial())) {
						potentialMessages.add(candidate);
					}
				}
			}
		}
		if (potentialMessages.isEmpty()) {
			if (checkEquality(type.value, EntityType.PLAYER) && item.value != null &&
					detailedItem != null && !item.value.equals(Material.AIR)) {
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
	
	private static Message getMessage(Value<DamageCause> cause, Value<EntityType> type, Value<Material> item) {
		return getMessage(cause, type, item, null);
	}
	
	private static Message getMessage(Value<DamageCause> cause, Value<EntityType> type, ItemStack item, boolean isItemStack) {
		return getMessage(cause, type, Value.make(item.getType()), item);
	}
	
	public static String getMessage(String victimName, Material blockKilledBy) {
		return getMessage(NULL_CAUSE, NULL_TYPE, Value.make(blockKilledBy)).instantiate(victimName);
	}
	
	public static String getMessage(String victimName, EntityType murdererType) {
		return getMessage(NULL_CAUSE, Value.make(murdererType), NULL_MATERIAL).instantiate(victimName);
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
			Message message = getMessage(NULL_CAUSE, Value.make(EntityType.PLAYER), heldItem, true);
			result = message.instantiate(victimName, killerName, itemName);
		}
		return result;
	}
	
	public static String getMessage(String victimName, DamageCause cause) {
		return getMessage(Value.make(cause), NULL_TYPE, NULL_MATERIAL).instantiate(victimName);
	}
	
	public static String getMessage(String victimName, String killerName, DamageCause cause) {
		return getMessage(Value.make(cause), Value.make(EntityType.PLAYER), NULL_MATERIAL).instantiate(victimName, killerName);
	}
}
