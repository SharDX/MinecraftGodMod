package com.ShaDev.forge.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ThunderBoltor extends Item { 
	public static Item Boltor;
	public ThunderBoltor(){
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName("ThunderBolter");
	}
	
	public ItemStack onItemRightClick(ItemStack stack,World world, EntityPlayer player) {
		 world.addWeatherEffect(new EntityLightningBolt(world, player.posX+1,player.posY,player.posZ));
	     if (!player.capabilities.isCreativeMode){
	    	 stack.stackSize--;
	     }
	     return stack;
	}

}