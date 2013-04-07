package com.republicasmp.cdm;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

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
		"<victim> was left for dead",
		"Zombies ate <victim>"
	};
	
	private final static String witch[] = {
		"<victim> got witch slapped"
	};
	
	private final static String customDeathType[] = {
		"<victim> was possibly smited by an admin",
		"<victim> died (it was Prod's fault)",
		"<victim> suffered death by Republica",
		ChatColor.MAGIC + "THE ADMINS" + ChatColor.RESET + " killed <victim>"
	};
	
	private final static String pushedFall[] = {
		"<killer> pushed <victim> off a cliff",
		"<killer> was the Scar to <victim>'s Mufasa"
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
		"<victim> is now scattered atoms",
		"<victim> had too short a fuse"
	};
	
	private final static String fallingWhatever[] = {
		"<victim> was squished to death under something" // TODO if it was an anvil, laugh about it
	};
	
	private final static String lava[] = {
		"<victim> forgot the difference between water and lava",
		"<victim> was melted"
	};
	
	private final static String poison[] = {
		"<victim> drank too much expired milk",
		"<victim> ate the wrong food"
	};
	
	private final static String starvation[] = {
		"<victim> forgot to pack a lunch",
		"<victim> should have spent more at the grocery store"
	};
	
	private final static String lightning[] = {
		"<victim> was struck by lightning",
		"<victim> was smited by the gods (not to be confused with the admins)"
	};
	
	private final static String suffocation[] = {
		"<victim> had its head in the blocks",
		"<victim> ran out of room to breathe"
	};
	
	private final static String suicide[] = {
		"<victim> was tired of living",
		"<victim> pulled the plug on life"
	};
	
	private final static String blaze[] = {
		"<victim> went out in a blaze of glory"
	};
	
	private final static String spider[] = {
		"<victim> had an unfortunate encounter with a spider", // TODO cave vs regular spiders?
		"<victim> was slain by Shelob's younger brother"
	};
	
	private final static String creeper[] = {
		"<victim>'s epitaph will be SsssssSssSSsSSssSS$...BOOM",
		"<victim> had something creepy happen"
	};
	
	private final static String ender_dragon[] = {
		"<victim> 0; Ender Dragon 1",
		"<victim>'s head is mounted on the wall of the dragon's lair"
	};
	
	private final static String enderman[] = {
		"<victim> saw static, then the faceless monster...no wait",
		"<victim> got backstabbed by the tall ones"
	};
	
	private final static String ghast[] = {
		"<victim> suffered a ghastly fate",
		"<victim> got fireballed into oblivion"
	};
	
	private final static String iron_golem[] = {
		"<victim> should have picked on something with less metal",
		"<victim> picked on too many villagers"
	};
	
	private final static String magma_cube[] = {
		"<victim> was killed by the coolest of all monsters",
		"<victim> saw fire, then a cube, then a cube on fire, then nothing"
	};
	
	private final static String zombiepigman[] = {
		"<victim> was slain by undead pigs...yay Minecraft!",
		"<victim> lost to the mob of pigs"
	};
	
	private final static String silverfish[] = {
		"<victim>'s corpse stinks of fish",
		"<victim> mined too much in a stronghold"
	};
	
	private final static String skeleton[] = {
		"<victim> was sniped from a distance",
		"<victim> succumbed a headshot from the expert sniper"
	};
	
	private final static String slime[] = {
		"<victim> was slimed",
		"<victim> is now a slimy piece of deadness"
	};
	
	private final static String wither[] = {
		"<victim> messed with the boss",
		"<victim> tried to tame the three-headed monster"
	};
	
	private final static String wolf[] = {
		"<victim> punched the wrong dog",
		"<victim> was prey"
	};
	
	private final static String playerDiamondSword[] = {
		"<killer> slew <victim> with a diamond-encrusted weapon{{ named \"<item>\"}}",
		"{{<killer>'s mighty blade \"<item>\" was driven through <victim>}}"
	};
	
	private final static String playerWrittenBook[] = {
		"<killer> killed <victim> with a fine work of literature{{ named \"<item>\"}}",
		"{{<killer> abused an autographed copy of " + ChatColor.ITALIC + "<item>" + ChatColor.RESET + " to kill <victim>}}"
	};
	
	private final static Message allMessages[] = {
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
		handleEntityDamage(blaze, EntityType.BLAZE);
		handleEntityDamage(spider, EntityType.CAVE_SPIDER);
		handleEntityDamage(creeper, EntityType.CREEPER);
		handleEntityDamage(ender_dragon, EntityType.ENDER_DRAGON);
		handleEntityDamage(enderman, EntityType.ENDERMAN);
		handleEntityDamage(ghast, EntityType.GHAST);
		handleEntityDamage(iron_golem, EntityType.IRON_GOLEM);
		handleEntityDamage(magma_cube, EntityType.MAGMA_CUBE);
		handleEntityDamage(zombiepigman, EntityType.PIG_ZOMBIE);
		handleEntityDamage(explosion, EntityType.PRIMED_TNT);
		handleEntityDamage(silverfish, EntityType.SILVERFISH);
		handleEntityDamage(skeleton, EntityType.SKELETON);
		handleEntityDamage(slime, EntityType.SLIME);
		handleEntityDamage(spider, EntityType.SPIDER);
		handleEntityDamage(witch, EntityType.WITCH);
		handleEntityDamage(wither, EntityType.WITHER);
		handleEntityDamage(wolf, EntityType.WOLF);
		handleEntityDamage(zombies, EntityType.ZOMBIE);
		
		// for damage from a cause and a player
		handlePlayerCauseDamage(pushedFall, DamageCause.FALL);
		
		// for damage from a player holding something special
		// note: generic messages are handled by the fallback method at the bottom of this class
		handleArmedPlayerDamage(playerStick, Material.STICK);
		handleArmedPlayerDamage(playerDiamondSword, Material.DIAMOND_SWORD);
		handleArmedPlayerDamage(playerWrittenBook, Material.WRITTEN_BOOK);
		
		// for damage from a player not holding something
		handleArmedPlayerDamage(playerNothing, Material.AIR);
		
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
	
	public static Message getFallbackArmedPlayerMessage(ItemStack itemHeld) {
		String materialName = itemHeld.getType().toString().toLowerCase();
		materialName = materialName.replace('_', ' ');
		String article = GrammarStuff.lookup(itemHeld.getType());
		String messageTemplate = "<killer> beat <victim> to death with " + article + materialName + "{{ named \"<item>\"}}";
		return new Message(messageTemplate, null, itemHeld.getType(), EntityType.PLAYER);
	}
	
	public final static Message genericMessage = new Message("<victim> died mysteriously", null, null, null);
}
