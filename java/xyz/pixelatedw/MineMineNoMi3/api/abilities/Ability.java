package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class Ability 
{
	
	protected AbilityProjectile projectile;
	protected AbilityAttribute attr;
	protected boolean isOnCooldown = false, isCharging = false, isRepeating = false, passiveActive = false;
	private int ticksForCooldown, ticksForCharge, ticksForRepeater, slotId = -1;
	
	public Ability(AbilityAttribute attr)
	{
		this.attr = attr;
		ticksForCooldown = attr.getAbilityCooldown();
		ticksForCharge = attr.getAbilityCharges();
		ticksForRepeater = attr.getAbilityCooldown();
	}
	
	public void setSlotId(int slot)
	{
		this.slotId = slot;
	}
	
	public int getSlotId()
	{
		return this.slotId;
	}
	
	public AbilityAttribute getAttribute() { return attr; }
	
	public void use(EntityPlayer player)
	{		
		//isOnCooldown = false;
		if(!isOnCooldown)
		{
			if(projectile != null)
			{
				if(this.attr.isRepeater())
					startRepeater(player);
				else
					player.worldObj.spawnEntityInWorld(projectile);
			}
			
			if(this.attr.getPotionEffectsForUser() != null)
				for(PotionEffect p : this.attr.getPotionEffectsForUser())				
					player.addPotionEffect(new PotionEffect(p));
					 
			if(this.attr.getPotionEffectsForAoE() != null) 
				for(PotionEffect p : this.attr.getPotionEffectsForAoE())
					for(EntityLivingBase l : WyHelper.getEntitiesNear(player, this.attr.getEffectRadius())) 
						l.addPotionEffect(new PotionEffect(p));
	
			if(!(this.attr.getAbilityCharges() > 0) && this.attr.getAbilityExplosionPower() > 0)
				player.worldObj.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getAbilityExplosionPower(), this.attr.canAbilityExplosionSetFire(), this.attr.canAbilityExplosionDestroyBlocks());		
			
			if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))	
				WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsCooldown" + this.getAttribute().getAttributeName(), true), (EntityPlayerMP) player);
			startCooldown();
		}
	}
	
	private void duringRepeater(EntityPlayer player) {}
	
	protected void startRepeater(EntityPlayer player)
	{
		this.isRepeating = true;
	}
	
	public void passive(EntityPlayer player)
	{
		if(passiveActive)
		{
			passiveActive = false;
			if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))
				WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsPassive" + this.getAttribute().getAttributeName(), false), (EntityPlayerMP) player);
			if(this.attr.getPotionEffectsForUser() != null)
				for(PotionEffect p : this.attr.getPotionEffectsForUser())	
					player.removePotionEffect(p.getPotionID());
			
			endPassive(player);
		}
		else
		{
			passiveActive = true;
			if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))
				WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsPassive" + this.getAttribute().getAttributeName(), true), (EntityPlayerMP) player);
			if(this.attr.getPotionEffectsForUser() != null)
				for(PotionEffect p : this.attr.getPotionEffectsForUser())				
					player.addPotionEffect(new PotionEffect(p.getPotionID(), Integer.MAX_VALUE, p.getAmplifier(), true));
			
			duringPassive(player);
		}
	}
	
	public void endPassive(EntityPlayer player) {}
	
	public void duringPassive(EntityPlayer player) {}
	
	public boolean isPassiveActive()
	{
		return this.passiveActive;
	}

	public void setPassiveActive(boolean b)
	{
		this.passiveActive = b;
	}
	
	public void setChargeActive(boolean b)
	{
		this.isCharging = b;
	}
	
	public void setCooldownActive(boolean b)
	{
		this.isOnCooldown = b;
	}
	
	
	
	public void duringCharging(EntityPlayer player, int currentCharge)
	{

	}
	
	public void startCharging(EntityPlayer player)
	{
		if(!isOnCooldown)
		{
			isCharging = true;
			if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))
				WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsCharging" + this.getAttribute().getAttributeName(), true), (EntityPlayerMP) player);
		}
	}
	
	public void endCharging(EntityPlayer player)
	{
		isCharging = false;
		isOnCooldown = true;
		
		if(projectile != null)
		{
			player.worldObj.spawnEntityInWorld(projectile);
		}
		

		if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))
		{
			WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsCharging" + this.getAttribute().getAttributeName(), false), (EntityPlayerMP) player);
			WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsCooldown" + this.getAttribute().getAttributeName(), true), (EntityPlayerMP) player);
		}
		startCooldown();
	}
	
	public boolean isCharging()
	{
		return isCharging;
	}
	
	public boolean isOnCooldown()
	{
		return isOnCooldown;
	}
	
	public void duringCooldown(EntityPlayer player, int currentCooldown) {}
	
	protected void startCooldown()
	{
		isOnCooldown = true;
	}
	
	public void update(EntityPlayer player) 
	{
		if(isOnCooldown)
		{
			if(ticksForCooldown > 0)
			{
				ticksForCooldown--;
				if(isRepeating)
				{
					ticksForRepeater--;
					if(ticksForRepeater > this.attr.getAbilityCooldown() - (this.attr.getAbilityCooldown() / 6) && projectile != null)
					{
						try 
						{
							player.worldObj.spawnEntityInWorld(projectile.getClass().getDeclaredConstructor(World.class, EntityLivingBase.class, AbilityAttribute.class).newInstance(player.worldObj, player, attr));
						} 
						catch (Exception e) { e.printStackTrace(); }
					}
					else
					{
						isRepeating = false;	
						ticksForRepeater = attr.getAbilityCooldown();
					}
				}
				duringCooldown(player, ticksForCooldown);
			}
			else
			{
				ticksForCooldown = this.attr.getAbilityCooldown();
				isOnCooldown = false;
				if(!player.getDisplayName().equals(FMLCommonHandler.instance().getMinecraftServerInstance().getServerOwner()))
					WyNetworkHelper.sendTo(new PacketPlayer("clientUpdateIsCooldown" + this.getAttribute().getAttributeName(), false), (EntityPlayerMP) player);
			}
		}
		if(isCharging)
		{
			if(ticksForCharge > 0)
			{
				ticksForCharge--;	
				duringCharging(player, ticksForCharge);
			}
			else
			{
				ticksForCharge = this.attr.getAbilityCharges();
				endCharging(player);
			}
		}
	}
	
	public void reset()
	{
		isOnCooldown = false;
		isCharging = false;
		isRepeating = false;
		passiveActive = false;			
	}
}
