package xyz.pixelatedw.MineMineNoMi3.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.DorikiEvent;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandDoriki extends CommandBase
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
				if(Integer.decode(str[1]) + props.getDoriki() <= Values.MAX_DORIKI)
					props.alterDoriki(Integer.decode(str[1]));
				else
					props.setDoriki(Values.MAX_DORIKI);
			}
			else if(str[0].equals("-"))
			{
				if(props.getDoriki() - Integer.decode(str[1]) <= 0)
					props.setDoriki(0);
				else
					props.alterDoriki(-Integer.decode(str[1]));		
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
					props.setDoriki(Values.MAX_DORIKI);
				else if(Integer.decode(str[1]) <= Values.MAX_DORIKI)
					props.setDoriki(Integer.decode(str[1]));
			}
			 
			DorikiEvent e = new DorikiEvent(player);
			if (MinecraftForge.EVENT_BUS.post(e))
				return;
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP)player);
		}		
	}

	public boolean canCommandSenderUseCommand(ICommandSender cmd)
	{
		return true;
	}
	
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/doriki <+/-/=> <amount> [player]";
	}

	public String getCommandName() 
	{
		return "doriki";
	}

}
