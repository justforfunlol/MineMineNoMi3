package WyPI.modules;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import WyPI.WyPI;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.extra.ItemProperty;
import WyPI.math.ISphere;
import WyPI.math.Sphere;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WyHelper
{
	private static WyHelper instance;
	public static WyHelper instance() 
	{ 
		if(instance == null) instance = new WyHelper();
		return instance;
	}
	
	private String[] exceptionsForJSON;

	public static enum Direction {SOUTH, SOUTH_EAST, EAST, NORTH, NORTH_EAST, NORTH_WEST, WEST, SOUTH_WEST;}
	
	public void generateLangFiles()
	{
		Set set = WyPI.apiInstance.getLangMap().entrySet();
		Iterator i = set.iterator();
		
		File langFolder = new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/lang/");
		langFolder.mkdirs();
		
		if(langFolder.exists())
		{			
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/lang/en_US.lang"), "UTF-8"))) 
			{
				while(i.hasNext())
				{
					Map.Entry entry = (Map.Entry)i.next();
					 
					writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
				}
				writer.close();
			}
			catch(Exception e) {e.getStackTrace();}
		}
	}

	public void generateIngameModels()
	{
		Set set = WyPI.apiInstance.getItemsMap().entrySet();
		Iterator i = set.iterator();
		
		while(i.hasNext())
		{
			Map.Entry entry = (Map.Entry)i.next();
			if(entry.getKey() instanceof Item)
			{
				Item item = (Item) entry.getKey();
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":" + item.getUnlocalizedName().substring(5), "inventory"));
			}
			if(entry.getKey() instanceof Block)
			{
				Block block = (Block) entry.getKey();
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":" + block.getUnlocalizedName().substring(5), "inventory"));
			}
		}
	}
	
	public void addExceptionsToJSONModels(String... s)
	{
		this.exceptionsForJSON = s;
	}
	
	public void generateJSONModels(boolean overrideFiles)
	{	
		File itemFolder = new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/");
		File blockstateFolder = new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/blockstates/");
		File blockFolder = new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/block/");
		
		itemFolder.mkdirs();
		blockstateFolder.mkdirs();
		blockFolder.mkdirs();
		  
		Set set = WyPI.apiInstance.getItemsMap().entrySet();
		Iterator i = set.iterator();
		
		if(itemFolder.exists() && blockFolder.exists() && blockstateFolder.exists())
		{  
			//Creates the handheldp.json file used by swords to display a 3D model
			if(overrideFiles || !(new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/handheldp.json").exists()))
			{
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/handheldp.json"), "UTF-8"))) 
				{
					writer.write("{ \"parent\": \"item/generated\",\"display\": {\"thirdperson_righthand\": {\"rotation\": [ 0, -90, 55 ],\"translation\": [ 0, 8.5, 0 ],\"scale\": [ 1.5, 1.5, 1.5 ]},\"thirdperson_lefthand\": {\"rotation\": [ 0, 90, -55 ],\"translation\": [ 0, 8.5, 0.0 ],\"scale\": [ 1.5, 1.5, 1.5 ]},\"firstperson_righthand\": {\"rotation\": [ 0, -90, 25 ],\"translation\": [ 1.13, 3.2, 1.13 ],\"scale\": [ 0.68, 0.68, 0.68 ]},\"firstperson_lefthand\": {\"rotation\": [ 0, 90, -25 ],\"translation\": [ 1.13, 3.2, 1.13 ],\"scale\": [ 0.68, 0.68, 0.68 ]}}} ");
				}
				catch(Exception e) {e.getStackTrace();}
			}
			  
			while(i.hasNext())
			{
				Map.Entry entry = (Map.Entry)i.next();
				
				//Creates the item json files for each registered item. IF the item has a damage value it will be rendered as a 3d model
				if(entry.getKey() instanceof Item)
				{
					if(overrideFiles || !(new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + ".json").exists()))
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							if(entry.getKey() instanceof AbilityItem && (((AbilityItem)entry.getKey()).getAttribute().getItemDamage() > 0 ))
								writer.write("{\"parent\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":item/handheldp\", \"textures\": { \"layer0\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":items/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "\"}");
							else
								writer.write("{\"parent\": \"item/generated\", \"textures\": { \"layer0\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":items/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "\"}");
							 
							if( (((AbilityItem)entry.getKey()).getAttribute().getProperties() != null) )
							{  
								writer.write(" ,\"overrides\": [");
								for(ItemProperty ip : (((AbilityItem)entry.getKey()).getAttribute().getProperties())) 
								{ 
									for(int k = 1; k < ip.getValue() + 1; k++)
									{
										writer.write("{\"predicate\": { \"" + ip.getName() + "\": " + k + " }, \"model\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "_" + k + "\"}");	
									
										try (Writer writerSubFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "_" + k + ".json"), "UTF-8"))) 
										{
											writerSubFile.write("{\"parent\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "\", \"textures\": { \"layer0\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":items/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "_" + k + "\"}}");									
											writerSubFile.close();
										}
										catch(Exception e) {e.getStackTrace();}
									}
								}
								writer.write("]");
							}
							
							writer.write("}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
				}  //Creates the block json files (including block, item and blockstate files)
				else if(entry.getKey() instanceof Block)
				{
					if(overrideFiles || !(new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/block/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json").exists()))
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/block/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":blocks/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\"}}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
					if(overrideFiles || !(new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json").exists()))
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/models/item/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"parent\":\"" + WyPI.apiInstance.getParentMod().getParentModID() + ":block/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\"}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
					if(overrideFiles || !(new File(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/blockstates/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json").exists()))
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WyPI.apiInstance.getParentMod().getSourceFolder() + "/assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/blockstates/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"variants\": {\"normal\": { \"model\": \"" + WyPI.apiInstance.getParentMod().getParentModID() + ":" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\" }}}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
				}
			}
		}
	}
 
	public void createSphere(Object e, int size, final IBlockState b)
	{
		BlockPos pos = e instanceof Entity ? ((Entity) e).getPosition() : e instanceof TileEntity ? ((TileEntity) e).getPos() : null;
		final World world = e instanceof Entity ? ((Entity) e).getEntityWorld() : e instanceof TileEntity ? ((TileEntity) e).getWorld() : null;
		Sphere.generate(pos.getX(), pos.getY(), pos.getZ(), size, new ISphere()
		{
		    public void call(int x, int y, int z)
		    {world.setBlockState(new BlockPos(x, y ,z), b);}
		});
	}
	
	public void createSphere(Object e, BlockPos pos, int size, final IBlockState b)
	{
		final World world = e instanceof Entity ? ((Entity) e).getEntityWorld() : e instanceof TileEntity ? ((TileEntity) e).getWorld() : null;
		Sphere.generate(pos.getX(), pos.getY(), pos.getZ(), size, new ISphere()
		{
		    public void call(int x, int y, int z)
		    {world.setBlockState(new BlockPos(x, y ,z), b);}
		});
	}
	
	public RayTraceResult rayTrace(Entity e)
	{
		float f = 1.0F;
		float f1 = e.prevRotationPitch + (e.rotationPitch - e.prevRotationPitch) * f;
		float f2 = e.prevRotationYaw + (e.rotationYaw - e.prevRotationYaw) * f;
		double d = e.prevPosX + (e.posX - e.prevPosX) * (double)f;
		double d1 = (e.prevPosY + (e.posY - e.prevPosY) * (double)f + 1.6200000000000001D) - (double)e.getYOffset();
		double d2 = e.prevPosZ + (e.posZ - e.prevPosZ) * (double)f;
		Vec3d vec3d = new Vec3d(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);	      
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f9 = f3 * f5;
		double d3 = 5000D;
		
		Vec3d vec3 = vec3d.addVector((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
		RayTraceResult ray = e.worldObj.rayTraceBlocks(vec3d, vec3, false);	

		return ray;
	}
	
	public void createCube(Entity e, int i, IBlockState b)
	{createCube(e, new int[] {i, i, i}, b);}
	
	public void createCube(Entity e, int[] s, IBlockState b)
	{
		for (int x = (s[0] * 0) - s[0]; x < s[0]; x++) 
		for (int y = (s[1] * 0) - s[1]; y < s[1]; y++) 
		for (int z = (s[2] * 0) - s[2]; z < s[2]; z++) 
		{
			e.worldObj.setBlockState(new BlockPos(e.getPosition().getX() + x, e.getPosition().getY() + y, e.getPosition().getZ() + z), b);
		}
	}
	
	public void sendMsgToPlayer(EntityPlayer player, String text)
	{player.addChatComponentMessage(new TextComponentString(text));}
    
	public String getFancyName(String text)
	{return text.replaceAll("\\s+","").toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll(":", "").replaceAll("#", "").replace(",", "");}

	public Color hexToRGB(String hexColor)
	{return Color.decode("#"+hexColor);} 
	
    public List<EntityLivingBase> getEntitiesNear(Entity e, double radius)
    {
	    return getEntitiesNear(e, radius, EntityLivingBase.class);
    }

    public List<EntityLivingBase> getEntitiesNear(Entity e, double radius, Class <? extends Entity> classEntity)
    {
    	AxisAlignedBB aabb = new AxisAlignedBB(e.posX, e.posY, e.posZ, e.posX + 1, e.posY + 1, e.posZ + 1).expand(radius, radius, radius);
    	List list = e.worldObj.getEntitiesWithinAABB(classEntity, aabb);
    	list.remove(e);
	    return list;
    }
    
    public List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius)
    {
		return getEntitiesNear(e, radius, EntityLivingBase.class);
    }

    public List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius, Class <? extends Entity> classEntity)
    {
    	AxisAlignedBB aabb = new AxisAlignedBB((double)e.getPos().getX(), (double)e.getPos().getY(), (double)e.getPos().getZ(), (double)(e.getPos().getX() + 1), (double)(e.getPos().getY() + 1), (double)(e.getPos().getZ() + 1)).expand(radius, radius, radius);
    	List list = e.getWorld().getEntitiesWithinAABB(classEntity, aabb);
		return list;
    }
    
	public Direction get4Directions(Entity e)
	{
		switch(MathHelper.floor_double(e.rotationYaw * 4.0F / 360.0F + 0.5D) & 3)
		{case 0: return Direction.SOUTH; case 1: return Direction.WEST; case 2: return Direction.NORTH; case 3: return Direction.EAST;}
		return null;
	}
	
	public Direction get8Directions(Entity e)
	{
		switch(MathHelper.floor_double(e.rotationYaw * 8.0F / 360.0F + 0.5D) & 7)
		{case 0: return Direction.SOUTH; case 1: return Direction.SOUTH_WEST; case 2: return Direction.WEST; case 3: return Direction.NORTH_WEST; case 4: return Direction.NORTH; case 5: return Direction.NORTH_EAST; case 6: return Direction.EAST; case 7: return Direction.SOUTH_EAST;}
		return null;
	}
    
	public String makeFabulous(String text)
	{
		int stringLength = text.length();
		if (stringLength < 1)
			return "";
		String outputString = "";
		TextFormatting[] colorChar = {TextFormatting.RED, TextFormatting.GOLD, TextFormatting.YELLOW, TextFormatting.GREEN, TextFormatting.AQUA, TextFormatting.LIGHT_PURPLE, TextFormatting.DARK_PURPLE, TextFormatting.AQUA, TextFormatting.WHITE, TextFormatting.DARK_RED};
		Random rand = new Random();
		for (int i = 0; i < stringLength; i++)
			outputString = outputString + colorChar[rand.nextInt(stringLength) % 10] + text.substring(i, i + 1);
		return outputString;
	}
	
	public List<EntityPlayer> getPlayers()
	{
		int numDimensions = Minecraft.getMinecraft().thePlayer.getServer().worldServers.length;
		List<EntityPlayer> playerList = new ArrayList<EntityPlayer>();
		for(int x = 0; x < numDimensions; x++)
			playerList.addAll(Minecraft.getMinecraft().thePlayer.getServer().worldServers[x].playerEntities);	
		return playerList;
	}
	
	public void setThirdPersonCameraDistance(int distance)
	{
		try
		{
			Field field = EntityRenderer.class.getDeclaredField("thirdPersonDistance");
			field.setAccessible(true);
			field.set(Minecraft.getMinecraft().entityRenderer, distance);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
