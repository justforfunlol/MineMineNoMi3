package WyPI.modules;

import WyPI.Module;
import WyPI.WyPI;

public class WyMathHelper extends Module
{
	private static WyMathHelper instance;
	public static WyMathHelper instance() 
	{ 
		if(instance == null) instance = new WyMathHelper(WyPI.apiInstance);
		return instance;
	}
	
	public WyMathHelper(WyPI instance)
	{
		super(instance);
	}

	public float degreesToRadians(double degrees) { return (float) (degrees * (double)Math.PI / 180) ; }
	
	public double percentage(double i, double j) { return i * (j / 100); }
}
