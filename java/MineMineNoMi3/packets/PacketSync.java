package MineMineNoMi3.packets;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.capability.EntityCapability.Storage;
import WyPI.network.AbstractClientMessageHandler;
import WyPI.network.AbstractServerMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSync implements IMessage
{
	private NBTTagCompound data;

	public PacketSync() {}
	
	public PacketSync(IEntityCapability props) 
	{
		data = (NBTTagCompound) Storage.storage.writeNBT(Values.ENTITY_CAPABILITIES, props, null);
	}

	public void fromBytes(ByteBuf buffer) 
	{
		data = ByteBufUtils.readTag(buffer);
	}
	
	public void toBytes(ByteBuf buffer) 
	{
		ByteBufUtils.writeTag(buffer, data);
	} 
  
	public static class ClientHandler extends AbstractClientMessageHandler<PacketSync> 
	{	
		public IMessage handleClientMessage(EntityPlayer player, PacketSync message, MessageContext ctx) 
		{
			if(player != null)
				Storage.storage.readNBT(Values.ENTITY_CAPABILITIES, player.getCapability(Values.ENTITY_CAPABILITIES, null), null, message.data);
			return null;
		}
	}
	
	public static class ServerHandler extends AbstractServerMessageHandler<PacketSync> 
	{	
		public IMessage handleServerMessage(EntityPlayer player, PacketSync message, MessageContext ctx) 
		{
			if(player != null)
				Storage.storage.readNBT(Values.ENTITY_CAPABILITIES, player.getCapability(Values.ENTITY_CAPABILITIES, null), null, message.data);
			return null;
		}
	}
}