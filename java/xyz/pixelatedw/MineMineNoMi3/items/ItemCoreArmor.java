package xyz.pixelatedw.MineMineNoMi3.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCoreArmor extends ItemArmor 
{

	private ArmorMaterial mat;

	public ItemCoreArmor(ArmorMaterial material, int renderType) 
	{
		super(material, 0, renderType);
		this.mat = material;
	} 
	
/*    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped model)
    {
		ModelBiped cloth = new ModelBiped(0.05F);

		cloth.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
		cloth.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
		cloth.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
		cloth.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
		cloth.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
		cloth.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
		cloth.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
		cloth.rightArmPose = ((EntityPlayer)entityLiving).getHeldItemMainhand() != null ? ArmPose.ITEM : ArmPose.EMPTY;

		cloth.isSneak = entityLiving.isSneaking();
		cloth.isRiding = entityLiving.isRiding();

		if(entityLiving instanceof EntityPlayer && entityLiving.getHeldItem(EnumHand.MAIN_HAND) != null && (entityLiving.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.BOW)) 
			cloth.rightArmPose = ArmPose.BOW_AND_ARROW;

		return cloth;
	}*/
}
