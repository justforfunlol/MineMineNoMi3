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
	   
	public void build(BlockPos pos, World world)
	{ 
		try  
		{
			int i = 0;
			for(int sy = 0; sy < height; sy++)
			for(int sz = 0; sz < length; sz++)
			for(int sx = 0; sx < width; sx++)
			{ 
				Block b = Block.getBlockById(blocks[i]);
				if(b != Blocks.AIR)  
				{
					BlockPos poz = new BlockPos(pos.getX() + sx , pos.getY() + sy, pos.getZ() + sz);
					if(world.getBlockState(poz) != b.getDefaultState())
					{
						world.setBlockToAir(poz);					
						world.setBlockState(poz, b.getStateFromMeta(data[i]), 2);
					}
				}
				i++; 
			}
		}
		catch(Exception e)
		{System.out.println("[ERROR] The .schematic could not be build due to : " + e.toString());}
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
}
