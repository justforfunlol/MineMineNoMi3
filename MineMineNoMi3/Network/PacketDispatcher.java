package MineMineNoMi3.Network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import MineMineNoMi3.Network.Packets.PacketPlayerCLIENT;
import MineMineNoMi3.Network.Packets.PacketPlayerSERVER;
import MineMineNoMi3.Network.Packets.PacketSyncCLIENT;
import MineMineNoMi3.Network.Packets.PacketSyncSERVER;

public class PacketDispatcher
{
	private static byte packetId = 0;

	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("mmnm");

	public static final void registerPackets() 
	{
		PacketDispatcher.registerMessage(PacketSyncCLIENT.Handler.class, PacketSyncCLIENT.class, Side.CLIENT);
		PacketDispatcher.registerMessage(PacketSyncSERVER.Handler.class, PacketSyncSERVER.class, Side.SERVER);
		PacketDispatcher.registerMessage(PacketPlayerCLIENT.Handler.class, PacketPlayerCLIENT.class, Side.CLIENT);
		PacketDispatcher.registerMessage(PacketPlayerSERVER.Handler.class, PacketPlayerSERVER.class, Side.SERVER);
	}

	private static final void registerMessage(Class handlerClass, Class messageClass, Side side) 
	{
		PacketDispatcher.dispatcher.registerMessage(handlerClass, messageClass, packetId++, side);
	}

	public static final void sendTo(IMessage message, EntityPlayerMP player) 
	{
	PacketDispatcher.dispatcher.sendTo(message, player);
	}

	public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) 
	{
		PacketDispatcher.dispatcher.sendToAllAround(message, point);
	}

	public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) 
	{
		PacketDispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}

	public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) 
	{
		PacketDispatcher.sendToAllAround(message, player.worldObj.provider.getDimension(), player.posX, player.posY, player.posZ, range);
	}

	public static final void sendToDimension(IMessage message, int dimensionId) 
	{
		PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
	}

	public static final void sendToServer(IMessage message)
	{
		PacketDispatcher.dispatcher.sendToServer(message);
	}
}