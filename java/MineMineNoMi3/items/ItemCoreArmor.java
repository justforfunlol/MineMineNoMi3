package MineMineNoMi3.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCoreArmor extends ItemArmor 
{

	private ArmorMaterial mat;

	public ItemCoreArmor(ArmorMaterial material, EntityEquipmentSlot type) 
	{
		super(material, 0, type);
		this.mat = material;
	}
	
	/*public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "mineminenomi:textures/armor/" + this.mat.name() + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		ModelBiped cloth = new ModelBiped(0.05F);

		cloth.bipedHead.showModel = armorSlot == 0;
		cloth.bipedHeadwear.showModel = armorSlot == 0;
		cloth.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
		cloth.bipedRightArm.showModel = armorSlot == 1;
		cloth.bipedLeftArm.showModel = armorSlot == 1;
		cloth.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
		cloth.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
		cloth.rightArmPose = ((EntityPlayer)entityLiving).getCurrentEquippedItem() != null ? 1 : 0;
		
		cloth.isSneak = entityLiving.isSneaking();
		cloth.isRiding = entityLiving.isRiding();

		if(entityLiving instanceof EntityPlayer && entityLiving.getHeldItem() != null && (entityLiving.getHeldItem().getItem() == Items.bow)) 
			cloth.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 2;

		return cloth;
	}*/
}
