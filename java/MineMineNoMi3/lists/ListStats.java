package MineMineNoMi3.lists;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentTranslation;

public class ListStats 
{

    public static final StatBase SHIPS_RAIDED = (new StatBasic("stat.shipsRaided", new TextComponentTranslation("stat.shipsRaided", new Object[0]))).registerStat();
	
}
