package xyz.pixelatedw.MineMineNoMi3.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandAbility extends CommandBase
{		
	public void processCommand(ICommandSender sender, String[] str) 
	{
		if(str.length >= 3)
		{
			EntityPlayer player = null;
			ExtendedEntityStats props = null;
			
			if(str.length == 3)
			{
				try{player = this.getCommandSenderAsPlayer(sender);}
				catch(PlayerNotFoundException e){e.printStackTrace();}
				props = ExtendedEntityStats.get(player);
			}
			if(str.length == 4)
			{
				player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(str[3]);	
				props = ExtendedEntityStats.get(player);
			}

			if(str[0].equals("+"))
			{
				if(str[1].equals("df"))
					props.addDevilFruitAbility(AbilityManager.instance().getAbilityByName(str[2]));
				else if(str[1].equals("r"))
					props.addRacialAbility(AbilityManager.instance().getAbilityByName(str[2]));
				else if(str[1].equals("h"))		
					props.addHakiAbility(AbilityManager.instance().getAbilityByName(str[2]));
			}
			else if(str[0].equals("-"))
			{
				if(str[1].equals("df"))
					props.removeDevilFruitAbility(AbilityManager.instance().getAbilityByName(str[2]));
				else if(str[1].equals("r"))
					props.removeRacialAbility(AbilityManager.instance().getAbilityByName(str[2]));
				else if(str[1].equals("h"))		
					props.removeHakiAbility(AbilityManager.instance().getAbilityByName(str[2]));
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
		return "/abl <+/-> <df/r/h> <ability> [player]";
	}

	public String getCommandName() 
	{
		return "abl";
	}

}
