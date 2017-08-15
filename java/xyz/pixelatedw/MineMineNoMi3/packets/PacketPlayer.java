package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.MainKeys;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator;

public class PacketPlayer implements IMessage
{
	private String cmd;
	
	public PacketPlayer() {}
	
	public PacketPlayer(String cmd) 
	{
		this.cmd = cmd;
	}
	
	public void fromBytes(ByteBuf buf) 
	{
		this.cmd = ByteBufUtils.readUTF8String(buf);
	}

	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.cmd);
	}

	public static class ServerHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		public IMessage onMessage(PacketPlayer message, MessageContext ctx) 
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
	
			if(message.cmd.equals("delete_book"))
				for(ItemStack is : player.inventory.mainInventory)
					if(is != null && is.getItem() instanceof CharacterCreator)
						WyHelper.removeStackFromInventory(player, is);
			if(message.cmd.equals("forcesync"))
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			if(message.cmd.contains("msg"))
				WyHelper.sendMsgToPlayer(player, message.cmd.replace("msg", ""));
			if(message.cmd.equals("enterCombatMode"))
			{
				props.setCombatMode(!props.isInCombatMode());
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			}
			for(int i = 0; i < 8; i++)
			{
				if(message.cmd.equals("useAbility" + i))
					if(props.getAbilityFromSlot(i) != null) props.getAbilityFromSlot(i).use(player);
			}
			
			return null;
		}
	}
	
}
