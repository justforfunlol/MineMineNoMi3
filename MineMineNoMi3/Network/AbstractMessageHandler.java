package MineMineNoMi3.Network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import MineMineNoMi3.Main;

public abstract class AbstractMessageHandler<T extends IMessage> implements IMessageHandler <T, IMessage>
{

	@SideOnly(Side.CLIENT)
	public abstract IMessage handleClientMessage(EntityPlayer player, T message, MessageContext ctx);
	
	public abstract IMessage handleServerMessage(EntityPlayer player, T message, MessageContext ctx);

	public IMessage onMessage(T message, MessageContext ctx) 
	{
		if (ctx.side.isClient())
			return handleClientMessage(Main.proxy.getPlayerEntity(ctx), message, ctx);
		else
			return handleServerMessage(Main.proxy.getPlayerEntity(ctx), message, ctx);
	}
}