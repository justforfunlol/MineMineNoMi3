package MineMineNoMi3.Proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy 
{
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap();
	 
	public static void storeEntityData(String name, NBTTagCompound compound)
	{extendedEntityData.put(name, compound);}
	
	public static NBTTagCompound getEntityData(String name)
	{return extendedEntityData.remove(name);}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) 
	{return ctx.getServerHandler().playerEntity;}
	
	public void tick() {}
	public void render() {}
	
}
