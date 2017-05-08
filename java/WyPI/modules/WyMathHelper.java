package WyPI.modules;

import WyPI.WyPI;

public class WyMathHelper
{
	private static WyMathHelper instance;
	public static WyMathHelper instance() 
	{ 
		if(instance == null) instance = new WyMathHelper();
		return instance;
	}

	public float degreesToRadians(double degrees) { return (float) (degrees * (double)Math.PI / 180) ; }
	
	public double percentage(double i, double j) { return i * (j / 100); }
	
    public double randomWithRange (double min, double max) { return (Math.random() * Math.abs(max - min) + 1) + (min <= max ? min : max); }

}
