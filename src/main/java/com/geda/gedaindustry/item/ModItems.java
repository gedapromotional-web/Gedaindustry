package com.geda.gedaindustry.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import com.geda.gedaindustry.GedaIndustry;

public class ModItems {
	// Tutti gli oggetti della mod, nell'ordine in cui li registriamo (serve alla scheda creativa).
	public static final List<Item> ALL = new ArrayList<>();

	// Attrezzi da crafting
	public static final Item HAMMER = register("hammer", CraftingToolItem::new, new Item.Properties().durability(128));
	public static final Item WIRE_CUTTERS = register("wire_cutters", CraftingToolItem::new, new Item.Properties().durability(128));

	// Stagno
	public static final Item RAW_TIN = simple("raw_tin");
	public static final Item TIN_INGOT = simple("tin_ingot");
	public static final Item TIN_NUGGET = simple("tin_nugget");

	// Bronzo
	public static final Item BRONZE_INGOT = simple("bronze_ingot");
	public static final Item BRONZE_NUGGET = simple("bronze_nugget");

	// Acciaio
	public static final Item STEEL_INGOT = simple("steel_ingot");
	public static final Item STEEL_NUGGET = simple("steel_nugget");

	// Polveri
	public static final Item IRON_DUST = simple("iron_dust");
	public static final Item COPPER_DUST = simple("copper_dust");
	public static final Item GOLD_DUST = simple("gold_dust");
	public static final Item TIN_DUST = simple("tin_dust");
	public static final Item BRONZE_DUST = simple("bronze_dust");

	// Piastre
	public static final Item IRON_PLATE = simple("iron_plate");
	public static final Item COPPER_PLATE = simple("copper_plate");
	public static final Item GOLD_PLATE = simple("gold_plate");
	public static final Item TIN_PLATE = simple("tin_plate");
	public static final Item BRONZE_PLATE = simple("bronze_plate");
	public static final Item STEEL_PLATE = simple("steel_plate");

	// Bacchette
	public static final Item IRON_ROD = simple("iron_rod");
	public static final Item STEEL_ROD = simple("steel_rod");

	// Ingranaggi
	public static final Item IRON_GEAR = simple("iron_gear");
	public static final Item BRONZE_GEAR = simple("bronze_gear");
	public static final Item STEEL_GEAR = simple("steel_gear");

	// Fili
	public static final Item COPPER_WIRE = simple("copper_wire");
	public static final Item GOLD_WIRE = simple("gold_wire");
	public static final Item STEEL_WIRE = simple("steel_wire");

	private static Item simple(String name) {
		return register(name, Item::new, new Item.Properties());
	}

	public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
		// La "chiave" dell'oggetto, per esempio gedaindustry:tin_ingot
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, GedaIndustry.id(name));

		// Crea l'oggetto e lo registra nel gioco.
		Item item = itemFactory.apply(settings.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		ALL.add(item);
		return item;
	}

	public static void initialize() {
		// Basta caricare la classe: gli oggetti qui sopra vengono registrati.
	}
}
