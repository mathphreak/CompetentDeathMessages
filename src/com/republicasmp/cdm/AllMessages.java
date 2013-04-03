package com.republicasmp.cdm;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public abstract class AllMessages {
	private final static String fallDamage[] = {
		"Cleanup on aisle 12, we seem to have spilled some <victim>",
		"<victim> can't break the laws of physics",
		"<victim> couldn't keep it up",
		"<victim> forgot to drink Red Bull"
	};
	
	private final static String drowning[] = {
		"<victim>'s relationship with the squid could never last",
		"<victim> drowned",
		"<victim> forgot how to swim",
		"<victim> must have tried on concrete shoes"
	};
	
	private final static String zombies[] = {
		"<victim> was left for dead"
	};
	
	private final static String witch[] = {
		"<victim> got witch slapped"
	};
	
	private final static String customDeathType[] = {
		"<victim> was possibly smited by an admin",
		"<victim> died (it was prod's fault)",
		"<victim> suffered death by Republica"
	};
	
	private final static String pushedFall[] = {
		"<killer> pushed <victim> off a cliff"
	};
	
	private final static String cactus[] = {
		"The cacti ate <victim>",
		"<victim> hugged a cactus"
	};
	
	private final static String playerStick[] = {
		"<killer>'s rod was too much for <victim> to handle"
	};
	
	private final static String playerNothing[] = {
		"<killer> savagely beat <victim> to death with his/her bare hands",
		"<killer> savagely beat <victim> to death with her/his bare hands"
	};
	
	private final static String fire[] = {
		"<victim> combusted"
	};
	
	private final static String explosion[] = {
		"<victim> is now scattered atoms"
	};
	
	private final static String fallingWhatever[] = {
		"<victim> was squished to death under something" // TODO if it was an anvil, laugh about it
	};
	
	private final static String lava[] = {
		"<victim> forgot the difference between water and lava"
	};
	
	private final static String poison[] = {
		"<victim> drank too much expired milk"
	};
	
	private final static String starvation[] = {
		"<victim> forgot to pack a lunch"
	};
	
	private final static String lightning[] = {
		"<victim> was struck by lightning"
	};
	
	private final static String suffocation[] = {
		"<victim> had its head in the blocks"
	};
	
	private final static String suicide[] = {
		"<victim> was tired of living"
	};
	
	public final static Message allMessages[] = {
		// if there are any uncategorized messages, they go here
		// but there shouldn't be
	};
	
	public final static ArrayList<Message> messages = new ArrayList<Message>();
	
	static {
		// for damage not from a block or a LivingEntity
		handleDamageCause(explosion, DamageCause.BLOCK_EXPLOSION);
		handleDamageCause(customDeathType, DamageCause.CUSTOM);
		handleDamageCause(drowning, DamageCause.DROWNING);
		handleDamageCause(fallDamage, DamageCause.FALL);
		handleDamageCause(fallingWhatever, DamageCause.FALLING_BLOCK);
		handleDamageCause(fire, DamageCause.FIRE);
		handleDamageCause(fire, DamageCause.FIRE_TICK);
		handleDamageCause(lava, DamageCause.LAVA);
		handleDamageCause(lightning, DamageCause.LIGHTNING);
		handleDamageCause(poison, DamageCause.POISON);
		handleDamageCause(starvation, DamageCause.STARVATION);
		handleDamageCause(suffocation, DamageCause.SUFFOCATION);
		handleDamageCause(suicide, DamageCause.SUICIDE);
		
		// for damage from a block
		handleBlockDamage(cactus, Material.CACTUS);
		
		// for damage from a monster
		handleEntityDamage(zombies, EntityType.ZOMBIE);
		handleEntityDamage(witch, EntityType.WITCH);
		
		// for damage from a cause and a player
		handlePlayerCauseDamage(pushedFall, DamageCause.FALL);
		
		// for damage from a player holding something
		handleArmedPlayerDamage(playerStick, Material.STICK);
		
		// for damage from a player not holding something
		handleEntityDamage(playerNothing, EntityType.PLAYER);
		
		for (Message m : allMessages) {
			messages.add(m);
		}
	}
	
	private static void handleDamageCause(String these[], DamageCause cause) {
		for (String s : these) {
			messages.add(new Message(s, cause, null, null));
		}
	}
	
	private static void handleBlockDamage(String these[], Material material) {
		for (String s : these) {
			messages.add(new Message(s, null, material, null));
		}
	}
	
	private static void handleEntityDamage(String these[], EntityType type) {
		for (String s : these) {
			messages.add(new Message(s, null, null, type));
		}
	}
	
	private static void handlePlayerCauseDamage(String these[], DamageCause cause) {
		for (String s : these) {
			messages.add(new Message(s, cause, null, EntityType.PLAYER));
		}
	}
	
	private static void handleArmedPlayerDamage(String these[], Material material) {
		for (String s : these) {
			messages.add(new Message(s, null, material, EntityType.PLAYER));
		}
	}
	
	public final static Message genericMessage = new Message("<victim> died mysteriously", null, null, null);
}
