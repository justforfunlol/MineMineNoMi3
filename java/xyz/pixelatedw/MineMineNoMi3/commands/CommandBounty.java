package xyz.pixelatedw.MineMineNoMi3.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandBounty extends CommandBase
{		
	public void processCommand(ICommandSender sender, String[] str) 
	{
		if(str.length >= 2)
		{
			EntityPlayer player = null;
			ExtendedEntityStats props = null;
			
			if(str.length == 2)
			{
				try{player = this.getCommandSenderAsPlayer(sender);}
				catch(PlayerNotFoundException e){e.printStackTrace();}
				props = ExtendedEntityStats.get(player);
			}
			if(str.length == 3)
			{
				player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(str[2]);	
				props = ExtendedEntityStats.get(player);
			}

			if(str[0].equals("+"))
			{
				if(Integer.decode(str[1]) + props.getBounty() <= Values.MAX_GENERAL)
					props.alterBounty(Integer.decode(str[1]));
				else
					props.setBounty(Values.MAX_GENERAL);
			}
			else if(str[0].equals("-"))
			{
				if(props.getBounty() - Integer.decode(str[1]) <= 0)
					props.setBounty(0);
				else
					props.alterBounty(-Integer.decode(str[1]));		
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
					props.setBounty(Values.MAX_GENERAL);
				else if(Integer.decode(str[1]) <= Values.MAX_GENERAL)
					props.setBounty(Integer.decode(str[1]));
			}
			 
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP)player);
		}		
	}

	public boolean canCommandSenderUseCommand(ICommandSender cmd)
	{
		return true;
	}
	
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/bounty <+/-/=> <amount> [player]";
	}

	public String getCommandName() 
	{
		return "bounty";
	}

}
