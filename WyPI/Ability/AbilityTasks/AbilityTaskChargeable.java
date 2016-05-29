package WyPI.Ability.AbilityTasks;

import WyPI.Ability.AbilityAttribute;
import WyPI.Ability.AbilityItem;
import WyPI.Ability.AbilityProjectile;
import WyPI.Ability.AbilityTask;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class AbilityTaskChargeable extends AbilityTask
{

	public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) 
	{
		AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
		int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
		
		if(power == 0) power = aa.getItemMaxCharges();
		
		int newDamage = aa.getDamage() + power;
		int newExplosion;
		double newSizeX, newSizeY, newSizeZ;
		
		if(aa.hasExplosion()) newExplosion = aa.getExplosion() + (power / 3);
		else newExplosion = 0;
		
		if(aa.getModel() != null)
		{
			newSizeX = aa.getScale()[0] + (power / 4);
			newSizeY = aa.getScale()[1] + (power / 4);
			newSizeZ = aa.getScale()[2] + (power / 4);	
		}
		else
		{
			newSizeX = 0;
			newSizeY = 0;
			newSizeZ = 0;				
		}
		
		AbilityAttribute newAA = new AbilityAttribute().setModel(aa.getModel()).setColor(aa.getColor()).setDamage(newDamage).setExplosion(newExplosion).setSize(newSizeX, newSizeY, newSizeZ);

		AbilityProjectile newProj = new AbilityProjectile(player.worldObj, player, newAA);
		newProj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
		player.worldObj.spawnEntityInWorld(newProj);
	}
	
}
