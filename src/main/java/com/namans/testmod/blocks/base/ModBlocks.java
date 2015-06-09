package com.namans.testmod.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.testmod.blocks.basic.BasicBlock;
import com.namans.testmod.core.main.ModConfig;

public enum ModBlocks {
	
	BASIC(BasicBlock.class, "tutorial_block");
	
	private Block block;
	private Class c;
	private String blockName;

	private ModBlocks(Class c, String blockName) {
		this.c = c;
		this.blockName = blockName;
		try {
			block = (Block) c.getConstructor(String.class).newInstance(blockName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Block getBlock() {
		return block;
	}
	public ItemStack getNewItemStack() {
		return new ItemStack(getBlock());
	}
	public ItemStack getNewItemStack(int amount, int metaData) {
		return new ItemStack(getBlock(), amount, metaData);
	}
	public String getBlockName() {
		return blockName;
	}
	public ModelResourceLocation getResource() {
		return new ModelResourceLocation(ModConfig.MOD_ID + ":" + getBlock().getUnlocalizedName().substring(5), "inventory");
	}
	public static void registerAll() {
		for (ModBlocks block : ModBlocks.values()) {
			Block b = block.getBlock(); 
			b.setLightLevel(1.0f);
		    GameRegistry.registerBlock(b, block.getBlockName());
		}
	}
	public static void registerAllRenderers() {
	    for (ModBlocks block : ModBlocks.values()) {
	    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block.getBlock()), 0, block.getResource());
    	}
	}
}