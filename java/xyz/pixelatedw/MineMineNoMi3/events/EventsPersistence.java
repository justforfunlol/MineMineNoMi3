package xyz.pixelatedw.MineMineNoMi3.events;

import com.google.common.collect.Iterables;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.DorikiEvent;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEffects;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class EventsPersistence
{

	/*
	 * onEntityUpdate 
	 * > Job boosts 
	 * > Fall damage nullification for Gomu & Bane 
	 * > Poison placement for Doku 
	 * > Doku nullification of poison damage 
	 * > Extra HP 
	 * > Fishman swimming boost 
	 * > Nullification of swimming for DF users 
	 * > Kilo gliding & falling
	 * > Buso Haki Timer
	 * 
	 * onPlayerDrinkMilk 
	 * > Removes abilities & persistance from user when milk is used
	 * 
	 * onEntityDeath 
	 * > Removing abilities when the user dies 
	 * > Doriki, Bounty & Belly rewards for killing players/mobs
	 * 
	 * onEntityAttackEvent 
	 * > Lava/Fire damage nullification for Mera & Magu 
	 * > Logia protection
	 * 
	 * onEntityJoinWorld 
	 * > Syncing between dimensions 
	 * > Gives a creation book for users without job/race/faction
	 * 
	 * onDorikiGained 
	 * > Rewards the user with rokushiki/fishman karate based on doriki
	 */


	/** XXX onEntityUpdate */
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		/*if(event.entityLiving instanceof Doppelman && !event.entityLiving.worldObj.isRemote)
		{
			Doppelman dopp = (Doppelman) event.entityLiving;
			EntityPlayer doppOwner = dopp.getOwner();

			if(doppOwner != null)
			{
				if(dopp != null)
				{
					ItemStack heldItem = doppOwner.getHeldItem();
					if(heldItem != null && heldItem.getItem() == ListAbilities.DOPPELMAN && dopp.getDistanceSqToEntity(doppOwner) > 6000)
					{
						dopp.setDead();
						heldItem.getTagCompound().setBoolean("doppelman", false);
					}
				}
			}
			else
				dopp.setDead();
		}*/
		
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			ItemStack heldItem = player.getHeldItem();
			IAttributeInstance maxHp = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
			int extraHP;
			
			if(!player.worldObj.isRemote)
			{
				for(int i = 0; i < props.getAbilitiesInHotbar(); i++)
				{
					if(props.getAbilityFromSlot(i) != null && !props.getAbilityFromSlot(i).equals("n/a"))
					{
						props.getAbilityFromSlot(i).update(player);
					}
				}
			}
			
			if (!props.getRace().equals(ID.RACE_CYBORG))
			{
				extraHP = (int) Math.pow(Math.log(props.getDoriki() + 1), 3) / 4 + 5;
				if (extraHP < 20)
					player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
				else
					player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(extraHP);
			}
			else
			{
				extraHP = (int) props.getUltraColaConsumed() * 20;
				if (extraHP < 20)
					player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
				else
					player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(extraHP);				
			}
			
			if (heldItem != null)
			{
				if (props.getJob().equals(ID.JOB_SWORDSMAN) && !heldItem.getItem().getItemAttributeModifiers().isEmpty()
						&& ((AttributeModifier) Iterables.get(heldItem.getItem().getItemAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()), 0)).getAmount() > 0)
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2, 1, false));

				if (props.getJob().equals(ID.JOB_SNIPER) && heldItem.getItemUseAction() == EnumAction.bow)
				{

				}

				if (props.getJob().equals(ID.JOB_DOCTOR))
				{

				}
				
				/*if(heldItem.getItem() == ListMisc.Umbrella && player.worldObj.getBlock((int)player.posX, (int)player.posY - 4, (int)player.posZ) == Blocks.air && !player.capabilities.isCreativeMode)
					player.motionY = -0.05;
				
				if(props.getUsedFruit().equals("kilokilo") && heldItem.getItem() == ListAbilities.KILOPRESS)
				{
					if (props.getKilo())
					{
						player.motionY -= 3;
						player.fallDistance = 0;
					}
					if ( !props.getKilo() && !heldItem.getTagCompound().getBoolean("use") )
						player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 20, true));
				}*/
			}
			
			if (props.getUsedFruit().equals("gomugomu") || props.getUsedFruit().equals("banebane") || props.isLogia() || (player.getHeldItem() != null 
					|| (player.getHeldItem() != null)) )
				player.fallDistance = 0;

			if (props.getUsedFruit().equals("dokudoku"))
			{
				if (player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != Blocks.air
						&& player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != ListMisc.Poison
						&& player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != ListMisc.Ope
						&& player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != ListMisc.OpeMid)
					player.worldObj.setBlock((int)player.posX, (int)player.posY, (int)player.posZ, ListMisc.Poison);

				if (player.isPotionActive(Potion.poison.id))
					player.removePotionEffect(Potion.poison.id);
			}
			
			if ((player.isInsideOfMaterial(Material.water) || (player.isWet() && player.worldObj.getBlock((int) player.posX, (int) player.posY - 3, (int) player.posZ) == Blocks.water))
					&& !player.capabilities.isCreativeMode)
			{
				if (!props.getUsedFruit().equals("N/A"))
					player.motionY -= 5;

				if (props.getRace().equals(ID.RACE_FISHMAN) && props.getUsedFruit().equals("N/A"))
				{
					player.setAir(300);

					if ((player.motionX >= 5.0D) || (player.motionZ >= 5.0D))
					{
						player.motionX /= 1.2D;
						player.motionZ /= 1.2D;
					}
					else
					{
						player.motionX *= 1.2D;
						player.motionZ *= 1.2D;
					}
				}
			}
			
			if(props.hasHakiActive())
				props.addHakiTimer();
			else
				props.resetHakiTimer();
			
			if(props.getHakiTimer() > 2400)
			{
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 0));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 1000, 0));
				props.triggerActiveHaki();
				props.resetHakiTimer();
			}
			
		}
	}	

	/** XXX onLivingDeath */
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
		}

		if (event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			EntityLivingBase target = event.entityLiving;

			IAttributeInstance attrAtk = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage);
			IAttributeInstance attrHP = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);

			if (attrAtk != null && attrHP != null)
			{
				double i = attrAtk.getAttributeValue();
				double j = attrHP.getAttributeValue();
				int rng = player.worldObj.rand.nextInt(3) + 1;
				int haki_rng = player.worldObj.rand.nextInt(199) + 1;

				if (target instanceof EntityPlayer)
				{
					ExtendedEntityStats targetprops = ExtendedEntityStats.get(player);

					if (props.getDoriki() < Values.MAX_DORIKI && !props.getRace().equals(ID.RACE_CYBORG))
						props.addDoriki((targetprops.getDoriki() / 3) + rng);
					if (props.getBelly() < Values.MAX_GENERAL)
						props.addBelly(targetprops.getBelly());
					if ((props.getFaction().equals(ID.FACTION_PIRATE) || props.getFaction().equals(ID.FACTION_REVOLUTIONARY))
							&& (targetprops.getFaction().equals(ID.FACTION_PIRATE) || targetprops.getFaction().equals(ID.FACTION_REVOLUTIONARY)))
						if (props.getBounty() < Values.MAX_GENERAL)
							props.addBounty(targetprops.getBounty() / 2);
				}
				else
				{
					if (props.getFaction().equals(ID.FACTION_MARINE) && target instanceof MarineData)
						return;

					if ((int) Math.round(((i + j) / 10) / Math.PI) + rng > 0)
						if (props.getDoriki() < Values.MAX_DORIKI && !props.getRace().equals(ID.RACE_CYBORG))
						{
							props.addDoriki((int) Math.round(((i + j) / 10) / Math.PI) + rng);
							DorikiEvent e = new DorikiEvent(player);
							if (MinecraftForge.EVENT_BUS.post(e))
								return;
						}
					if (props.getFaction().equals(ID.FACTION_PIRATE) || props.getFaction().equals(ID.FACTION_REVOLUTIONARY))
						if ((int) Math.round((i + j) / 10) + rng > 0)
							if (props.getBounty() < Values.MAX_GENERAL)
								props.addBounty((int) Math.round(((i + j) / 10) / Math.PI));
				}

				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			}
		}
	}

	/** XXX onEntityAttackEvent */
	@SubscribeEvent
	public void onEntityAttackEvent(LivingAttackEvent event)
	{
		EntityLivingBase entity = event.entityLiving;
		Entity sourceOfDamage = event.source.getSourceOfDamage();
		ExtendedEntityStats props = ExtendedEntityStats.get(entity);

		for (int i = -2; i <= 2; i++)
			for (int j = -2; j <= 2; j++)
				for (int k = -2; k <= 2; k++)
					if (entity.worldObj.getBlock((int)entity.posX + i, (int)entity.posY + j, (int)entity.posZ + k) == ListMisc.KairosekiOre || entity.worldObj.getBlock((int)entity.posX + i, (int)entity.posY + j, (int)entity.posZ + k) == ListMisc.KairosekiBlock)
						return;
		
		if (sourceOfDamage instanceof EntityPlayer)
		{
			
			ExtendedEntityStats propz = ExtendedEntityStats.get((EntityLivingBase) sourceOfDamage);
			ItemStack heldItem = ((EntityLivingBase) sourceOfDamage).getHeldItem();

			if(heldItem != null)
			{
				boolean hasKairosekiWeapon = heldItem.isItemEnchanted() ? EnchantmentHelper.getEnchantmentLevel(ListEffects.kairoseki.effectId, heldItem) > 0 : false;
				boolean hasHaki = propz.hasHakiActive();
	
				if (entity instanceof EntityPlayer)
				{
					if (props.isLogia())
						if (!hasHaki && !hasKairosekiWeapon)
							event.setCanceled(true);
				}
				else
				{
					if (entity instanceof EntityNewMob)
					{
						if (((EntityNewMob) entity).isLogia())
							if (!hasHaki && !hasKairosekiWeapon)
								event.setCanceled(true);
					}
					else
					{
						// Possible mods/plugins support ?
					}					
				}
			}
		}

		if (sourceOfDamage instanceof EntityLivingBase)
		{
			boolean hasKairosekiWeapon;
			boolean hasHaki;
			if (sourceOfDamage instanceof EntityNewMob)
				hasHaki = ((EntityNewMob) sourceOfDamage).hasHaki();
			else
				hasHaki = false;

			if (props.isLogia())
				if (!hasHaki)
					event.setCanceled(true);

		}
 
		if (sourceOfDamage instanceof EntityArrow)
		{
			if (entity instanceof EntityPlayer && props.isLogia())
				event.setCanceled(true);

		}

		if (event.entityLiving instanceof EntityPlayer)
		{
			if (props.getUsedFruit().equals("meramera") && (event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire)))
			{
				entity.extinguish();
				event.setCanceled(true);
			}
			if (props.getUsedFruit().equals("magumagu")
					&& (event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire) || event.source.equals(DamageSource.lava)))
			{
				entity.extinguish();
				event.setCanceled(true);
			}
		}
	}

	/** XXX onEntityJoinWorld */
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);

			if (!player.worldObj.isRemote)
			{
				if (props.getRace().equals("N/A") && props.getFaction().equals("N/A") && props.getJob().equals("N/A") && !player.inventory.hasItemStack(new ItemStack(ListMisc.CharacterCreator)))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.CharacterCreator, 1));
				for (int i = 0; i < MinecraftServer.getServer().worldServers.length; i++)
					WyNetworkHelper.sendToDimension(new PacketSync(props), i);
			}
		}
	}
	

	/** XXX onDorikiGained */
	@SubscribeEvent
	public void onDorikiGained(DorikiEvent event)
	{
		if (event.props.getRace().equals(ID.RACE_HUMAN))
		{
			ability(event.player, 500, RokushikiAbilities.SORU);
			ability(event.player, 1500, RokushikiAbilities.TEKKAI);
			ability(event.player, 3000, RokushikiAbilities.SHIGAN);
			ability(event.player, 4500, RokushikiAbilities.GEPPO);
			//KENBOSHOUKU - 5000
			ability(event.player, 6000, RokushikiAbilities.KAMIE);
			ability(event.player, 8500, RokushikiAbilities.RANKYAKU);
			//BUSOSHOKU - 9000
			//HAOSHOKU - 9000 + other
			
		}
		/*else if (event.props.getRace().equals(ID.RACE_FISHMAN))
		{
			ability(event.player, 500, FishKarateAbilities.UCHIMIZU);
			ability(event.player, 1500, FishKarateAbilities.YARINAMI);
			ability(event.player, 3000, FishKarateAbilities.SAMEHADASHOTEI);
			ability(event.player, 4500, FishKarateAbilities.SOSHARK);
			ability(event.player, 6000, FishKarateAbilities.MURASAME);
			ability(event.player, 8500, FishKarateAbilities.KARAKUSAGAWARASEIKEN);
		}*/
	}	

	private void ability(EntityPlayer player, int doriki, Ability ability)
	{
		ExtendedEntityStats props = ExtendedEntityStats.get(player);	
		if (props.getDoriki() >= doriki && !props.hasRacialAbility(ability))
			props.addRacialAbility(ability);
		if (props.getDoriki() < doriki && props.hasRacialAbility(ability))
			props.removeRacialAbility(ability);
	}
	
}
