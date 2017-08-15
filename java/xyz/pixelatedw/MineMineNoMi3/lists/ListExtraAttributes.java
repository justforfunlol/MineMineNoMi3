package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelCube;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelSphere;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;
import xyz.pixelatedw.MineMineNoMi3.entities.models.ModelGomuBazooka;

public class ListExtraAttributes
{

	public static AbilityAttribute LIBERATION_BLOCK = new AbilityAttribute("Liberation Block").setProjectileModel(new ModelCube()).setProjectileColor(Color.BLACK).setProjectileDamage(5).setProjectileSize(3, 3, 3);
	 
	public static AbilityAttribute METEOR = new AbilityAttribute("Meteor").setProjectileTicks(500).setProjectileModel(new ModelSphere()).setProjectileSize(20, 20, 20).setProjectileColor("56494B").setProjectileExplosion(13);
	
	public static AbilityAttribute GOMUGOMUNOPISTOL = new AbilityAttribute("Gomu Gomu no Pistol").setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1);
	public static AbilityAttribute GOMUGOMUNOJETPISTOL = new AbilityAttribute("Gomu Gomu no Jet Pistol").setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1).setProjectileSpeed(4);
	public static AbilityAttribute GOMUGOMUNOGIGANTPISTOL = new AbilityAttribute("Gomu Gomu no Gigant Pistol").setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(7, 5, 5);
	public static AbilityAttribute GOMUGOMUNOKONGGUN = new AbilityAttribute("Gomu Gomu no Kong Gun").setProjectileModel(new ModelCube()).setProjectileColor("2A3439").setProjectileSize(7, 5, 5);	
	
	public static AbilityAttribute GOMUGOMUNOBAZOOKA = new AbilityAttribute("Gomu Gomu no Bazooka").setProjectileModel(new ModelGomuBazooka()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1);
	public static AbilityAttribute GOMUGOMUNOJETBAZOOKA = new AbilityAttribute("Gomu Gomu no Jet Bazooka").setProjectileModel(new ModelGomuBazooka()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1).setProjectileSpeed(4);
	public static AbilityAttribute GOMUGOMUNOGIGANTBAZOOKA = new AbilityAttribute("Gomu Gomu no Gigant Bazooka").setProjectileModel(new ModelGomuBazooka()).setProjectileColor("F5DEB3").setProjectileSize(7, 5, 5);
	public static AbilityAttribute GOMUGOMUNOLEOBAZOOKA = new AbilityAttribute("Gomu Gomu no Leo Bazooka").setProjectileModel(new ModelGomuBazooka()).setProjectileColor("2A3439").setProjectileSize(7, 5, 5);
	
	public static AbilityAttribute GOMUGOMUNOGATLING = new AbilityAttribute("Gomu Gomu no Gatling").setProjectileTicks(16).setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1);
	public static AbilityAttribute GOMUGOMUNOJETGATLING = new AbilityAttribute("Gomu Gomu no Jet Gatling").setProjectileTicks(16).setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(3, 1, 1).setProjectileSpeed(4);
	public static AbilityAttribute GOMUGOMUNOGIGANTGATLING = new AbilityAttribute("Gomu Gomu no Gigant Gatling").setProjectileTicks(16).setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileSize(5, 3, 3);
	public static AbilityAttribute GOMUGOMUNOKONGORGAN = new AbilityAttribute("omu Gomu no Kong Organ").setProjectileTicks(16).setProjectileModel(new ModelCube()).setProjectileColor("2A3439").setProjectileSize(5, 3, 3);

	public static AbilityAttribute NORMALBULLET = new AbilityAttribute("Bullet").setProjectileModel(new ModelSphere()).setProjectileDamage(2).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#D3D3D3");
	public static AbilityAttribute KAIROSEKIBULLET = new AbilityAttribute("Kairoseki Bullet").setProjectileModel(new ModelSphere()).setProjectileDamage(4).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#F3F3F3");
	
	public static AbilityAttribute GRAVITO = new AbilityAttribute("Gravito").setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileSize(1.5, 0.4, 6).setProjectileTicks(100).setProjectileColor("E590DF").setProjectileAlpha(50).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 550, 1), new PotionEffect(Potion.weakness.id, 550, 1));                       
	
}
