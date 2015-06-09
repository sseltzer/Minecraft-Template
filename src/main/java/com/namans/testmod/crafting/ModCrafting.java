package com.namans.testmod.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.testmod.blocks.base.ModBlocks;
import com.namans.testmod.items.base.ModItems;

public class ModCrafting {
	public static void registerAll() {
		registerShapedRecipies();
		registerShapelessRecipies();
		registerSmeltingRecipies();
	}

	private static void registerShapedRecipies() {
		GameRegistry.addRecipe(ModBlocks.BASIC.getNewItemStack(), "##", "##", '#', ModItems.BASIC.getItem());
	}

	private static void registerShapelessRecipies() {
		GameRegistry.addShapelessRecipe(ModItems.BASIC.getNewItemStack(), Items.redstone, new ItemStack(Items.dye, 1, 4));
	}

	private static void registerSmeltingRecipies() {
		GameRegistry.addSmelting(Items.diamond, ModItems.BASIC.getNewItemStack(), 1.0f);
	}
}
