package MineMineNoMi3.lists;

import javax.annotation.Nullable;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PropertyGetters 
{

	public static IItemPropertyGetter UMBRELLA = new IItemPropertyGetter()
    {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
            return entityIn == null ? 0.0F : (entityIn.getHeldItemMainhand() == stack && entityIn instanceof EntityPlayer && !((EntityPlayer)entityIn).onGround && entityIn.worldObj.getBlockState(new BlockPos(entityIn.posX, entityIn.posY - 4, entityIn.posZ)) == Blocks.AIR.getDefaultState() && !((EntityPlayer)entityIn).isCreative() ? 1.0F : 0.0F);
        }
    };
	 
	public static IItemPropertyGetter HOOK = new IItemPropertyGetter()
    {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack itemStack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
        	return entityIn == null ? 0 : (itemStack.getTagCompound() != null && itemStack.getTagCompound().getInteger("form") == 1 ? 1 : 0); 
        }
    };
    
	public static IItemPropertyGetter GEAR = new IItemPropertyGetter()
    {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack itemStack, @Nullable World world, @Nullable EntityLivingBase entity)
        {
        	if(entity == null) return 0;
        	else
        	{
        		IEntityCapability props = entity.getCapability(Values.ENTITY_CAPABILITIES, null);
        		if(itemStack.getDisplayName().equals("§rGear Second")) return 0;
        		else if(itemStack.getDisplayName().equals("§rGear Third")) return 1;
        		else if(itemStack.getDisplayName().equals("§rGear Forth")) return 2;
        		else return 0;
        	}
        }
    };
}
