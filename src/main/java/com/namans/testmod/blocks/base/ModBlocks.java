package com.namans.testmod.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.testmod.blocks.basic.BasicBlock;
import com.namans.testmod.core.main.ModConfig;
import com.namans.testmod.items.basic.BasicItem;

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
	public String getBlockName() {
		return blockName;
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
	    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block.getBlock()), 0, new ModelResourceLocation(ModConfig.MOD_ID  + ":" + block.getBlock().getUnlocalizedName().substring(5), "inventory"));
    	}
	}
}