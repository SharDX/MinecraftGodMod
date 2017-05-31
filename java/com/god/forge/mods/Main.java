package com.god.forge.mods;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static GodFood godFood;
	public static GodBlock godBlock;
	public static Item godSword;
	public static final String MODID = "MyMods";
	public static final String VERSION = "0.2";
	@EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new AnvilKaboom());
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosions());
		MinecraftForge.EVENT_BUS.register(new HarderSurvival());
		godFood = new GodFood();
		GameRegistry.registerItem(godFood, "godFood");
		godBlock = new GodBlock();
		GameRegistry.registerBlock(godBlock, "godBlock");
		godSword = new GodSword();
		GameRegistry.registerItem(godSword, "godSword");
		
		//textures ..
		Item godgodSwordItem = GameRegistry.findItem("mymods", "godSword");
		ModelResourceLocation godgodSwordModel = new ModelResourceLocation("mymods:godSword","inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(godgodSwordItem, 0, godgodSwordModel);
	}
	@EventHandler
	public void start(FMLServerStartingEvent event) 
	{
	    event.registerServerCommand(new FlameSomeCows());
	    event.registerServerCommand(new WolfArmy());
	    event.registerServerCommand(new SkeltonSpawner());
	}

}