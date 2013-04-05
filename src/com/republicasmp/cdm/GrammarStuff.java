package com.republicasmp.cdm;

import java.util.ArrayList;

import org.bukkit.Material;

public abstract class GrammarStuff {
	public static final ArrayList<Material> needsNothing = new ArrayList<Material>();
	public static final ArrayList<Material> needsA = new ArrayList<Material>();
	public static final ArrayList<Material> needsAn = new ArrayList<Material>();
	
	static {
		for (Material mat : Material.values()) {
			String name = mat.toString().toLowerCase();
			if (name.startsWith("a") || name.startsWith("e") || name.startsWith("i") || name.startsWith("o") || name.startsWith("u")) {
				an(mat);
			} else {
				a(mat);
			}
			if (name.endsWith("s") || name.endsWith("ore") || name.endsWith("stone")) {
				nothing(mat);
			}
			if (name.startsWith("coal") || name.startsWith("cobbles") || name.startsWith("cooked")) {
				nothing(mat);
			}
			if (name.startsWith("flin") || name.startsWith("glowst")) {
				nothing(mat);
			}
		}
		nothing(Material.BLAZE_POWDER, Material.BREAD);
		nothing(Material.CLAY, Material.COCOA);
		a(Material.COMPASS);
		nothing(Material.DIRT, Material.ENDER_STONE);
		nothing(Material.FIRE, Material.GRAVEL);
		nothing(Material.GRILLED_PORK, Material.ICE, Material.LAVA, Material.LEATHER);
		nothing(Material.LONG_GRASS, Material.MAGMA_CREAM, Material.MUSHROOM_SOUP);
	}
	
	private static void nothing(Material... materials) {
		for (Material m : materials) {
			nothingOne(m);
		}
	}
	
	private static void nothingOne(Material m) {
		needsA.remove(m);
		needsAn.remove(m);
		needsNothing.add(m);
	}
	
	private static void a(Material... materials) {
		for (Material m : materials) {
			aOne(m);
		}
	}
	
	private static void aOne(Material m) {
		needsNothing.remove(m);
		needsAn.remove(m);
		needsA.add(m);
	}
	
	private static void an(Material... materials) {
		for (Material m : materials) {
			anOne(m);
		}
	}
	
	private static void anOne(Material m) {
		needsNothing.remove(m);
		needsA.remove(m);
		needsAn.add(m);
	}
}
