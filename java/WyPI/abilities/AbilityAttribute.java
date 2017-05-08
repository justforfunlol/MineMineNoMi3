 package WyPI.abilities;

import java.awt.Color;

import WyPI.abilities.extra.EffectType;
import WyPI.abilities.extra.ItemProperty;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class AbilityAttribute 
{	
	private String attributeName = "N/A";
	private boolean hasFire = true, hasExplosion = true, canBeDropped = true, canBeCharged = false, isRepeater = false, falseAttribute = false;
	private int itemTicks = 0, entityTicks = 60, entityDamage = 1, entitySpeed = 1, entityExplosion = 0, itemMaxStackSize = 1, potionEffectAoeRadius = 0, itemDamage = 0, itemMaxCharge = 1, entityOnFire = 0, itemMaxDamage = 2;
	private float projectileAlpha = 255;
	private Color entityColor = Color.decode("#FFFFFF");
	private double[] entityScale = new double[] {1, 1, 1}, entityPos = new double[] {0, 0, 0}, entityRotation = new double[] {0, 0, 0, 0}, entityMotion = new double[] {0, 0, 0};
	private ModelBase entityModel = null;
	private PotionEffect[] potionEffectsForProjectile = null, potionEffectsForUser = null, potionEffectsForAoE = null;
	private ResourceLocation entityTexture = null;
	private EnumAction itemAction = EnumAction.NONE;
	private Object[] entityTrailType = null, itemTrailType = null;
	private AbilityTask[] abilityTasks = null;
	private ItemProperty[] abilityProperties = null;
	private EnumRarity abilityRarity = null;
	
	public AbilityAttribute() {}	
	public AbilityAttribute(String name) {this.attributeName = name;}
	
	public AbilityAttribute setAttributeName(String name) { this.attributeName = name; return this; }
		//Item
	public AbilityAttribute setItemCooldown(int i) {this.itemTicks = i;return this;}	
	public AbilityAttribute setItemAction(EnumAction action) {this.itemAction = action;return this;}
	public AbilityAttribute setItemDamage(int swordDamage) {this.itemDamage = swordDamage; return this;} 
	public AbilityAttribute setItemCanBeDropped() {this.canBeDropped = true;return this;}
	public AbilityAttribute setItemCharge(int ticks) {this.itemAction = EnumAction.BOW;this.canBeCharged = true;this.itemMaxCharge = ticks;return this;}
	public AbilityAttribute setItemRepeater() {this.isRepeater = true;return this;}
	public AbilityAttribute setItemMaxStack(int stackSize) {this.itemMaxStackSize = stackSize;return this;}	
	public AbilityAttribute setItemMaxDamage(int maxDmg) { this.itemMaxDamage = maxDmg; return this; }
	public AbilityAttribute setItemRarity(EnumRarity rarity) { this.abilityRarity = rarity; return this; }
		//Projectile
	public AbilityAttribute setProjectileTicks(int i) {this.entityTicks = i;return this;}
	public AbilityAttribute setProjectileDamage(int i) {this.entityDamage = i;return this;}
	public AbilityAttribute setProjectileModel(ModelBase i) {this.entityModel = i;return this;}
	public AbilityAttribute setProjectileColor(Color i) {this.entityColor = i;return this;}
	public AbilityAttribute setProjectileColor(int i) {this.entityColor = new Color(i);return this;}
	public AbilityAttribute setProjectileColor(String color) {if(color.contains("#")){this.entityColor = Color.decode(color);}else{this.entityColor = Color.decode("#" + color);}return this;}
	public AbilityAttribute setProjectileAlpha(float alpha) { this.projectileAlpha = alpha; return this; }
	public AbilityAttribute setProjectileSize(double x, double y, double z) { this.entityScale = new double[] {x, y, z}; return this; }
	public AbilityAttribute setProjectileSize(double i[]) { this.entityScale = i; return this; }
	public AbilityAttribute setProjectilePosition(double i[]) { this.entityPos = i; return this; }
	public AbilityAttribute setProjectileExplosion(int i, boolean fire, boolean explosion) {this.entityExplosion = i;this.hasFire = fire;this.hasExplosion = explosion;return this;}
	public AbilityAttribute setProjectileExplosion(int i, boolean fire) {this.entityExplosion = i;this.hasFire = fire;return this;}
	public AbilityAttribute setProjectileExplosion(int i) {this.entityExplosion = i;return this;}
	public AbilityAttribute setProjectileSpeed(int i) {this.entitySpeed = i;return this;}
		//Potion Effects
	public AbilityAttribute addEffects(EffectType type, PotionEffect... e) 
	{
		if(type == EffectType.PROJECTILE) this.potionEffectsForProjectile = e;
		if(type == EffectType.USER) this.potionEffectsForUser = e;
		if(type == EffectType.AOE) this.potionEffectsForAoE = e;
		return this;
	}
	public AbilityAttribute setEffectRadius(int i) { this.potionEffectAoeRadius = i;return this;}
		//Misc
	public AbilityAttribute addTasks(AbilityTask... a) { this.abilityTasks = a; return this; }
	public AbilityAttribute addProperty(ItemProperty... a) { this.abilityProperties = a; return this; }
	public AbilityAttribute setFalseAttribute() { this.falseAttribute = true; return this; }

	
	
	
	

		//Item
	public int getItemCooldown() {return itemTicks;}
	public int getItemStackSize() {return this.itemMaxStackSize;}
	public EnumAction getItemAction() {return this.itemAction;}
	public boolean canItemBeDropped() {return this.canBeDropped;}
	public int getItemDamage() {return this.itemDamage;}
	public boolean isItemRepeater() {return this.isRepeater;}
	public int getItemMaxDamage() {return itemMaxDamage;}
	public boolean canItemBeCharged() {return this.canBeCharged;}
	public EnumRarity getItemRarity() { return this.abilityRarity; }
		//Projectile
	public boolean hasProjectile() {return this.entityTicks > 0 && this.entityModel != null;}
	public int getProjectileTicks() {return entityTicks;}
	public int getProjectileDamage() {return entityDamage;}
	public Color getProjectileColor() {return entityColor;}
	public ModelBase getProjectileModel() {return entityModel;}
	public double[] getProjectileSize() {return entityScale;}
	public double[] getProjectilePosition() { return entityPos; }
	public int getProjectileSpeed() {return entitySpeed;}
	public int getProjectileExplosionPower() {return entityExplosion;}		
	public boolean canExplosionSetFire() {return hasFire;}
	public boolean canExplosionDestroyBlocks() {return hasExplosion;}	
	public int getItemMaxCharges() {return this.itemMaxCharge;}	
	public float getProjectileAlpha() { return this.projectileAlpha; }
		//Potion Effects
	public PotionEffect[] getPotionEffectsForProjectile() {return this.potionEffectsForProjectile;}
	public PotionEffect[] getPotionEffectsForUser() {return this.potionEffectsForUser;}
	public PotionEffect[] getPotionEffectsForAoE() {return this.potionEffectsForAoE;}
	public int getEffectRadius() {return this.potionEffectAoeRadius;}
		//Misc
	public String getAttributeName() {return this.attributeName;}
	public AbilityTask[] getTasks() {return this.abilityTasks;}
	public ItemProperty[] getProperties() { return this.abilityProperties; }
	public boolean isFalseAttribute() {return this.falseAttribute;}	
	public boolean isPlayerSourceOfExplosion() {return this.getProjectileExplosionPower() > 0 && !this.hasProjectile();}
	public boolean hasAOE() {return this.potionEffectsForProjectile != null && this.potionEffectAoeRadius > 0;}
	public boolean hasEffectOnUser() {return !this.hasProjectile() && this.potionEffectsForProjectile != null && this.hasAOE() == false;}

}
