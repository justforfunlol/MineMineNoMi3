package WyPI.modules;

import java.lang.management.ManagementFactory;

import org.apache.logging.log4j.Level;

import WyPI.WyPI;
import net.minecraftforge.fml.common.FMLLog;

public class WyDebug
{
	private static WyDebug instance;
	public static WyDebug instance() 
	{ 
		if(instance == null) instance = new WyDebug();
		return instance;
	}

	public boolean isDebug()
	{
		return ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
	}

	public void info(Object msg)
	{
		FMLLog.log(WyPI.apiInstance.getParentMod().getParentModID(), Level.INFO, String.valueOf(msg));
	}

	public void warn(Object msg)
	{
		FMLLog.log(WyPI.apiInstance.getParentMod().getParentModID(), Level.WARN, String.valueOf(msg));
	}

	public void error(Object msg)
	{
		FMLLog.log(WyPI.apiInstance.getParentMod().getParentModID(), Level.ERROR, String.valueOf(msg));
	}
	
	public void debug(Object msg)
	{
		FMLLog.log(WyPI.apiInstance.getParentMod().getParentModID(), Level.DEBUG, String.valueOf(msg));
	}
}
