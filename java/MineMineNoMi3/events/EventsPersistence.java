package MineMineNoMi3.events;

import com.google.common.collect.Iterables;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.entities.mobs.marines.MarineData;
import MineMineNoMi3.events.entityevents.DorikiEvent;
import MineMineNoMi3.lists.IDs;
import MineMineNoMi3.lists.ListAbilities;
import MineMineNoMi3.lists.ListMisc;
import MineMineNoMi3.packets.PacketSync;
import WyPI.abilities.AbilityItem;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsPersistence 
{
	
	/*	onEntityUpdate
	 * 		> Job boosts
	 * 		> Fall damage nullification for Gomu & Bane
	 * 		> Poison placement for Doku
	 * 		> Extra HP
	 * 
	 * 	onPlayerDrinkMilk
	 * 		> Removes abilities & persistance from user when milk is used
	 * 
	 * 	onLivingDeath
	 * 		> Doriki, Bounty & Belly rewards for killing players/mobs
	 * 
	 * 	onEntityAttackEvent
	 * 		> Lava/Fire damage nullification for Mera & Magu
	 * 		> Logia protection
	 * 
	 * 	onEntityJoinWorld
	 * 		> Syncing between dimensions
	 * 		> Gives a creation book for users without job/race/faction
	 * 
	 * 	onDorikiGained
	 * 		> Rewards the user with rokushiki/fishman karate based on doriki
	 */
	
	/**XXX onEntityUpdate */
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{	
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);	
			IAttributeInstance maxHp = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);		
			int extraHP;

			if(!props.getRace().equals(IDs.ID_RACE_CYBORG))
			{
				extraHP = (int)Math.pow( Math.log(props.getDoriki() + 1 ), 3) / 4 + 5;
				if(extraHP < 20)
					player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
				else
					player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(extraHP);
			}
			else
			{
				
			}
			
			if(heldItem != null) 
			{	
				if(props.getJob().equals(IDs.ID_JOB_SWORDSMAN) && !heldItem.getItem().getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND).isEmpty() && ((AttributeModifier)Iterables.get(heldItem.getItem().getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName()), 0)).getAmount() > 0)
					player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2, 1, false, false));
				
				if(props.getJob().equals(IDs.ID_JOB_SNIPER) && heldItem.getItemUseAction() == EnumAction.BOW)
				{
				
				}
				
				if(props.getJob().equals(IDs.ID_JOB_DOCTOR))
				{
					
				}
			}
			
			if(props.getUsedFruit().equals("gomugomu") || props.getUsedFruit().equals("banebane") || props.isLogia() || 
					(player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ListAbilities.GEPPO))
				player.fallDistance = 0;
			
			if(props.getUsedFruit().equals("dokudoku") && player.worldObj.getBlockState(new BlockPos(player.posX, player.posY - 1, player.posZ)) != Blocks.AIR.getDefaultState()
					&& player.worldObj.getBlockState(new BlockPos(player.posX, player.posY - 1, player.posZ)) != ListMisc.Poison.getDefaultState() && player.worldObj.getBlockState(new BlockPos(player.posX, player.posY - 1, player.posZ)) != ListMisc.Ope.getDefaultState()
					&& player.worldObj.getBlockState(new BlockPos(player.posX, player.posY - 1, player.posZ)) != ListMisc.OpeMid.getDefaultState())
				player.worldObj.setBlockState(new BlockPos(player.posX, player.posY, player.posZ), ListMisc.Poison.getDefaultState());
			
			//System.out.println( (int)Math.pow( Math.log(10000 + 1 ), 3) / 2 );
			
			/*int extraHP = (int)Math.pow(Math.log(props.getDoriki()+1), 3)/2;

			if(extraHP < 20)
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			else
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(extraHP);*/
		}
	}
	
	/**XXX onPlayerDrinkMilk */
	@SubscribeEvent
	public void onPlayerDrinkMilk(RightClickItem event)
	{
		if(event.getEntityPlayer() != null && event.getItemStack() != null 
				&& event.getItemStack().getItem() == Items.MILK_BUCKET && !event.getWorld().isRemote)
		{
			IEntityCapability props = event.getEntityPlayer().getCapability(Values.ENTITY_CAPABILITIES, null);
			
			for(ItemStack is : event.getEntityPlayer().inventory.mainInventory)
				if(is != null && is.getItem() instanceof AbilityItem)
					event.getEntityPlayer().inventory.deleteStack(is);

			props.setUsedFruit("N/A");
			props.setIsLogia(false);
			
			WyNetworkHelper.instance().sendTo(new PacketSync(props), (EntityPlayerMP)event.getEntityPlayer());
		}
	}

	/**XXX onLivingDeath */
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
	    if(event.getSource().getEntity() instanceof EntityPlayer)
	    { 
			EntityPlayer player = (EntityPlayer)event.getSource().getEntity();
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			EntityLivingBase target = event.getEntityLiving();
			
			IAttributeInstance attrAtk = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
			IAttributeInstance attrHP = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH);
			
			if(attrAtk != null && attrHP != null)
			{ 
				double i = attrAtk.getAttributeValue();
				double j = attrHP.getAttributeValue();
				int rng = player.worldObj.rand.nextInt(3)+1;
				int haki_rng = player.worldObj.rand.nextInt(199)+1;
				
				if(target instanceof EntityPlayer)
				{
					IEntityCapability targetprops = player.getCapability(Values.ENTITY_CAPABILITIES, null);
					
					if(props.getDoriki() < Values.MAX_DORIKI && !props.getRace().equals(IDs.ID_RACE_CYBORG))
						props.addDoriki((targetprops.getDoriki()/3) + rng);
					if(props.getBelly() < Values.MAX_GENERAL)
						props.addBelly(targetprops.getBelly());
					if( ( props.getFaction().equals(IDs.ID_FACTION_PIRATE) || props.getFaction().equals(IDs.ID_FACTION_REVOLUTIONARY) ) && ( targetprops.getFaction().equals(IDs.ID_FACTION_PIRATE) || targetprops.getFaction().equals(IDs.ID_FACTION_REVOLUTIONARY)) )
						if(props.getBounty() < Values.MAX_GENERAL)
							props.addBounty(targetprops.getBounty()/2);
				} 
				else
				{
					if(props.getFaction().equals(IDs.ID_FACTION_MARINE) && target instanceof MarineData)
						return;
					
					if( (int)Math.round( ( (i + j) / 10) / Math.PI ) + rng > 0 )
						if(props.getDoriki() < Values.MAX_DORIKI && !props.getRace().equals(IDs.ID_RACE_CYBORG))
						{
							props.addDoriki((int)Math.round( ( (i + j) / 10 ) / Math.PI ) + rng );
							DorikiEvent e = new DorikiEvent(player);
							if (MinecraftForge.EVENT_BUS.post(e)) return;
						}
					if( props.getFaction().equals(IDs.ID_FACTION_PIRATE) || props.getFaction().equals(IDs.ID_FACTION_REVOLUTIONARY) )
						if( (int)Math.round( (i + j) / 10 ) + rng > 0 )
							if(props.getBounty() < Values.MAX_GENERAL)
								props.addBounty( (int)Math.round( ( (i + j) / 10) / Math.PI ) );
				}
				
				WyNetworkHelper.instance().sendTo(new PacketSync(props), (EntityPlayerMP)player);
			}
	    }
	}
	
	/**XXX onEntityAttackEvent */
	@SubscribeEvent
	public void onEntityAttackEvent(LivingAttackEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		Entity sourceOfDamage = event.getSource().getSourceOfDamage();
		IEntityCapability props = entity.getCapability(Values.ENTITY_CAPABILITIES, null);
		
		if(sourceOfDamage instanceof EntityPlayer)
		{
			boolean hasKairosekiWeapon;
			boolean hasHaki;
			
			if(entity instanceof EntityPlayer)
			{
				
			}
			else
			{
				
			}
			//TBC
		}
		
		if(sourceOfDamage instanceof EntityLivingBase)
		{
			boolean hasKairosekiWeapon;
			boolean hasHaki = false;
			
			if(props.isLogia())
				if(!hasHaki)
					event.setCanceled(true);
		}
		
		if(sourceOfDamage instanceof EntityArrow)
		{			
			if(entity instanceof EntityPlayer && props.isLogia())
				event.setCanceled(true);

		}
		
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			if(props.getUsedFruit().equals("meramera") && (event.getSource().equals(DamageSource.inFire) || event.getSource().equals(DamageSource.onFire)))
			{
				entity.extinguish();
				event.setCanceled(true);
			}
			if(props.getUsedFruit().equals("magumagu") && (event.getSource().equals(DamageSource.inFire) || event.getSource().equals(DamageSource.onFire) || event.getSource().equals(DamageSource.lava)))
			{
				entity.extinguish();
				event.setCanceled(true);
			}
		}
	}
	
	/**XXX onEntityJoinWorld */
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.getEntity();
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			
			if(!player.worldObj.isRemote)
			{
		    	if(props.getRace().equals("N/A") && props.getFaction().equals("N/A") && props.getJob().equals("N/A") && !player.inventory.hasItemStack(new ItemStack(ListMisc.CharacterCreator)))
		    		player.inventory.addItemStackToInventory(new ItemStack(ListMisc.CharacterCreator, 1));
				for(int i = 0; i < player.getServer().worldServers.length; i++)
					WyNetworkHelper.instance().sendToDimension(new PacketSync(props), i);
			}
		}
	}
	
	/**XXX onDorikiGained */
	@SubscribeEvent
	public void onDorikiGained(DorikiEvent event)
	{
		if(event.props.getRace().equals(IDs.ID_RACE_HUMAN))
		{
			ability(event.player, 500, ListAbilities.SORU);
			ability(event.player, 1500, ListAbilities.TEKKAI);
			ability(event.player, 3000, ListAbilities.SHIGAN);
			ability(event.player, 4500, ListAbilities.GEPPO);
			ability(event.player, 6000, ListAbilities.KAMIE);
			ability(event.player, 8500, ListAbilities.RANKYAKU);
		}
		else if(event.props.getRace().equals(IDs.ID_RACE_FISHMAN))
		{
			ability(event.player, 500, ListAbilities.UCHIMIZU);
			ability(event.player, 1500, ListAbilities.YARINAMI);
			ability(event.player, 3000, ListAbilities.SAMEHADASHOTEI);
			ability(event.player, 4500, ListAbilities.SOSHARK);
			ability(event.player, 6000, ListAbilities.MURASAME);
			ability(event.player, 8500, ListAbilities.KARAKUSAGAWARASEIKEN);			
		}
	}
	
	private void ability(EntityPlayer player, int doriki, Item ability)
	{
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
		if(props.getDoriki() >= doriki && !player.inventory.hasItemStack(new ItemStack(ability)))
			player.inventory.addItemStackToInventory(new ItemStack(ability));	
		if(props.getDoriki() < doriki && player.inventory.hasItemStack(new ItemStack(ability)))
			player.inventory.deleteStack(new ItemStack(ability));
	}
}
