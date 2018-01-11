package xyz.pixelatedw.MineMineNoMi3;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class MainConfig 
{
	
	private static Configuration config;
	
	public static boolean enableShips;
	public static boolean enableDFtoDrop;
	public static boolean enableAmbushes;
	public static double rateDFDrops;
	public static double rateAmbushes;	
	public static int devilFruitAbilitiesSystem;
	
	
	public static void init(File configFile)
	{
		config = new Configuration(configFile);
		
		config.load();
		
		enableShips = config.get(Configuration.CATEGORY_GENERAL, "Allow Ships to Spawn", true).getBoolean();
		
		enableDFtoDrop = config.get(Configuration.CATEGORY_GENERAL, "Allow Devil Fruits to drop from leaves", true).getBoolean();
		rateDFDrops = config.get(Configuration.CATEGORY_GENERAL, "Rate at which Devil Fruits drop from leaves", 0.1).getDouble(); // / 10000
					
		//devilFruitAbilitiesSystem = config.get(Configuration.CATEGORY_GENERAL, "Devil Fruit Abilities System", 0).getInt();
			
		config.save();
	}
	 
	public static Configuration getConfig() { return config; }

}
