package com.ShaDev.forge.main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosions {
	float power = 64.0F;
	@SubscribeEvent
	public void Exoplode(EntityJoinWorldEvent event){
		if(!(event.entity instanceof EntityTNTPrimed)){
			return;
		}
	Entity entity = event.entity;
	event.entity.worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, true);
	}
}
