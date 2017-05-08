package WyPI.modules;

import java.io.InputStream;

import WyPI.Schematic;
import WyPI.WyPI;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WySchematicHelper
{

	private static WySchematicHelper instance;
	public static WySchematicHelper instance() 
	{ 
		if(instance == null) instance = new WySchematicHelper();
		return instance;
	}

	public Schematic load(String name)
	{
		try
		{
			InputStream is = WySchematicHelper.class.getClassLoader().getResourceAsStream("assets/" + WyPI.apiInstance.getParentMod().getParentModID() + "/schematics/" + name + ".schematic");	
			NBTTagCompound nbt = CompressedStreamTools.readCompressed(is);
			
			short width = nbt.getShort("Width");
			short height = nbt.getShort("Height");
			short length = nbt.getShort("Length");
			
			byte[] blocks = nbt.getByteArray("Blocks");
			byte[] data = nbt.getByteArray("Data");
			
			NBTTagList tiles = nbt.getTagList("TileEntities", 10);
			
			is.close();
			
			return new Schematic(name, tiles, width, height, length, blocks, data);
		}
		catch(Exception e) { return null; }	
	}
	
	public void build(Schematic sch, BlockPos pos, World world)
	{ 
		build(sch, pos, world, 1);
	}
	
	private void build(Schematic sch, BlockPos pos, World world, int phase)
	{ 
		try  
		{
			int i = 0;
			for(int sy = 0; sy < sch.getHeight(); sy++)
			for(int sz = 0; sz < sch.getLength(); sz++)
			for(int sx = 0; sx < sch.getWidth(); sx++)
			{ 
				Block b = Block.getBlockById(sch.getBlocks()[i]);
				if(phase == 1 && (b != Blocks.AIR || b != Blocks.TORCH || b != Blocks.OAK_DOOR))  
				{
					BlockPos poz = new BlockPos(pos.getX() + sx , pos.getY() + sy, pos.getZ() + sz);
					if(world.getBlockState(poz) != b.getDefaultState())
					{
						world.setBlockToAir(poz);	
						world.setBlockState(poz, b.getStateFromMeta(sch.getData()[i]), 2);
					}
				}
				i++;
			}
		}
		catch(Exception e)
		{System.out.println("[ERROR] The .schematic could not be built due to : " + e.toString());}
		finally
		{
			if(phase == 1)
				build(sch, pos, world, 2);
		}
	}

}
