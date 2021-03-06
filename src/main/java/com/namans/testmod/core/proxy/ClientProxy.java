package com.namans.testmod.core.proxy;


import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.namans.testmod.blocks.base.ModBlocks;
import com.namans.testmod.items.base.ModItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ModItems.registerAllRenderers();
		ModBlocks.registerAllRenderers();
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}
