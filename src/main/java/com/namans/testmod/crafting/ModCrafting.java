package com.namans.testmod.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.testmod.blocks.base.ModBlocks;
import com.namans.testmod.items.base.ModItems;

public class ModCrafting {
	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BASIC.getBlock()),	"##","##",	'#', ModItems.BASIC.getItem());
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BASIC.getItem()), Items.redstone, new ItemStack(Items.dye, 1, 4));
		GameRegistry.addSmelting(Items.diamond, new ItemStack(ModItems.BASIC.getItem()), 1.0f);
	}
}
