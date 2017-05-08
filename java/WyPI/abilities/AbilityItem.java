package WyPI.abilities;

import com.google.common.collect.Multimap;

import WyPI.abilities.extra.ItemProperty;
import WyPI.modules.WyHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityItem extends Item
{
	protected AbilityAttribute attr;
	
	public AbilityItem(AbilityAttribute attr)
	{
		this.attr = attr;
		this.setMaxDamage(attr.getItemMaxDamage());
		this.setMaxStackSize(attr.getItemStackSize());
		if(attr != null && attr.getProperties() != null)
			for(ItemProperty ipg : attr.getProperties())
				this.addPropertyOverride(new ResourceLocation(ipg.getName()), ipg.getItemPropertyGetter());
	}
	
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("ticks", 0);
			itemStack.getTagCompound().setBoolean("use", false); 
		}
		if(itemStack.getTagCompound() != null)
		{	
			if(!itemStack.getTagCompound().getBoolean("use"))
			{
				if(this.attr.getTasks() != null)
					for(AbilityTask t : this.attr.getTasks())
						t.onItemUse(itemStack, player);
				
				if(this.attr.getItemMaxCharges() > 0)
					player.setActiveHand(hand);
				
				if(!this.attr.isFalseAttribute())
				{
					if(this.attr.hasProjectile() && !(this.attr.getItemMaxCharges() > 0) && !world.isRemote)
					{		 
						AbilityProjectile proj = new AbilityProjectile(player.worldObj, player, attr);
						proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, this.attr.getProjectileSpeed() + 0.5F, 0);
						world.spawnEntityInWorld(proj);
					}
					
					if(this.attr.getPotionEffectsForUser() != null)
						for(PotionEffect p : this.attr.getPotionEffectsForUser())				
							player.addPotionEffect(new PotionEffect(p));
						 
					if(this.attr.getPotionEffectsForAoE() != null) 
						for(PotionEffect p : this.attr.getPotionEffectsForAoE())
							for(EntityLivingBase l : WyHelper.instance().getEntitiesNear(player, this.attr.getEffectRadius())) 
								l.addPotionEffect(new PotionEffect(p));
	
					if(this.attr.isPlayerSourceOfExplosion() && !(this.attr.getItemMaxCharges() > 0))
						world.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getProjectileExplosionPower(), this.attr.canExplosionSetFire(), this.attr.canExplosionDestroyBlocks());
					
					//if(this.attr.getItemMaxDamage() > 0) itemStack.damageItem(2, player);
				}
				
				if(this.attr.getItemCooldown() > 0 && !(this.attr.getItemMaxCharges() > 0))
				{
					itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
					itemStack.getTagCompound().setBoolean("use", true);
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}
	
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count)
	{
		if(this.attr.getItemMaxCharges() > 0)
		{ 
			if(this.attr.getTasks() != null)
				for(AbilityTask t : this.attr.getTasks())
					t.onItemWhileUsing(stack, (EntityPlayer) player, count);
		}
	}
	 
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase player, int timeLeft)
    {
		if(this.attr.getItemMaxCharges() > 0)
		{ 
			if(this.attr.getTasks() != null)
				for(AbilityTask t : this.attr.getTasks())
					t.onItemAfterUse(itemStack, (EntityPlayer) player, timeLeft);
			
			if(!this.attr.isFalseAttribute())
			{
				if(this.attr.hasProjectile() && !world.isRemote)
				{
					AbilityProjectile proj = new AbilityProjectile(world, (EntityPlayer) player, attr);
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, this.attr.getProjectileSpeed() + 0.5F, 0);
					world.spawnEntityInWorld(proj);
				}
				
				if(this.attr.isPlayerSourceOfExplosion())
					world.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getProjectileExplosionPower(), this.attr.canExplosionSetFire(), this.attr.canExplosionDestroyBlocks());
				
			}
			
			if(this.attr.getItemCooldown() > 0)
			{
				itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
				itemStack.getTagCompound().setBoolean("use", true);
			}
    	}
    }
    
    public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityLivingBase player)
    {this.onPlayerStoppedUsing(itemStack, world, player, this.attr.getItemMaxCharges()); return itemStack;}
    
    public EnumRarity getRarity(ItemStack stack)
    {
    	if(this.attr.getItemRarity() != null)
        	return this.attr.getItemRarity();
    	else    	
        	return super.getRarity(stack);
    }
    
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase livingBase, EntityLivingBase livingBase2)
	{
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("ticks", 0);
			itemStack.getTagCompound().setBoolean("use", false);				
		}
		if(itemStack.getTagCompound() != null)
		{
			if(!itemStack.getTagCompound().getBoolean("use"))
			{
				if(this.attr.getTasks() != null)
					for(AbilityTask t : this.attr.getTasks())
						t.onItemHit(itemStack, livingBase, livingBase2);
				
				if(this.attr.getItemCooldown() > 0)
				{
					itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
					itemStack.getTagCompound().setBoolean("use", true);
				}
			}	
		}		
		return true;
	}	
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if (itemStack.getTagCompound() != null && this.attr != null) //&& !world.isRemote
		{		
			int t = itemStack.getTagCompound().getInteger("ticks");      
			boolean u = itemStack.getTagCompound().getBoolean("use");
			int tf = this.attr.getItemCooldown();

			if(this.attr.getTasks() != null)
				for(AbilityTask ta : this.attr.getTasks()) 
					ta.onItemTick(itemStack, (EntityPlayer)entity);
			
			if(u && t > 0)
			{
				t--;
				if(this.attr.isItemRepeater() && t > tf - (tf/4))
				{
					if(this.attr.hasProjectile())
					{
						AbilityProjectile proj = new AbilityProjectile(world, (EntityPlayer) entity, attr);
						proj.setHeadingFromThrower(entity, entity.rotationPitch, entity.rotationYaw, 0, 1.5F, 1);
						world.spawnEntityInWorld(proj);
					}
					else
						if(this.attr.getTasks() != null)
							for(AbilityTask ta : this.attr.getTasks()) 
								ta.onItemUse(itemStack, (EntityPlayer)entity);						
				}
				if(this.attr.getTasks() != null)
					for(AbilityTask ta : this.attr.getTasks()) 
						ta.onItemCooldown(itemStack, (EntityPlayer)entity);
				itemStack.getTagCompound().setInteger("ticks", t);	
			} 
			else if(t <= 0)
			{
				itemStack.getTagCompound().setInteger("ticks", tf);
				itemStack.getTagCompound().setBoolean("use", false);
			}
		}		
	}
	
	public boolean hasEffect(ItemStack itemStack)
	{
		if (itemStack.getTagCompound() != null) 
		{	
			if(itemStack.getTagCompound().getBoolean("use"))
				return true;	
			else
				return false;
		}
		return false;
	} 
	 
	public Multimap getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap multimap = super.getAttributeModifiers(slot, stack);
		if(this.attr.getItemDamage() > 0 && slot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attr.getItemDamage(), 0)); 
			
			return multimap;
		}
		return multimap;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {return true;}
	public AbilityAttribute getAttribute() {return attr;}
	public EnumAction getItemUseAction(ItemStack itemStack) {return this.attr.getItemAction();}
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {return this.attr.canItemBeDropped();}	
    public int getMaxItemUseDuration(ItemStack stack) {return this.attr.getItemMaxCharges();}
}
