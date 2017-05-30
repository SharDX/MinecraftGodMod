package com.ShaDev.forge.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;


public class FlameSomeCows implements ICommand
{ 
    private final List aliases;
    private int NumberOfCows = 0;
    public FlameSomeCows() 
    { 
        aliases = new ArrayList(); 
        // These are the commands that can be used to invoke your command
        aliases.add("FlameSomeCows"); 
        aliases.add("KFC");
    } 

    @Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getName() 
    { 
        // The big name of your command
        return "FlameSomeCows"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    {
        // Help file summary
        return "FlameSomeCows <Number>";
    }

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    {
        // Can the user use this command I think
        return true;
    }

    @Override
    public List getAliases() 
    {
        // Return all the aliases
        return aliases;
    }

    @Override
    public void execute(ICommandSender sender, String[] args)
    {
            if (args.length != 1)
            {
                sender.addChatMessage(new ChatComponentText("Invalid Number of Arguments"));
                return;
            }
            try{
            	NumberOfCows = Integer.parseInt(args[0]);	
            }catch(NumberFormatException e){
            	sender.addChatMessage(new ChatComponentText("invalid Number"));
            	return;
            }
            EntityPlayer player = (EntityPlayer) sender;
            for (int i = 0; i < NumberOfCows ; i++ ){
            	EntityCow cow = new EntityCow(player.worldObj);
            	cow.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
            	cow.setFire(5000);
            	player.worldObj.spawnEntityInWorld(cow);
            }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos)
    {
        return null;
    }

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		return true;
	}
	private void sendErrorMessage (ICommandSender sender, String message) { 
		sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED+ message));
	}
}