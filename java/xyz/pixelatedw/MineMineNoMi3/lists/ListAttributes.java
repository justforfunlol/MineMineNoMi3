package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelCube;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelSphere;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks.AbilityTaskChargeable;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks.AbilityTaskPlaceBlock;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks.AbilityTaskSetOnFire;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks.AbilityTaskSwordEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.models.ModelBird;
import xyz.pixelatedw.MineMineNoMi3.entities.models.ModelGhost;
import xyz.pixelatedw.MineMineNoMi3.entities.models.ModelHeart;
import xyz.pixelatedw.MineMineNoMi3.entities.models.ModelX;

public class ListAttributes 
{
	
	//public static AbilityAttribute ZOANFORM_USHI = new AbilityAttribute().addTasks(new TaskZoanForms("Human Point", "Power Point", "Speed Point")) );
/*	public static AbilityAttribute FIDDLEBANFF = new AbilityAttribute("Fiddle Banff") );
	
	public static AbilityAttribute SAGARINORYUSEI = new AbilityAttribute("Sagari no Ryusei").setItemCooldown(500).addTasks(Tasks.sagariNoRyusei) );
	public static AbilityAttribute MOKO = new AbilityAttribute("Moko").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileSize(new double[] {0, 0, 0}).addTasks(Tasks.moko) );
	
	public static AbilityAttribute DARKMATTER = new AbilityAttribute("Dark Matter").setItemCooldown(250).setProjectileModel(new ModelSphere()).setProjectileColor("000000").setProjectileSize(5, 5, 5).addTasks(Tasks.darkMatter) );
	public static AbilityAttribute KUROUZU = new AbilityAttribute("Kurouzu").setItemCooldown(200) );
	public static AbilityAttribute LIBERATION = new AbilityAttribute("Liberation").setItemCooldown(50).addTasks(Tasks.liberation) );
	public static AbilityAttribute BLACKHOLE = new AbilityAttribute("Black Hole").setItemCooldown(200).addTasks(Tasks.blackHole) );
	
	public static AbilityAttribute TENSIONHORMONE = new AbilityAttribute("Tension Hormone").setItemCooldown(500).addTasks(Tasks.tensionHormone) );
	public static AbilityAttribute CHIYUHORMONE = new AbilityAttribute("Chiyu Hormone").setItemCooldown(500).addTasks(Tasks.chiyuHormone) );
	
	public static AbilityAttribute KILOPRESS = new AbilityAttribute("Kilo Press").setItemCooldown(80).addTasks(Tasks.kilopress) );
	
	public static AbilityAttribute TODOROKI = new AbilityAttribute("Todoroki").setItemCooldown(300).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(5, 3, 3).setProjectileTicks(10).setProjectileDamage(15).setItemRepeater() );
	
	public static AbilityAttribute PISTOLKISS = new AbilityAttribute("Pistol Kiss").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.3, .3, .3).setProjectileColor("#FFC0DB").setProjectileDamage(5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 100, 1)).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.digSlowdown.id, 100, 1)) );
	public static AbilityAttribute PERFUMEFEMUR = new AbilityAttribute("Perfume Femur").setItemCooldown(200).setItemDamage(15).addTasks(Tasks.parfumefemur) );
	public static AbilityAttribute SLAVEARROW = new AbilityAttribute("Slave Arrow").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.3, .3, .3).setProjectileColor("#FFC0DB").setProjectileDamage(5).setItemRepeater() );
	public static AbilityAttribute MEROMEROMELLOW = new AbilityAttribute("Mero Mero Mellow").setItemCooldown(150).setProjectileModel(new ModelHeart()).setProjectileSize(3, 3, 3).setProjectileColor("#FFC0DB").setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 200, 1)).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.digSlowdown.id, 200, 1)) );
	
	public static AbilityAttribute SPIRALHOLLOW = new AbilityAttribute("Spiral Hollow").setItemCooldown(200).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("#F8F8FF").setProjectileSize(5, 3, 3).setProjectileTicks(3) );
	public static AbilityAttribute ATOMICSPAR = new AbilityAttribute("Atomic Spar").setItemCooldown(120).setProjectileModel(new ModelX()).setProjectileSize(2, 2, 2).setProjectileColor("#F8F8FF").setProjectileDamage(10) );
	public static AbilityAttribute SPARCLAW = new AbilityAttribute("Spar Claw").setItemCooldown(120).addTasks(Tasks.sparclaw) );
	public static AbilityAttribute SPIDER = new AbilityAttribute("Spider").addEffects(EffectType.USER,new PotionEffect(Potion.resistance.id, 10, 100), new PotionEffect(Potion.moveSlowdown.id, 10, 100)) );
	
	public static AbilityAttribute NEGATIVEHOLLOW = new AbilityAttribute("Negative Hollow").setItemCooldown(150).setProjectileModel(new ModelGhost()).setProjectileSize(1, 1, 1).setProjectileColor("#F8F8FF").setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 200, 1), new PotionEffect(Potion.moveSlowdown.id, 200, 1)) );
	public static AbilityAttribute MINIHOLLOW = new AbilityAttribute("Mini Hollow").setItemCooldown(80).setProjectileModel(new ModelGhost()).setProjectileSize(0.4, 0.4, 0.4).setProjectileColor("#F8F8FF").setProjectileDamage(5).setProjectileExplosion(2).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 200, 0), new PotionEffect(Potion.moveSlowdown.id, 200, 0)).setItemRepeater() );
	public static AbilityAttribute TOKUHOLLOW = new AbilityAttribute("Toku Hollow").setItemCooldown(250).setProjectileModel(new ModelGhost()).setProjectileSize(4, 4, 4).setProjectileColor("#F8F8FF").setProjectileDamage(10).setProjectileExplosion(7, false, false).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 200, 1), new PotionEffect(Potion.moveSlowdown.id, 200, 1)) );
	
	public static AbilityAttribute BLACKKNIGHT = new AbilityAttribute("Black Knight") );
	public static AbilityAttribute OVERHEAT = new AbilityAttribute("Overheat") );
	public static AbilityAttribute SORANOMICHI = new AbilityAttribute("Sora no Michi") );
	public static AbilityAttribute PARASITE = new AbilityAttribute("Parasite").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(1, .5, .5).setProjectileColor("#FFFFFF").setProjectileDamage(10) );
	
	public static AbilityAttribute BARIBARINOPISTOL = new AbilityAttribute("Bari Bari no Pistol").setItemDamage(20) );
	public static AbilityAttribute BARRIERBALL = new AbilityAttribute("Barrier Ball").setItemCooldown(100).addTasks(Tasks.barrierBall) );
	public static AbilityAttribute BARRIERCRASH = new AbilityAttribute("Barrier Crash").setItemCooldown(150).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(.3, 9, 9).setProjectileDamage(15) );
	public static AbilityAttribute BARRIER = new AbilityAttribute("Barrier").setItemCooldown(80).addTasks(Tasks.barrier) );
	
	public static AbilityAttribute FUBUKI = new AbilityAttribute("Fubuki").setItemCooldown(250).addTasks(Tasks.fubuki) );
	public static AbilityAttribute TABIRAYUKI = new AbilityAttribute("Tabira Yuki").setItemDamage(6).addTasks(Tasks.tabirayuki) );
	public static AbilityAttribute MANNENYUKI = new AbilityAttribute("Mannen Yuki") );
	public static AbilityAttribute KAMAKURAJUSSOSHI = new AbilityAttribute("Kamakura Jussoshi").setItemCooldown(300).addTasks(Tasks.kamakurajusshoshi) );
	public static AbilityAttribute YUKIRABI = new AbilityAttribute("Yuki Rabi").setItemCooldown(70).setProjectileColor(Color.WHITE).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 50, 1)).setItemRepeater() );
	public static AbilityAttribute KAMAKURA = new AbilityAttribute("Kamakura").setItemCooldown(100).addTasks(Tasks.kamakura) );
	
	public static AbilityAttribute SHINOKUNI = new AbilityAttribute("Shinokuni") );
	public static AbilityAttribute KARAKUNI = new AbilityAttribute("Karakuni").setItemCooldown(300).addTasks(Tasks.karakuni) );
	public static AbilityAttribute BLUESWORD = new AbilityAttribute("Blue Sword").setItemDamage(7).addTasks(Tasks.bluesword) );
	public static AbilityAttribute GASTANET = new AbilityAttribute("Gastanet").setItemCooldown(150).setProjectileExplosion(5, false) );
	public static AbilityAttribute GASTILLE = new AbilityAttribute("Gastille").setItemCooldown(200).setProjectileSpeed(6).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileColor("324AB2").setProjectileSize(2, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)).setItemRepeater().setProjectileExplosion(1, false) );
	public static AbilityAttribute GASROBE = new AbilityAttribute("Gas Robe").setItemCooldown(150).setProjectileSpeed(6).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setItemRepeater() );
	
	public static AbilityAttribute DOKUFUGU = new AbilityAttribute("Doku Fugu").setItemCooldown(250).setProjectileDamage(15).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)).setItemRepeater() );
	public static AbilityAttribute VENOMDEMON = new AbilityAttribute("Venom Demon") );
	public static AbilityAttribute VENOMROAD = new AbilityAttribute("Venom Road").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor("A020F0").setProjectileSize(6, 4, 4).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)).addTasks(Tasks.venomroad) );
	public static AbilityAttribute CHLOROBALL = new AbilityAttribute("Chloro Ball").setItemCooldown(150).setProjectileDamage(10).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)).addTasks(Tasks.chloroball) );
	public static AbilityAttribute HYDRA = new AbilityAttribute("Hydra").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor("A020F0").setProjectileSize(6, 4, 4).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)) );
	
	public static AbilityAttribute CANDLEHOUSE = new AbilityAttribute("Candle House").setItemCooldown(250).addTasks(Tasks.candleHouse) );
	public static AbilityAttribute CANDLEWALL = new AbilityAttribute("Candle Wall").setItemCooldown(150).addTasks(Tasks.candleWall) );
	public static AbilityAttribute DORUDORUARTSKEN = new AbilityAttribute("Doru Doru Arts : Ken").setItemDamage(7) );
	public static AbilityAttribute DORUDORUARTSMORI = new AbilityAttribute("Doru Doru Arts : Mori").setItemCooldown(100).setProjectileDamage(15).setProjectileModel(new ModelCube()).setProjectileColor("A2ADD0").setProjectileSize(5, .5, .5) );
	
	public static AbilityAttribute BAKURETSUKAZAN = new AbilityAttribute("Bakuretsu Kazan").setItemCooldown(400).addTasks(Tasks.bakuretsukazan) );
	public static AbilityAttribute RYUSEIKAZAN = new AbilityAttribute("Ryusei Kazan").setItemCooldown(300).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(4, 2, 2).setProjectileColor("CF1020").setItemRepeater().addTasks(new AbilityTaskPlaceBlock(Blocks.lava), new AbilityTaskSetOnFire(100)) );
	public static AbilityAttribute MEIGO = new AbilityAttribute("Meigo").setItemCooldown(200).setProjectileDamage(40).setProjectileModel(new ModelCube()).setProjectileColor("CF1020").setProjectileSize(6, 4, 4).setProjectileTicks(3) );
	public static AbilityAttribute DAIFUNKA = new AbilityAttribute("Dai Funka").setItemCooldown(150).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileSize(4, 2, 2).setProjectileColor("CF1020").addTasks(new AbilityTaskPlaceBlock(Blocks.lava), new AbilityTaskSetOnFire(100)) );
	
	public static AbilityAttribute GROUNDDEATH = new AbilityAttribute("Ground Death").setItemCooldown(300).addTasks(Tasks.groundDeath) );
	public static AbilityAttribute BARJAN = new AbilityAttribute("Barjan").setItemCooldown(150).setProjectileDamage(15).setProjectileModel(new ModelCube()).setProjectileColor("967117").setProjectileSize(1.5, 0.4, 6).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.hunger.id, 500, 1)) );
	public static AbilityAttribute SABLES = new AbilityAttribute("Sables").setItemCooldown(150).addTasks(Tasks.sables) );
	public static AbilityAttribute DESERTSPADA = new AbilityAttribute("Desert Spada").setItemCooldown(250).addTasks(Tasks.desertSpada) );
	
	public static AbilityAttribute TSUNOTOKAGE = new AbilityAttribute("Tsuno-Tokage").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor(Color.black).setProjectileSize(5, 2, 2).setProjectileTicks(3) );
	public static AbilityAttribute SHADOWSASGARD = new AbilityAttribute("Shadow's Asgard").setItemCooldown(400).addTasks(Tasks.shadowsasgard) );
	public static AbilityAttribute BLACKBOX = new AbilityAttribute("Black Box").setItemCooldown(200).setProjectileModel(new ModelCube()).setProjectileColor(Color.black).setProjectileSize(2, 2, 2) );
	public static AbilityAttribute DOPPELMAN = new AbilityAttribute("Doppelman").setItemCooldown(10).addTasks(Tasks.doppelman) );
	public static AbilityAttribute BRICKBAT = new AbilityAttribute("Brick Bat").setItemCooldown(100).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(1,	1, 1).setProjectileColor(Color.black).setItemRepeater() );
	
	public static AbilityAttribute SHIMAYURASHI = new AbilityAttribute("Shima Yurashi").setItemCooldown(250).setProjectileDamage(20).setProjectileExplosion(2, false).setItemRepeater() );
	public static AbilityAttribute KABUTOWARI = new AbilityAttribute("Kabutowari").setItemCooldown(150).setProjectileExplosion(5, false) );
	public static AbilityAttribute KAISHIN = new AbilityAttribute("Kaishin").setItemCooldown(150).setProjectileDamage(50).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(1, false, false) );
	
	public static AbilityAttribute KICKBOMB = new AbilityAttribute("Kick Bomb").setItemCooldown(150).setProjectileExplosion(7, false) );
	public static AbilityAttribute NOSEFANCYCANNON = new AbilityAttribute("Nose Fancy Cannon").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileColor("3D2B1F").setProjectileSize(.8, .4, .4).setProjectileDamage(10).setProjectileExplosion(3, false) );
	
	public static AbilityAttribute URSUSSHOCK = new AbilityAttribute("Ursus Shock").setItemCooldown(300).setProjectileModel(new ModelCube()).setProjectileColor("F8F8FF").setProjectileSize(1.5, 1.5, 1.5).setProjectileDamage(50).setProjectileExplosion(2, false, false).setItemCharge(40).setFalseAttribute().addTasks(new AbilityTaskChargeable()) );
	public static AbilityAttribute PADHO = new AbilityAttribute("Pad Ho").setItemCooldown(150).addTasks(Tasks.padho) );
	
	public static AbilityAttribute WHITELAUNCHER = new AbilityAttribute("White Launcher").setItemCooldown(150).addTasks(Tasks.whitelauncher) );
	public static AbilityAttribute WHITESNAKE = new AbilityAttribute("White Snake").setItemCooldown(150).setProjectileTicks(120).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(15).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1)) );
	public static AbilityAttribute WHITEOUT = new AbilityAttribute("White Out").setItemCooldown(80).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 500, 5)).setItemRepeater() );
*/	
	public static AbilityAttribute SANGO = new AbilityAttribute("Sango").setItemCooldown(250).setProjectileTicks(10).setProjectileModel(new ModelCube()).setProjectileSize(10, 3, 3).setProjectileColor("7CB9E8").setProjectileDamage(15);
	public static AbilityAttribute KARI = new AbilityAttribute("Kari").setItemCooldown(150).setItemExplosion(6, false, false);
	public static AbilityAttribute RAIGO = new AbilityAttribute("Raigo").setItemCooldown(400).setProjectileModel(new ModelCube()).setProjectileColor("5D8AA8").setProjectileSize(8, 8, 8).setProjectileDamage(40).setProjectileExplosion(7, false);
//	public static AbilityAttribute VOLTVARI = new AbilityAttribute("Volt Vari").setItemCooldown(80).setProjectileModel(new ModelSphere()).setProjectileSize(3, 3, 3).setProjectileDamage(5).setProjectileColor("7CB9E8").setItemCharge(20).addTasks(new AbilityTaskChargeable());
//	public static AbilityAttribute ELTHOR = new AbilityAttribute("El Thor").setItemCooldown(200).addTasks(Tasks.elthor);
	 
	public static AbilityAttribute GAMMAKNIFE = new AbilityAttribute("Gamma Knife").setItemCooldown(750).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileColor("00AB66").setProjectileDamage(100).setProjectileSize(5, 1, 1);
	public static AbilityAttribute MES = new AbilityAttribute("Mes").setItemCooldown(100); 
	public static AbilityAttribute COUNTERSHOCK = new AbilityAttribute("Counter Shock").setItemCooldown(200).setProjectileTicks(7).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 1).setProjectileDamage(40).setProjectileExplosion(1, false, false);
	public static AbilityAttribute ROOM = new AbilityAttribute("Room").setItemCooldown(100);
	
	public static AbilityAttribute NORONOROBEAM = new AbilityAttribute("Noro Noro Beam").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.6, .6, .6).setProjectileColor("FF1DCE").addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 100, 10)).setProjectileSpeed(5);
	public static AbilityAttribute NORONOROBEAMSWORD = new AbilityAttribute("Noro Noro Beam Sword").setProjectileDamage(6);
	
	public static AbilityAttribute SHISHANOTE = new AbilityAttribute("Shisha no Te").setItemCooldown(100).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(3, false);
	public static AbilityAttribute SKATTING = new AbilityAttribute("Skatting").setItemCooldown(50);  	
/*	 
	public static AbilityAttribute GEAR = new AbilityAttribute("Gear").setItemCooldown(400).setItemCharge(80).addTasks(Tasks.gear) );
	public static AbilityAttribute GOMUGOMUNOBAZOOKA = new AbilityAttribute("Gomu Gomu no Bazooka").setItemCooldown(250).setItemCharge(30).addTasks(Tasks.gomugomubazooka) );
	public static AbilityAttribute GOMUGOMUNOGATLING = new AbilityAttribute("Gomu Gomu no Gatling").setItemCooldown(250).setItemRepeater().addTasks(Tasks.gomugomugatling) ); 
	public static AbilityAttribute GOMUGOMUNOPISTOL = new AbilityAttribute("Gomu Gomu no Pistol").setItemCooldown(150).setItemCharge(20).addTasks(Tasks.gomugomupistol) );
*/	
	public static AbilityAttribute AMANOMURAKUMO = new AbilityAttribute("Ama no Murakumo").setItemDamage(9); 
	public static AbilityAttribute AMATERASU = new AbilityAttribute("Amaterasu").setItemCooldown(350).setProjectileTicks(150).setProjectileModel(new ModelCube()).setProjectileSize(5, 1.2, 1.2).setProjectileColor("FFFF00").setProjectileSpeed(7).setProjectileDamage(35).setProjectileExplosion(6, false);
	public static AbilityAttribute YASAKANINOMAGATAMA = new AbilityAttribute("Yasakani no Magatama").setItemCooldown(60).setProjectileModel(new ModelCube()).setProjectileSize(3, .5, .5).setProjectileColor("FFFF00").setProjectileSpeed(5).setItemRepeater().setProjectileDamage(5).setProjectileExplosion(3, false);
	public static AbilityAttribute YATANOKAGAMI = new AbilityAttribute("Yata no Kagami").setItemCooldown(100);
	 
	public static AbilityAttribute SPRINGDEATHKNOCK = new AbilityAttribute("Spring Death Knock").setItemCooldown(200).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("E6E8FA").setProjectileSize(5, 3, 3).setProjectileTicks(3);
	public static AbilityAttribute SPRINGSNIPE = new AbilityAttribute("Spring Snipe").setItemCooldown(150).setItemCharge(20);
	public static AbilityAttribute SPRINGHOPPER = new AbilityAttribute("Spring Hopper").setItemCooldown(40).setItemCharge(15);

	public static AbilityAttribute ICETIMECAPSULE = new AbilityAttribute("Ice Time Capsule").setItemCooldown(350);
	public static AbilityAttribute ICESABER = new AbilityAttribute("Ice Saber").setItemDamage(6);
	public static AbilityAttribute ICEBALL = new AbilityAttribute("Ice Ball").setItemCooldown(150).setProjectileDamage(5).setProjectileModel(new ModelSphere()).setProjectileColor("00FFFF").setProjectileSize(5, 5, 5);
	public static AbilityAttribute ICEAGE = new AbilityAttribute("Ice Age").setItemCooldown(350).addEffects(EffectType.AOE, new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100)).setEffectRadius(20);
	public static AbilityAttribute ICEBLOCKPARTISAN = new AbilityAttribute("Ice Block : Partisan").setItemCooldown(100).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileColor("00FFFF").setProjectileSize(5, .5, .5).setItemRepeater();
	public static AbilityAttribute ICEBLOCKPHEASANT = new AbilityAttribute("Ice Block : Pheasant").setItemCooldown(500).setProjectileDamage(15).setProjectileModel(new ModelBird()).setProjectileColor("00FFFF").setProjectileSize(5, 5, 5);
	
	public static AbilityAttribute ENJOMO  = new AbilityAttribute("Enjomo").setItemCooldown(250);
	public static AbilityAttribute JUJIKA = new AbilityAttribute("Jujika").setItemCooldown(150).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileColor("FF0000").setProjectileSize(3, .1, .1);
	public static AbilityAttribute HIDARUMA = new AbilityAttribute("Hidaruma").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0);
	public static AbilityAttribute DAIENKAIENTEI = new AbilityAttribute("Dai Enkai : Entei").setItemCooldown(500).setProjectileModel(new ModelSphere()).setProjectileDamage(25).setProjectileColor("FF0000").setProjectileSize(9, 9, 9).setProjectileExplosion(4).setItemCharge(15);
	public static AbilityAttribute HIGAN = new AbilityAttribute("Higan").setItemCooldown(80).setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileColor("FF0000").setProjectileSize(.3, .3, .3).setItemRepeater();
	public static AbilityAttribute HIKEN = new AbilityAttribute("Hiken").setItemCooldown(200).setProjectileModel(new ModelCube()).setProjectileDamage(20).setProjectileColor("FF0000").setProjectileSize(2, 1, 1).setProjectileExplosion(2);
 
	public static AbilityAttribute SORU = new AbilityAttribute("Soru").addEffects(EffectType.USER, new PotionEffect(Potion.moveSpeed.id, 30, 3));
	public static AbilityAttribute TEKKAI = new AbilityAttribute("Tekkai").addEffects(EffectType.USER,new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100));
	public static AbilityAttribute GEPPO = new AbilityAttribute("Geppo").setItemCooldown(22);
	public static AbilityAttribute RANKYAKU = new AbilityAttribute("Rankyaku").setItemCooldown(200).setProjectileTicks(100).setProjectileModel(new ModelCube()).setProjectileSize(1.5, 0.4, 6).setProjectileColor("69E3FF").setProjectileDamage(20).setProjectileExplosion(5, false);
	public static AbilityAttribute SHIGAN = new AbilityAttribute("Shigan").setItemCooldown(130).setProjectileTicks(3).setProjectileModel(new ModelCube()).setProjectileSize(6, 1, 1).setProjectileDamage(25);
	public static AbilityAttribute KAMIE = new AbilityAttribute("Kamie").addEffects(EffectType.USER,new PotionEffect(Potion.resistance.id, 20, 100));
	
	public static AbilityAttribute UCHIMIZU = new AbilityAttribute("Uchimizu").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(1.3, 1, 1).setProjectileDamage(5).setItemRepeater();
	public static AbilityAttribute YARINAMI = new AbilityAttribute("Yarinami").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(3, 1, 1).setProjectileDamage(15);
	public static AbilityAttribute SAMEHADASHOTEI = new AbilityAttribute("Samehada Shotei").addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 10, 100), new PotionEffect(Potion.moveSlowdown.id, 10, 100));
	public static AbilityAttribute SOSHARK = new AbilityAttribute("Soshark").setItemCooldown(200);
	public static AbilityAttribute MURASAME = new AbilityAttribute("Murasame").setItemCooldown(250).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(1.8, 1, 1).setProjectileDamage(15).setItemRepeater();
	public static AbilityAttribute KARAKUSAGAWARASEIKEN = new AbilityAttribute("Karakusagawara Seiken").setItemCooldown(400);
/*	
	public static AbilityAttribute FRESHFIRE = new AbilityAttribute("Fresh Fire") );
	public static AbilityAttribute MASTERNAIL = new AbilityAttribute("Master Nail") );
	public static AbilityAttribute RADICALBEAM = new AbilityAttribute("Radical Beam") );
	public static AbilityAttribute COUPDEVENT = new AbilityAttribute("Coup de Vent") );
	public static AbilityAttribute STRONGRIGHT = new AbilityAttribute("Strong Right") );
*/	
	public static AbilityAttribute KENBUNSHOKUHAKI = new AbilityAttribute().setItemCooldown(300);
	public static AbilityAttribute BUSOSHOKUHAKI = new AbilityAttribute().setItemCooldown(0);
	public static AbilityAttribute HAOSHOKUHAKI = new AbilityAttribute().setItemCooldown(1000);
/*
	public static AbilityAttribute DIALREJECT = new AbilityAttribute("Reject Dial").setItemMaxStack(16).setProjectileExplosion(4, false).setItemMaxDamage(1).addTasks(Tasks.rejectDial, Tasks.consumable);
	public static AbilityAttribute DIALBREATH = new AbilityAttribute("Breath Dial").setItemMaxStack(16).setItemMaxDamage(4).addTasks(Tasks.breathDial, Tasks.consumable);
	public static AbilityAttribute DIALIMPACT = new AbilityAttribute("Impact Dial").setItemMaxStack(16).setProjectileExplosion(4, false).setItemMaxDamage(1).addTasks(Tasks.consumable);
	public static AbilityAttribute DIALFIRE = new AbilityAttribute("Fire Dial").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileDamage(8).setProjectileColor("FF0000").setProjectileSize(1, .8, .8).setProjectileExplosion(1).setItemMaxDamage(2).addTasks(Tasks.consumable) );
	public static AbilityAttribute DIALMILKY = new AbilityAttribute("Milky Road").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileSize(.1, .1, .1).setProjectileColor(Color.BLUE).setProjectileTicks(20).setItemMaxDamage(1).addTasks(Tasks.milkydial, Tasks.consumable);
	public static AbilityAttribute DIALAXE = new AbilityAttribute("Axe Dial").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileSize(1.5, 0.4, 6).setProjectileTicks(100).setProjectileColor("69E3FF").setItemMaxDamage(4).addTasks(Tasks.consumable);
	*/
	public static AbilityAttribute NULL = new AbilityAttribute("nil");
}
