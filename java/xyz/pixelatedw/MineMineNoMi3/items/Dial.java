package xyz.pixelatedw.MineMineNoMi3.items;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class Dial extends Item
{
/*
	private EnumDialType type;
	
	public Dial(EnumDialType type, int power)
	{
		this.type = type;
		this.setMaxDamage(power);
		this.maxStackSize = 16;  
	} 
	 
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
    	if(!MainKeys.isShiftKeyDown())
    	{
			if(type == EnumDialType.FIRE && !world.isRemote)
			{
				Vec3 look = player.getLookVec();
				EntitySmallFireball fireball = new EntitySmallFireball(world, player, 1, 1, 1);
				fireball.setPosition(
						player.posX,
						player.posY + 1.5, 
						player.posZ);
				fireball.accelerationX = look.xCoord * 0.2;
				fireball.accelerationY = look.yCoord * 0.2;
				fireball.accelerationZ = look.zCoord * 0.2;
				world.spawnEntityInWorld(fireball);		  
			}
			
			if(type == EnumDialType.IMPACT && !world.isRemote)
			{
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 100));
				world.newExplosion(player, player.posX, player.posY, player.posZ, 3, false, true);
			}
			
			if(type == EnumDialType.MILKY)
			{
				AbilityProjectile milky = new AbilityProjectile(world, player, ListAbilities.MILKYDIAL);
				milky.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
				world.spawnEntityInWorld(milky);
			}
			
			if(type == EnumDialType.AXE)
			{
				AbilityProjectile axe = new AbilityProjectile(world, player, ListAbilities.AXEDIAL);
				axe.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 2F, 1.2F);
				world.spawnEntityInWorld(axe);			
			}
			
			if(type == EnumDialType.BREATH)
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
			
			if(type == EnumDialType.FLASH)
			{
				for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 10))
				{
					IEntityCapability props = target.getCapability(Values.ENTITY_CAPABILITIES, null);

					props.setBlind(50);
				}
			}
			
			if(type == EnumDialType.REJECT)
			{
				for(EntityLivingBase target : WyHelper.instance().getEntitiesNear(player, 10))
				{
					target.attackEntityFrom(DamageSource.magic, Integer.MAX_VALUE);
					player.attackEntityFrom(DamageSource.magic, Integer.MAX_VALUE);
				}
			}

			itemStack.damageItem(2, player);
		}
		return new ActionResult(EnumActionResult.PASS, itemStack);
	} 
	
    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if(MainKeys.isShiftKeyDown() && (type != EnumDialType.REJECT || type != EnumDialType.MILKY ))
	    	if(!world.isRemote)
	    	{
	    		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), ListMisc.Dial.getDefaultState().withProperty(BlockDial.getDialProperty(), this.type));

	    		itemStack.stackSize--;
	    	}
    	return EnumActionResult.PASS;
    }
	*/
}
