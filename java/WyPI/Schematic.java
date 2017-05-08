package WyPI;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Schematic
{
	private  NBTTagList tileentities;
	private  short width, height, length;
	private byte[] blocks, data;
	private String name = "N/A";
	
	private BlockPos center;
	
	public Schematic(String name, NBTTagList tiles, short width, short height, short length, byte[] blocks, byte[] data)
	{
		this.name = name;
		this.tileentities = tiles;
		this.width = width;
		this.height = height;
		this.length = length;
		this.blocks = blocks;
		this.data = data;
	}	 

	public int getWidth()
	{
		return width;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public String getName()
	{
		return name;
	}

	public byte[] getBlocks() 
	{
		return blocks;
	}

	public byte[] getData() 
	{
		return data;
	}
	
}
