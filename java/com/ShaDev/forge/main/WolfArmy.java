package com.ShaDev.forge.main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;


public class WolfArmy implements ICommand
{
	public final List aliases;
	private int Amount = 0;
	private String Color = "";
	public WolfArmy(){
		aliases = new ArrayList();
		aliases.add("wolfArmy");
		aliases.add("wa");
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getName() {
		return "WolfArmy";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "WolfArmy <AmryAmount>";
	}

	@Override
	public List getAliases() {
		return aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args){
		if(args.length != 1){
			sender.addChatMessage(new ChatComponentText("Invalid Number Of Arguments"));
		}try{ Amount = Integer.parseInt(args[0]);			
		}catch(NumberFormatException n){
			sender.addChatMessage(new ChatComponentText("NaN , Please Type a VALID number !"));
			return;
		}
		EntityPlayer Player = (EntityPlayer) sender;
		UUID playeruuid = Player.getUniqueID();
		String Euuid = playeruuid.toString();
		for(int i = 0; i < Amount; i++){
		EntityWolf wolfy = new EntityWolf(Player.worldObj);
		wolfy.setOwnerId(Euuid);
		wolfy.setTamed(true);
		wolfy.setCollarColor(EnumDyeColor.MAGENTA);
		wolfy.setLocationAndAngles(Player.posX, Player.posY, Player.posZ, 0, 0);
		Player.worldObj.spawnEntityInWorld(wolfy);
		}
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		// TODO Auto-generated method stub
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