package MineMineNoMi3.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Network.PacketDispatcher;
import MineMineNoMi3.Network.Packets.PacketSyncCLIENT;

public class CommandExtol extends CommandBase
{		
	public void execute(MinecraftServer server, ICommandSender sender, String[] str) throws CommandException 
	{
		if(str.length >= 2)
		{
			EntityPlayer player = null;
			IPlayerCapability props = null;
			
			if(str.length == 2)
			{
				try{player = this.getCommandSenderAsPlayer(sender);}
				catch(PlayerNotFoundException e){e.printStackTrace();}
				props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			}
			if(str.length == 3)
			{
				player = server.getPlayerList().getPlayerByUsername(str[2]);
				props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			}

			if(str[0].equals("+"))
			{
				if(Integer.decode(str[1]) + props.getExtol() <= Values.MAX_GENERAL)
					props.addExtol(Integer.decode(str[1]));
				else
					props.setExtol(Values.MAX_GENERAL);
			}
			else if(str[0].equals("-"))
			{
				if(props.getExtol() - Integer.decode(str[1]) <= 0)
					props.setExtol(0);
				else
					props.decExtol(Integer.decode(str[1]));		
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
					props.setExtol(Values.MAX_GENERAL);
				else if(Integer.decode(str[1]) <= Values.MAX_GENERAL)
					props.setExtol(Integer.decode(str[1]));
			}
			
			PacketDispatcher.sendTo(new PacketSyncCLIENT(props), (EntityPlayerMP)player);
		}		
	}

	public String getCommandName() 
	{
		return "extol";
	}
	
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/extol <+/-/=> <amount> [player]";
	}
}
