package WyPI.abilities;

import java.awt.Color;

import WyPI.abilities.extra.EffectType;
import WyPI.vfx.ParticleTemplate;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.EnumAction;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;

public class AbilityAttribute 
{	
	private String attributeName = "";
	private boolean hasFire = true, hasExplosion = true, canBeDropped = true, canBeCharged = false, isRepeater = false, falseAttribute = false;
	private int itemTicks = 0, entityTicks = 60, entityDamage = 1, entitySpeed = 1, entityExplosion = 0, itemMaxStackSize = 1, potionEffectAoeRadius = 0, itemDamage = 0, itemMaxCharge = 1, entityOnFire = 0;
	private Color entityColor = Color.decode("#FFFFFF");
	private double[] entityScale = new double[] {1, 1, 1}, entityPos = new double[] {0, 0, 0}, entityRotation = new double[] {0, 0, 0, 0}, entityMotion = new double[] {0, 0, 0};
	private ModelBase entityModel = null;
	private PotionEffect[] potionEffectsForProjectile = null, potionEffectsForUser = null, potionEffectsForAoE = null;
	private ResourceLocation entityTexture = null;
	private EnumAction itemAction = EnumAction.NONE;
	private ParticleTemplate entityTrail = null, itemTrail = null;
	private Object[] entityTrailType = null, itemTrailType = null;
	private AbilityTask[] abilityTasks = null;
	
	public AbilityAttribute() {}	
	public AbilityAttribute(String name) {this.attributeName = name;}
	
	public AbilityAttribute setItemTicks(int i) {this.itemTicks = i;return this;}	
	public AbilityAttribute setEntityTicks(int i) {this.entityTicks = i;return this;}
	public AbilityAttribute setDamage(int i) {this.entityDamage = i;return this;}
	public AbilityAttribute setColor(Color i) {this.entityColor = i;return this;}
	public AbilityAttribute setColor(int i) {this.entityColor = new Color(i);return this;}
	public AbilityAttribute setColor(String color) {if(color.contains("#")){this.entityColor = Color.decode(color);}else{this.entityColor = Color.decode("#" + color);}return this;}
	public AbilityAttribute setModel(ModelBase i) {this.entityModel = i;return this;}
	public AbilityAttribute setSize(double x, double y, double z) {this.entityScale = new double[] {x, y, z};return this;}
	public AbilityAttribute setSize(double i[]) {this.entityScale = i;return this;}
	public AbilityAttribute setExplosion(int i, boolean fire, boolean explosion) {this.entityExplosion = i;this.hasFire = fire;this.hasExplosion = explosion;return this;}
	public AbilityAttribute setExplosion(int i, boolean fire) {this.entityExplosion = i;this.hasFire = fire;return this;}
	public AbilityAttribute setExplosion(int i) {this.entityExplosion = i;return this;}
	public AbilityAttribute setSpeed(int i) {this.entitySpeed = i;return this;}
	public AbilityAttribute addEffects(EffectType type, PotionEffect... e) 
	{
		if(type == EffectType.PROJECTILE) this.potionEffectsForProjectile = e;
		if(type == EffectType.USER) this.potionEffectsForUser = e;
		if(type == EffectType.AOE) this.potionEffectsForAoE = e;
		return this;
	}
	public AbilityAttribute setAoERadius(int i) { this.potionEffectAoeRadius = i;return this;}
	public AbilityAttribute setPosition(double x, double y, double z) {this.entityPos = new double[] {x, y, z};return this;}
	public AbilityAttribute setRotation(double angle, int xAxis, int yAxis, int zAxis) {this.entityRotation = new double[] {angle, xAxis, yAxis, zAxis};return this;}
	public AbilityAttribute setMotion(double x, double y, double z) {this.entityMotion = new double[] {x, y, z};return this;}
	public AbilityAttribute setItemAction(EnumAction action) {this.itemAction = action;return this;}
	public AbilityAttribute setParticleForProjectile(ParticleTemplate pt, EnumParticleTypes... e) {this.entityTrail = pt;this.entityTrailType = e;return this;}
	public AbilityAttribute setParticleForItem(ParticleTemplate pt, EnumParticleTypes... e) {this.itemTrail = pt;this.itemTrailType = e;return this;}
 	public AbilityAttribute setDamageAsSword(int dmg) {this.itemDamage = dmg; return this;}
 	public AbilityAttribute setItemCanBeCharged(int i) {this.canBeCharged = true;this.itemAction = EnumAction.BOW;this.itemMaxCharge = i;return this;}
	public AbilityAttribute setItemCanBeDropped() {this.canBeDropped = true;return this;}
	public AbilityAttribute setItemRepeater() {this.isRepeater = true;return this;}
	public AbilityAttribute setEnemyOnFire(int inFireTicks) {this.entityOnFire = inFireTicks;return this;}
	public AbilityAttribute addTasks(AbilityTask... a) {this.abilityTasks = a;return this;}
	public AbilityAttribute setFalseAttribute() {this.falseAttribute = true;return this;}
	
	/*
 	TODO v2.0
 	
	public AbilityAttribute setTexture(String modid, String path)
	{this.entity_texture = new ResourceLocation(modid, path);return this;}
	
	public AbilityAttribute setSound(Entity e, String sound)
	{e.worldObj.playSound(e.posX, e.posY, e.posZ, sound, 100, 0, false);return this;}	
	public AbilityAttribute setSound(Entity e, String sound, int volume)
	{e.worldObj.playSound(e.posX, e.posY, e.posZ, sound, volume, 0, false);return this;}
	public AbilityAttribute setSound(Entity e, String sound, int volume, int pitch)
	{e.worldObj.playSound(e.posX, e.posY, e.posZ, sound, volume, pitch, false);return this;}
	
	public AbilityAttribute setModelOpacity(int i)
	{this.model_opacity = i;return this;}
	
	public AbilityAttribute setItemLore(String lore)
	{this.item_lore = lore;return this;}
	
	public AbilityAttribute setSpeedAsSword(double speed)
	{this.item_swordSpeed = speed;return this;}
	
	*/

	public String getAttributeName() {return this.attributeName;}
	public int getItemTicks() {return itemTicks;}
	public int getEntityTicks() {return entityTicks;}
	public int getDamage() {return entityDamage;}
	public Color getColor() {return entityColor;}
	public ModelBase getModel() {return entityModel;}
	public double[] getScale() {return entityScale;}
	public int getSpeed() {return entitySpeed;}
	public int getExplosionPower() {return entityExplosion;}
	public boolean hasFire() {return hasFire;}
	public boolean isPlayerSourceOfExplosion() {return this.getExplosionPower() > 0 && !this.hasProjectile();}
	public boolean canExplosionDestroyBlocks() {return hasExplosion;}	
	public PotionEffect[] getPotionEffectsForProjectile() {return this.potionEffectsForProjectile;}
	public PotionEffect[] getPotionEffectsForUser() {return this.potionEffectsForUser;}
	public PotionEffect[] getPotionEffectsForAoE() {return this.potionEffectsForAoE;}
	public double[] getPosition() {return this.entityPos;}
	public double[] getRotation() {return this.entityRotation;}
	public double[] getMotion() {return this.entityMotion;}
	public ResourceLocation getTexture() {return this.entityTexture;}
	public int getItemStackSize() {return this.itemMaxStackSize;}
	public EnumAction getItemAction() {return this.itemAction;}
	public boolean canItemBeDropped() {return this.canBeDropped;}
	public boolean hasCooldown() {return this.itemTicks > 0;}	
	public boolean hasProjectile() {return this.entityTicks > 0 && this.entityModel != null;}
	//public boolean hasEffectOnUser() {return !this.hasProjectile() && this.potionEffectsForProjectile != null && this.hasAOE() == false;}
	public int getAOERadius() {return this.potionEffectAoeRadius;}
	//public boolean hasAOE() {return this.potionEffectsForProjectile != null && this.potionEffectAoeRadius > 0;}
	public ParticleTemplate getTrailForProjectile() {return this.entityTrail;}
	public ParticleTemplate getTrailForItem() {return this.itemTrail;}
	public Object[] getTrailTypeForProjectile() {return this.entityTrailType;}
	public Object[] getTrailTypeForItem() {return this.itemTrailType;}
	public int getDamageAsSword() {return this.itemDamage;}
	public boolean canItemBeCharged() {return this.canBeCharged;}
	public int getItemMaxCharges() {return this.itemMaxCharge;}
	public boolean isRepeater() {return this.isRepeater;}
	public int getEntityOnFireTimer() {return this.entityOnFire;}
	public AbilityTask[] getTasks() {return this.abilityTasks;}
	public boolean isFalseAttribute() {return this.falseAttribute;}

}
