package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.PikaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class PikaAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new YataNoKagami(), new YasakaniNoMagatama(), new Amaterasu()};
	
	public static class Amaterasu extends Ability
	{
		public Amaterasu() 
		{
			super(ListAttributes.AMATERASU); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new PikaProjectiles.Amaterasu(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class YasakaniNoMagatama extends Ability
	{
		public YasakaniNoMagatama() 
		{
			super(ListAttributes.YASAKANINOMAGATAMA); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new PikaProjectiles.YasakaniNoMagatama(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class YataNoKagami extends Ability
	{
		public YataNoKagami() 
		{
			super(ListAttributes.YATANOKAGAMI); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				if(WyHelper.rayTraceBlocks(player) != null)
				{
					MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);
					
					int x = mop.blockX;
					int y = mop.blockY;
					int z = mop.blockZ;
					if (player.isRiding())
						player.mountEntity((Entity)null);
					EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 5.0F);
	                player.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
	                player.fallDistance = 0.0F;
					//isOnCooldown = true;
					//startCooldown();
				}
				super.use(player);
			}
		} 
	}

}
