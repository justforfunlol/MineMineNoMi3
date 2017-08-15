package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import sun.awt.AWTAccessor.SystemColorAccessor;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.Tasks;

public class AbilityItem extends Item
{
	protected AbilityAttribute attr = ListAttributes.NULL;
	protected EntityThrowable projectile = null;
	
	public AbilityItem()
	{ 
		this.setMaxDamage(attr.getItemMaxDamage());
		this.setMaxStackSize(attr.getItemStackSize());
	}
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
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
				if(this.attr.getItemMaxCharges() > 0)
					player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));		
				
				if(!(this.attr.getItemMaxCharges() > 0) && !world.isRemote)
				{
					this.tasksUse(itemStack, world, player);
					if(projectile != null)
						world.spawnEntityInWorld(projectile);
				}
					
				if(this.attr.getPotionEffectsForUser() != null)
					for(PotionEffect p : this.attr.getPotionEffectsForUser())				
						player.addPotionEffect(new PotionEffect(p));
						 
				if(this.attr.getPotionEffectsForAoE() != null) 
					for(PotionEffect p : this.attr.getPotionEffectsForAoE())
						for(EntityLivingBase l : WyHelper.getEntitiesNear(player, this.attr.getEffectRadius())) 
							l.addPotionEffect(new PotionEffect(p));
	
				if(!(this.attr.getItemMaxCharges() > 0) && this.attr.getItemExplosionPower() > 0)
					world.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getItemExplosionPower(), this.attr.getItemExplosionHasFire(), this.attr.getItemExplosionHasSmoke());
					
				if(this.attr.getItemMaxDamage() > 0) itemStack.damageItem(2, player);
				
				if(this.attr.getItemCooldown() > 0 && !(this.attr.getItemMaxCharges() > 0))
				{
					itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
					itemStack.getTagCompound().setBoolean("use", true);
				}
			}
		}
		return itemStack;
	}
	
    public void tasksUse(ItemStack itemStack, World world, EntityPlayer player){}
    public void tasksDuringUse(ItemStack stack, EntityPlayer player, int count){}
    public void tasksAfterUse(ItemStack itemStack, World world, EntityPlayer player, int timeLeft){}
    public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player){}
    public void tasksDuringCooldown(ItemStack itemStack, World world, EntityLivingBase entity){}
    public void tasksTick(ItemStack itemStack, World world, EntityPlayer player){}
    
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
		if(this.attr.getItemMaxCharges() > 0)
		{ 
			tasksDuringUse(stack, player, count);
		}
	}

    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int timeLeft)
    {
		if(this.attr.getItemMaxCharges() > 0)
		{ 
			if(timeLeft <= this.getMaxItemUseDuration(itemStack) - this.attr.getItemMaxCharges())
				timeLeft = this.attr.getItemMaxCharges();
			
			
			this.tasksAfterUse(itemStack, world, player, timeLeft);				
			if(this.projectile != null && !world.isRemote)
				world.spawnEntityInWorld(projectile);
				
			if(this.attr.getItemExplosionPower() > 0)
				world.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getItemExplosionPower(), this.attr.getItemExplosionHasFire(), this.attr.getItemExplosionHasSmoke());
			
			if(this.attr.getItemCooldown() > 0)
			{
				itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
				itemStack.getTagCompound().setBoolean("use", true);
			}
    	}
    }

    public EnumRarity getRarity(ItemStack stack)
    {
    	if(this.attr.getItemRarity() != null)
        	return this.attr.getItemRarity();
    	else    	
        	return super.getRarity(stack);
    }
    
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
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
				tasksHit(itemStack, target, player);
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

			tasksTick(itemStack, world, (EntityPlayer) entity);
			
			if(u && t > 0)
			{
				t--;
				//if(this.attr.isItemRepeater() && t > tf - (tf/4))
				//	if(this.projectile != null && !world.isRemote)
				//		world.spawnEntityInWorld(this.projectile);
				tasksDuringCooldown(itemStack, world, (EntityPlayer) entity);
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
	 
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = super.getAttributeModifiers(stack);
		if(this.attr.getItemDamage() > 0)
		{
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.attr.getItemDamage(), 0)); 
			
			return multimap;
		}
		return multimap;	
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {return true;}
	public AbilityAttribute getAttribute() {return attr;}
	public EnumAction getItemUseAction(ItemStack itemStack) {return this.attr.getItemAction();}
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {return this.attr.canItemBeDropped();}	
    public int getMaxItemUseDuration(ItemStack stack) {return 72000;}
}

