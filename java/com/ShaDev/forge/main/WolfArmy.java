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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
		aliases.add("ws");
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
		return "/WolfArmy <normal/Enchanced> <EnchancedLevel> <AmryAmount>";
	}

	@Override
	public List getAliases() {
		return aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args){
		int Type = 0;
		int GodLevel = 0;
		int AlongTime = 500000000;
		if(args.length != 3){
			sender.addChatMessage(new ChatComponentText("Invalid Number Of Arguments"));
		}try{
			Type = Integer.parseInt(args[0]);
			GodLevel = Integer.parseInt(args[1]);
			Amount = Integer.parseInt(args[2]);			
		}catch(NumberFormatException n){
			sender.addChatMessage(new ChatComponentText("NaN , Please Type a VALID number !"));
			return;
		}
		EntityPlayer Player = (EntityPlayer) sender;
		UUID playeruuid = Player.getUniqueID();
		String Euuid = playeruuid.toString();
		if(Type == 0){
			for(int i = 0; i < Amount; i++){
				EntityWolf wolfy = new EntityWolf(Player.worldObj);
				wolfy.setOwnerId(Euuid);
				wolfy.setTamed(true);
				wolfy.setCollarColor(EnumDyeColor.MAGENTA);
				wolfy.setLocationAndAngles(Player.posX, Player.posY, Player.posZ, 0, 0);
				Player.worldObj.spawnEntityInWorld(wolfy);
			}
		}else if(Type == 1){
			for(int i = 0; i < Amount; i++){
				EntityWolf wolfy = new EntityWolf(Player.worldObj);
				wolfy.setOwnerId(Euuid);
				wolfy.setTamed(true);
				wolfy.setCollarColor(EnumDyeColor.MAGENTA);
				wolfy.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,AlongTime,GodLevel));
				wolfy.addPotionEffect(new PotionEffect(Potion.damageBoost.id,AlongTime, GodLevel));
				wolfy.addPotionEffect(new PotionEffect(Potion.regeneration.id,AlongTime, GodLevel));
				wolfy.setLocationAndAngles(Player.posX, Player.posY, Player.posZ, 0, 0);
				Player.worldObj.spawnEntityInWorld(wolfy);
				}
		}
		Player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[+]" + " Summoned " + Amount + " Wolfez"));
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