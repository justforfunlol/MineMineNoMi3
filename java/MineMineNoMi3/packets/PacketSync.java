package MineMineNoMi3.packets;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.capability.EntityCapability.Storage;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSync implements IMessage
{
	public NBTTagCompound data;

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
	
	public static class ClientHandler implements IMessageHandler<PacketSync, IMessage>
	{ 
		public IMessage onMessage(final PacketSync message, final MessageContext ctx) 
		{
			final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			final IEntityCapability props = player != null ? player.getCapability(Values.ENTITY_CAPABILITIES, null) : null;
			 
            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable() 
            { 
                public void run() 
                {
                	if(props != null)
                		EntityCapability.Storage.storage.readNBT(Values.ENTITY_CAPABILITIES, player.getCapability(Values.ENTITY_CAPABILITIES, null), null, message.data);
                }
            });			
			return null;
		}
	}
	
	public static class ServerHandler implements IMessageHandler<PacketSync, IMessage>
	{
		public IMessage onMessage(final PacketSync message, final MessageContext ctx) 
		{
			final EntityPlayer player = ctx.getServerHandler().playerEntity;
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			 
            IThreadListener mainThread = (WorldServer) player.worldObj;
            mainThread.addScheduledTask(new Runnable() 
            {
                public void run() 
                {
                	EntityCapability.Storage.storage.readNBT(Values.ENTITY_CAPABILITIES, player.getCapability(Values.ENTITY_CAPABILITIES, null), null, message.data);
                }
            });			
			return null;
		}
	}
}