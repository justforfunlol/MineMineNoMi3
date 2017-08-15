package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Geppo;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Kamie;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Rankyaku;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Shigan;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Soru;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Tekkai;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class HakiAbilities 
{

	public static AbilityItem KENBUNSHOKUHAKI = new KenbunshokuHaki();
	public static AbilityItem BUSOSHOKUHAKI = new BusoshokuHaki();
	public static AbilityItem HAOSHOKUHAKI = new Geppo();
	
	public static AbilityItem[] abilitiesArray = new AbilityItem[] {KENBUNSHOKUHAKI, BUSOSHOKUHAKI, HAOSHOKUHAKI};
	
	public static class KenbunshokuHaki extends AbilityItem
	{
		public KenbunshokuHaki() 
		{
			this.attr = ListAttributes.KENBUNSHOKUHAKI; 
		}
	}
	
	public static class BusoshokuHaki extends AbilityItem
	{
		public BusoshokuHaki() 
		{
			this.attr = ListAttributes.BUSOSHOKUHAKI; 
		}
		
	    public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
	    {
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			
			if(!props.hasHakiActive())
			{
				props.triggerActiveHaki();
				itemStack.getTagCompound().setBoolean("use", true);
			}
			else
			{
				props.triggerActiveHaki();
				itemStack.getTagCompound().setBoolean("use", false);
			}
	    };
	    
	    public void tasksTick(ItemStack itemStack, World world, EntityPlayer player)
	    {
			ExtendedEntityStats props = ExtendedEntityStats.get(player);

			if(!props.hasHakiActive())
			{
				itemStack.getTagCompound().setBoolean("use", false);
			}
	    };
	}
	
	public static class HaoshokuHaki extends AbilityItem
	{
		public HaoshokuHaki() 
		{
			this.attr = ListAttributes.HAOSHOKUHAKI; 
		}
		
	    public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
	    {
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			
			for(EntityLivingBase target : WyHelper.getEntitiesNear(player, 50))
			{
				ExtendedEntityStats propz = ExtendedEntityStats.get(target);

				if(props.getDoriki() > propz.getDoriki() * 2)
				{
					target.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 2));
					target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1000, 10));
					target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1000, 10));
				}
			}
	    };
	}
}
