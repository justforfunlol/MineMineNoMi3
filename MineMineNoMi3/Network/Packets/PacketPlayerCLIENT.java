package MineMineNoMi3.Network.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import org.lwjgl.input.Keyboard;

import MineMineNoMi3.Network.AbstractClientMessageHandler;
import WyPI.Ability.AbilityProjectile;

public class PacketPlayerCLIENT implements IMessage
{
	private String cmd;
	
	public PacketPlayerCLIENT() {}
	
	public PacketPlayerCLIENT(String cmd, int keyCode) 
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
	
	public static class Handler extends AbstractClientMessageHandler<PacketPlayerCLIENT> 
	{	
		public IMessage handleClientMessage(EntityPlayer player, PacketPlayerCLIENT message, MessageContext ctx) 
		{
			return null;
		}
	}
	
}
