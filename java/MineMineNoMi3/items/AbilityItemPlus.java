package MineMineNoMi3.items;

import MineMineNoMi3.entities.projectiles.ProjectileAvalanche;
import MineMineNoMi3.entities.projectiles.ProjectileFire;
import MineMineNoMi3.entities.projectiles.ProjectileGas;
import MineMineNoMi3.entities.projectiles.ProjectileGlint;
import MineMineNoMi3.entities.projectiles.ProjectileGreenFire;
import MineMineNoMi3.entities.projectiles.ProjectileSmoke;
import MineMineNoMi3.entities.projectiles.ProjectileVulcan;
import MineMineNoMi3.lists.ListMisc;
import WyPI.abilities.AbilityAttribute;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityTask;
import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AbilityItemPlus extends AbilityItem
{

	public AbilityItemPlus(AbilityAttribute attr)
	{
		super(attr);
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{ 
		//System.out.println((Math.abs(player.getOfflineUUID(player.getDisplayNameString()).hashCode()) >> 20) + world.rand.nextInt(100));
		
		for(int i = -2; i <= 2; i++)
		for(int j = -2; j <= 2; j++)
		for(int k = -2; k <= 2; k++)
			if( world.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) == ListMisc.KairosekiOre.getDefaultState() || world.getBlockState(new BlockPos(player.posX + i, player.posY + j, player.posZ + k)) == ListMisc.KairosekiBlock.getDefaultState())
				return new ActionResult(EnumActionResult.FAIL, itemStack);
		     
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("ticks", 0);
			itemStack.getTagCompound().setBoolean("use", false);
		}
		if (itemStack.getTagCompound() != null)
		{
			if (!itemStack.getTagCompound().getBoolean("use"))
			{
				if (this.attr.getTasks() != null)
					for (AbilityTask t : this.attr.getTasks())
						t.onItemUse(itemStack, player);

				if (this.attr.canItemBeCharged())
					player.setActiveHand(hand);

				if (!this.attr.isFalseAttribute())
				{
					if (this.attr.hasProjectile() && !this.attr.canItemBeCharged() && !world.isRemote)
					{
						System.out.println(this.attr.getAttributeName());
						AbilityProjectile proj = null;
						if (this.attr.getAttributeName().equals("Hiken") || this.attr.getAttributeName().equals("Higan") || this.attr.getAttributeName().equals("Jujika") || this.attr.getAttributeName().equals("Dai Enkai : Entei") || this.attr.getAttributeName().equals("Fire Dial"))
							proj = new ProjectileFire(player.worldObj, player, attr);
						else if (this.attr.getAttributeName().equals("Ice Block : Pheasant"))
							proj = new ProjectileAvalanche(player.worldObj, player, attr);
						else if (this.attr.getAttributeName().equals("Ryusei Kazan") || this.attr.getAttributeName().equals("Dai Funka"))
							proj = new ProjectileVulcan(player.worldObj, player, attr);
						else if ( this.attr.getAttributeName().equals("White Snake") || this.attr.getAttributeName().equals("White Out") )
							proj = new ProjectileSmoke(player.worldObj, player, attr);
						else if (this.attr.getAttributeName().equals("Gas Robe"))
							proj = new ProjectileGas(player.worldObj, player, attr);
						else if (this.attr.getAttributeName().equals("Yasakani no Magatama"))
							proj = new ProjectileGlint(player.worldObj, player, attr);
						else if (this.attr.getAttributeName().equals("Hidaruma"))
							proj = new ProjectileGreenFire(player.worldObj, player, attr);
						else
							proj = new AbilityProjectile(player.worldObj, player, attr);
						proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, this.attr.getProjectileSpeed() + 0.5F, 0);
						world.spawnEntityInWorld(proj);
					}

					if (this.attr.getPotionEffectsForUser() != null)
						for (PotionEffect p : this.attr.getPotionEffectsForUser())
							player.addPotionEffect(new PotionEffect(p));

					if (this.attr.getPotionEffectsForAoE() != null)
						for (PotionEffect p : this.attr.getPotionEffectsForAoE())
							for (EntityLivingBase l : WyHelper.instance().getEntitiesNear(player, this.attr.getEffectRadius()))
								l.addPotionEffect(new PotionEffect(p));

					if (this.attr.isPlayerSourceOfExplosion() && !this.attr.canItemBeCharged())
						world.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getProjectileExplosionPower(), this.attr.canExplosionSetFire(), this.attr.canExplosionDestroyBlocks());
				}

				if (this.attr.getItemCooldown() > 0 && !this.attr.canItemBeCharged())
				{
					itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
					itemStack.getTagCompound().setBoolean("use", true);
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}
}
