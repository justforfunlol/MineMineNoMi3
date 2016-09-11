package MineMineNoMi3.commands;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.packets.PacketSync;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandBelly extends CommandBase
{		
	public void execute(MinecraftServer server, ICommandSender sender, String[] str) throws CommandException 
	{
		if(str.length >= 2)
		{
			EntityPlayer player = null;
			IEntityCapability props = null;
			
			if(str.length == 2)
			{
				try{player = this.getCommandSenderAsPlayer(sender);}
				catch(PlayerNotFoundException e){e.printStackTrace();}
				props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			}
			if(str.length == 3)
			{
				player = server.getPlayerList().getPlayerByUsername(str[2]);	
				props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			}

			if(str[0].equals("+"))
			{
				if(Integer.decode(str[1]) + props.getBelly() <= Values.MAX_GENERAL)
					props.addBelly(Integer.decode(str[1]));
				else
					props.setBelly(Values.MAX_GENERAL);
			}
			else if(str[0].equals("-"))
			{
				if(props.getBelly() - Integer.decode(str[1]) <= 0)
					props.setBelly(0);
				else
					props.decBelly(Integer.decode(str[1]));		
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
					props.setBelly(Values.MAX_GENERAL);
				else if(Integer.decode(str[1]) <= Values.MAX_GENERAL)
					props.setBelly(Integer.decode(str[1]));
			}
			 
			WyNetworkHelper.instance().sendTo(new PacketSync(props), (EntityPlayerMP)player);
		}		
	}

	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/belly <+/-/=> <amount> [player]";
	}

	public String getCommandName() 
	{
		return "belly";
	}

}
