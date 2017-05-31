package com.god.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GodFood extends ItemFood{
	public GodFood(){
		super(10, 5, true);
		this.setAlwaysEdible();
		this.setNoRepair();
		this.isWolfsFavoriteMeat();
		this.setUnlocalizedName("GodFood");
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.resistance.id,3000, 100));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id,3000, 100));
		player.addPotionEffect(new PotionEffect(Potion.absorption.id,3000, 100));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,3000, 500));
		player.addPotionEffect(new PotionEffect(Potion.saturation.id,3000, 100));
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id,3000, 100));
	}
}
