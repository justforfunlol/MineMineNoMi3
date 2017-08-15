package xyz.pixelatedw.MineMineNoMi3.api;

import java.awt.Color;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;

public class WyHelper 
{

	public static enum Direction {SOUTH, SOUTH_EAST, EAST, NORTH, NORTH_EAST, NORTH_WEST, WEST, SOUTH_WEST;}
	
	public static AxisAlignedBB NULL_AABB = AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	
	public static Color hexToRGB(String hexColor)
	{return Color.decode("#"+hexColor);} 
	
	public static void sendMsgToPlayer(EntityPlayer player, String text)
	{player.addChatComponentMessage(new ChatComponentText(text));}
    
	public static String getFancyName(String text)
	{return text.replaceAll("\\s+","").toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll(":", "").replaceAll("#", "").replace(",", "");}

	
    public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius)
    {
	    return getEntitiesNear(e, radius, EntityLivingBase.class);
    }

    public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius, Class <? extends Entity> classEntity)
    { 
    	AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(e.posX, e.posY, e.posZ, e.posX + 1, e.posY + 1, e.posZ + 1).expand(radius, radius, radius);
    	List list = e.worldObj.getEntitiesWithinAABB(classEntity, aabb);
    	list.remove(e);
	    return list;
    }
    
    public static List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius)
    {
		return getEntitiesNear(e, radius, EntityLivingBase.class);
    }

    public static List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius, Class <? extends Entity> classEntity)
    {
    	AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)e.xCoord, (double)e.yCoord, (double)e.zCoord, (double)(e.xCoord + 1), (double)(e.yCoord + 1), (double)(e.zCoord + 1)).expand(radius, radius, radius);
    	List list = e.getWorldObj().getEntitiesWithinAABB(classEntity, aabb);
		return list;
    }
    
	public static Direction get4Directions(Entity e)
	{
		switch(MathHelper.floor_double(e.rotationYaw * 4.0F / 360.0F + 0.5D) & 3)
		{case 0: return Direction.SOUTH; case 1: return Direction.WEST; case 2: return Direction.NORTH; case 3: return Direction.EAST;}
		return null;
	}
	
	public static Direction get8Directions(Entity e)
	{
		switch(MathHelper.floor_double(e.rotationYaw * 8.0F / 360.0F + 0.5D) & 7)
		{case 0: return Direction.SOUTH; case 1: return Direction.SOUTH_WEST; case 2: return Direction.WEST; case 3: return Direction.NORTH_WEST; case 4: return Direction.NORTH; case 5: return Direction.NORTH_EAST; case 6: return Direction.EAST; case 7: return Direction.SOUTH_EAST;}
		return null;
	}
	
	public static MovingObjectPosition rayTrace(Entity e)
	{
		float f = 1.0F;
		float f1 = e.prevRotationPitch + (e.rotationPitch - e.prevRotationPitch) * f;
		float f2 = e.prevRotationYaw + (e.rotationYaw - e.prevRotationYaw) * f;
		double d = e.prevPosX + (e.posX - e.prevPosX) * (double)f;
		double d1 = (e.prevPosY + (e.posY - e.prevPosY) * (double)f + 1.6200000000000001D) - (double)e.getYOffset();
		double d2 = e.prevPosZ + (e.posZ - e.prevPosZ) * (double)f;
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);	      
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f9 = f3 * f5;
		double d3 = 5000D;
		
		Vec3 vec3 = vec3d.addVector((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
		MovingObjectPosition ray = e.worldObj.rayTraceBlocks(vec3d, vec3, false);	

		return ray;
	}
	
	public static void createCube(Entity e, int i, Block b)
	{createCube(e, new int[] {i, i, i}, b);}
	
	public static void createCube(Entity e, int[] s, Block b)
	{
		for (int x = (s[0] * 0) - s[0]; x < s[0]; x++) 
		for (int y = (s[1] * 0) - s[1]; y < s[1]; y++) 
		for (int z = (s[2] * 0) - s[2]; z < s[2]; z++) 
		{
			e.worldObj.setBlock((int)e.posX + x, (int)e.posY + y, (int)e.posZ + z, b);
		}
	}
	
	public static void createSphere(Object e, int size, final Block b)
	{
		int x = 0, y = 0, z = 0;
		final World world;
		if(e instanceof Entity)
		{
			x = (int) ((Entity)e).posX;
			y = (int) ((Entity)e).posY;
			z = (int) ((Entity)e).posZ;
			world = ((Entity)e).worldObj;
		}
		else if(e instanceof TileEntity)
		{
			x = (int) ((TileEntity)e).xCoord;
			y = (int) ((TileEntity)e).yCoord;
			z = (int) ((TileEntity)e).zCoord;
			world = ((TileEntity)e).getWorldObj();			
		}
		else
		{
			world = null;
		}
		
		Sphere.generate(x, y, z, size, new ISphere()
		{
		    public void call(int x, int y, int z)
		    {world.setBlock(x, y ,z, b);}
		});
	}
	
	public static void createSphere(Object e, int x, int y, int z, int size, final Block b)
	{
		final World world;
		if(e instanceof Entity)
			world = ((Entity)e).worldObj;
		else if(e instanceof TileEntity)
			world = ((TileEntity)e).getWorldObj();			
		else
			world = null;
		
		Sphere.generate(x, y, z, size, new ISphere()
		{
		    public void call(int x, int y, int z)
		    {world.setBlock(x, y ,z, b);}
		});
	}
	
    public static void removeStackFromInventory(EntityPlayer player, ItemStack stack)
    {
    	for(int i = 0; i < player.inventory.mainInventory.length; i++)
    	{
    		if(stack == player.inventory.getStackInSlot(i))
    		{
    			player.inventory.setInventorySlotContents(i, null);
    			break;
    		}
    	}
    }
    
    public static void removeStackFromSlot(EntityPlayer player, int index)
    {
        if (player.inventory.mainInventory[index] != null)
            player.inventory.mainInventory[index] = null;
    }
}
