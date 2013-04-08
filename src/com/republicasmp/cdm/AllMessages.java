package com.republicasmp.cdm;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

public abstract class AllMessages {
	private final static String quoteItem = "\"<item>\"";
	private final static String italicItem = ChatColor.ITALIC + "<item>" + ChatColor.RESET;
	
	private final static String fallDamage[] = {
		"Cleanup on aisle 12, we seem to have spilled some <victim>",
		"<victim> can't break the laws of physics",
		"<victim> couldn't keep it up",
		"<victim> forgot to drink Red Bull",
		"<victim> went kersplat"
	};
	
	private final static String drowning[] = {
		"<victim>'s relationship with the squid could never last",
		"<victim> drowned",
		"<victim> forgot how to swim",
		"<victim> must have tried on concrete shoes",
		"<victim> failed at scuba diving"
	};
	
	private final static String zombies[] = {
		"<victim> was left for dead",
		"Zombies ate <victim>",
		"<victim> was a zombie magnet",
		"<victim> was out late at night with the undead",
		"<victim> has a zombie problem"
	};
	
	private final static String witch[] = {
		"<victim> got witch slapped",
		"<victim> only has one problem, but it's a witch",
		"Witches be trippin' <victim>",
		"<victim> messed with a master of potions",
		"<victim> lost to a witch"
	};
	
	private final static String customDeathType[] = {
		"<victim> was possibly smited by an admin",
		"<victim> died (it was Prod's fault)",
		"<victim> suffered death by Republica",
		ChatColor.MAGIC + "THE ADMINS" + ChatColor.RESET + " killed <victim>",
		"The staff hopes nobody notices <victim> died"
	};
	
	private final static String pushedFall[] = {
		"<killer> pushed <victim> off a cliff",
		"<killer> was the Scar to <victim>'s Mufasa",
		"<killer> shoved <victim> from a high place to a low one",
		"<killer> thinks <victim> should stay farther back from the edge next time",
		"<victim> \"accidentally\" fell from a cliff, and <killer> fled the scene"
	};
	
	private final static String cactus[] = {
		"The cacti ate <victim>",
		"<victim> hugged a cactus",
		"A cactus hugged <victim>",
		"<victim> got the pointy end of the...cactus",
		"<victim> learned a painful lesson"
	};
	
	private final static String playerStick[] = {
		"<killer>'s rod was too much for <victim> to handle"
	};
	
	private final static String playerNothing[] = {
		"<killer> savagely beat <victim> to death with his/her bare hands",
		"<killer> savagely beat <victim> to death with her/his bare hands",
		"<killer> pummeled <victim> to death"
	};
	
	private final static String fire[] = {
		"<victim> combusted",
		"<victim> is now crispy",
		"<victim> was deep-fried",
		"Oh well, at least <victim> was warm for the rest of his/her life",
		"Oh well, at least <victim> was warm for the rest of her/his life"
	};
	
	private final static String explosion[] = {
		"<victim> is now scattered atoms",
		"<victim> had too short a fuse",
		"<victim> played with TNT",
		"<victim> wins the Nobel Prize in Exploding",
		"<victim> somehow died in a non-creeper-related explosion"
	};
	
	private final static String fallingWhatever[] = {
		"<victim> was squished to death under something", // TODO if it was an anvil, laugh about it
		"<victim> was crushed to death by something",
		"<victim> was smushed under something",
		"<victim> was squashed by something",
		"<victim> is now a pancake"
	};
	
	private final static String lava[] = {
		"<victim> forgot the difference between water and lava",
		"<victim> was melted",
		"<victim> jumped into a volcano",
		"<victim> mined a volcano",
		"<victim> and lava...bad combination"
	};
	
	private final static String poison[] = {
		"<victim> drank too much expired milk",
		"<victim> ate the wrong food",
		"<victim> ate some weird mushrooms",
		"<victim> ran out of non-rotten flesh to eat",
		"<victim> experimented with cooking"
	};
	
	private final static String starvation[] = {
		"<victim> forgot to pack a lunch",
		"<victim> should have spent more at the grocery store",
		"<victim> hasn't bothered to start a farm yet",
		"<victim> ran out of supplies",
		"<victim> starved"
	};
	
	private final static String lightning[] = {
		"<victim> was struck by lightning",
		"<victim> was smited by the gods (not to be confused with the admins)",
		"<victim> was a wonderful conductor of electricity",
		"<victim> pulled an http://xkcd.com/795/",
		"<victim> was golfing in a thunderstorm"
	};
	
	private final static String suffocation[] = {
		"<victim> had his/her head in the blocks",
		"<victim> had her/his head in the blocks",
		"<victim> ran out of room to breathe",
		"<victim> ran out of O2",
		"<victim> needed more air"
	};
	
	private final static String suicide[] = {
		"<victim> was tired of living",
		"<victim> pulled the plug on life",
		"<victim> got bored of life",
		"<victim> gave up",
		"<victim> ragequit life"
	};
	
	private final static String blaze[] = {
		"<victim> went out in a blaze of glory",
		"<victim> went to blazes",
		"<victim> found a blaze spawner...the hard way",
		"<victim> was burned alive by blazes",
		"<victim> was slain by a Lesser Flying Fireball-Breathing Monster"
	};
	
	private final static String spider[] = {
		"<victim> had an unfortunate encounter with a spider",
		"<victim> was slain by Shelob's younger brother",
		"<victim> was slain by Shelob's younger sister",
		"<victim> ran into the eight-legged beast",
		"<victim> is now a nice bundle of silk"
	};
	
	private final static String creeper[] = {
		"<victim>'s epitaph will be SsssssSssSSsSSssSS$...BOOM",
		"<victim> had something creepy happen",
		"<victim> was assaulted by Minecraft's most famous monster",
		"<victim> had an unfortunate run-in with something green that explodes",
		"<victim> tried to punch a creeper"
	};
	
	private final static String ender_dragon[] = {
		"<victim> 0; Ender Dragon 1",
		"<victim>'s head is mounted on the wall of the dragon's lair",
		"<victim>'s life was ended by the Ender Dragon",
		"<victim> joins the swelling ranks of those slain by the dragon",
		"There's only one dragon in Minecraft, but <victim> was still killed by it"
	};
	
	private final static String enderman[] = {
		"<victim> saw static, then the faceless monster...no wait",
		"<victim> got backstabbed by the tall ones",
		"The Endermen gave <victim> a hug",
		"<victim> was slain by the tall purple guy",
		"An Enderman teleported away from the scene of <victim>'s death"
	};
	
	private final static String ghast[] = {
		"<victim> suffered a ghastly fate",
		"<victim> got fireballed into oblivion",
		"<victim> shed a ghast tear",
		"<victim> was slain by a Greater Flying Fireball-Breathing Monster",
		"<victim> was killed by those stupid ghasts"
	};
	
	private final static String iron_golem[] = {
		"<victim> should have picked on something with less metal",
		"<victim> picked on too many villagers",
		"<victim> was the scourge of the village",
		"<victim> learned the hard way...iron golems aren't gentle giants",
		"<victim> was a heartless monster, and was dealt with accordingly"
	};
	
	private final static String magma_cube[] = {
		"<victim> was killed by the coolest of all monsters",
		"<victim> saw fire, then a cube, then a cube on fire, then nothing",
		"<victim> was flattened by a magma cube",
		"<victim> saw the cube slices, then the afterlife",
		"<victim> needs a few days away from anything with \"magma\" in the name"
	};
	
	private final static String zombiepigman[] = {
		"<victim> was slain by undead pigs...yay Minecraft!",
		"<victim> lost to the mob of pigs",
		"Put a zombie and a pig in a blender, and you get what killed <victim>",
		"Pig + lightning = world - <victim>",
		"<victim> went hog wild"
	};
	
	private final static String silverfish[] = {
		"<victim>'s corpse stinks of fish",
		"<victim> mined too much in a stronghold",
		"Wait, <victim>'s gone...something's fishy",
		"<victim> suffered a fishy fate",
		"<victim> would have pulled a Jonah if silverfish were about eighty times as big"
	};
	
	private final static String skeleton[] = {
		"<victim> was sniped from a distance",
		"<victim> succumbed a headshot from the expert sniper",
		"<victim> was killed by skin and bones, but without the skin",
		"<victim> heard bones rattling, then a bow firing, then absolutely nothing",
		"<victim> was slain by the game's best archer"
	};
	
	private final static String slime[] = {
		"<victim> was slimed",
		"<victim> is now a slimy piece of deadness",
		"<victim> is covered in green goop",
		"<victim> was eaten by bouncing green cubes...Minecraft FTW",
		"<victim> faced down the recursively subdividing green enemy...and lost"
	};
	
	private final static String wither[] = {
		"<victim> messed with the boss",
		"<victim> tried to tame the three-headed monster",
		"<victim> found a wither, but didn't last long",
		"<victim> can't handle the floating three-headed weirdness",
		"<victim> picked on something with two heads too many"
	};
	
	private final static String wolf[] = {
		"<victim> punched the wrong dog",
		"<victim> was prey",
		"<victim> was bitten by a rabid wolf...maybe",
		"<victim> isn't very good at cruelty to animals",
		"<victim> has a wolf problem"
	};
	
	private final static String playerDiamondSword[] = {
		"<killer> slew <victim> with a diamond-encrusted weapon{{ named " + quoteItem + "}}",
		"<killer>'s mighty blade{{ " + quoteItem + "}} was driven through <victim>",
		"<killer>'s sparkling, shining sword{{ named " + quoteItem + "}} is now stained with <victim>'s blood",
		"<victim> ran into <killer>'s blade{{ " + quoteItem + "}}",
		"<victim> was impaled on <killer>'s diamond sword{{ named " + quoteItem + "}}"
	};
	
	private final static String playerWrittenBook[] = {
		"{{<killer> killed <victim> with a fine work of literature named " + italicItem + "}}",
		"{{<killer> abused an autographed copy of " + italicItem + " to kill <victim>}}",
		"{{<killer> killed <victim> with " + italicItem + "}}",
		"{{<victim> was slain with <killer>'s copy of " + italicItem + "}}",
		"{{<killer> bloodied a copy of " + italicItem + " on <victim>}}"
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
			messages.add(new Message(ChatColor.RESET + s, cause, null, null));
		}
	}
	
	private static void handleBlockDamage(String these[], Material material) {
		for (String s : these) {
			messages.add(new Message(ChatColor.RESET + s, null, material, null));
		}
	}
	
	private static void handleEntityDamage(String these[], EntityType type) {
		for (String s : these) {
			messages.add(new Message(ChatColor.RESET + s, null, null, type));
		}
	}
	
	private static void handlePlayerCauseDamage(String these[], DamageCause cause) {
		for (String s : these) {
			messages.add(new Message(ChatColor.RESET + s, cause, null, EntityType.PLAYER));
		}
	}
	
	private static void handleArmedPlayerDamage(String these[], Material material) {
		for (String s : these) {
			messages.add(new Message(ChatColor.RESET + s, null, material, EntityType.PLAYER));
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
