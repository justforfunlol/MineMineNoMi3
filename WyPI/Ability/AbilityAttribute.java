package WyPI.Ability;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import net.minecraft.item.EnumAction;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import WyPI.Particles.ParticleTemplate;

public class AbilityAttribute 
{	
	private String attribute_name = "";
	private boolean hasFire = true, hasExplosion = true, canBeDropped = true, canBeCharged = false, isRepeater = false, falseAttribute = false;
	private int item_ticks = 0, entity_ticks = 60, entity_dmg = 0, entity_speed = 1, entity_explosion = 0, item_maxStackSize = 1, aoe_radius = 0, item_swordDmg = 0, item_maxCharge = 1, entityOnFire = 0;
	private Color entity_color = Color.decode("#FFFFFF");
	private double[] entity_scale = new double[] {1, 1, 1}, entity_pos = new double[] {0, 0, 0}, entity_rot = new double[] {0, 0, 0, 0}, entity_motion = new double[] {0, 0, 0};
	private ModelBase entity_model = null;
	private PotionEffect[] entity_potionEffects = null;
	private ResourceLocation entity_texture = null;
	private EnumAction item_action = EnumAction.NONE;
	private ParticleTemplate entity_trail = null, item_trail = null;
	private Object[] entity_trailType = null, item_trailType = null;
	private AbilityTask[] ability_tasks = null;
	
	public AbilityAttribute(){}	
	public AbilityAttribute(String name)
	{this.attribute_name = name;}
	
	public AbilityAttribute setItemTicks(int i) {this.item_ticks = i;return this;}	
	public AbilityAttribute setEntityTicks(int i) {this.entity_ticks = i;return this;}
	public AbilityAttribute setDamage(int i) {this.entity_dmg = i;return this;}
	public AbilityAttribute setColor(Color i) {this.entity_color = i;return this;}
	public AbilityAttribute setColor(String color) {if(color.contains("#")){this.entity_color = Color.decode(color);}else{this.entity_color = Color.decode("#" + color);}return this;}
	public AbilityAttribute setModel(ModelBase i) {this.entity_model = i;return this;}
	public AbilityAttribute setSize(double x, double y, double z) {this.entity_scale = new double[] {x, y, z};return this;}
	public AbilityAttribute setSize(double i[]) {this.entity_scale = i;return this;}
	public AbilityAttribute setExplosion(int i, boolean fire, boolean explosion) {this.entity_explosion = i;this.hasFire = fire;this.hasExplosion = explosion;return this;}
	public AbilityAttribute setExplosion(int i, boolean fire) {this.entity_explosion = i;this.hasFire = fire;return this;}
	public AbilityAttribute setExplosion(int i) {this.entity_explosion = i;return this;}
	public AbilityAttribute setSpeed(int i) {this.entity_speed = i;return this;}
	public AbilityAttribute addEffects(PotionEffect... e) {this.entity_potionEffects = e;return this;}
	public AbilityAttribute addEffects(int i, PotionEffect... e) {this.aoe_radius = i;this.entity_potionEffects = e;return this;}
	public AbilityAttribute setPosition(double x, double y, double z) {this.entity_pos = new double[] {x, y, z};return this;}
	public AbilityAttribute setRotation(double angle, int xAxis, int yAxis, int zAxis) {this.entity_rot = new double[] {angle, xAxis, yAxis, zAxis};return this;}
	public AbilityAttribute setMotion(double x, double y, double z) {this.entity_motion = new double[] {x, y, z};return this;}
	public AbilityAttribute setItemAction(EnumAction action) {this.item_action = action;return this;}
	public AbilityAttribute setParticleForProjectile(ParticleTemplate pt, EnumParticleTypes... e) {this.entity_trail = pt;this.entity_trailType = e;return this;}
	public AbilityAttribute setParticleForItem(ParticleTemplate pt, EnumParticleTypes... e) {this.item_trail = pt;this.item_trailType = e;return this;}
 	public AbilityAttribute setDamageAsSword(int dmg) {this.item_swordDmg = dmg; return this;}
 	public AbilityAttribute setItemCanBeCharged(int i) {this.canBeCharged = true;this.item_action = EnumAction.BOW;this.item_maxCharge = i;return this;}
	public AbilityAttribute setItemCanBeDropped() {this.canBeDropped = true;return this;}
	public AbilityAttribute setItemRepeater() {this.isRepeater = true;return this;}
	public AbilityAttribute setEnemyOnFire(int fire) {this.entityOnFire = fire;return this;}
	public AbilityAttribute addTasks(AbilityTask... a) {this.ability_tasks = a;return this;}
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

	public String getAttributeName() {return this.attribute_name;}
	public int getItemTicks() {return item_ticks;}
	public int getEntityTicks() {return entity_ticks;}
	public int getDamage() {return entity_dmg;}
	public Color getColor() {return entity_color;}
	public ModelBase getModel() {return entity_model;}
	public double[] getScale() {return entity_scale;}
	public int getSpeed() {return entity_speed;}
	public int getExplosion() {return entity_explosion;}
	public boolean hasFire() {return hasFire;}
	public boolean isPlayerSourceOfExplosion() {return this.getExplosion() > 0 && !this.hasProjectile();}
	public boolean hasExplosion() {return hasExplosion;}	
	public PotionEffect[] getPotionEffectList() {return this.entity_potionEffects;}
	public double[] getPosition() {return this.entity_pos;}
	public double[] getRotation() {return this.entity_rot;}
	public double[] getMotion() {return this.entity_motion;}
	public ResourceLocation getTexture() {return this.entity_texture;}
	public int getItemStackSize() {return this.item_maxStackSize;}
	public EnumAction getItemAction() {return this.item_action;}
	public boolean canItemBeDropped() {return this.canBeDropped;}
	public boolean hasCooldown() {return this.item_ticks > 0;}	
	public boolean hasProjectile() {return this.entity_ticks > 0 && this.entity_model != null;}
	public boolean hasEffectOnUser() {return !this.hasProjectile() && this.entity_potionEffects != null && this.hasAOE() == false;}
	public int getAOERadius() {return this.aoe_radius;}
	public boolean hasAOE() {return this.entity_potionEffects != null && this.aoe_radius > 0;}
	public ParticleTemplate getTrailForProjectile() {return this.entity_trail;}
	public ParticleTemplate getTrailForItem() {return this.item_trail;}
	public Object[] getTrailTypeForProjectile() {return this.entity_trailType;}
	public Object[] getTrailTypeForItem() {return this.item_trailType;}
	public int getDamageAsSword() {return this.item_swordDmg;}
	public boolean canItemBeCharged() {return this.canBeCharged;}
	public int getItemMaxCharges() {return this.item_maxCharge;}
	public boolean isRepeater() {return this.isRepeater;}
	public int getEntityOnFireTimer() {return this.entityOnFire;}
	public AbilityTask[] getTasks() {return this.ability_tasks;}
	public boolean isFalseAttribute() {return this.falseAttribute;}
	
}
