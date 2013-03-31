package com.republicasmp.cdm;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public abstract class MessageWrapper {
	
	private static Message getMessage(DamageCause cause, EntityType type, Material item) {
		ArrayList<Message> potentialMessages = new ArrayList<Message>();
		for (Message candidate : AllMessages.allMessages) {
			if (cause == null || cause.equals(candidate.getCause())) {
				if (type == null || type.equals(candidate.getEntityType())) {
					if (item == null || item.equals(candidate.getMaterial())) {
						potentialMessages.add(candidate);
					}
				}
			}
		}
		if (potentialMessages.isEmpty()) {
			return AllMessages.genericMessage;
		} else {
			Random random = new Random();
			return potentialMessages.get(random.nextInt(potentialMessages
					.size()));
		}
	}
	
	public static String getMessage(String victimName, Material blockKilledBy) {
		return getMessage((DamageCause) null, null, blockKilledBy).instantiate("", victimName);
	}
	
	public static String getMessage(String victimName, EntityType murdererType) {
		return getMessage((DamageCause) null, murdererType, null).instantiate("", victimName);
	}
	
	public static String getMessage(String victimName, String killerName, Material heldItemType) {
		return getMessage((DamageCause) null, EntityType.PLAYER, heldItemType).instantiate(killerName, victimName);
	}
	
	public static String getMessage(String victimName, DamageCause cause) {
		return getMessage(cause, null, null).instantiate("", victimName);
	}
	
	public static String getMessage(String victimName, String killerName, DamageCause cause) {
		return getMessage(cause, EntityType.PLAYER, null).instantiate(killerName, victimName);
	}
}
