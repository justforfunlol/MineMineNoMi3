package WyPI;

import java.io.File;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;

public class ParentModContainer
{
	private File sourceFolder;
	private String parentModId;
	private Object parentMod; 
	
	public ParentModContainer(Object mod)
	{
		ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
		sourceFolder = mc.getSource();
		parentModId = mc.getModId();
		parentMod = mod;		
	}
	
	public Object getModObject() { return parentMod; }
	
	public File getSourceFolder() { return sourceFolder; }
	
	public String getParentModID() { return parentModId; }
}
