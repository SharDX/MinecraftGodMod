package com.god.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SkeltonSpawner implements ICommand{
	public static List aliases;
	private int Amount = 0;
	public SkeltonSpawner(){
		aliases = new ArrayList();
		aliases.add("SkeletonSpawner");
		aliases.add("ss");
	}
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "SkeletonSpawner";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/sp || /SkeletonSpawner <Amount Of Skeletons>";
	}

	@Override
	public List getAliases() {
		return aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if(args.length != 1){
			sender.addChatMessage(new ChatComponentText("Invalid Number Of Arguments"));
		}try{
			Amount = Integer.parseInt(args[0]);
		}catch(NumberFormatException n){
			sender.addChatMessage(new ChatComponentText("NaN , Please enter a VALID number"));
			return;
		}
		EntityPlayer player = (EntityPlayer) sender;
		for(int i=0; i < Amount;i++){
			EntitySkeleton skeleton = new EntitySkeleton(player.worldObj);
			skeleton.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
			skeleton.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_chestplate));
			skeleton.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
			player.worldObj.spawnEntityInWorld(skeleton);
		}
		player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[+]" + "Summoned " + Amount + " Skeletons !"));
	} 

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return true;
	}

}
