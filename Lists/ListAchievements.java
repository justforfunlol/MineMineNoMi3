package MineMineNoMi3.Lists;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import WyPI.*;

public class ListAchievements 
{
	public static AchievementPage MMnMAchievementPage;
	public static Achievement firstDevilFruit, becomePirate, becomeMarine, becomeBountyHunter, becomeRevolutionary;
	
	public static void init()
	{
		//WyPI.Registry.addACHIEVEMENT(firstDevilFruit, 0, 0, "First Devil Fruit", "Eat your first devil fruit.", ListDevilFruits.MeraMeraNoMi, null);
		becomePirate = new Achievement("achievement.becomePirate", "becomePirate", 4, -6, ListDevilFruits.MeraMeraNoMi, null);
		WyPI.Registry.addNAME("achievement.becomePirate", "Test1");
		WyPI.Registry.addNAME("achievement.becomePirate.desc", "test11");
		
		becomeMarine = new Achievement("achievement.becomeMarine", "becomeMarine", 3, -6, ListDevilFruits.MeraMeraNoMi, null);
		WyPI.Registry.addNAME("achievement.becomeMarine", "Test2");
		WyPI.Registry.addNAME("achievement.becomeMarine.desc", "test22");
		
		MMnMAchievementPage = new AchievementPage("Mine Mine no Mi", new Achievement[] { becomePirate, becomeMarine} );
		AchievementPage.registerAchievementPage(MMnMAchievementPage);
	}
	
}
