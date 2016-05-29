package MineMineNoMi3;

import net.minecraft.util.text.TextFormatting;


public enum EnumFruitType 
{

	PARAMECIA		(TextFormatting.RED			, "Paramecia"),
	LOGIA			(TextFormatting.YELLOW		, "Logia"),
	MYTHICALZOAN	(TextFormatting.AQUA		, "Mythical Zoan"),
	ZOAN			(TextFormatting.GREEN		, "Zoan"),
	ARTIFICIALLOGIA	(TextFormatting.GOLD		, "Artificial Logia"),
	ARTIFICIALPARAM	(TextFormatting.GOLD		, "Artificial Paramecia"),
	ARTIFICIALZOAN	(TextFormatting.GOLD		, "Artificial Zoan");
	
	
	private TextFormatting color;
	private String name;
	
	private EnumFruitType(TextFormatting color, String name)
	{
		this.color = color;
		this.name = name;
	}
	
	public TextFormatting getColor()
	{
		return color;		
	}
	
	public String getName()
	{
		return name;
	}
}
