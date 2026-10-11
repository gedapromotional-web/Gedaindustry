package com.geda.gedaindustry.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import com.geda.gedaindustry.GedaIndustry;
import com.geda.gedaindustry.block.ModBlocks;

public class ModCreativeTab {
	public static final ResourceKey<CreativeModeTab> KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(), GedaIndustry.id("main")
	);

	// La scheda "Geda Industry" della modalità creativa.
	public static final CreativeModeTab TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.HAMMER))
			.title(Component.translatable("itemGroup.gedaindustry"))
			.displayItems((params, output) -> {
				// Prima i blocchi, poi tutti gli oggetti nell'ordine in cui sono registrati.
				output.accept(ModBlocks.TIN_ORE);
				output.accept(ModBlocks.DEEPSLATE_TIN_ORE);
				output.accept(ModBlocks.RAW_TIN_BLOCK);
				output.accept(ModBlocks.TIN_BLOCK);
				output.accept(ModBlocks.BRONZE_BLOCK);
				output.accept(ModBlocks.STEEL_BLOCK);
				for (Item item : ModItems.ALL) {
					output.accept(item);
				}
			})
			.build();

	public static void initialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, KEY, TAB);
	}
}
