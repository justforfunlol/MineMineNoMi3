package MineMineNoMi3;

import java.io.File;

import MineMineNoMi3.lists.ID;
import net.minecraftforge.common.config.Configuration;

public class MainConfig
{
	private static Configuration config;
	
	public static boolean allowShips_actual;
	private static final boolean allowShips_default = true;
	public static boolean allowDFtoDrop_actual;
	private static final boolean allowDFtoDrop_default = true;
	
	public static double rateDFDrops_actual;
	private static final double rateDFDrops_default = 0.00001D;
	
	
	public static void init(File configFile)
	{
		config = new Configuration(configFile);

		config.load();

		allowShips_actual = config.get(ID.CONFIG_BASIC, "Allow Ships to Spawn", allowShips_default).getBoolean();
		allowDFtoDrop_actual = config.get(ID.CONFIG_BASIC, "Allow Devil Fruits to drop from leaves", allowDFtoDrop_default).getBoolean();
		rateDFDrops_actual = config.get(ID.CONFIG_BASIC, "Rate at which Devil Fruits drop from leaves", rateDFDrops_default).getDouble();
		 
		config.save();
	}
	 
	public static Configuration getConfig() { return config; }
}
