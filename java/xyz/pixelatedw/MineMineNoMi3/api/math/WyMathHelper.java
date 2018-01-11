package xyz.pixelatedw.MineMineNoMi3.api.math;

public class WyMathHelper
{
	public static float degreesToRadians(double degrees) { return (float) (degrees * (double)Math.PI / 180) ; }
	
	public static double percentage(double i, double j) { return i * (j / 100); }
	
    public static double randomWithRange (double min, double max) { return (Math.random() * Math.abs(max - min) + 1) + (min <= max ? min : max); }

    public static float clampf(float val, float min, float max) { return Math.max(min, Math.min(max, val)); }
    
    public static double clampd(double val, double min, double max) { return Math.max(min, Math.min(max, val)); }
    
    public static int clampi(int val, int min, int max) { return Math.max(min, Math.min(max, val)); }
}
