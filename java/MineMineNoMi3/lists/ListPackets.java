package MineMineNoMi3.lists;

import MineMineNoMi3.packets.PacketPlayer;
import MineMineNoMi3.packets.PacketSync;
import MineMineNoMi3.packets.PacketWorld;
import WyPI.modules.WyNetworkHelper;
import net.minecraftforge.fml.relauncher.Side;

public class ListPackets
{

	public static void init()
	{  
		/*WyNetworkHelper.instance().registerMessage(PacketSync.ClientHandler.class, PacketSync.class, 1, Side.CLIENT);
		WyNetworkHelper.instance().registerMessage(PacketSync.ServerHandler.class, PacketSync.class, 2, Side.SERVER);
		WyNetworkHelper.instance().registerMessage(PacketPlayer.ClientHandler.class, PacketPlayer.class, 3, Side.CLIENT);
		WyNetworkHelper.instance().registerMessage(PacketPlayer.ServerHandler.class, PacketPlayer.class, 4, Side.SERVER);
		WyNetworkHelper.instance().registerMessage(PacketWorld.ServerHandler.class, PacketWorld.class, 5, Side.SERVER);*/
	} 
	
}
