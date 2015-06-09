package com.namans.testmod.items.base;

import com.namans.testmod.core.main.ModConfig;
import com.namans.testmod.items.basic.BasicItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum ModItems {
	
	BASIC(BasicItem.class, "tutorial_item");
	
	private Item item;
	private Class c;
	private String itemName;

	private ModItems(Class c, String itemName) {
		this.c = c;
		this.itemName = itemName;
		try {
			item = (Item) c.getConstructor(String.class).newInstance(itemName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Item getItem() {
		return item;
	}
	public ItemStack getNewItemStack() {
		return new ItemStack(getItem());
	}
	public ItemStack getNewItemStack(int amount, int metaData) {
		return new ItemStack(getItem(), amount, metaData);
	}
	public String getItemName() {
		return itemName;
	}
	public ModelResourceLocation getResource() {
		return new ModelResourceLocation(ModConfig.MOD_ID + ":" + getItem().getUnlocalizedName().substring(5), "inventory");
	}
	public static void registerAll() {
		for (ModItems item : ModItems.values()) {
			GameRegistry.registerItem(item.getItem(), item.getItemName());
		}
	}
	public static void registerAllRenderers() {
	    for (ModItems item : ModItems.values()) {
	    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item.getItem(), 0, item.getResource());
		}
	}
}