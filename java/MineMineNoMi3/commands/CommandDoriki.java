package MineMineNoMi3.commands;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.events.entityevents.DorikiEvent;
import MineMineNoMi3.packets.PacketSync;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

public class CommandDoriki extends CommandBase
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
				if(Integer.decode(str[1]) + props.getDoriki() <= Values.MAX_DORIKI)
					props.addDoriki(Integer.decode(str[1]));
				else
					props.setDoriki(Values.MAX_DORIKI);
			}
			else if(str[0].equals("-"))
			{
				if(props.getDoriki() - Integer.decode(str[1]) <= 0)
					props.setDoriki(0);
				else
					props.decDoriki(Integer.decode(str[1]));		
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
					props.setDoriki(Values.MAX_DORIKI);
				else if(Integer.decode(str[1]) <= Values.MAX_DORIKI)
					props.setDoriki(Integer.decode(str[1]));
			}
			
			DorikiEvent e = new DorikiEvent(player);
			if (MinecraftForge.EVENT_BUS.post(e)) return;
			WyNetworkHelper.instance().sendTo(new PacketSync(props), (EntityPlayerMP)player);
		}		
	}
	
	public String getCommandName() 
	{
		return "doriki";
	}
	
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/doriki <+/-/=> <amount> [player]";
	}
}
