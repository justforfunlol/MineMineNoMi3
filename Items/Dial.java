package MineMineNoMi3.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.Values;
import MineMineNoMi3.Blocks.BlockDial;
import MineMineNoMi3.Blocks.BlockDial.DialType;
import MineMineNoMi3.Lists.ListAbilities;
import MineMineNoMi3.Lists.ListMisc;
import WyPI.Ability.AbilityProjectile;

public class Dial extends Item
{

	private String type;
	
	public Dial(String type, int power)
	{
		this.type = type;
		this.setMaxDamage(power);
		this.maxStackSize = 16;  
	} 
	 
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
    	if(!MainKeys.isShiftKeyDown())
    	{
			if(type.equals("fire") && !world.isRemote)
			{
				Vec3d look = player.getLookVec();
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
			
			if(type.equals("impact") && !world.isRemote)
			{
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 100));
				world.newExplosion(player, player.posX, player.posY, player.posZ, 3, false, true);
			}
			
			if(type.equals("milky"))
			{
				AbilityProjectile milky = new AbilityProjectile(world, player, ListAbilities.MILKYDIAL);
				milky.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
				world.spawnEntityInWorld(milky);
			}
			
			if(type.equals("axe"))
			{
				AbilityProjectile axe = new AbilityProjectile(world, player, ListAbilities.AXEDIAL);
				axe.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 2F, 1.2F);
				world.spawnEntityInWorld(axe);			
			}
			
			itemStack.damageItem(2, player);
		}
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if(MainKeys.isShiftKeyDown())
	    	if(!world.isRemote)
	    	{
	    		if(type.equals("fire"))
	    			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), ListMisc.Dial.getDefaultState().withProperty(BlockDial.DIAL_TYPE, DialType.FIRE));
	    		if(type.equals("impact"))
	    			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), ListMisc.Dial.getDefaultState().withProperty(BlockDial.DIAL_TYPE, DialType.IMPACT));
	    	}
    	return EnumActionResult.PASS;
    }
	
}
