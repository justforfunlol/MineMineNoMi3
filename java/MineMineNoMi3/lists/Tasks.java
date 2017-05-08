package MineMineNoMi3.lists;

import java.awt.Color;

import MineMineNoMi3.DevilFruitAbilitiesHelper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.entities.mobs.Doppelman;
import MineMineNoMi3.entities.models.ModelGomuBazooka;
import MineMineNoMi3.items.Heart;
import WyPI.abilities.AbilityAttribute;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityTask;
import WyPI.abilities.ModelCube;
import WyPI.abilities.ModelSphere;
import WyPI.math.ISphere;
import WyPI.math.Sphere;
import WyPI.modules.WyHelper;
import WyPI.modules.WyHelper.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class Tasks 
{
	
	public static AbilityTask changeItemForm = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(itemStack.getTagCompound().getInteger("form") == 0)
					itemStack.getTagCompound().setInteger("form", 1);
				else
					itemStack.getTagCompound().setInteger("form", 0);
			}
		}
	};
	
	public static AbilityTask liberation = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(itemStack.getTagCompound().getInteger("liberationPower") > 0)
			{
				if(!player.worldObj.isRemote)
				{
					AbilityProjectile proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.LIBERATION_BLOCK);
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 0);
					player.worldObj.spawnEntityInWorld(proj); 
					int i = itemStack.getTagCompound().getInteger("liberationPower");
					i = i - 1;
					itemStack.getTagCompound().setInteger("liberationPower", i);
				}
			}
			else
			{
				for(int x = -20; x < 20; x++)
				for(int y = -20; y < 20; y++)
				for(int z = -20; z < 20; z++)
				{
					if( player.worldObj.getBlockState(new BlockPos(player.posX + x, player.posY + y, player.posZ + z)) == ListMisc.Darkness.getDefaultState())
					{
						player.worldObj.setBlockToAir(new BlockPos(player.posX + x, player.posY + y, player.posZ + z));
						itemStack.getTagCompound().setInteger("liberationPower", 10);
					}
				}
			}
		}
	};
	
	public static AbilityTask darkMatter = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			WyHelper.instance().createSphere(abilityProjectile, 3, ListMisc.Darkness.getDefaultState());
			WyHelper.instance().createSphere(abilityProjectile, 2, ListMisc.Darkness.getDefaultState());
			WyHelper.instance().createSphere(abilityProjectile, 1, ListMisc.Darkness.getDefaultState());
		}
	};	
	
	public static AbilityTask blackHole = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.NORTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 3; j++)
				for(int k = 0; k < 12; k++)		
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 1), player.posZ - (k + 2)), ListMisc.Darkness.getDefaultState());
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.SOUTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 3; j++)
				for(int k = 0; k < 12; k++)		
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 1), player.posZ + (k + 2)), ListMisc.Darkness.getDefaultState());
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.EAST)
			{
				for(int i = 0; i < 12; i++)
				for(int j = 0; j < 3; j++)
				for(int k = -3; k < 3; k++)		
					player.worldObj.setBlockState(new BlockPos(player.posX + (i + 2), player.posY - (j + 1), player.posZ + k), ListMisc.Darkness.getDefaultState());
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.WEST)
			{
				for(int i = 0; i < 12; i++)
				for(int j = 0; j < 3; j++)
				for(int k = -3; k < 3; k++)		
					player.worldObj.setBlockState(new BlockPos(player.posX - (i + 2), player.posY - (j + 1), player.posZ + k), ListMisc.Darkness.getDefaultState());
			}
		}
	};
	
	public static AbilityTask sagariNoRyusei = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			if(!player.worldObj.isRemote)
			{			
				AbilityProjectile proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.METEOR );
				proj.setHeadingFromThrower(player, 90, 0, 0, 1.5F, 0);
				proj.setPosition(player.posX, player.posY + 100, player.posZ);
				proj.motionY = -1.9;
				player.worldObj.spawnEntityInWorld(proj);
			}
		};
	};
	 
	public static AbilityTask moko = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			if(hit.entityHit != null)
			{
				int posX = (int) hit.entityHit.posX;
				int posY = (int) hit.entityHit.posY;
				int posZ = (int) hit.entityHit.posZ;

				for(int x = -5; x < 5; x++)
				for(int y = 0; y < 22; y++)
				for(int z = -5; z < 5; z++)
				{
					if( abilityProjectile.worldObj.getBlockState(new BlockPos(posX + x, posY - y, posZ + z)) != ListMisc.Ope.getDefaultState() && abilityProjectile.worldObj.getBlockState(new BlockPos(posX + x, posY - y, posZ + z)) != ListMisc.OpeMid.getDefaultState() 
							&& abilityProjectile.worldObj.getBlockState(new BlockPos(posX + x, posY - y, posZ + z)) != Blocks.BEDROCK.getDefaultState() )
						abilityProjectile.worldObj.setBlockState(new BlockPos(posX + x, posY - y, posZ + z), Blocks.AIR.getDefaultState());
				}
			}
		};
	};
	
	public static AbilityTask chiyuHormone = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 1));
		};
		
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 1));		
		};
	};
	
	public static AbilityTask tensionHormone = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 1));
		};
		
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300, 1));
			target.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 1));			
		};
	}; 
	
	public static AbilityTask rejectDial = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 10))
			{
				target.attackEntityFrom(DamageSource.generic, Integer.MAX_VALUE);
				player.attackEntityFrom(DamageSource.generic, Integer.MAX_VALUE);
			}
		}
	};
	
	public static AbilityTask breathDial = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 10))
			{
				Direction dir = WyHelper.instance().get4Directions(target);
				if(dir == WyHelper.Direction.SOUTH)
					target.motionX -= 10;
				else if(dir == WyHelper.Direction.EAST)
					target.motionX += 10; 
				else if(dir == WyHelper.Direction.NORTH)
					target.motionZ -= 10;
				else if(dir == WyHelper.Direction.WEST)  
					target.motionZ += 10;	
			}
		}
	};
	
	public static AbilityTask consumable = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			itemStack.damageItem(2, player);
		}
	};
	
	public static AbilityTask swordsSpecialAbility = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			if(!player.worldObj.isRemote && itemStack.getTagCompound().getInteger("specialCooldown") <= 0)
			{
				if(props.getUsedFruit().equals("opeope") && DevilFruitAbilitiesHelper.isEntityInRoom(player))
				{
					AbilityProjectile proj = new AbilityProjectile(player.worldObj, (EntityPlayer) player, ListAbilities.DIALAXE.getAttribute());
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.7F, 0);
					player.worldObj.spawnEntityInWorld(proj);
					itemStack.getTagCompound().setInteger("specialCooldown", 80);
				}
				else if(props.getUsedFruit().equals("guragura"))
				{
					player.worldObj.newExplosion(player, player.posX, player.posY, player.posZ, 5, false, false);
					itemStack.getTagCompound().setInteger("specialCooldown", 140);
				}
				else if(props.getUsedFruit().equals("jikijiki"))
				{			
					AbilityProjectile proj = new AbilityProjectile(player.worldObj, (EntityPlayer) player, ListExtraAttributes.GRAVITO);
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.7F, 0);
					player.worldObj.spawnEntityInWorld(proj);
					itemStack.getTagCompound().setInteger("specialCooldown", 180);
				}
			}
		};
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			if(itemStack.getTagCompound().getInteger("specialCooldown") > 0)
			{
				int t = itemStack.getTagCompound().getInteger("specialCooldown");
				t--;
				itemStack.getTagCompound().setInteger("specialCooldown", t);
			}
		};
	};
	
	public static AbilityTask barrier = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.NORTH)
				{
					for(int x = -3; x < 3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ - 3) - z), ListMisc.Barrier.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.SOUTH)
				{
					for(int x = -3; x < 3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ + 2) - z), ListMisc.Barrier.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.EAST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlockState(new BlockPos((player.posX + 2) - x, player.posY + y, player.posZ - z), ListMisc.Barrier.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.WEST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlockState(new BlockPos((player.posX - 3) - x, player.posY + y, player.posZ - z), ListMisc.Barrier.getDefaultState());
				}
			}
		}		
	};
	
	public static AbilityTask barrierBall = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			RayTraceResult rtr = WyHelper.instance().rayTrace(player);

			if(rtr.entityHit != null)
			{
				if(rtr.entityHit instanceof EntityLivingBase)
					WyHelper.instance().createSphere(rtr.entityHit, 5, ListMisc.Barrier.getDefaultState());
			}
			else
				WyHelper.instance().createSphere(player, 5, ListMisc.Barrier.getDefaultState());
		}
	};
	
	public static AbilityTask kilopress = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			if(!props.getKilo())
				props.setKilo(true);
			else
				props.setKilo(false);
		}
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);		
			if(props.getKilo())
			{
				itemStack.setStackDisplayName("§r10,000 Kilo Press");
				if(player.onGround)
				{
					for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(player, 2))
						e.attackEntityFrom(DamageSource.causePlayerDamage(player), 25);
					props.setKilo(false);
				}
			}
			else
				itemStack.setStackDisplayName("§r1 Kilo Press");
		}
	};
	
	
	public static AbilityTask parfumefemur = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
			target.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 300, 1));
		}
	};
	
	public static AbilityTask sparclaw = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 10);
		};
	};
	
	public static AbilityTask chloroball = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit) 
		{
			if(!abilityProjectile.worldObj.isRemote)
			{
				for(int i = -1; i < 1; i++)
				for(int j = -1; j < 0; j++)
				for(int k = -1; k < 1; k++)
					abilityProjectile.worldObj.setBlockState(new BlockPos(abilityProjectile.getPosition().getX() + i, abilityProjectile.getPosition().getY() + j, abilityProjectile.getPosition().getZ() + k), ListMisc.Poison.getDefaultState());
				
			}
		};
	};

	public static AbilityTask haohokuhaki = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			
			for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 50))
			{
				IEntityCapability propz = target.getCapability(Values.ENTITY_CAPABILITIES, null);

				if(props.getDoriki() > propz.getDoriki() * 2)
				{
					target.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1000, 2));
					target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1000, 10));
					target.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 1000, 10));
				}
			}
		}
	};
	
	public static AbilityTask busoshokuhaki = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
			
			if(!props.hasHakiActive())
			{
				props.triggerActiveHaki();
				itemStack.getTagCompound().setBoolean("use", true);
			}
			else
			{
				props.triggerActiveHaki();
				itemStack.getTagCompound().setBoolean("use", false);
			}
		}
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(!props.hasHakiActive())
			{
				itemStack.getTagCompound().setBoolean("use", false);
			}
		};
	};
	
	public static AbilityTask kenbunshokuhaki = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 100))
				target.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 1));
		}
	};
	
	public static AbilityTask karakusagawaraseiken = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(player, 25))
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 30);

				e.motionY += 0.3;
				
				if(player.worldObj.rand.nextInt(2) == 0)
				{
					if(player.worldObj.rand.nextInt(2) == 0)
						e.motionX += 0.8;
					if(player.worldObj.rand.nextInt(2) == 1)
						e.motionX -= 0.8;
				}
				if(player.worldObj.rand.nextInt(2) == 1)
				{
					if(player.worldObj.rand.nextInt(2) == 0)
						e.motionZ += 0.8;
					if(player.worldObj.rand.nextInt(2) == 1)
						e.motionZ -= 0.8;
				}
	
			}
		}
	};
	
	public static AbilityTask fubuki = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, final EntityPlayer player)
		{
			for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(player, 25))
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 10);
				e.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 2));
				
				Sphere.generate((int)player.posX, (int)player.posY, (int)player.posZ, 25, new ISphere()
			    { 
					public void call(int x, int y, int z)
					{
		    			for(int i = -4; i <= 4; i++)
				    		if(player.worldObj.isAirBlock(new BlockPos(x, y, z)) && player.worldObj.getBlockState(new BlockPos(x, y - 1, z)) != Blocks.AIR.getDefaultState() && player.worldObj.getBlockState(new BlockPos(x, y - 1, z)) != Blocks.SNOW_LAYER.getDefaultState()  )
				    			player.worldObj.setBlockState(new BlockPos(x, y, z), Blocks.SNOW_LAYER.getDefaultState());
					}
			    });
			}
		}
	};
	
	public static AbilityTask tabirayuki = new AbilityTask() {public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) { target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1, 60));; }};
	
	public static AbilityTask kamakurajusshoshi = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				
				if(WyHelper.instance().rayTrace(player).entityHit != null && WyHelper.instance().rayTrace(player).entityHit instanceof EntityLivingBase)
				{
					WyHelper.instance().createSphere(WyHelper.instance().rayTrace(player).entityHit, 4, Blocks.SNOW.getDefaultState());
					WyHelper.instance().createSphere(WyHelper.instance().rayTrace(player).entityHit, 6, Blocks.SNOW.getDefaultState());
					WyHelper.instance().createSphere(WyHelper.instance().rayTrace(player).entityHit, 8, Blocks.SNOW.getDefaultState());
				}
				else
				{
					WyHelper.instance().createSphere(player, 4, Blocks.SNOW.getDefaultState());
					WyHelper.instance().createSphere(player, 6, Blocks.SNOW.getDefaultState());
					WyHelper.instance().createSphere(player, 8, Blocks.SNOW.getDefaultState());
				}
			}
		}		
	};
	
	public static AbilityTask kamakura = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(WyHelper.instance().rayTrace(player).entityHit != null && WyHelper.instance().rayTrace(player).entityHit instanceof EntityLivingBase)
					WyHelper.instance().createSphere(WyHelper.instance().rayTrace(player).entityHit, 4, Blocks.SNOW.getDefaultState());
				else
					WyHelper.instance().createSphere(player, 4, Blocks.SNOW.getDefaultState());
			}
		}		
	};
	
	public static AbilityTask bakuretsukazan = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				for(int i = -7; i < 7; i++)
				for(int j = -5; j < 0; j++)
				for(int k = -7; k < 7; k++)
					player.worldObj.setBlockState(new BlockPos(player.getPosition().getX() + i, player.getPosition().getY() + j, player.getPosition().getZ() + k), Blocks.FLOWING_LAVA.getDefaultState());
			}
		}
	};
	
	public static AbilityTask candleHouse = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				for(int y = 0; y <= 3; y++)
				{
					for(int x = 0; x < 1; x++)
						for(int z = -5; z < 5; z++)
							player.worldObj.setBlockState(new BlockPos((player.posX + 6) - x, player.posY + y, player.posZ - z), Blocks.CLAY.getDefaultState());
					for(int x = 0; x < 1; x++)
						for(int z = -5; z < 5; z++)
							player.worldObj.setBlockState(new BlockPos((player.posX - 5) - x, player.posY + y, player.posZ - z), Blocks.CLAY.getDefaultState());
					for(int x = -5; x < 5; x++)
						for(int z = 0; z < 1; z++)
							player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ + 6) - z), Blocks.CLAY.getDefaultState());
					for(int x = -5; x < 5; x++)
						for(int z = 0; z < 1; z++)
							player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ - 5) - z), Blocks.CLAY.getDefaultState());
				}
				for(int x = -5; x < 5; x++)
					for(int y = 0; y < 1; y++)
						for(int z = -5; z < 5; z++)
					  		player.worldObj.setBlockState(new BlockPos(player.posX - x, (player.posY + 4) + y, player.posZ - z), Blocks.CLAY.getDefaultState());
			}
		}
	};
	
	public static AbilityTask candleWall = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.NORTH)
				{
					for(int x = -3; x <  3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ - 3) - z), Blocks.CLAY.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.SOUTH)
				{
					for(int x = -3; x <  3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ + 2) - z), Blocks.CLAY.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.EAST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlockState(new BlockPos((player.posX + 2) - x, player.posY + y, player.posZ - z), Blocks.CLAY.getDefaultState());
				}
				if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.WEST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlockState(new BlockPos((player.posX - 3) - x, player.posY + y, player.posZ - z), Blocks.CLAY.getDefaultState());
				}
			}
		}
	};
	
	public static AbilityTask groundDeath = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for(EntityLivingBase l : WyHelper.instance().getEntitiesNear(player, 25))
			{
				for(int i = -2; i < 2; i++)
				for(int j = -3; j < 3; j++)
				for(int k = -2; k < 2; k++)
				{
					l.worldObj.setBlockState(new BlockPos(l.getPosition().getX() + k, l.getPosition().getY() - j, l.getPosition().getZ() + i), Blocks.AIR.getDefaultState());
					l.worldObj.setBlockState(new BlockPos(l.getPosition().getX() + k, l.getPosition().getY() + j, l.getPosition().getZ() + i), Blocks.SAND.getDefaultState());
				}
			}
		}
	};
	
	public static AbilityTask desertSpada = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.NORTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 5; j++)
				for(int k = 0; k < 12; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 2), player.posZ - (k + 2)), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY + (j + 2), player.posZ - (k + 2)), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.SOUTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 5; j++)
				for(int k = 0; k < 12; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 2), player.posZ + (k + 2)), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY + (j + 2), player.posZ + (k + 2)), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.EAST)
			{
				for(int i = 0; i < 12; i++)
				for(int j = 0; j < 5; j++)
				for(int k = -3; k < 3; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + (i + 2), player.posY - (j + 2), player.posZ + k), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + (i + 2), player.posY + (j + 2), player.posZ + k), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.WEST)
			{
				for(int i = 0; i < 12; i++)
				for(int j = 0; j < 5; j++)
				for(int k = -3; k < 3; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX - (i + 2), player.posY - (j + 2), player.posZ + k), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX - (i + 2), player.posY + (j + 2), player.posZ + k), Blocks.SAND.getDefaultState());
				}
			}
		}
	};
	
	public static AbilityTask iceTime = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for(EntityLivingBase l : WyHelper.instance().getEntitiesNear(player, 25))
			{
				WyHelper.instance().createCube(l, new int[] {2, 4, 2}, Blocks.PACKED_ICE.getDefaultState());
			}
		}
	};
	
	public static AbilityTask room = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{			
			final World world = player.getEntityWorld();
			if(!world.isRemote)
			{
				Sphere.generate((int) player.posX, (int) player.posY, (int) player.posZ, 20, new ISphere()
				{
				    public void call(int x, int y, int z)
				    {
				    	if(world.getBlockState(new BlockPos(x, y ,z)) == Blocks.AIR.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.TALLGRASS.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.LEAVES2.getDefaultState() 
				    			|| world.getBlockState(new BlockPos(x, y ,z)) == Blocks.LEAVES.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.WHEAT.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.CARROTS.getDefaultState()
				    			|| world.getBlockState(new BlockPos(x, y ,z)) == Blocks.BEETROOTS.getDefaultState())
				    		world.setBlockState(new BlockPos(x, y ,z), ListMisc.Ope.getDefaultState());
				    }
				});
				player.worldObj.setBlockState(new BlockPos(player.posX, player.posY, player.posZ), ListMisc.OpeMid.getDefaultState());
				//((BlockOpeMid) world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ)).getBlock()).setRoomObject(new Room(5 + power, new BlockPos(player.posX, player.posY, player.posZ), player));
			}
		}
	};
	
	public static AbilityTask iceBall = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			WyHelper.instance().createSphere(abilityProjectile, 6, Blocks.PACKED_ICE.getDefaultState());
		}
	};	
	
	public static AbilityTask iceAge = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for (int i = -20; i < 20; i++) 
			for (int j = -10; j < 10; j++) 
			for (int k = -20; k < 20; k++)
				if(!player.worldObj.isAirBlock(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) && player.worldObj.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) != ListMisc.Ope.getDefaultState()
						&& player.worldObj.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) != ListMisc.OpeMid.getDefaultState() && player.worldObj.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) != Blocks.BEDROCK.getDefaultState())
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k), Blocks.PACKED_ICE.getDefaultState());	
		}
	};
	
	public static AbilityTask kagero = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			for(int j = -2; j <= 2; j++)
			{
				for(int i = -5; i <= 5; i++)
					if(abilityProjectile.worldObj.isAirBlock(new BlockPos(abilityProjectile.posX + i, abilityProjectile.posY + j, abilityProjectile.posZ)))
						abilityProjectile.worldObj.setBlockState(new BlockPos(abilityProjectile.posX + i, abilityProjectile.posY + j, abilityProjectile.posZ), Blocks.FIRE.getDefaultState());
					
				for(int i = -5; i <= 5; i++)
					if(abilityProjectile.worldObj.isAirBlock(new BlockPos(abilityProjectile.posX, abilityProjectile.posY + j, abilityProjectile.posZ + i)))
						abilityProjectile.worldObj.setBlockState(new BlockPos(abilityProjectile.posX, abilityProjectile.posY + j, abilityProjectile.posZ + i), Blocks.FIRE.getDefaultState());
			}			
		}
	};

	public static AbilityTask enjomo = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, final EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				Sphere.generate((int)player.posX, (int)player.posY, (int)player.posZ, 12, new ISphere()
			    { 
					public void call(int x, int y, int z)
					{
		    			for(int i = -3; i <= 3; i++)
				    		if(player.worldObj.isAirBlock(new BlockPos(x, y + i, z)))
				    			player.worldObj.setBlockState(new BlockPos(x, y + i, z), Blocks.FIRE.getDefaultState());
					}
			    });
				
				for(EntityLivingBase l : WyHelper.instance().getEntitiesNear(player, 12))
				{l.setFire(20);}
			}
		}
	};
	
	public static AbilityTask soshark = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 10);
			Direction dir = WyHelper.instance().get4Directions(attacker);
			if(dir == WyHelper.Direction.SOUTH)
				target.motionX += 0.7;
			else if(dir == WyHelper.Direction.EAST)
				target.motionX -= 0.7; 
			else if(dir == WyHelper.Direction.NORTH)
				target.motionZ += 0.7;
			else if(dir == WyHelper.Direction.WEST)  
				target.motionZ -= 0.7;				
		};
	};
	 
	public static AbilityTask venomroad = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)  
		{
			if(WyHelper.instance().rayTrace(player) != null)
			{
				RayTraceResult mop = WyHelper.instance().rayTrace(player);
				 
				int x = mop.getBlockPos().getX();
				int y = mop.getBlockPos().getY();
				int z = mop.getBlockPos().getZ();

				EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0.0F);
				if(!MinecraftForge.EVENT_BUS.post(event))
				{
					if (player.isRiding())
						player.dismountEntity((Entity)null);
					player.setPositionAndRotation(x, y, z, player.rotationYaw, player.rotationPitch);
				}			
			}	
		}		
	};
	
	public static AbilityTask milkydial = new AbilityTask()
	{
		public void onProjectileUpdate(AbilityProjectile a) 
		{
			if(a.worldObj.getBlockState(new BlockPos((int)a.posX, (int)a.posY - 1, (int)a.posZ)) == Blocks.AIR.getDefaultState() && a.worldObj.getBlockState(new BlockPos((int)a.posX + 1, (int)a.posY - 1, (int)a.posZ)) == Blocks.AIR.getDefaultState()
					&& a.worldObj.getBlockState(new BlockPos((int)a.posX - 1, (int)a.posY - 1, (int)a.posZ)) == Blocks.AIR.getDefaultState() && a.worldObj.getBlockState(new BlockPos((int)a.posX, (int)a.posY - 1, (int)a.posZ + 1)) == Blocks.AIR.getDefaultState()
					&& a.worldObj.getBlockState(new BlockPos((int)a.posX, (int)a.posY - 1, (int)a.posZ - 1)) == Blocks.AIR.getDefaultState() && a.worldObj.getBlockState(new BlockPos((int)a.posX + 1, (int)a.posY - 1, (int)a.posZ + 1)) == Blocks.AIR.getDefaultState()
					&& a.worldObj.getBlockState(new BlockPos((int)a.posX + 1, (int)a.posY - 1, (int)a.posZ - 1)) == Blocks.AIR.getDefaultState() && a.worldObj.getBlockState(new BlockPos((int)a.posX - 1, (int)a.posY - 1, (int)a.posZ - 1)) == Blocks.AIR.getDefaultState()
					&& a.worldObj.getBlockState(new BlockPos((int)a.posX - 1, (int)a.posY - 1, (int)a.posZ + 1)) == Blocks.AIR.getDefaultState())
			{
				a.worldObj.setBlockState(new BlockPos((int)a.posX, 		(int)a.posY - 1, (int)a.posZ), 		ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX + 1, 	(int)a.posY - 1, (int)a.posZ), 		ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX - 1, 	(int)a.posY - 1, (int)a.posZ), 		ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX, 		(int)a.posY - 1, (int)a.posZ + 1), 	ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX, 		(int)a.posY - 1, (int)a.posZ - 1), 	ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX + 1, 	(int)a.posY - 1, (int)a.posZ + 1), 	ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX + 1, 	(int)a.posY - 1, (int)a.posZ - 1), 	ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX - 1, 	(int)a.posY - 1, (int)a.posZ + 1), 	ListMisc.SkyBlock.getDefaultState());
				a.worldObj.setBlockState(new BlockPos((int)a.posX - 1, 	(int)a.posY - 1, (int)a.posZ - 1), 	ListMisc.SkyBlock.getDefaultState());
			}			
		};
	};
	
	public static AbilityTask karakuni = new AbilityTask()
	{ 	
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(player, 25))
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
				e.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1000, 2));
			}
		}
	};
	
	public static AbilityTask gear = new AbilityTask()
	{ 	
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft)
		{ 
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(itemStack.getDisplayName().equals("§rGear Second"))
				props.setGear((byte) 2);
			if(itemStack.getDisplayName().equals("§rGear Third"))
				props.setGear((byte) 3);
			if(itemStack.getDisplayName().equals("§rGear Forth"))
				props.setGear((byte) 4);
		}
		
		public void onItemWhileUsing(ItemStack itemStack, EntityPlayer player, int count) 
		{
			if(!player.worldObj.isRemote)
			{
				if(count <= 80 && count > 40)
					itemStack.setStackDisplayName("§rGear Second");
				if(count <= 40 && count > 20)
					itemStack.setStackDisplayName("§rGear Third");
				if(count <= 20)
					itemStack.setStackDisplayName("§rGear Forth");
			}
		}
		
		public void onItemCooldown(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if((itemStack.getTagCompound().getInteger("ticks") < 200 && props.getGear() == 2) || (itemStack.getTagCompound().getInteger("ticks") < 250 && props.getGear() == 3) || (itemStack.getTagCompound().getInteger("ticks") < 300 && props.getGear() == 4))
				props.setGear((byte) 1);
			else if(itemStack.getTagCompound().getInteger("ticks") < 10) 
				itemStack.setStackDisplayName("§rGear");
		};
	};
	
	public static AbilityTask gomugomubazooka = new AbilityTask()
	{ 
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft)
		{
			if(!player.worldObj.isRemote)
			{
				AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
				int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
				IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
				
				if(power == 0) power = aa.getItemMaxCharges();
	
				AbilityProjectile proj = null;
	
				if(props.getGear() == 1)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOBAZOOKA.setProjectileDamage(5 + (power/3)) );				
				else if(props.getGear() == 2)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOJETBAZOOKA.setProjectileDamage(10 + (power/3)) );
				else if(props.getGear() == 3)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOGIGANTBAZOOKA.setProjectileDamage(15 + (power/2)) );
				else if(props.getGear() == 4)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOLEOBAZOOKA.setProjectileDamage(15 + power) );
				
				if(proj != null)
				{
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
					player.worldObj.spawnEntityInWorld(proj);
				}
			}
		}
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(props.getGear() == 1)
				itemStack.setStackDisplayName("§rGomu Gomu no Bazooka");
			if(props.getGear() == 2)
				itemStack.setStackDisplayName("§rGomu Gomu no Jet Bazooka");
			if(props.getGear() == 3)
				itemStack.setStackDisplayName("§rGomu Gomu no Gigant Bazooka");
			if(props.getGear() == 4)
				itemStack.setStackDisplayName("§rGomu Gomu no Leo Bazooka");
		};
		
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit) 
		{
			if(hit.entityHit instanceof EntityLivingBase)
			{
				((EntityLivingBase) hit.entityHit).motionY += 0.8;
				Direction dir = WyHelper.instance().get4Directions(abilityProjectile.getThrower());
				if(dir == WyHelper.Direction.SOUTH)
					((EntityLivingBase) hit.entityHit).motionZ += 1.7;
				else if(dir == WyHelper.Direction.EAST)
					((EntityLivingBase) hit.entityHit).motionX += 1.7; 
				else if(dir == WyHelper.Direction.NORTH)
					((EntityLivingBase) hit.entityHit).motionZ -= 1.7;
				else if(dir == WyHelper.Direction.WEST)  
					((EntityLivingBase) hit.entityHit).motionX -= 1.7;	
			}
		}; 
	};

	public static AbilityTask gomugomugatling = new AbilityTask()
	{ 	
		public void onItemUse(ItemStack itemStack, EntityPlayer player)  
		{
			if(!player.worldObj.isRemote)
			{
				IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
				
				AbilityProjectile proj = null;
	
				if(props.getGear() == 1)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOGATLING.setProjectileDamage(5) );				
				else if(props.getGear() == 2)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOJETGATLING.setProjectileDamage(5) );
				else if(props.getGear() == 3)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOGIGANTGATLING.setProjectileDamage(10) );
				else if(props.getGear() == 4)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOKONGORGAN.setProjectileSpeed(4).setProjectileDamage(10) );
				
				if(proj != null)
				{
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
					player.worldObj.spawnEntityInWorld(proj);
				}	
			}
		};
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(props.getGear() == 1)
				itemStack.setStackDisplayName("§rGomu Gomu no Gatling");
			if(props.getGear() == 2)
				itemStack.setStackDisplayName("§rGomu Gomu no Jet Gatling");
			if(props.getGear() == 3)
				itemStack.setStackDisplayName("§rGomu Gomu no Gigant Gatling");
			if(props.getGear() == 4)
				itemStack.setStackDisplayName("§rGomu Gomu no Kong Organ");
		};		
	};
	
	public static AbilityTask gomugomupistol = new AbilityTask()
	{ 		
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft)
		{
			if(!player.worldObj.isRemote)
			{
				AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
				int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
				IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
				
				if(power == 0) power = aa.getItemMaxCharges();
	
				AbilityProjectile proj = null;
	
				if(props.getGear() == 1)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOPISTOL.setProjectileDamage(5 + (power/2)) );
				else if(props.getGear() == 2)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOJETPISTOL.setProjectileDamage(10 + (power/2)) );
				else if(props.getGear() == 3)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOGIGANTPISTOL.setProjectileDamage(20 + (power/2)) );
				else if(props.getGear() == 4)
					proj = new AbilityProjectile(player.worldObj, player, ListExtraAttributes.GOMUGOMUNOKONGGUN.setProjectileSpeed(4).setProjectileDamage(20 + power) );
				
				if(proj != null)
				{
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
					player.worldObj.spawnEntityInWorld(proj);
				}
			}
		}
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(!player.worldObj.isRemote)
			{
				if(props.getGear() == 1)
					itemStack.setStackDisplayName("§rGomu Gomu no Pistol");
				if(props.getGear() == 2)
					itemStack.setStackDisplayName("§rGomu Gomu no Jet Pistol");
				if(props.getGear() == 3)
					itemStack.setStackDisplayName("§rGomu Gomu no Gigant Pistol");
				if(props.getGear() == 4)
					itemStack.setStackDisplayName("§rGomu Gomu no Kong Gun");
			}
		};
		
	};

	public static AbilityTask doppelman = new AbilityTask()
	{ 
		//String[] actions = {"§rAggressive", "§rDefensive", "§rChange Positions", "§rFollow", "§rStay", "§rReturn"};
		String[] actions = {"§rChange Positions", "§rSelf-destruct", "§rReturn"};
		String currentAction = actions[0];
		
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{	
			if(!player.worldObj.isRemote)
			{
				if(itemStack.getTagCompound().getBoolean("doppelman") == false)
				{
					Doppelman doppelman = new Doppelman(player.worldObj, player);
					doppelman.setLocationAndAngles(player.posX, player.posY, player.posZ, player.cameraYaw, player.cameraPitch);
					player.worldObj.spawnEntityInWorld(doppelman);
					itemStack.getTagCompound().setBoolean("doppelman", true);
				}
				else
				{
					if(MainKeys.isShiftKeyDown())
					{
						for(int i = 0; i < actions.length; i++)		
							if(currentAction.equals(actions[i]))
							{
								if(currentAction.equals(actions[actions.length - 1]))
									currentAction = actions[0];
								else
									currentAction = actions[i + 1];
								break;
							}
					}
					else
					{
						if(currentAction == actions[0])
						{
							for(EntityLivingBase dopp : WyHelper.instance().getEntitiesNear(player, 840))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
								{
									BlockPos newPos = dopp.getPosition();
									dopp.setPositionAndUpdate(player.posX, player.posY, player.posZ);
									player.setPositionAndUpdate(newPos.getX(), newPos.getY(), newPos.getZ());
								}
						}
						if(currentAction == actions[1])
						{							
							for(EntityLivingBase dopp : WyHelper.instance().getEntitiesNear(player, 840))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
								{
									dopp.worldObj.newExplosion(dopp, dopp.posX, dopp.posY, dopp.posZ, 5, false, false);
									for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(dopp, 10))
										if(target != ((Doppelman)dopp).getOwner())
											target.addPotionEffect(new PotionEffect(MobEffects.WITHER, 500, 1));
									dopp.setDead();
									itemStack.getTagCompound().setBoolean("doppelman", false);
								}
						}
						if(currentAction == actions[actions.length - 1])
						{
							for(EntityLivingBase dopp : WyHelper.instance().getEntitiesNear(player, 840))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
									dopp.setDead();
							itemStack.getTagCompound().setBoolean("doppelman", false);
						}
					}		
				}
			}
		}

		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			if(itemStack.getTagCompound().getBoolean("doppelman") == true)
			{
				if(MainKeys.isShiftKeyDown())
				{
					for(int i = 0; i < actions.length; i++)					
						if(currentAction.equals(actions[i]))
						{
							if(currentAction.equals(actions[actions.length - 1]))
								itemStack.setStackDisplayName(currentAction + " -> " + actions[0] );
							else
								itemStack.setStackDisplayName(currentAction + " -> " + actions[i + 1]);
						}
				}
				else
					itemStack.setStackDisplayName(currentAction);
			}
			else
				itemStack.setStackDisplayName("§rDoppelman");	
		};
		
	};
	
	/** TODO Shadow's Asgard */	
	public static AbilityTask shadowsasgard = new AbilityTask()
	{ 
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			
		}
	};
	
	public static AbilityTask sables = new AbilityTask()
	{ 
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.motionY += 1;
			target.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 500, 1));
			Direction dir = WyHelper.instance().get4Directions(attacker);
			if(dir == WyHelper.Direction.SOUTH)
				target.motionX += 0.2;
			else if(dir == WyHelper.Direction.EAST)
				target.motionX -= 0.2; 
			else if(dir == WyHelper.Direction.NORTH)
				target.motionZ += 0.2;
			else if(dir == WyHelper.Direction.WEST)  
				target.motionZ -= 0.2;	
		}			
	};
	
	public static AbilityTask padho = new AbilityTask()
	{ 
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.motionY += 5;
			Direction dir = WyHelper.instance().get4Directions(attacker);
			if(dir == WyHelper.Direction.SOUTH)
				target.motionX += 10;
			else if(dir == WyHelper.Direction.EAST)
				target.motionX -= 10; 
			else if(dir == WyHelper.Direction.NORTH)
				target.motionZ += 10;
			else if(dir == WyHelper.Direction.WEST)  
				target.motionZ -= 10;	
		}			
	};
		
	public static AbilityTask whitelauncher = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			double mX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mY = (double)(-MathHelper.sin((player.rotationPitch + 0) / 180.0F * (float)Math.PI) * 0.4);

			double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
			mX /= (double)f2;
			mY /= (double)f2;
			mZ /= (double)f2;
			mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mX *= 5;
			mY *= 1.5;
			mZ *= 5;

			player.motionX = mX;
			player.motionY = mY;
			player.motionZ = mZ;
		}
		public void onItemCooldown(ItemStack itemStack, EntityPlayer entity) 
		{
			if(itemStack.getTagCompound().getInteger("ticks") > 120)
			{
				for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(entity, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(entity), 10);
			}
					
		}
	};
		 
	public static AbilityTask elthor = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			RayTraceResult mop = WyHelper.instance().rayTrace(player);
				
			if(mop != null)
			{
				int i = mop.getBlockPos().getX();
				int j = mop.getBlockPos().getY();
				int k = mop.getBlockPos().getZ();
					
				if(!player.worldObj.isRemote)      		 
					player.worldObj.newExplosion(new EntityLightningBolt(player.worldObj, i, j, k, false), i, j, k, 6, true, true);
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k, false));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i+1, j, k, false));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k+1, false));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i-1, j, k, false));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k-1, false));
			}
		}		
	};
		
	public static AbilityTask mes = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			IEntityCapability props = target.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(props.hasHeart())
			{
				ItemStack heart = new ItemStack(ListMisc.Heart);
				((Heart) heart.getItem()).setHeartOwner(heart, target);
				heart.setStackDisplayName(target.getName() + "'s Heart"); 
						
				((EntityPlayer) attacker).inventory.addItemStackToInventory(heart);
				
				props.setHasHeart(false);			
			}

		}	
	};

	public static AbilityTask skatting = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			if(player.getActivePotionEffect(MobEffects.INVISIBILITY) != null)
				player.removePotionEffect(MobEffects.INVISIBILITY);
			else
				player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, Integer.MAX_VALUE, Integer.MAX_VALUE, false, false));
		}
		
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			if(target.getActivePotionEffect(MobEffects.INVISIBILITY) != null)
				target.removePotionEffect(MobEffects.INVISIBILITY);
			else
				target.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, Integer.MAX_VALUE, Integer.MAX_VALUE, false, false));			
		};
		
	};
		
	public static AbilityTask geppo = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			Direction dir = WyHelper.instance().get8Directions(player);
			
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
							
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ, 0, 0, 0);
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX + 0.2, player.posY, player.posZ + 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX + 0.2, player.posY, player.posZ - 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX - 0.2, player.posY, player.posZ - 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX - 0.2, player.posY, player.posZ + 0.2, 0, 0, 0);
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX + 0.5, player.posY, player.posZ, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX + 0.2, player.posY, player.posZ, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX - 0.5, player.posY, player.posZ, 0, 0, 0);	
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX - 0.2, player.posY, player.posZ, 0, 0, 0);	
				
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ + 0.5, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ + 0.2, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ - 0.5, 0, 0, 0);
			player.worldObj.spawnParticle(EnumParticleTypes.CLOUD, player.posX, player.posY, player.posZ - 0.2, 0, 0, 0);
		}
	};
			
	public static AbilityTask yatanokagami = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)  
		{
			if(WyHelper.instance().rayTrace(player) != null)
			{
				RayTraceResult mop = WyHelper.instance().rayTrace(player);
				 
				int x = mop.getBlockPos().getX();
				int y = mop.getBlockPos().getY();
				int z = mop.getBlockPos().getZ();

				EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0.0F);
				if(!MinecraftForge.EVENT_BUS.post(event))
				{
					if (player.isRiding())
						player.dismountEntity((Entity)null);
					player.setPositionAndRotation(x, y, z, player.rotationYaw, player.rotationPitch);
				}			
			}	
		}
	}; 

	public static AbilityTask bluesword = new AbilityTask() {public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {target.setFire(100);}};
	
	public static AbilityTask springhopper = new AbilityTask()
	{
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) 
		{
			Direction dir = WyHelper.instance().get8Directions(player);
				 
			int power;
				
			if(((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges() == timeLeft)
				power = 1;
			else
				power = 0;
				
			if(player.onGround)
				player.motionY += 1.2 + (double)1/2;
			else
				player.motionY += 1.36 + (double)1/7;
	  
			if(dir == WyHelper.Direction.NORTH) player.motionZ -= 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.NORTH_WEST) {player.motionZ -= 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.SOUTH) player.motionZ += 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.NORTH_EAST) {player.motionZ -= 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.WEST) player.motionX -= 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.SOUTH_WEST) {player.motionZ += 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyHelper.Direction.EAST) player.motionX += 1.4 + (double)1/2;
			if(dir == WyHelper.Direction.SOUTH_EAST) {player.motionZ += 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
		}	
	};
		   
	public static AbilityTask springsnipe = new AbilityTask()
	{
		public void onItemCooldown(ItemStack itemStack, EntityPlayer player) 
		{
			if(itemStack.getTagCompound().getInteger("ticks") > 85)
				for(EntityLivingBase e : WyHelper.instance().getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 10 + (itemStack.getTagCompound().getInteger("extra_power") * 10));
		}
		
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) 
		{
			double mX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4);
			double mY = (double)(-MathHelper.sin((player.rotationPitch + 0) / 180.0F * (float)Math.PI) * 0.4);
		         
			int power;
		       
			if(((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges() == timeLeft)
				power = 1;
			else
				power = 0;
				
			itemStack.getTagCompound().setInteger("extra_power", power);
				
			double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
			mX /= (double)f2;
			mY /= (double)f2;
			mZ /= (double)f2;
			mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mX *= 7.5 + power;
			mY *= 2.5 + power;
			mZ *= 7.5 + power;

			player.motionX = mX;
			player.motionY = mY;
			player.motionZ = mZ;
		}
	};
	
	public static AbilityTask debug = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			FMLNetworkHandler.openGui(player, Main.getMineMineNoMi(), 4, player.worldObj, 0, 0, 0);	  	
		}
	};
}
