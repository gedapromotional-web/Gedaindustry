package com.geda.gedaindustry.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import com.geda.gedaindustry.GedaIndustry;

public class ModWorldGen {
	// Definito in data/gedaindustry/worldgen/placed_feature/ore_tin.json
	public static final ResourceKey<PlacedFeature> ORE_TIN = ResourceKey.create(
			Registries.PLACED_FEATURE, GedaIndustry.id("ore_tin")
	);

	public static void initialize() {
		// Il minerale di stagno compare in tutti i biomi dell'Overworld.
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ORE_TIN
		);
	}
}
