package MineMineNoMi3.packets;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.items.CharacterCreator;
import WyPI.modules.WyHelper;
import WyPI.modules.WyNetworkHelper;
import WyPI.network.AbstractClientMessageHandler;
import WyPI.network.AbstractServerMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketWorld implements IMessage
{
	protected int posX = 0, posY = 0, posZ = 0, blockId = -1;
	
	public PacketWorld() {}
	
	public PacketWorld(int posX, int posY, int posZ, int blockId) 
	{
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.blockId = blockId;
	}
	
	public void fromBytes(ByteBuf buf) 
	{
		this.posX = buf.readInt();
		this.posY = buf.readInt();
		this.posZ = buf.readInt();
		this.blockId = buf.readInt();
	}

	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(this.posX);
		buf.writeInt(this.posY);
		buf.writeInt(this.posZ);
		buf.writeInt(this.blockId);
	}
	 
	public static class ServerHandler implements IMessageHandler<PacketWorld, IMessage>
	{
		public IMessage onMessage(final PacketWorld message, final MessageContext ctx) 
		{
			final EntityPlayer player = ctx.getServerHandler().playerEntity;
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			
            IThreadListener mainThread = (WorldServer) player.worldObj;
            mainThread.addScheduledTask(new Runnable() 
            {
                public void run() 
                {
        			if(message.blockId != -1)
        				player.worldObj.setBlockState(new BlockPos(message.posX, message.posY, message.posZ), Block.getBlockById(message.blockId).getDefaultState());
                }
            });			
			return null;
		}
	}	
}
