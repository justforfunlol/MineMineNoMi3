package xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityTask;

public class AbilityTaskChargeable extends AbilityTask
{

	public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) 
	{
		AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
		int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
		
		if(power == 0) power = aa.getItemMaxCharges();
		
		int newDamage = aa.getProjectileDamage() + power;
		int newExplosion;
		double newSizeX, newSizeY, newSizeZ;
		boolean newHasFire = aa.canExplosionSetFire(), newHasSmoke = aa.canExplosionDestroyBlocks();
		
		if(aa.getProjectileExplosionPower() > 0) newExplosion = aa.getProjectileExplosionPower() + (power / 3);
		else newExplosion = 0;
		
		if(aa.getProjectileModel() != null)
		{
			newSizeX = aa.getProjectileSize()[0] + (power / 4);
			newSizeY = aa.getProjectileSize()[1] + (power / 4);
			newSizeZ = aa.getProjectileSize()[2] + (power / 4);	
		}
		else
		{
			newSizeX = 0;
			newSizeY = 0;
			newSizeZ = 0;				
		}
		
		AbilityAttribute newAA = new AbilityAttribute(aa.getAttributeName()).setProjectileModel(aa.getProjectileModel()).setProjectileSize(newSizeX, newSizeY, newSizeZ).setProjectileColor(aa.getProjectileColor()).setProjectileDamage(newDamage).setProjectileExplosion(newExplosion, newHasFire, newHasSmoke);

		if(!player.worldObj.isRemote)
		{
			AbilityProjectile proj = new AbilityProjectile(player.worldObj, (EntityPlayer) player, newAA);
			//proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, newAA.getProjectileSpeed() + 0.5F, 0);
			player.worldObj.spawnEntityInWorld(proj);		
		}
	}
	
}
