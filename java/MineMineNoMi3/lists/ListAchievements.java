package MineMineNoMi3.lists;

import MineMineNoMi3.Main;
import WyPI.modules.WyRegistry;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ListAchievements 
{
	public static AchievementPage MMnMAchievementPage;
	public static Achievement firstDevilFruit, becomePirate, becomeMarine, becomeBountyHunter, becomeRevolutionary;
	
	public static void init()
	{ 
		//WyPI.Registry.addACHIEVEMENT(firstDevilFruit, 0, 0, "First Devil Fruit", "Eat your first devil fruit.", ListDevilFruits.MeraMeraNoMi, null);
		becomePirate = new Achievement("achievement.becomePirate", "becomePirate", 4, -6, ListDevilFruits.MeraMeraNoMi, null);
		WyRegistry.instance().registerName("achievement.becomePirate", "Test1");
		WyRegistry.instance().registerName("achievement.becomePirate.desc", "test11");
		
		becomeMarine = new Achievement("achievement.becomeMarine", "becomeMarine", 3, -6, ListDevilFruits.MeraMeraNoMi, null);
		WyRegistry.instance().registerName("achievement.becomeMarine", "Test2");
		WyRegistry.instance().registerName("achievement.becomeMarine.desc", "test22");
		
		MMnMAchievementPage = new AchievementPage("Mine Mine no Mi", new Achievement[] { becomePirate, becomeMarine} );
		AchievementPage.registerAchievementPage(MMnMAchievementPage);
	}
	
}
