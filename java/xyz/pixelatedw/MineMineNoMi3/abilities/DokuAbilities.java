package xyz.pixelatedw.MineMineNoMi3.abilities;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.DokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class DokuAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new Hydra(), new ChloroBall(), new VenomRoad(), new DokuFugu()};	
		
	
	public static class DokuFugu extends Ability
	{
		public DokuFugu() 
		{
			super(ListAttributes.DOKUFUGU); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.ChloroBall(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class VenomRoad extends Ability
	{
		public VenomRoad() 
		{
			super(ListAttributes.VENOMROAD); 
		}
		
		public void use(EntityPlayer player)
		{	
			WyHelper.sendMsgToPlayer(player, ChatFormatting.RED + "NOT YET IMPLEMENTED");
			/*if(!player.worldObj.isRemote)
			{
				if(!isOnCooldown)
				{
					if(WyHelper.rayTrace(player) != null)
					{
						MovingObjectPosition mop = WyHelper.rayTrace(player);
						 
						int x = mop.blockX;
						int y = mop.blockY;
						int z = mop.blockZ;
		
						EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0.0F);
						if(!MinecraftForge.EVENT_BUS.post(event))
						{
							if (player.isRiding())
								player.dismountEntity((Entity)null);
							player.setPositionAndRotation(x, y, z, player.rotationYaw, player.rotationPitch);
						}			
					}	
					
					isOnCooldown = true;
					startCooldown();
				}
			}*/
		} 
	}
	
	public static class ChloroBall extends Ability
	{
		public ChloroBall() 
		{
			super(ListAttributes.CHLOROBALL); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.ChloroBall(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Hydra extends Ability
	{
		public Hydra() 
		{
			super(ListAttributes.HYDRA); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.Hydra(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
}
