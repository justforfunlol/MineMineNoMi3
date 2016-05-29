package MineMineNoMi3.Lists;

import MineMineNoMi3.Main;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.ParticleTemplateProjectileWithLOD;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.INPCCapability;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Entities.Mobs.Doppelman;
import MineMineNoMi3.Entities.Models.ModelGomuBazooka;
import MineMineNoMi3.Items.Heart;
import WyPI.UtilISphere;
import WyPI.UtilSphere;
import WyPI.WyPI;
import WyPI.WyPI.Dir;
import WyPI.Ability.AbilityAttribute;
import WyPI.Ability.AbilityItem;
import WyPI.Ability.AbilityProjectile;
import WyPI.Ability.AbilityTask;
import WyPI.Ability.ModelCube;
import net.minecraft.block.state.IBlockState;
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
	
	public static AbilityTask bakuretsukazan = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				for(int i = -4; i < 4; i++)
				for(int j = -5; j < 0; j++)
				for(int k = -4; k < 4; k++)
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
				if(WyPI.Utils.get4Directions(player) == WyPI.Dir.NORTH)
				{
					for(int x = -3; x <  3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ - 3) - z), Blocks.CLAY.getDefaultState());
				}
				if(WyPI.Utils.get4Directions(player) == WyPI.Dir.SOUTH)
				{
					for(int x = -3; x <  3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlockState(new BlockPos(player.posX - x, player.posY + y, (player.posZ + 2) - z), Blocks.CLAY.getDefaultState());
				}
				if(WyPI.Utils.get4Directions(player) == WyPI.Dir.EAST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlockState(new BlockPos((player.posX + 2) - x, player.posY + y, player.posZ - z), Blocks.CLAY.getDefaultState());
				}
				if(WyPI.Utils.get4Directions(player) == WyPI.Dir.WEST)
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
			for(EntityLivingBase l : WyPI.Utils.getEntitiesNear(player, 25))
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
			if(WyPI.Utils.get4Directions(player) == WyPI.Dir.NORTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 5; j++)
				for(int k = 0; k < 12; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 2), player.posZ - (k + 2)), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY + (j + 2), player.posZ - (k + 2)), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.SOUTH)
			{
				for(int i = -3; i < 3; i++)
				for(int j = 0; j < 5; j++)
				for(int k = 0; k < 12; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY - (j + 2), player.posZ + (k + 2)), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + i, player.posY + (j + 2), player.posZ + (k + 2)), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.EAST)
			{
				for(int i = 0; i < 12; i++)
				for(int j = 0; j < 5; j++)
				for(int k = -3; k < 3; k++)		
				{
					player.worldObj.setBlockState(new BlockPos(player.posX + (i + 2), player.posY - (j + 2), player.posZ + k), Blocks.AIR.getDefaultState());
					player.worldObj.setBlockState(new BlockPos(player.posX + (i + 2), player.posY + (j + 2), player.posZ + k), Blocks.SAND.getDefaultState());
				}
			}
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.WEST)
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
			for(EntityLivingBase l : WyPI.Utils.getEntitiesNear(player, 25))
			{
				WyPI.Utils.createCube(l, new int[] {2, 4, 2}, Blocks.PACKED_ICE.getDefaultState());
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
				UtilSphere.generate((int) player.posX, (int) player.posY, (int) player.posZ, 20, new UtilISphere()
				{
				    public void call(int x, int y, int z)
				    {
				    	if(world.getBlockState(new BlockPos(x, y ,z)) == Blocks.AIR.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.TALLGRASS.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.LEAVES2.getDefaultState() || world.getBlockState(new BlockPos(x, y ,z)) == Blocks.LEAVES.getDefaultState())
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
			WyPI.Utils.createSphere(abilityProjectile, 6, Blocks.PACKED_ICE.getDefaultState());
		}
	};	
	
	public static AbilityTask iceAge = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			for (int i = -20; i < 20; i++) 
			for (int j = -10; j < 10; j++) 
			for (int k = -20; k < 20; k++)
			for (IBlockState ibs : Values.BANNED_BLOCKS)
				if(!player.worldObj.isAirBlock(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) && player.worldObj.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) != ibs)
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
	
	public static AbilityTask iceBlock = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			abilityProjectile.worldObj.setBlockState(abilityProjectile.getPosition(), Blocks.PACKED_ICE.getDefaultState());
		}
	};
	
	public static AbilityTask fireBlock = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			abilityProjectile.worldObj.setBlockState(abilityProjectile.getPosition(), Blocks.FIRE.getDefaultState());
		}
	};
	
	public static AbilityTask lavaBlock = new AbilityTask()
	{
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
		{
			abilityProjectile.worldObj.setBlockState(abilityProjectile.getPosition(), Blocks.FLOWING_LAVA.getDefaultState());
		}
	};
	
	public static AbilityTask enjomo = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				UtilSphere.generate((int)player.posX, (int)player.posY, (int)player.posZ, 12, new UtilISphere()
			    { 
					public void call(int x, int y, int z)
					{
		    			for(int i = -3; i <= 3; i++)
				    		if(player.worldObj.isAirBlock(new BlockPos(x, y + i, z)))
				    			player.worldObj.setBlockState(new BlockPos(x, y + i, z), Blocks.FIRE.getDefaultState());
					}
			    });
				
				for(EntityLivingBase l : WyPI.Utils.getEntitiesNear(player, 12))
				{l.setFire(20);}
			}
		}
	};
	
	public static AbilityTask soshark = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 10);
			Dir dir = WyPI.Utils.get4Directions(attacker);
			if(dir == Dir.SOUTH)
				target.motionX += 0.7;
			else if(dir == Dir.EAST)
				target.motionX -= 0.7; 
			else if(dir == Dir.NORTH)
				target.motionZ += 0.7;
			else if(dir == Dir.WEST)  
				target.motionZ -= 0.7;				
		};
	};
	 
	public static AbilityTask venomroad = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player)  
		{
			if(WyPI.Utils.rayTraceBlocks(player) != null)
			{
				RayTraceResult mop = WyPI.Utils.rayTraceBlocks(player);
				 
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
			for(EntityLivingBase e : WyPI.Utils.getEntitiesNear(player, 25))
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
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

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
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

			if((itemStack.getTagCompound().getInteger("ticks") < 200 && props.getGear() == 2) || (itemStack.getTagCompound().getInteger("ticks") < 250 && props.getGear() == 3) || (itemStack.getTagCompound().getInteger("ticks") < 300 && props.getGear() == 4))
			{
				props.setGear((byte) 1);
				itemStack.setStackDisplayName("§rGear");
			}
		};
	};
	
	public static AbilityTask gomugomubazooka = new AbilityTask()
	{ 
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft)
		{
			AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
			int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(power == 0) power = aa.getItemMaxCharges();

			AbilityProjectile proj = null;

			if(props.getGear() == 1)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelGomuBazooka()).setColor("F5DEB3").setSize(3, 1, 1).setDamage(5 + (power/3)) );				
			else if(props.getGear() == 2)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelGomuBazooka()).setColor("F5DEB3").setSize(3, 1, 1).setSpeed(4).setDamage(10 + (power/3)).setParticleForProjectile(new ParticleTemplateProjectileWithLOD(4), EnumParticleTypes.SMOKE_NORMAL) );
			else if(props.getGear() == 3)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelGomuBazooka()).setColor("F5DEB3").setSize(7, 5, 5).setDamage(15 + (power/2)) );
			else if(props.getGear() == 4)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelGomuBazooka()).setColor("2A3439").setSpeed(4).setSize(7, 5, 5).setDamage(15 + power) );
			
			if(proj != null)
			{
				proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
				player.worldObj.spawnEntityInWorld(proj);
			}
			
		}
		
		public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit) 
		{
			if(hit.entityHit instanceof EntityLivingBase)
			{
				((EntityLivingBase) hit.entityHit).motionY += 0.8;
				IPlayerCapability props = abilityProjectile.getThrower().getCapability(Values.CAPABILITIES_PLAYER, null);
				Dir dir = WyPI.Utils.get4Directions(abilityProjectile.getThrower());
				//System.out.println(0.25 / props.getGear()); 
				if(dir == Dir.SOUTH)
					((EntityLivingBase) hit.entityHit).motionZ += 1.7;
				else if(dir == Dir.EAST)
					((EntityLivingBase) hit.entityHit).motionX += 1.7; 
				else if(dir == Dir.NORTH)
					((EntityLivingBase) hit.entityHit).motionZ -= 1.7;
				else if(dir == Dir.WEST)  
					((EntityLivingBase) hit.entityHit).motionX -= 1.7;	
			}
		}; 
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

			if(props.getGear() == 1)
				itemStack.setStackDisplayName("§rGomu Gomu no Bazooka");
			if(props.getGear() == 2)
				itemStack.setStackDisplayName("§rGomu Gomu no Jet Bazooka");
			if(props.getGear() == 3)
				itemStack.setStackDisplayName("§rGomu Gomu no Gigant Bazooka");
			if(props.getGear() == 4)
				itemStack.setStackDisplayName("§rGomu Gomu no Leo Bazooka");
		};
	};

	public static AbilityTask gomugomugatling = new AbilityTask()
	{ 	
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			AbilityProjectile proj = null;

			if(props.getGear() == 1)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(3, 1, 1).setEntityTicks(16).setDamage(5) );				
			else if(props.getGear() == 2)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(3, 1, 1).setSpeed(4).setEntityTicks(16).setDamage(10).setParticleForProjectile(new ParticleTemplateProjectileWithLOD(4), EnumParticleTypes.SMOKE_NORMAL) );
			else if(props.getGear() == 3 || props.getGear() == 4)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(5, 3, 3).setPosition(0, 8, 0).setEntityTicks(16).setDamage(20) );

			if(proj != null)
			{
				proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
				player.worldObj.spawnEntityInWorld(proj);
			}	
		};
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

			if(props.getGear() == 1)
				itemStack.setStackDisplayName("§rGomu Gomu no Gatling");
			if(props.getGear() == 2)
				itemStack.setStackDisplayName("§rGomu Gomu no Jet Gatling");
			if(props.getGear() == 3 || props.getGear() == 4)
				itemStack.setStackDisplayName("§rGomu Gomu no Gigant Gatling");
		};		
	};
	
	public static AbilityTask gomugomupistol = new AbilityTask()
	{ 		
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft)
		{
			AbilityAttribute aa = ((AbilityItem)itemStack.getItem()).getAttribute();
			int power = (timeLeft - ((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges()) * -1;
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(power == 0) power = aa.getItemMaxCharges();

			AbilityProjectile proj = null;

			if(props.getGear() == 1)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(3, 1, 1).setDamage(5 + (power/2)) );				
			else if(props.getGear() == 2)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(3, 1, 1).setSpeed(4).setDamage(10 + (power/2)).setParticleForProjectile(new ParticleTemplateProjectileWithLOD(4), EnumParticleTypes.SMOKE_NORMAL) );
			else if(props.getGear() == 3)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("F5DEB3").setSize(7, 5, 5).setDamage(20 + (power/2)) );
			else if(props.getGear() == 4)
				proj = new AbilityProjectile(player.worldObj, player, new AbilityAttribute().setModel(new ModelCube()).setColor("#2a3439").setSpeed(4).setSize(7, 5, 5).setDamage(20 + power) );
			
			if(proj != null)
			{
				proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
				player.worldObj.spawnEntityInWorld(proj);
			}
		}
		
		public void onItemTick(ItemStack itemStack, EntityPlayer player) 
		{
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

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
	
	/** TODO Doppelman */
	public static AbilityTask doppelman = new AbilityTask()
	{ 
		//String[] actions = {"§rAggressive", "§rDefensive", "§rChange Positions", "§rFollow", "§rStay", "§rReturn"};
		String[] actions = {"§rChange Positions", "§rReturn"};
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
						/*if(currentAction == actions[0])
						{
							for(EntityLivingBase dopp : WyPI.Utils.getEntitiesNear(player, 230))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
									((Doppelman) dopp).setState(0);
						}
						if(currentAction == actions[1])
						{
							for(EntityLivingBase dopp : WyPI.Utils.getEntitiesNear(player, 230))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
									((Doppelman) dopp).setState(1);
						}*/
						if(currentAction == actions[0])
						{
							for(EntityLivingBase dopp : WyPI.Utils.getEntitiesNear(player, 230))
								if(dopp instanceof Doppelman && ((Doppelman) dopp).getOwner() == player)
								{
									BlockPos newPos = dopp.getPosition();
									dopp.setPositionAndUpdate(player.posX, player.posY, player.posZ);
									player.setPositionAndUpdate(newPos.getX(), newPos.getY(), newPos.getZ());
								}
						}
						//if(currentAction == actions[3])
							//System.out.println( "Follow" );
						//if(currentAction == actions[4])
							//System.out.println( "Stay" );
						if(currentAction == actions[actions.length - 1])
						{
							for(EntityLivingBase dopp : WyPI.Utils.getEntitiesNear(player, 230))
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
			Dir dir = WyPI.Utils.get4Directions(attacker);
			if(dir == Dir.SOUTH)
				target.motionX += 0.2;
			else if(dir == Dir.EAST)
				target.motionX -= 0.2; 
			else if(dir == Dir.NORTH)
				target.motionZ += 0.2;
			else if(dir == Dir.WEST)  
				target.motionZ -= 0.2;	
		}			
	};
	
	public static AbilityTask padho = new AbilityTask()
	{ 
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			target.motionY += 5;
			Dir dir = WyPI.Utils.get4Directions(attacker);
			if(dir == Dir.SOUTH)
				target.motionX += 10;
			else if(dir == Dir.EAST)
				target.motionX -= 10; 
			else if(dir == Dir.NORTH)
				target.motionZ += 10;
			else if(dir == Dir.WEST)  
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
			ParticleTemplateProjectileWithLOD lod = new ParticleTemplateProjectileWithLOD(15);
			if(itemStack.getTagCompound().getInteger("ticks") > 120)
			{
				if(!entity.onGround)
					lod.render(entity, EnumParticleTypes.SMOKE_LARGE);
				for(EntityLivingBase e : WyPI.Utils.getEntitiesNear(entity, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(entity), 10);
			}
					
		}
	};
		
	public static AbilityTask elthor = new AbilityTask()
	{
		public void onItemUse(ItemStack itemStack, EntityPlayer player) 
		{
			RayTraceResult mop = WyPI.Utils.rayTraceBlocks(player);
				
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
	};
		
	public static AbilityTask mes = new AbilityTask()
	{
		public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
		{
			if(target instanceof EntityPlayer)
			{
				IPlayerCapability props = attacker.getCapability(Values.CAPABILITIES_PLAYER, null);

				if(props.hasHeart())
				{
					ItemStack heart = new ItemStack(ListMisc.Heart);
					((Heart) heart.getItem()).setHeartOwner(target);
					heart.setStackDisplayName(target.getName() + "'s Heart"); 
						
					((EntityPlayer) attacker).inventory.addItemStackToInventory(heart);

					props.setHasHeart(false);
				}				
			}
			else
			{
				INPCCapability props = target.getCapability(Values.CAPABILITIES_NPC, null);

				if(props.hasHeart())
				{
					ItemStack heart = new ItemStack(ListMisc.Heart);
					((Heart) heart.getItem()).setHeartOwner(target);
					heart.setStackDisplayName(target.getName() + "'s Heart"); 
						
					((EntityPlayer) attacker).inventory.addItemStackToInventory(heart);

					props.setHasHeart(false);
				}
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
			WyPI.Dir dir = WyPI.Utils.get8Directions(player);
			
			if(player.onGround)
				player.motionY += 1.7;
			else
				player.motionY += 1.86;

			if(dir == WyPI.Dir.NORTH) player.motionZ -= 1;
			if(dir == WyPI.Dir.NORTH_WEST) {player.motionZ -= 1;player.motionX -= 1;}
			if(dir == WyPI.Dir.SOUTH) player.motionZ += 1;
			if(dir == WyPI.Dir.NORTH_EAST) {player.motionZ -= 1;player.motionX += 1;}
			if(dir == WyPI.Dir.WEST) player.motionX -= 1;
			if(dir == WyPI.Dir.SOUTH_WEST) {player.motionZ += 1;player.motionX -= 1;}
			if(dir == WyPI.Dir.EAST) player.motionX += 1;
			if(dir == WyPI.Dir.SOUTH_EAST) {player.motionZ += 1;player.motionX += 1;}
							
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
			if(WyPI.Utils.rayTraceBlocks(player) != null)
			{
				RayTraceResult mop = WyPI.Utils.rayTraceBlocks(player);
				 
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

	public static AbilityTask icesaber = new AbilityTask() {public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 1));}};
		
	public static AbilityTask noronorobeamsword = new AbilityTask() {public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 5));}};
	
	public static AbilityTask bluesword = new AbilityTask() {public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {target.setFire(100);}};
	
	public static AbilityTask springhopper = new AbilityTask()
	{
		public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) 
		{
			WyPI.Dir dir = WyPI.Utils.get8Directions(player);
				 
			int power;
				
			if(((AbilityItem)itemStack.getItem()).getAttribute().getItemMaxCharges() == timeLeft)
				power = 1;
			else
				power = 0;
				
			if(player.onGround)
				player.motionY += 1.2 + (double)1/2;
			else
				player.motionY += 1.36 + (double)1/7;
	  
			if(dir == WyPI.Dir.NORTH) player.motionZ -= 1.4 + (double)1/2;
			if(dir == WyPI.Dir.NORTH_WEST) {player.motionZ -= 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyPI.Dir.SOUTH) player.motionZ += 1.4 + (double)1/2;
			if(dir == WyPI.Dir.NORTH_EAST) {player.motionZ -= 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
			if(dir == WyPI.Dir.WEST) player.motionX -= 1.4 + (double)1/2;
			if(dir == WyPI.Dir.SOUTH_WEST) {player.motionZ += 1.4 + (double)1/2;player.motionX -= 1.4 + (double)1/2;}
			if(dir == WyPI.Dir.EAST) player.motionX += 1.4 + (double)1/2;
			if(dir == WyPI.Dir.SOUTH_EAST) {player.motionZ += 1.4 + (double)1/2;player.motionX += 1.4 + (double)1/2;}
		}	
	};
		   
	public static AbilityTask springsnipe = new AbilityTask()
	{
		public void onItemCooldown(ItemStack itemStack, EntityPlayer player) 
		{
			if(itemStack.getTagCompound().getInteger("ticks") > 85)
				for(EntityLivingBase e : WyPI.Utils.getEntitiesNear(player, 1.6))
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
