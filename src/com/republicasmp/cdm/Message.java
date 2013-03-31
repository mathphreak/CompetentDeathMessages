package com.republicasmp.cdm;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Message {
	private String messageTemplate;
	private DamageCause cause = null;
	private Material material = null;
	private EntityType entityType = null;
	
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
	
	public String instantiate(String killerName, String victimName) {
		return messageTemplate.replace("<killer>", killerName).replace("<victim>", victimName);
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
