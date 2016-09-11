package WyPI.modules;

import WyPI.Module;
import WyPI.WyPI;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class WyRegistry extends Module
{

	private int entityID = 100;
	private int packetID = 0;
	
	private static WyRegistry instance;
	public static WyRegistry instance() 
	{ 
		if(instance == null) instance = new WyRegistry(WyPI.apiInstance);
		return instance;
	}
	
	public WyRegistry(WyPI instance)
	{
		super(instance);
	}
	
	public void registerName(String key, String localizedName)
	{
		this.apiInstance.getLangMap().put(key, localizedName);
	}  
	
	public void registerTileEntity(Block block, Class<? extends TileEntity> tile, String localizedName)
	{
		GameRegistry.registerTileEntity(tile, block.getUnlocalizedName().substring(5));
	}
	
	public void registerBlock(Block block, String localizedName, float hard)
	{	
		registerBlock(block, localizedName, hard, null);
	}
	 
	public void registerBlock(Block block, String localizedName, float hard, CreativeTabs tab)
	{	
		String truename = WyHelper.instance().getFancyName(localizedName);
		if(tab != null)
			block.setUnlocalizedName(truename).setHardness(hard).setCreativeTab(tab);
		else
			block.setUnlocalizedName(truename).setHardness(hard);
		block.setRegistryName(truename);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		this.apiInstance.getItemsMap().put(block, localizedName);
		registerName("tile." + truename + ".name", localizedName);
	}
	
	public void registerItem(Item item, String localizedName)
	{	
		registerItem(item, localizedName, null);
	} 
	
	public void registerItem(Item item, String localizedName, CreativeTabs tab)
	{	
		String truename = WyHelper.instance().getFancyName(localizedName);
		if(tab != null)
			item.setUnlocalizedName(truename).setCreativeTab(tab);
		else
			item.setUnlocalizedName(truename);
		item.setRegistryName(truename);
		GameRegistry.register(item);
		this.apiInstance.getItemsMap().put(item, localizedName);
		registerName("item." + truename + ".name", localizedName);
	}
	
	public void registerMob(String name, Class<? extends Entity> entity)
	{
		registerMob(name, entity, -1, -1);
	}
	 
	public void registerMob(String name, Class<? extends Entity> entity, int color1, int color2)
	{
		EntityRegistry.registerModEntity(entity, name, entityID++, apiInstance.getParentMod().getModObject(), 64, 1, true);
		if(color1 != -1 && color2 != -1)
			EntityRegistry.registerEgg(entity, color1, color2);
		registerName("entity." + apiInstance.getParentMod().getParentModID() + "." + name + ".name", name);
	}
	 
	public void registerPacket(Class handlerClass, Class messageClass, Side side)
	{
		WyNetworkHelper.instance().registerMessage(handlerClass, messageClass, packetID++, side);
	}
	
	public void registerDimension(String name, int id, Class<? extends WorldProvider> clazz)
	{
		DimensionType.register(name, "_" + WyHelper.instance().getFancyName(name), id, clazz, true);
		DimensionManager.registerDimension(id, DimensionType.getById(id));	
		DimensionManager.createProviderFor(id);
	}

}
