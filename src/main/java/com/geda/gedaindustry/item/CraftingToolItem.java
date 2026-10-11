package com.geda.gedaindustry.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

/**
 * Attrezzo da crafting (martello, tagliafili): quando lo usi in una ricetta
 * resta nella griglia e perde 1 punto di durabilità. Quando si consuma del tutto, sparisce.
 */
public class CraftingToolItem extends Item {
	public CraftingToolItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemStackTemplate getCraftingRemainder(ItemStack stack) {
		if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
			ItemStack moreDamaged = stack.copy();
			moreDamaged.setCount(1);
			moreDamaged.setDamageValue(stack.getDamageValue() + 1);
			return ItemStackTemplate.fromNonEmptyStack(moreDamaged);
		}

		// Attrezzo rotto: non lascia niente.
		return null;
	}
}
