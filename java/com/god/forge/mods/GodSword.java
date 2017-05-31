package com.god.forge.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GodSword extends Item { 
	public static Item Boltor;
	public GodSword(){
		super();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("godSword");
	}
	
	public ItemStack onItemRightClick(ItemStack stack,World world, EntityPlayer player) {
		 world.addWeatherEffect(new EntityLightningBolt(world, player.posX+2,player.posY,player.posZ));
	     if (!player.capabilities.isCreativeMode){
	    	 stack.stackSize--;
	     }
	     return stack;
	}
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		int maxHp = (int) ((EntityLivingBase) entity).getHealth();
		entity.attackEntityFrom(DamageSource.generic, maxHp/3);
		return true;
	}
}