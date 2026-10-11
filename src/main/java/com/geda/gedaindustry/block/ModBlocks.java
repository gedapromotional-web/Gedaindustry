package com.geda.gedaindustry.block;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.geda.gedaindustry.GedaIndustry;

public class ModBlocks {
	// Minerali: si comportano come quelli di ferro (serve almeno un piccone di pietra).
	public static final Block TIN_ORE = register("tin_ore", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE));
	public static final Block DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));

	// Blocchi di metallo
	public static final Block TIN_BLOCK = register("tin_block", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Block RAW_TIN_BLOCK = register("raw_tin_block", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK));
	public static final Block BRONZE_BLOCK = register("bronze_block", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	public static final Block STEEL_BLOCK = register("steel_block", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		Identifier identifier = GedaIndustry.id(name);
		BlockItemId id = BlockItemId.create(identifier, identifier);

		// Crea e registra il blocco.
		Block block = blockFactory.apply(properties.setId(id.block()));
		Registry.register(BuiltInRegistries.BLOCK, id.block(), block);

		// Crea e registra l'oggetto del blocco (quello che tieni in mano).
		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
		Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

		return block;
	}

	public static void initialize() {
		// Basta caricare la classe: i blocchi qui sopra vengono registrati.
	}
}
