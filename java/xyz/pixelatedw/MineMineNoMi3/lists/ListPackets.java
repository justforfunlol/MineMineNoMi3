package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.relauncher.Side;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketWorld;

public class ListPackets 
{
	public static void init()
	{  
		WyNetworkHelper.registerMessage(PacketSync.ServerHandler.class, PacketSync.class, 1, Side.SERVER);
		WyNetworkHelper.registerMessage(PacketPlayer.ServerHandler.class, PacketPlayer.class, 2, Side.SERVER);
		WyNetworkHelper.registerMessage(PacketWorld.ServerHandler.class, PacketWorld.class, 3, Side.SERVER);
	} 
	
}
