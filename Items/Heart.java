package MineMineNoMi3.Items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Heart extends Item
{

	private EntityLivingBase heartOwner;
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		if(this.heartOwner != null)
		{
			if(this.heartOwner.isDead)
				player.inventory.deleteStack(itemStack);
			this.heartOwner.attackEntityFrom(DamageSource.magic, 5);
			this.heartOwner.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 250, 1));
			this.heartOwner.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 250, 1));
		}
		
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
	public void setHeartOwner(EntityLivingBase e)
	{
		this.heartOwner = e;
	}
	
}
