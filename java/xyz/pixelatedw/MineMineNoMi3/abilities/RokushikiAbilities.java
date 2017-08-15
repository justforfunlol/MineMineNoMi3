package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class RokushikiAbilities 
{
	
	public static AbilityItem SORU = new Soru();
	public static AbilityItem TEKKAI = new Tekkai();
	public static AbilityItem GEPPO = new Geppo();
	public static AbilityItem RANKYAKU = new Rankyaku();
	public static AbilityItem SHIGAN = new Shigan();
	public static AbilityItem KAMIE = new Kamie();
	
	public static AbilityItem[] abilitiesArray = new AbilityItem[] {SORU, TEKKAI, GEPPO, RANKYAKU, SHIGAN, KAMIE};
	
	public static class Soru extends AbilityItem
	{
		public Soru() 
		{
			this.attr = ListAttributes.SORU; 
		}
	}
	
	public static class Tekkai extends AbilityItem
	{
		public Tekkai() 
		{
			this.attr = ListAttributes.TEKKAI; 
		}
	}
	
	public static class Geppo extends AbilityItem
	{
		public Geppo() 
		{
			this.attr = ListAttributes.TEKKAI; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			Direction dir = WyHelper.get8Directions(player);
			
			if(player.onGround)
				player.motionY += 1.7;
			else
				player.motionY += 1.86;

			if(dir == WyHelper.Direction.NORTH) player.motionZ -= 1;
			if(dir == WyHelper.Direction.NORTH_WEST) {player.motionZ -= 1;player.motionX -= 1;}
			if(dir == WyHelper.Direction.SOUTH) player.motionZ += 1;
			if(dir == WyHelper.Direction.NORTH_EAST) {player.motionZ -= 1;player.motionX += 1;}
			if(dir == WyHelper.Direction.WEST) player.motionX -= 1;
			if(dir == WyHelper.Direction.SOUTH_WEST) {player.motionZ += 1;player.motionX -= 1;}
			if(dir == WyHelper.Direction.EAST) player.motionX += 1;
			if(dir == WyHelper.Direction.SOUTH_EAST) {player.motionZ += 1;player.motionX += 1;}
							
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX, (int) player.posY, (int) player.posZ, 0, 0, 0);
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX + 0.2, (int) player.posY, (int) player.posZ + 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX + 0.2, (int) player.posY, (int) player.posZ - 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX - 0.2, (int) player.posY, (int) player.posZ - 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX - 0.2, (int) player.posY, (int) player.posZ + 0.2, 0, 0, 0);
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX + 0.5, (int) player.posY, (int) player.posZ, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX + 0.2, (int) player.posY, (int) player.posZ, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX - 0.5, (int) player.posY, (int) player.posZ, 0, 0, 0);	
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX - 0.2, (int) player.posY, (int) player.posZ, 0, 0, 0);	
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX, (int) player.posY, (int) player.posZ + 0.5, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX, (int) player.posY, (int) player.posZ + 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX, (int) player.posY, (int) player.posZ - 0.5, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD.getParticleName(), (int) player.posX, (int) player.posY, (int) player.posZ - 0.2, 0, 0, 0);
		};
	}
	
	public static class Rankyaku extends AbilityItem
	{
		public Rankyaku() 
		{
			this.attr = ListAttributes.RANKYAKU; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new RokushikiProjectiles.Rankyaku(world, player, attr);
		}
	}
	

	public static class Shigan extends AbilityItem
	{
		public Shigan() 
		{
			this.attr = ListAttributes.SHIGAN; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new RokushikiProjectiles.Shigan(world, player, attr);
		}
	}
	
	public static class Kamie extends AbilityItem
	{
		public Kamie() 
		{
			this.attr = ListAttributes.KAMIE; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			
		}
	}
}
