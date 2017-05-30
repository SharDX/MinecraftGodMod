package com.ShaDev.forge.main;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "Enchanced Craft !";
	public static final String VERSION = "0.12";
	@EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new AnvilKaboom());
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosions());
		MinecraftForge.EVENT_BUS.register(new HarderSurvival());
	}
	@EventHandler
	public void start(FMLServerStartingEvent event) 
	{
	    event.registerServerCommand(new FlameSomeCows());
	    event.registerServerCommand(new WolfArmy());
	}
	static final GodFood godFood = new GodFood();
	static final Block godBlock = new GodBlock();
	static final Item thunderBoltor = new ThunderBoltor();
	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(godBlock, "godBlock");
		GameRegistry.registerItem(thunderBoltor, "BoltSomeNobs");
		GameRegistry.registerItem(godFood, "Mtn Deu");
	}
	
}