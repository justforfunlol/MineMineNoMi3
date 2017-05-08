package WyPI.modules;

import WyPI.WyPI;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class WyNetworkHelper
{
 
	public static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("WyPINetwork");
	private static WyNetworkHelper instance;
	public static WyNetworkHelper instance() 
	{ 
		if(instance == null) instance = new WyNetworkHelper();
		return instance;
	}

	public final void registerMessage(Class handlerClass, Class messageClass, int id, Side side) 
	{
		dispatcher.registerMessage(handlerClass, messageClass, id, side);
	}
	
	public final void sendTo(IMessage message, EntityPlayerMP player)
	{
		dispatcher.sendTo(message, player);
	}
	
	public final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range)
	{
		dispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}
	
	public final void sendToDimension(IMessage message, int dimensionId)
	{
		dispatcher.sendToDimension(message, dimensionId);
	}

	public final void sendToServer(IMessage message)
	{
		dispatcher.sendToServer(message);
	}

}
