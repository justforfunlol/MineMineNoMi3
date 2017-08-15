package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.DaiEnkaiEntei;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.Enjomo;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.Hidaruma;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.Higan;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.Hiken;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities.Jujika;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BaneAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new SpringHopper(), new SpringSnipe(), new SpringDeathKnock(), null};
	
	public static class SpringHopper extends AbilityItem
	{
		public SpringHopper() 
		{
			this.attr = ListAttributes.SPRINGHOPPER; 
		}

	    public void tasksAfterUse(ItemStack itemStack, World world, EntityPlayer player, int timeLeft)
	    {
			Direction dir = WyHelper.get8Directions(player);
			 
			int power;
				
			if(((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges() == timeLeft)
				power = 1;
			else
				power = 0;

			if(player.onGround)
				player.motionY += 1.2 + (double)1/2;
			else
				player.motionY += 1.36 + (double)1/7;
	  
			if(dir == WyHelper.Direction.NORTH) player.motionZ -= 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.NORTH_WEST) {player.motionZ -= 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.SOUTH) player.motionZ += 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.NORTH_EAST) {player.motionZ -= 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.WEST) player.motionX -= 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.SOUTH_WEST) {player.motionZ += 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.EAST) player.motionX += 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.SOUTH_EAST) {player.motionZ += 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
	    }
	}
	
	public static class SpringSnipe extends AbilityItem
	{
		public SpringSnipe() 
		{
			this.attr = ListAttributes.SPRINGSNIPE; 
		}
		
	    public void tasksDuringCooldown(ItemStack itemStack, World world, EntityLivingBase player)
	    {
			if(itemStack.getTagCompound().getInteger("ticks") > 115)
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player), 1 + (itemStack.getTagCompound().getInteger("extra_power") * 5));
	    }
	    
	    public void tasksAfterUse(ItemStack itemStack, World world, EntityPlayer player, int timeLeft)
	    {
			double mX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mY = (double)(-MathHelper.sin((player.rotationPitch + 0) / 180.0F * (float)Math.PI) * 0.4);
		         
			int power;
		       
			if(((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges() == timeLeft)
				power = 1;
			else
				power = 0;
				
			itemStack.getTagCompound().setInteger("extra_power", power);
				
			double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
			mX /= (double)f2;
			mY /= (double)f2;
			mZ /= (double)f2;
			mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mX *= 7.5 + power;
			mY *= 2.5 + power;
			mZ *= 7.5 + power;

			player.motionX = mX;
			player.motionY = mY;
			player.motionZ = mZ;
	    }
	}
	
	public static class SpringDeathKnock extends AbilityItem
	{
		public SpringDeathKnock() 
		{
			this.attr = ListAttributes.SPRINGDEATHKNOCK; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new BaneProjectiles.SpringDeathKnock(world, player, attr);
		};	
	}
}
