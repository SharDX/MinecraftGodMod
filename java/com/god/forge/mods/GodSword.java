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
		 MovingObjectPosition trace = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(200, 1.0F);
		 int x = (int) trace.hitVec.xCoord;
		 int y = (int) trace.hitVec.yCoord;
		 int z = (int) trace.hitVec.zCoord;
		 world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
	     if (!player.capabilities.isCreativeMode){
	    	 stack.stackSize--;
	     }
	     return stack;
	}
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		int maxHp = (int) ((EntityLivingBase) entity).getHealth();
		entity.attackEntityFrom(DamageSource.generic, (maxHp/4)+10);
		return true;
	}
}
