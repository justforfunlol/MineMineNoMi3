package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari200Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari20Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari5Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari60Million;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class GoroAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new ElThor(), new VoltVari(), new Raigo(), new Kari(), new Sango()};
	
	public static class ElThor extends Ability
	{
		public ElThor() 
		{
			super(ListAttributes.ELTHOR); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			super.startCharging(player);				
		}
		
		public void duringCharging(EntityPlayer player, int currentCharge)
		{		
			MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
			
			if(mop != null)
			{
				double i = mop.blockX;
				double j = mop.blockY;
				double k = mop.blockZ;

				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ELTHOR, i, j, k), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			}
		}
		
		public void endCharging(EntityPlayer player)
		{						
			MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
			
			if(mop != null)
			{
				double i = mop.blockX;
				double j = mop.blockY;
				double k = mop.blockZ;

				WyNetworkHelper.sendTo(new PacketPlayer("ElThorThunder", i, j, k), (EntityPlayerMP) player);
				player.worldObj.newExplosion(new EntityLightningBolt(player.worldObj, i, j, k), i, j, k, 6, true, MainConfig.enableGriefing);
			}
			
			super.endCharging(player);
		}
	}
	
	public static class VoltVari extends Ability
	{
		private int power = 0;
		
		public VoltVari() 
		{
			super(ListAttributes.VOLTVARI); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				isCharging = true;
				this.startExtUpdate(player);
			}
		}
		
		public void duringCharging(EntityPlayer player, int currentCharge)
		{		
			power = currentCharge;
			double truePower = Math.abs(power - this.attr.getAbilityCharges());

			if(truePower % 50 == 0 && MainConfig.enableAnimeScreaming)
			{
				int voltVariType = (int) Math.floor(truePower / 50);
				switch(voltVariType)
				{
					case 1:
						this.attr.setAttributeName("1 Million Volt Vari");
						break;
					case 2:
						this.attr.setAttributeName("5 Million Volt Vari");
						break;
					case 3:
						this.attr.setAttributeName("10 Million Volt Vari");
						break;
					case 4:
						this.attr.setAttributeName("20 Million Volt Vari");
						break;
					case 5:
						this.attr.setAttributeName("50 Million Volt Vari");
						break;
					case 6:
						this.attr.setAttributeName("60 Million Volt Vari");
						break;
					case 7:
						this.attr.setAttributeName("100 Million Volt Vari");
						break;
				}
				
				if(voltVariType < 8)
					this.sendShounenScream(player);
			}
		}
		
		public void endCharging(EntityPlayer player)
		{
			double truePower = Math.abs(power - this.attr.getAbilityCharges());
			double trueCooldown = (truePower / 50) * 3;

			if(truePower > 0 && truePower <= 100)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 0 && truePower <= 90)
						this.attr.setAttributeName("1 Million Volt Vari");
					else
						this.attr.setAttributeName("5 Million Volt Vari");
				}
				this.projectile = new VoltVari5Million(player.worldObj, player, ListExtraAttributes.VOLTVARI5MILLION);
			}
			else if(truePower > 200 && truePower <= 300)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 500 && truePower <= 600)
						this.attr.setAttributeName("10 Million Volt Vari");
					else
						this.attr.setAttributeName("20 Million Volt Vari");
				}
				this.projectile = new VoltVari20Million(player.worldObj, player, ListExtraAttributes.VOLTVARI20MILLION);
			}
			else if(truePower > 800 && truePower <= 900)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 1000 && truePower <= 1050)
						this.attr.setAttributeName("50 Million Volt Vari");
					else
						this.attr.setAttributeName("60 Million Volt Vari");
				}
				this.projectile = new VoltVari60Million(player.worldObj, player, ListExtraAttributes.VOLTVARI60MILLION);
			}
			else if(truePower > 1500 && truePower <= 1600)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 2000 && truePower <= 2100)
						this.attr.setAttributeName("100 Million Volt Vari");
					else
						this.attr.setAttributeName("Max 200 Million Volt Vari");
				}
				this.projectile = new VoltVari200Million(player.worldObj, player, ListExtraAttributes.VOLTVARI200MILLION);
			}
			
			this.sendShounenScream(player);
				
			this.attr.setAbilityCooldown(trueCooldown);

			this.isCharging = false;
			this.isOnCooldown = true;	
			WyNetworkHelper.sendTo(new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP) player);

	    	if(!ID.DEV_EARLYACCESS && !player.capabilities.isCreativeMode)
	    		WyTelemetry.addStat("abilityUsed_" + this.getAttribute().getAttributeName(), 1);

			if(projectile != null)
				player.worldObj.spawnEntityInWorld(projectile);
			
			this.startExtUpdate(player);
		}
	}
	
	public static class Raigo extends Ability
	{
		public Raigo() 
		{
			super(ListAttributes.RAIGO); 
		}
		
		public void use(EntityPlayer player)
		{			
			if(!this.isOnCooldown)		
			{
				MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
				
				if(mop != null)
				{
					double x = mop.blockX;
					double y = mop.blockY;
					double z = mop.blockZ;
					
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_RAIGO, x, player.posY, z), player.dimension, x, y, z, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					
					AbilityProjectile proj = new GoroProjectiles.Raigo(player.worldObj, player, ListAttributes.RAIGO);	
					proj.setLocationAndAngles(x, (y + 90), z, 0, 0);
					proj.motionX = 0;
					proj.motionZ = 0;
					proj.motionY = -1.4;
					player.worldObj.spawnEntityInWorld(proj);
				}
			}
			super.use(player);
		} 
	}
	
	public static class Kari extends Ability
	{
		public Kari() 
		{
			super(ListAttributes.KARI); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)		
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KARI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.startCharging(player);				
		}
		
		public void endCharging(EntityPlayer player)
		{						
			super.endCharging(player);
		}
	}
	
	public static class Sango extends Ability
	{
		public Sango() 
		{
			super(ListAttributes.SANGO); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new GoroProjectiles.Sango(player.worldObj, player, attr);
			super.use(player);
		} 
	}

}
