package com.god.forge.mods;

import java.util.Random;

import javafx.scene.paint.Color;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
public class GodBlock extends Block{
	public static Block NoorBlock;
	public GodBlock(){
		super(Material.iron);
		this.setUnlocalizedName("GodBlock");
		this.setHardness(4.0F);
		this.setResistance(50.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(50.0F);
		this.setLightOpacity(0);
		this.slipperiness = 2;
		}
	@Override
	public Item getItemDropped(IBlockState state, Random random, int i2) {
		return Main.godFood;
	}
		
	@Override
	public int quantityDropped(Random random) {
		return random.nextInt(2) + 3; 
	}
	
}


