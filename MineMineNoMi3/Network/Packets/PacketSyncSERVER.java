package MineMineNoMi3.Network.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Capability.PlayerCapability.Storage;
import MineMineNoMi3.Network.AbstractServerMessageHandler;

public class PacketSyncSERVER implements IMessage
{
	private NBTTagCompound data;

	public PacketSyncSERVER() {}

	public PacketSyncSERVER(IPlayerCapability props) 
	{
		data = (NBTTagCompound) Storage.storage.writeNBT(Values.CAPABILITIES_PLAYER, props, null);
	}

	public void fromBytes(ByteBuf buffer) 
	{
		data = ByteBufUtils.readTag(buffer);
	}
		 
	public void toBytes(ByteBuf buffer) 
	{
		ByteBufUtils.writeTag(buffer, data);
	}
	  
	public static class Handler extends AbstractServerMessageHandler<PacketSyncSERVER> 
	{	
		public IMessage handleServerMessage(EntityPlayer player, PacketSyncSERVER message, MessageContext ctx) 
		{
			Storage.storage.readNBT(Values.CAPABILITIES_PLAYER, player.getCapability(Values.CAPABILITIES_PLAYER, null), null, message.data);
			return null;
		}
	}
}