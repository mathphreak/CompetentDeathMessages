package com.republicasmp.cdm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Message {
	private String messageTemplate;
	private DamageCause cause = null;
	private Material material = null;
	private EntityType entityType = null;
	private static final Pattern IF_ITEM_NAME_PATTERN = Pattern.compile(".*(\\{\\{([^\\}]+)\\}\\}).*");
	
	public Message(String messageTemplate, DamageCause cause,
			Material material, EntityType entityType) {
		super();
		this.messageTemplate = messageTemplate;
		this.cause = cause;
		this.material = material;
		this.entityType = entityType;
	}

	public String toString() {
		return messageTemplate;
	}
	
	public String instantiate(String victimName, String killerName, String itemName) {
		String itemNameReplacement = "";
		String itemNamePart = "";
		Matcher ifItemName = IF_ITEM_NAME_PATTERN.matcher(this.messageTemplate);
		if (ifItemName.matches()) {
			itemNamePart = ifItemName.group(1);
			if (itemName.equals("")) {
				itemNameReplacement = "";
			} else {
				itemNameReplacement = ifItemName.group(2).replace("<item>",
						itemName);
			}
		}
		return messageTemplate
				.replace(itemNamePart, itemNameReplacement)
				.replace("<killer>", killerName)
				.replace("<victim>", victimName);
	}
	
	public String instantiate(String victimName, String killerName) {
		return instantiate(victimName, killerName, "");
	}
	
	public String instantiate(String victimName) {
		return instantiate(victimName, "", "");
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public DamageCause getCause() {
		return cause;
	}

	public Material getMaterial() {
		return material;
	}

	public EntityType getEntityType() {
		return entityType;
	}
}
