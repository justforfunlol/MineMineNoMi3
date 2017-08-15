package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeaponsAbilities.SharpWeapon;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.PikaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class PikaAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new AmaNoMurakumo(), new Amaterasu(), new YasakaniNoMagatama(), new YataNoKagami()};

	public static class YataNoKagami extends AbilityItem
	{
		public YataNoKagami() 
		{
			this.attr = ListAttributes.YATANOKAGAMI; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
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
		};	
	}
	
	public static class YasakaniNoMagatama extends AbilityItem
	{
		public YasakaniNoMagatama() 
		{
			this.attr = ListAttributes.YASAKANINOMAGATAMA; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new PikaProjectiles.YasakaniNoMagatama(world, player, attr);
		};	
	}
	
	public static class Amaterasu extends AbilityItem
	{
		public Amaterasu() 
		{
			this.attr = ListAttributes.AMATERASU; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new PikaProjectiles.Amaterasu(world, player, attr);
		};	
	}
	
	public static class AmaNoMurakumo extends SharpWeapon
	{
		public AmaNoMurakumo() 
		{
			super(9, false);
			this.attr = ListAttributes.AMANOMURAKUMO; 
		}
	}
	
}
