package MineMineNoMi3.packets;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityArlong;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityChew;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityKuroobi;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr0;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr1;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr3;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr5;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityDonKrieg;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityGin;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityPearl;
import MineMineNoMi3.items.CharacterCreator;
import WyPI.modules.WyHelper;
import WyPI.modules.WyNetworkHelper;
import WyPI.network.AbstractClientMessageHandler;
import WyPI.network.AbstractServerMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
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
	
	
	public static class ClientHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		public IMessage onMessage(final PacketPlayer message, final MessageContext ctx) 
		{
			final EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable() 
            {
                public void run() 
                {
        			if(message.cmd.contains("msg"))
        				WyHelper.instance().sendMsgToPlayer(player, message.cmd.replace("msg", ""));
                }
            });			
			return null;
		}
	}
 
	public static class ServerHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		public IMessage onMessage(final PacketPlayer message, final MessageContext ctx) 
		{
			final EntityPlayer player = ctx.getServerHandler().playerEntity;
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			
            IThreadListener mainThread = (WorldServer) player.worldObj;
            mainThread.addScheduledTask(new Runnable() 
            {
                public void run() 
                {
        			if(message.cmd.equals("delete_book"))
        				for(ItemStack is : player.inventory.mainInventory)
        					if(is != null && is.getItem() instanceof CharacterCreator)
        						player.inventory.deleteStack(is);
        			if(message.cmd.equals("forcesync"))
        				WyNetworkHelper.instance().sendTo(new PacketSync(player.getCapability(Values.ENTITY_CAPABILITIES, null)), (EntityPlayerMP) player);
        			if(message.cmd.contains("msg"))
        				WyHelper.instance().sendMsgToPlayer(player, message.cmd.replace("msg", ""));
                }
            });			
			return null;
		}
	}
	
}
