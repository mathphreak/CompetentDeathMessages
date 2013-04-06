package com.republicasmp.cdm;

import java.util.HashMap;

import org.bukkit.Material;

public abstract class GrammarStuff {
	private static final HashMap<Material, String> prefixes;
	
	public static final String lookup(Material material) {
		return prefixes.get(material);
	}
	
	static {
		prefixes = new HashMap<Material, String>();
		for (Material mat : Material.values()) {
			String name = mat.toString().toLowerCase();
			if (name.startsWith("a") || name.startsWith("e") || name.startsWith("i") ||
					name.startsWith("o") || name.startsWith("u")) {
				an(mat);
			} else {
				a(mat);
			}
			if (name.endsWith("s") || name.endsWith("ore") || name.endsWith("stone")) {
				nothing(mat);
			}
			if (name.startsWith("coal") || name.startsWith("cobbles") ||
					name.startsWith("cooked") || name.startsWith("raw")) {
				nothing(mat);
			}
			if (name.startsWith("flin") || name.startsWith("glowst") ||
					name.startsWith("record")) {
				nothing(mat);
			}
		}
		nothing(Material.BLAZE_POWDER);
		nothing(Material.BREAD);
		nothing(Material.CLAY);
		nothing(Material.COCOA);
		a(Material.COMPASS);
		nothing(Material.DIRT);
		nothing(Material.ENDER_STONE);
		nothing(Material.FIRE);
		nothing(Material.GRAVEL);
		nothing(Material.GRILLED_PORK);
		nothing(Material.ICE);
		nothing(Material.LAVA);
		nothing(Material.LEATHER);
		nothing(Material.LONG_GRASS);
		nothing(Material.MAGMA_CREAM);
		nothing(Material.MUSHROOM_SOUP);
		nothing(Material.MYCEL);
		nothing(Material.NETHERRACK);
		nothing(Material.OBSIDIAN);
		nothing(Material.PAPER);
		nothing(Material.PORK);
		nothing(Material.PUMPKIN_PIE);
		nothing(Material.REDSTONE);
		nothing(Material.REDSTONE_WIRE);
		nothing(Material.ROTTEN_FLESH);
		nothing(Material.SAND);
		nothing(Material.SNOW);
		nothing(Material.SOIL);
		nothing(Material.SOUL_SAND);
		nothing(Material.STATIONARY_LAVA);
		nothing(Material.STATIONARY_WATER);
		nothing(Material.STRING);
		nothing(Material.SUGAR);
		nothing(Material.SUGAR_CANE);
		nothing(Material.SULPHUR);
		nothing(Material.TNT);
		nothing(Material.TRIPWIRE);
		nothing(Material.WATER);
		nothing(Material.WHEAT);
		nothing(Material.WOOD);
		nothing(Material.WOOL);
	}
	
	private static void nothing(Material m) {
		prefixes.put(m, "");
	}
	
	private static void a(Material m) {
		prefixes.put(m, "a ");
	}
	
	private static void an(Material m) {
		prefixes.put(m, "an ");
	}
}
