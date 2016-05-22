package MineMineNoMi3.Events;

import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Lists.ListAbilities;
import MineMineNoMi3.Network.PacketDispatcher;
import MineMineNoMi3.Network.Packets.PacketSyncCLIENT;
import WyPI.Ability.AbilityItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsDevilFruits 
{
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{	
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(props.getUsedFruit().equals("gomugomu") || props.getUsedFruit().equals("banebane") || props.isLogia() || 
					(player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ListAbilities.GEPPO))
				player.fallDistance = 0;
		}
	}
	
	@SubscribeEvent
	public void onPlayerDrinkMilk(RightClickItem event)
	{
		if(event.getEntityPlayer() != null && event.getItemStack() != null 
				&& event.getItemStack().getItem() == Items.MILK_BUCKET && !event.getWorld().isRemote)
		{
			IPlayerCapability props = event.getEntityPlayer().getCapability(Values.CAPABILITIES_PLAYER, null);
			
			for(ItemStack is : event.getEntityPlayer().inventory.mainInventory)
				if(is != null && is.getItem() instanceof AbilityItem)
					event.getEntityPlayer().inventory.deleteStack(is);

			props.setUsedFruit("N/A");
			props.setIsLogia(false);
			
			PacketDispatcher.sendTo(new PacketSyncCLIENT(props), (EntityPlayerMP)event.getEntityPlayer());
		}
	}
	
	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event)
	{
/*		if(event.source.getSourceOfDamage() instanceof EntityLivingBase)
		{		
			MainExtendedEntity propz = MainExtendedEntity.get( event.entityLiving );
			MainExtendedPlayer props = MainExtendedPlayer.get( (EntityPlayer) event.source.getSourceOfDamage());
			
			boolean flag1 = propz.hasHaki();
			
			if(propz.isLogia())
				if(!flag1)
					event.setCanceled(true);
			
			if(event.entityLiving instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer)event.entityLiving).isLogia())
				if(!flag1)
					event.setCanceled(true);	
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			ItemStack heldItem = player.getCurrentEquippedItem();
				
			MainExtendedEntity propz = MainExtendedEntity.get( event.entityLiving );
			
			boolean flag1 = heldItem != null && heldItem.getItem() instanceof ItemSword && heldItem.isItemEnchanted() && EnchantmentHelper.getEnchantmentLevel(ListEffects.kairoseki.effectId, heldItem) > 0;
			boolean flag2 = false;//heldItem != null && heldItem.getItem() instanceof Haki && ((Haki)heldItem.getItem()).type.equals("busoshoku") && heldItem.getTagCompound() != null && heldItem.getTagCompound().getBoolean("use");

			if(propz.isLogia())	
				if(!flag1 || !flag2)
					event.setCanceled(true);
	
			if(event.entityLiving instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer)event.entityLiving).isLogia())			
				if(!flag1 || !flag2)						
					event.setCanceled(true);			
		}*/
		
		if(event.getSource().getSourceOfDamage() instanceof EntityArrow)
		{
			EntityLivingBase living = (EntityLivingBase)event.getEntityLiving();
			/*ICapability props = living.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(living instanceof EntityPlayer && props.isLogia())
				event.setCanceled(true);	
			
			if(living instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer) living).getUsedFruit().equals("gomugomu"))
				event.setCanceled(true);*/
		}
		
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(props.getUsedFruit().equals("meramera") && (event.getSource().equals(DamageSource.inFire) || event.getSource().equals(DamageSource.onFire)))
			{
				player.extinguish();
				event.setCanceled(true);
			}
			if(props.getUsedFruit().equals("magumagu") && (event.getSource().equals(DamageSource.inFire) || event.getSource().equals(DamageSource.onFire) || event.getSource().equals(DamageSource.lava)))
			{
				player.extinguish();
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(!(event.getEntityLiving() instanceof EntityPlayer) && event.getSource().getSourceOfDamage() instanceof EntityPlayer)
		{
			//MainExtendedEntity propz = MainExtendedEntity.get(event.getEntityLiving());
			EntityPlayer killer = (EntityPlayer) event.getSource().getSourceOfDamage();
			//MainExtendedPlayer props = MainExtendedPlayer.get(killer);
			
			/*if(propz.hasShadow() && props.getUsedFruit().equals("kagekage"))
				killer.inventory.addItemStackToInventory(new ItemStack(ListMisc.Shadow));*/
		}
	}
	
}
