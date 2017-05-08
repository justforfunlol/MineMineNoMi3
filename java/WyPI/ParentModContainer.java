package WyPI;

import java.io.File;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;

public class ParentModContainer
{
	private String parentModId, sourceFolder;
	private Object parentMod; 
	
	public ParentModContainer(Object mod, String sourceFolder)
	{
		ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
		if(sourceFolder != null)
			this.sourceFolder = sourceFolder;
		else
			this.sourceFolder = mc.getSource().getAbsolutePath();
		parentModId = mc.getModId();
		parentMod = mod;		
	}
	
	public Object getModObject() { return parentMod; }
	
	public String getSourceFolder() { return this.sourceFolder; }
	
	public String getParentModID() { return parentModId; }
}
