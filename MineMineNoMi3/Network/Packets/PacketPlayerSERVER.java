package MineMineNoMi3.Network.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import MineMineNoMi3.Values;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Network.AbstractServerMessageHandler;
import MineMineNoMi3.Network.PacketDispatcher;

public class PacketPlayerSERVER implements IMessage
{
	private String cmd;
	
	public PacketPlayerSERVER() {}
	
	public PacketPlayerSERVER(String cmd) 
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
	
	public static class Handler extends AbstractServerMessageHandler<PacketPlayerSERVER> 
	{	 
		public IMessage handleServerMessage(EntityPlayer player, PacketPlayerSERVER message, MessageContext ctx) 
		{
			if(message.cmd.equals("delete_book"))
				player.inventory.removeStackFromSlot(player.inventory.getSlotFor(new ItemStack(ListMisc.CharacterCreator)));
			if(message.cmd.equals("forcesync"))
				PacketDispatcher.sendTo(new PacketSyncCLIENT(player.getCapability(Values.CAPABILITIES_PLAYER, null)), (EntityPlayerMP) player);
			return null;
		}
	}
	
}
