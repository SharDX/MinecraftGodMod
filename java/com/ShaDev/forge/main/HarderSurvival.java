package com.ShaDev.forge.main;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HarderSurvival {
	@SubscribeEvent
	public void SkeletonsComeBack(LivingDeathEvent event){
		if(!(event.entity instanceof EntityZombie)){
			return;
		}
		EntityZombie BabyZombie = new EntityZombie(event.entity.worldObj);
		for(int i =0; i < 3;i++){
			BabyZombie.setChild(true);
			BabyZombie.setLocationAndAngles(
					event.entity.posX,
					event.entity.posY,
					event.entity.posZ, 0, 0
					);
			
		event.entity.worldObj.spawnEntityInWorld(BabyZombie);
	}
}
}
