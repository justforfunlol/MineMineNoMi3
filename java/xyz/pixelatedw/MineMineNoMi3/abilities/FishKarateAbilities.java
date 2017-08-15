package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Geppo;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Kamie;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Rankyaku;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Shigan;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Soru;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Tekkai;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.FishKarateProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class FishKarateAbilities 
{
	public static AbilityItem UCHIMIZU = new Soru();
	public static AbilityItem YARINAMI = new Tekkai();
	public static AbilityItem SAMEHADASHOTEI = new Geppo();
	public static AbilityItem SOSHARK = new Rankyaku();
	public static AbilityItem MURASAME = new Shigan();
	public static AbilityItem KARAKUSAGAWARASEIKEN = new Kamie();
	
	public static AbilityItem[] abilitiesArray = new AbilityItem[] {UCHIMIZU, YARINAMI, SAMEHADASHOTEI, SOSHARK, MURASAME, KARAKUSAGAWARASEIKEN};
	
	public static class Uchimizu extends AbilityItem
	{
		public Uchimizu() 
		{
			this.attr = ListAttributes.UCHIMIZU; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new FishKarateProjectiles.Uchimizu(world, player, attr);
		}
	}
	
	public static class Yarinami extends AbilityItem
	{
		public Yarinami() 
		{
			this.attr = ListAttributes.YARINAMI; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new FishKarateProjectiles.Yarinami(world, player, attr);
		}
	}
	
	public static class SamehadaShotei extends AbilityItem
	{
		public SamehadaShotei() 
		{
			this.attr = ListAttributes.SAMEHADASHOTEI; 
		}
	}
	
	public static class Soshark extends AbilityItem
	{
		public Soshark() 
		{
			this.attr = ListAttributes.SOSHARK; 
		}
		
		public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker)
		{
			target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 10);
			Direction dir = WyHelper.get4Directions(attacker);
			if(dir == WyHelper.Direction.SOUTH)
				target.motionX += 0.7;
			else if(dir == WyHelper.Direction.EAST)
				target.motionX -= 0.7; 
			else if(dir == WyHelper.Direction.NORTH)
				target.motionZ += 0.7;
			else if(dir == WyHelper.Direction.WEST)  
				target.motionZ -= 0.7;		
		}
	}
	
	public static class Murasame extends AbilityItem
	{
		public Murasame() 
		{
			this.attr = ListAttributes.MURASAME; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new FishKarateProjectiles.Murasame(world, player, attr);
		}
	}
	
	public static class KarakusagawaraSeiken extends AbilityItem
	{
		public KarakusagawaraSeiken() 
		{
			this.attr = ListAttributes.KARAKUSAGAWARASEIKEN; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 25))
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 30);

				e.motionY += 0.3;
				
				if(player.worldObj.rand.nextInt(2) == 0)
				{
					if(player.worldObj.rand.nextInt(2) == 0)
						e.motionX += 0.8;
					if(player.worldObj.rand.nextInt(2) == 1)
						e.motionX -= 0.8;
				}
				if(player.worldObj.rand.nextInt(2) == 1)
				{
					if(player.worldObj.rand.nextInt(2) == 0)
						e.motionZ += 0.8;
					if(player.worldObj.rand.nextInt(2) == 1)
						e.motionZ -= 0.8;
				}
	
			}
		}
	}
}
