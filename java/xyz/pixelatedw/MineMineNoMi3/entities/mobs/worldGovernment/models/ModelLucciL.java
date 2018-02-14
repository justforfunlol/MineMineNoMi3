package xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLucciL extends ModelBiped
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer rightlegd;
	ModelRenderer leftlegd;
	ModelRenderer hair;
	ModelRenderer ear1;
	ModelRenderer ear2;

	public ModelLucciL()
	{
		textureWidth = 64;
		textureHeight = 64;

		this.bipedHeadwear = new ModelRenderer(this, 1, 1);
		this.bipedHeadwear.addBox(0F, 0F, 0F, 0, 0, 0);
		this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadwear.setTextureSize(64, 32);
		this.bipedHeadwear.mirror = true;
		setRotation(this.bipedHeadwear, 0F, 0F, 0F);
		this.bipedHead = new ModelRenderer(this, 1, 1);
		this.bipedHead.addBox(0F, 0F, 0F, 0, 0, 0);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHead.setTextureSize(64, 32);
		this.bipedHead.mirror = true;
		setRotation(this.bipedHead, 0F, 0F, 0F);
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, -4F, 1F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 12, 16, 9);
		body.setRotationPoint(-2F, -7F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 10, 41);
		rightarm.addBox(-5F, -2F, -2F, 5, 18, 5);
		rightarm.setRotationPoint(-6F, -3F, 2F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 10, 41);
		leftarm.addBox(-1F, -2F, -2F, 5, 18, 5);
		leftarm.setRotationPoint(7F, -3F, 2F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		rightleg.setRotationPoint(-3F, 9F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		leftleg.setRotationPoint(3F, 9F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		rightlegd = new ModelRenderer(this, 0, 16);
		rightlegd.addBox(-2F, 6F, 0F, 4, 9, 4);
		rightlegd.setRotationPoint(-3F, 9F, 0F);
		rightlegd.setTextureSize(64, 32);
		rightlegd.mirror = true;
		setRotation(rightlegd, 0F, 0F, 0F);
		leftlegd = new ModelRenderer(this, 0, 16);
		leftlegd.addBox(-2F, 6F, 0F, 4, 9, 4);
		leftlegd.setRotationPoint(3F, 9F, 0F);
		leftlegd.setTextureSize(64, 32);
		leftlegd.mirror = true;
		setRotation(leftlegd, 0F, 0F, 0F);
		hair = new ModelRenderer(this, 30, 46);
		hair.addBox(-4F, -10F, 5F, 9, 10, 8);
		hair.setRotationPoint(0F, 0F, 0F);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0F, 0F, 0F);
		ear1 = new ModelRenderer(this, 0, 29);
		ear1.addBox(-3F, -13F, -1F, 2, 1, 1);
		ear1.setRotationPoint(0F, 0F, 0F);
		ear1.setTextureSize(64, 32);
		ear1.mirror = true;
		setRotation(ear1, 0F, 0F, 0F);
		ear2 = new ModelRenderer(this, 0, 29);
		ear2.addBox(1F, -13F, -1F, 2, 1, 1);
		ear2.setRotationPoint(0F, 0F, 0F);
		ear2.setTextureSize(64, 32);
		ear2.mirror = true;
		setRotation(ear2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		rightlegd.render(f5);
		leftlegd.render(f5);
		hair.render(f5);
		ear1.render(f5);
		ear2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
		leftlegd.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		rightlegd.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;

		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
	}

}
