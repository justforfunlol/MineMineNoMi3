package WyPI.modules;

import java.io.InputStream;

import WyPI.Module;
import WyPI.Schematic;
import WyPI.WyPI;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class WySchematicHelper extends Module
{

	private static WySchematicHelper instance;
	public static WySchematicHelper instance() 
	{ 
		if(instance == null) instance = new WySchematicHelper(WyPI.apiInstance);
		return instance;
	}
	
	public WySchematicHelper(WyPI instance)
	{
		super(instance);
	}

	public Schematic load(String name)
	{
		try
		{
			InputStream is = WySchematicHelper.class.getClassLoader().getResourceAsStream("assets/" + apiInstance.getParentMod().getParentModID() + "/schematics/" + name + ".schematic");	
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
}
