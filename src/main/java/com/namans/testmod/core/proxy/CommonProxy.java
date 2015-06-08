package com.namans.testmod.core.proxy;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.namans.testmod.blocks.base.ModBlocks;
import com.namans.testmod.crafting.ModCrafting;
import com.namans.testmod.items.base.ModItems;


public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.registerAll();
		ModBlocks.registerAll();
	}
	public void init(FMLInitializationEvent e) {
		ModCrafting.initCrafting();
	}
	public void postInit(FMLPostInitializationEvent e) {
	}
}
