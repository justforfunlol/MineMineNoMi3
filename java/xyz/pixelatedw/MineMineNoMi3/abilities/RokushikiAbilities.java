package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class RokushikiAbilities 
{
	
	public static Ability SORU = new Soru();
	public static Ability TEKKAI = new Tekkai();
	public static Ability GEPPO = new Geppo();
	public static Ability RANKYAKU = new Rankyaku();
	public static Ability SHIGAN = new Shigan();
	public static Ability KAMIE = new Kamie();
	
	public static Ability[] abilitiesArray = new Ability[] {SORU, TEKKAI, GEPPO, RANKYAKU, SHIGAN, KAMIE};
	
	public static class Soru extends Ability
	{
		public Soru() 
		{
			super(ListAttributes.SORU); 
		}
	}
	
	public static class Tekkai extends Ability
	{
		public Tekkai() 
		{
			super(ListAttributes.TEKKAI); 
		}
	}
	
	public static class Geppo extends Ability
	{
		public Geppo() 
		{
			super(ListAttributes.GEPPO); 
		}
		
		public void use(EntityPlayer player)
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
			
			super.use(player);
		};
	}
	
	public static class Rankyaku extends Ability
	{
		public Rankyaku() 
		{
			super(ListAttributes.RANKYAKU); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new RokushikiProjectiles.Rankyaku(player.worldObj, player, ListAttributes.RANKYAKU);
			super.use(player);
		}
	}
	

	public static class Shigan extends Ability
	{
		public Shigan() 
		{
			super(ListAttributes.SHIGAN); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new RokushikiProjectiles.Shigan(player.worldObj, player, ListAttributes.SHIGAN);
			super.use(player);
		}
	}
	
	public static class Kamie extends Ability
	{
		public Kamie() 
		{
			super(ListAttributes.KAMIE); 
		}
	}
}
