package com.geda.gedaindustry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geda.gedaindustry.block.ModBlocks;
import com.geda.gedaindustry.item.ModCreativeTab;
import com.geda.gedaindustry.item.ModItems;
import com.geda.gedaindustry.world.ModWorldGen;

public class GedaIndustry implements ModInitializer {
	public static final String MOD_ID = "gedaindustry";

	// Scrive messaggi nella console e nel file di log di Minecraft.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Questo codice parte appena Minecraft carica la mod.
		ModItems.initialize();
		ModBlocks.initialize();
		ModCreativeTab.initialize();
		ModWorldGen.initialize();

		LOGGER.info("Ciao dal mondo di Geda Industry!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
