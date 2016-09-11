package MineMineNoMi3.packets;

import MineMineNoMi3.Values;
import MineMineNoMi3.items.CharacterCreator;
import WyPI.modules.WyNetworkHelper;
import WyPI.network.AbstractClientMessageHandler;
import WyPI.network.AbstractServerMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

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
	
	public static class ClientHandler extends AbstractClientMessageHandler<PacketPlayer> 
	{	
		public IMessage handleClientMessage(EntityPlayer player, PacketPlayer message, MessageContext ctx) 
		{
			return null;
		}
	}
	
	public static class ServerHandler extends AbstractServerMessageHandler<PacketPlayer> 
	{	 
		public IMessage handleServerMessage(EntityPlayer player, PacketPlayer message, MessageContext ctx) 
		{
			if(message.cmd.equals("delete_book"))
				for(ItemStack is : player.inventory.mainInventory)
					if(is != null && is.getItem() instanceof CharacterCreator)
						player.inventory.deleteStack(is);
			if(message.cmd.equals("forcesync"))
				WyNetworkHelper.instance().sendTo(new PacketSync(player.getCapability(Values.ENTITY_CAPABILITIES, null)), (EntityPlayerMP) player);
			return null;
		}
	}
	
}
