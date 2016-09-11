package MineMineNoMi3.lists;

import java.awt.Color;

import MineMineNoMi3.ParticleTemplateForProjectileWithLOD;
import MineMineNoMi3.entities.models.ModelBird;
import MineMineNoMi3.entities.models.ModelGhost;
import MineMineNoMi3.entities.models.ModelX;
import WyPI.abilities.AbilityAttribute;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.ModelCube;
import WyPI.abilities.ModelSphere;
import WyPI.abilities.extra.EffectType;
import WyPI.abilities.tasks.AbilityTaskChargeable;
import WyPI.vfx.ParticleTemplateForItem;
import WyPI.vfx.ParticleTemplateForProjectile;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;

public class ListAbilities 
{  
	public static AbilityItem KILOPRESS = new AbilityItem(new AbilityAttribute("Kilo Press") );
	
	public static AbilityItem TODOROKI = new AbilityItem(new AbilityAttribute("Todoroki") );
	
	public static AbilityItem PISTOLKISS = new AbilityItem(new AbilityAttribute("Pistol Kiss") );
	public static AbilityItem PERFUMEFEMUR = new AbilityItem(new AbilityAttribute("Perfume Femur") );
	public static AbilityItem SLAVEARROW = new AbilityItem(new AbilityAttribute("Slave Arrow") );
	public static AbilityItem MEROMEROMELLOW = new AbilityItem(new AbilityAttribute("Mero Mero Mellow") );
	
	public static AbilityItem SPIRALHOLLOW = new AbilityItem(new AbilityAttribute("Spiral Hollow").setItemTicks(200).setDamage(20).setModel(new ModelCube()).setColor("#F8F8FF").setSize(5, 3, 3).setEntityTicks(3) );
	public static AbilityItem ATOMICSPAR = new AbilityItem(new AbilityAttribute("Atomic Spar").setItemTicks(120).setModel(new ModelX()).setSize(2, 2, 2).setColor("#F8F8FF").setDamage(10) );
	public static AbilityItem SPARCLAW = new AbilityItem(new AbilityAttribute("Spar Claw").setItemTicks(120).addTasks(Tasks.sparclaw) );
	public static AbilityItem SPIDER = new AbilityItem(new AbilityAttribute("Spider").addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 10, 100), new PotionEffect(MobEffects.SLOWNESS, 10, 100)) );
	
	public static AbilityItem NEGATIVEHOLLOW = new AbilityItem(new AbilityAttribute("Negative Hollow").setItemTicks(150).setModel(new ModelGhost()).setSize(1, 1, 1).setColor("#F8F8FF").setDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 1), new PotionEffect(MobEffects.SLOWNESS, 200, 1)) );
	public static AbilityItem MINIHOLLOW = new AbilityItem(new AbilityAttribute("Mini Hollow").setItemTicks(80).setModel(new ModelGhost()).setSize(0.4, 0.4, 0.4).setColor("#F8F8FF").setDamage(5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 0), new PotionEffect(MobEffects.SLOWNESS, 200, 0)).setItemRepeater() );
	public static AbilityItem TOKUHOLLOW = new AbilityItem(new AbilityAttribute("Toku Hollow").setItemTicks(250).setModel(new ModelGhost()).setSize(4, 4, 4).setColor("#F8F8FF").setDamage(10).setExplosion(5, false, false).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 1), new PotionEffect(MobEffects.SLOWNESS, 200, 1)) );
	
	public static AbilityItem BLACKKNIGHT = new AbilityItem(new AbilityAttribute("Black Knight") );
	public static AbilityItem OVERHEAT = new AbilityItem(new AbilityAttribute("Overheat") );
	public static AbilityItem SORANOMICHI = new AbilityItem(new AbilityAttribute("Sora no Michi") );
	public static AbilityItem PARASITE = new AbilityItem(new AbilityAttribute("Parasite") );
	
	public static AbilityItem BARIBARINOPISTOL = new AbilityItem(new AbilityAttribute("Bari Bari no Pistol") );
	public static AbilityItem BARRIERBALL = new AbilityItem(new AbilityAttribute("Barrier Ball") );
	public static AbilityItem BARRIERCRASH = new AbilityItem(new AbilityAttribute("Barrier Crash") );
	public static AbilityItem BARRIER = new AbilityItem(new AbilityAttribute("Barrier") );
	
	public static AbilityItem FUBUKI = new AbilityItem(new AbilityAttribute("Fubuki").setItemTicks(250).addTasks(Tasks.fubuki) );
	public static AbilityItem TABIRAYUKI = new AbilityItem(new AbilityAttribute("Tabira Yuki").setDamageAsSword(6).addTasks(Tasks.tabirayuki) );
	public static AbilityItem MANNENYUKI = new AbilityItem(new AbilityAttribute("Mannen Yuki") );
	public static AbilityItem KAMAKURAJUSSOSHI = new AbilityItem(new AbilityAttribute("Kamakura Jussoshi").setItemTicks(300).addTasks(Tasks.kamakurajusshoshi) );
	public static AbilityItem YUKIRABI = new AbilityItem(new AbilityAttribute("Yuki Rabi").setItemTicks(70).setColor(Color.WHITE).setDamage(5).setModel(new ModelCube()).setSize(1, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 50, 1)) );
	public static AbilityItem KAMAKURA = new AbilityItem(new AbilityAttribute("Kamakura").setItemTicks(100).addTasks(Tasks.kamakura) );
	
	public static AbilityItem SHINOKUNI = new AbilityItem(new AbilityAttribute("Shinokuni") );
	public static AbilityItem KARAKUNI = new AbilityItem(new AbilityAttribute("Karakuni").setItemTicks(300).addTasks(Tasks.karakuni) );
	public static AbilityItem BLUESWORD = new AbilityItem(new AbilityAttribute("Blue Sword").setDamageAsSword(7).addTasks(Tasks.bluesword) );
	public static AbilityItem GASTANET = new AbilityItem(new AbilityAttribute("Gastanet").setItemTicks(150).setExplosion(5, false) );
	public static AbilityItem GASTILLE = new AbilityItem(new AbilityAttribute("Gastille").setItemTicks(200).setSpeed(6).setDamage(10).setModel(new ModelCube()).setColor("324AB2").setSize(2, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).setItemRepeater().setExplosion(1, false) );
	public static AbilityItem GASROBE = new AbilityItem(new AbilityAttribute("Gas Robe").setItemTicks(150).setSpeed(6).setDamage(10).setModel(new ModelCube()).setSize(0, 0, 0).setItemRepeater().setParticleForProjectile(new ParticleTemplateForProjectileWithLOD(6), EnumParticleTypes.PORTAL, EnumParticleTypes.SPELL_WITCH) );
	
	public static AbilityItem DOKUFUGU = new AbilityItem(new AbilityAttribute("Doku Fugu").setItemTicks(250).setDamage(15).setModel(new ModelSphere()).setColor("A020F0").setSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).setItemRepeater() );
	public static AbilityItem VENOMDEMON = new AbilityItem(new AbilityAttribute("Venom Demon") );
	public static AbilityItem VENOMROAD = new AbilityItem(new AbilityAttribute("Venom Road").setItemTicks(200).setDamage(30).setModel(new ModelCube()).setColor("A020F0").setSize(6, 4, 4).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).addTasks(Tasks.venomroad) );
	public static AbilityItem CHLOROBALL = new AbilityItem(new AbilityAttribute("Chloro Ball").setItemTicks(150).setDamage(10).setModel(new ModelSphere()).setColor("A020F0").setSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).addTasks(Tasks.chloroball) );
	public static AbilityItem HYDRA = new AbilityItem(new AbilityAttribute("Hydra").setItemTicks(200).setDamage(30).setModel(new ModelCube()).setColor("A020F0").setSize(6, 4, 4).setEntityTicks(3).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)) );
	
	public static AbilityItem CANDLEHOUSE = new AbilityItem(new AbilityAttribute("Candle House").setItemTicks(250).addTasks(Tasks.candleHouse) );
	public static AbilityItem CANDLEWALL = new AbilityItem(new AbilityAttribute("Candle Wall").setItemTicks(150).addTasks(Tasks.candleWall) );
	public static AbilityItem DORUDORUARTSKEN = new AbilityItem(new AbilityAttribute("Doru Doru Arts : Ken").setDamageAsSword(7) );
	public static AbilityItem DORUDORUARTSMORI = new AbilityItem(new AbilityAttribute("Doru Doru Arts : Mori").setItemTicks(100).setDamage(15).setModel(new ModelCube()).setColor("A2ADD0").setSize(5, .5, .5) );
	
	public static AbilityItem BAKURETSUKAZAN = new AbilityItem(new AbilityAttribute("Bakuretsu Kazan").setItemTicks(400).addTasks(Tasks.bakuretsukazan) );
	public static AbilityItem RYUSEIKAZAN = new AbilityItem(new AbilityAttribute("Ryusei Kazan").setItemTicks(300).setDamage(10).setModel(new ModelCube()).setSize(4, 2, 2).setColor("CF1020").setEnemyOnFire(100).setItemRepeater().addTasks(Tasks.lavaBlock) );
	public static AbilityItem MEIGO = new AbilityItem(new AbilityAttribute("Meigo").setItemTicks(200).setDamage(40).setModel(new ModelCube()).setColor("CF1020").setSize(6, 4, 4).setEntityTicks(3) );
	public static AbilityItem DAIFUNKA = new AbilityItem(new AbilityAttribute("Dai Funka").setItemTicks(150).setDamage(20).setModel(new ModelCube()).setSize(4, 2, 2).setColor("CF1020").setEnemyOnFire(100).addTasks(Tasks.lavaBlock) );
	
	public static AbilityItem GROUNDDEATH = new AbilityItem(new AbilityAttribute("Ground Death").setItemTicks(300).addTasks(Tasks.groundDeath) );
	public static AbilityItem BARJAN = new AbilityItem(new AbilityAttribute("Barjan").setItemTicks(150).setDamage(15).setModel(new ModelCube()).setColor("967117").setSize(1.5, 0.4, 6).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.HUNGER, 500, 1)) );
	public static AbilityItem SABLES = new AbilityItem(new AbilityAttribute("Sables").setItemTicks(150).addTasks(Tasks.sables) );
	public static AbilityItem DESERTSPADA = new AbilityItem(new AbilityAttribute("Desert Spada").setItemTicks(250).addTasks(Tasks.desertSpada) );
	
	public static AbilityItem TSUNOTOKAGE = new AbilityItem(new AbilityAttribute("Tsuno-Tokage").setItemTicks(200).setDamage(30).setModel(new ModelCube()).setColor(Color.black).setSize(6, 4, 4).setEntityTicks(3) );
	public static AbilityItem SHADOWSASGARD = new AbilityItem(new AbilityAttribute("Shadow's Asgard").setItemTicks(400).addTasks(Tasks.shadowsasgard) );
	public static AbilityItem BLACKBOX = new AbilityItem(new AbilityAttribute("Black Box").setItemTicks(200).setModel(new ModelCube()).setColor(Color.black).setSize(2, 2, 2) );
	public static AbilityItem DOPPELMAN = new AbilityItem(new AbilityAttribute("Doppelman").setItemTicks(10).addTasks(Tasks.doppelman) );
	public static AbilityItem BRICKBAT = new AbilityItem(new AbilityAttribute("Brick Bat").setItemTicks(100).setDamage(10).setModel(new ModelCube()).setSize(1,	1, 1).setColor(Color.black).setItemRepeater() );
	
	public static AbilityItem SHIMAYURASHI = new AbilityItem(new AbilityAttribute("Shima Yurashi").setItemTicks(250).setDamage(20).setExplosion(2, false).setItemRepeater() );
	public static AbilityItem KABUTOWARI = new AbilityItem(new AbilityAttribute("Kabutowari").setItemTicks(150).setExplosion(5, false) );
	public static AbilityItem KAISHIN = new AbilityItem(new AbilityAttribute("Kaishin").setItemTicks(150).setDamage(50).setModel(new ModelCube()).setSize(0, 0, 0).setExplosion(1, false, false) );
	
	public static AbilityItem KICKBOMB = new AbilityItem(new AbilityAttribute("Kick Bomb").setItemTicks(150).setExplosion(7, false) );
	public static AbilityItem NOSEFANCYCANNON = new AbilityItem(new AbilityAttribute("Nose Fancy Cannon").setItemTicks(100).setModel(new ModelCube()).setColor("3D2B1F").setSize(2, 1, 1).setDamage(10).setExplosion(3, false) );
	
	public static AbilityItem URSUSSHOCK = new AbilityItem(new AbilityAttribute("Ursus Shock").setItemTicks(300).setModel(new ModelCube()).setColor("F8F8FF").setSize(1.5, 1.5, 1.5).setDamage(50).setExplosion(2, false, false).setItemCanBeCharged(40).setFalseAttribute().addTasks(new AbilityTaskChargeable()) );
	public static AbilityItem PADHO = new AbilityItem(new AbilityAttribute("Pad Ho").setItemTicks(150).addTasks(Tasks.padho) );
	
	public static AbilityItem WHITELAUNCHER = new AbilityItem(new AbilityAttribute("White Launcher").setItemTicks(150).addTasks(Tasks.whitelauncher) );
	public static AbilityItem WHITESNAKE = new AbilityItem(new AbilityAttribute("White Snake").setItemTicks(150).setEntityTicks(120).setModel(new ModelCube()).setSpeed(5).setSize(0, 0, 0).setDamage(15).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).setParticleForProjectile(new ParticleTemplateForProjectileWithLOD(10), EnumParticleTypes.SMOKE_LARGE) );
	public static AbilityItem WHITEOUT = new AbilityItem(new AbilityAttribute("White Out").setItemTicks(80).setModel(new ModelCube()).setSpeed(5).setSize(0, 0, 0).setDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 500, 5)).setParticleForProjectile(new ParticleTemplateForProjectileWithLOD(10), EnumParticleTypes.EXPLOSION_NORMAL).setItemRepeater() );
	
	public static AbilityItem SANGO = new AbilityItem(new AbilityAttribute("Sango").setItemTicks(250).setEntityTicks(10).setModel(new ModelCube()).setSize(10, 3, 3).setColor("7CB9E8").setDamage(15) );
	public static AbilityItem KARI = new AbilityItem(new AbilityAttribute("Kari").setItemTicks(150).setExplosion(6, false, false) );
	public static AbilityItem RAIGO = new AbilityItem(new AbilityAttribute("Raigo").setItemTicks(400).setModel(new ModelCube()).setColor("5D8AA8").setSize(8, 8, 8).setDamage(40).setExplosion(7, false) );
	public static AbilityItem VOLTVARI = new AbilityItem(new AbilityAttribute("Volt Vari").setItemTicks(80).setModel(new ModelSphere()).setSize(3, 3, 3).setDamage(5).setColor("7CB9E8").setItemCanBeCharged(20).addTasks(new AbilityTaskChargeable()).setFalseAttribute() );
	public static AbilityItem ELTHOR = new AbilityItem(new AbilityAttribute("El Thor").setItemTicks(200).addTasks(Tasks.elthor) );
	 
	public static AbilityItem GAMMAKNIFE = new AbilityItem(new AbilityAttribute("Gamma Knife").setItemTicks(750).setEntityTicks(20).setModel(new ModelCube()).setColor("00AB66").setDamage(100).setSize(5, 1, 1) );
	public static AbilityItem MES = new AbilityItem(new AbilityAttribute("Mes").setItemTicks(100).addTasks(Tasks.mes) ); 
	public static AbilityItem COUNTERSHOCK = new AbilityItem(new AbilityAttribute("Counter Shock").setItemTicks(200).setEntityTicks(7).setModel(new ModelCube()).setSize(1, 1, 1).setDamage(40).setExplosion(1, false, false) );
	public static AbilityItem ROOM = new AbilityItem(new AbilityAttribute("Room").setItemTicks(100).addTasks(Tasks.room) );
	
	public static AbilityItem NORONOROBEAM = new AbilityItem(new AbilityAttribute("Noro Noro Beam").setItemTicks(100).setModel(new ModelCube()).setSize(.6, .6, .6).setColor("FF1DCE").addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 100, 10)).setSpeed(5) );
	public static AbilityItem NORONOROBEAMSWORD = new AbilityItem(new AbilityAttribute("Noro Noro Beam Sword").setDamage(6).addTasks(Tasks.noronorobeamsword) );
	
	public static AbilityItem SHISHANOTE = new AbilityItem(new AbilityAttribute("Shisha no Te").setItemTicks(100).setDamage(5).setModel(new ModelCube()).setSize(0, 0, 0).setExplosion(3, false) );
	public static AbilityItem SKATTING = new AbilityItem(new AbilityAttribute("Skatting").setItemTicks(50).addTasks(Tasks.skatting) ); 
	
	public static AbilityItem GEAR = new AbilityItem(new AbilityAttribute("Gear").setItemTicks(400).setItemCanBeCharged(80).addTasks(Tasks.gear) );
	public static AbilityItem GOMUGOMUNOBAZOOKA = new AbilityItem(new AbilityAttribute("Gomu Gomu no Bazooka").setItemCanBeCharged(30).setItemTicks(250).addTasks(Tasks.gomugomubazooka) );
	public static AbilityItem GOMUGOMUNOGATLING = new AbilityItem(new AbilityAttribute("Gomu Gomu no Gatling").setItemTicks(250).setItemRepeater().addTasks(Tasks.gomugomugatling) ); 
	public static AbilityItem GOMUGOMUNOPISTOL = new AbilityItem(new AbilityAttribute("Gomu Gomu no Pistol").setItemTicks(150).setItemCanBeCharged(20).addTasks(Tasks.gomugomupistol) );
	
	public static AbilityItem AMANOMURAKUMO = new AbilityItem(new AbilityAttribute("Ama no Murakumo").setDamageAsSword(9) ); 
	public static AbilityItem AMATERASU = new AbilityItem(new AbilityAttribute("Amaterasu").setItemTicks(350).setEntityTicks(150).setModel(new ModelCube()).setSize(5, 1.2, 1.2).setColor("FFFF00").setSpeed(7).setDamage(35).setExplosion(6, false) );
	public static AbilityItem YASAKANINOMAGATAMA = new AbilityItem(new AbilityAttribute("Yasakani no Magatama").setItemTicks(60).setModel(new ModelCube()).setSize(3, .5, .5).setColor("FFFF00").setSpeed(5).setItemRepeater().setDamage(5).setExplosion(3, false) );
	public static AbilityItem YATANOKAGAMI = new AbilityItem(new AbilityAttribute("Yata no Kagami").setItemTicks(100).addTasks(Tasks.yatanokagami) );
	 
	public static AbilityItem SPRINGDEATHKNOCK = new AbilityItem(new AbilityAttribute("Spring Death Knock").setItemTicks(200).setDamage(20).setModel(new ModelCube()).setColor("E6E8FA").setSize(5, 3, 3).setEntityTicks(3) );
	public static AbilityItem SPRINGSNIPE = new AbilityItem(new AbilityAttribute("Spring Snipe").setItemTicks(150).setItemCanBeCharged(20).addTasks(Tasks.springsnipe) );
	public static AbilityItem SPRINGHOPPER = new AbilityItem(new AbilityAttribute("Spring Hopper").setItemTicks(80).setItemCanBeCharged(15).addTasks(Tasks.springhopper) );

	public static AbilityItem ICETIMECAPSULE = new AbilityItem(new AbilityAttribute("Ice Time Capsule").setItemTicks(350).addTasks(Tasks.iceTime) );
	public static AbilityItem ICESABER = new AbilityItem(new AbilityAttribute("Ice Saber").setDamageAsSword(6).addTasks(Tasks.icesaber) ); 
	public static AbilityItem ICEBALL = new AbilityItem(new AbilityAttribute("Ice Ball").setItemTicks(150).setDamage(5).setModel(new ModelSphere()).setColor("00FFFF").setSize(5, 5, 5).addTasks(Tasks.iceBall) );
	public static AbilityItem ICEAGE = new AbilityItem(new AbilityAttribute("Ice Age").setItemTicks(350).addEffects(EffectType.AOE, new PotionEffect(MobEffects.SLOWNESS, 200, 100), new PotionEffect(MobEffects.MINING_FATIGUE, 200, 100)).setAoERadius(20).addTasks(Tasks.iceAge) );
	public static AbilityItem ICEBLOCKPARTISAN = new AbilityItem(new AbilityAttribute("Ice Block : Partisan").setItemTicks(100).setDamage(10).setModel(new ModelCube()).setColor("00FFFF").setSize(5, .5, .5).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.WATER_SPLASH, EnumParticleTypes.CRIT_MAGIC, EnumParticleTypes.DRIP_WATER).setItemRepeater().addTasks(Tasks.iceBlock) );
	public static AbilityItem ICEBLOCKPHEASANT = new AbilityItem(new AbilityAttribute("Ice Block : Pheasant").setItemTicks(500).setDamage(15).setModel(new ModelBird()).setColor("00FFFF").setSize(5, 5, 5).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.WATER_SPLASH, EnumParticleTypes.CRIT_MAGIC, EnumParticleTypes.DRIP_WATER) );
	
	public static AbilityItem ENJOMO  = new AbilityItem(new AbilityAttribute("Enjomo").setItemTicks(250).addTasks(Tasks.enjomo));
	public static AbilityItem KAGERO = new AbilityItem(new AbilityAttribute("Jujika").setItemTicks(150).setDamage(5).setModel(new ModelCube()).setColor("FF0000").setSize(3, .1, .1).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.FLAME, EnumParticleTypes.LAVA).addTasks(Tasks.kagero));
	public static AbilityItem HIDARUMA = new AbilityItem(new AbilityAttribute("Hidaruma").setItemTicks(150).setModel(new ModelCube()).setSize(0, 0, 0).setEnemyOnFire(100).setParticleForItem(new ParticleTemplateForItem(), EnumParticleTypes.VILLAGER_HAPPY).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.VILLAGER_HAPPY).addTasks(Tasks.fireBlock) );
	public static AbilityItem DAIENKAIENTEI = new AbilityItem(new AbilityAttribute("Dai Enkai : Entei").setModel(new ModelSphere()).setDamage(25).setColor("FF0000").setSize(9, 9, 9).setExplosion(4).setItemTicks(500).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.FLAME, EnumParticleTypes.LAVA).setItemCanBeCharged(15).addTasks(new AbilityTaskChargeable()).setFalseAttribute() );
	public static AbilityItem HIGAN = new AbilityItem(new AbilityAttribute("Higan").setItemTicks(80).setModel(new ModelCube()).setDamage(5).setColor("FF0000").setSize(.3, .3, .3).setItemRepeater().setParticleForProjectile(new ParticleTemplateForProjectileWithLOD(1), EnumParticleTypes.FLAME, EnumParticleTypes.LAVA) );
	public static AbilityItem HIKEN = new AbilityItem(new AbilityAttribute("Hiken").setItemTicks(200).setModel(new ModelCube()).setDamage(20).setColor("FF0000").setSize(3, 1, 1).setExplosion(2).setParticleForProjectile(new ParticleTemplateForProjectile(), EnumParticleTypes.FLAME, EnumParticleTypes.LAVA) );
  
	public static AbilityItem SORU = new AbilityItem(new AbilityAttribute().addEffects(EffectType.USER, new PotionEffect(MobEffects.SPEED, 10, 2)));
	public static AbilityItem TEKKAI = new AbilityItem(new AbilityAttribute().addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 10, 100), new PotionEffect(MobEffects.SLOWNESS, 10, 100)));
	public static AbilityItem GEPPO = new AbilityItem(new AbilityAttribute().setItemTicks(22).addTasks(Tasks.geppo) );
	public static AbilityItem RANKYAKU = new AbilityItem(new AbilityAttribute().setItemTicks(200).setEntityTicks(100).setModel(new ModelCube()).setSize(1.5, 0.4, 6).setColor("69E3FF").setDamage(20).setExplosion(5, false) );
	public static AbilityItem SHIGAN = new AbilityItem(new AbilityAttribute().setItemTicks(130).setEntityTicks(3).setModel(new ModelCube()).setSize(6, 1, 1).setDamage(25) );
	public static AbilityItem KAMIE = new AbilityItem(new AbilityAttribute().addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 20, 100)) );
	
	public static AbilityItem UCHIMIZU = new AbilityItem(new AbilityAttribute().setItemTicks(100).setModel(new ModelCube()).setColor("00CED1").setSize(1.3, 1, 1).setDamage(5).setItemRepeater());
	public static AbilityItem YARINAMI = new AbilityItem(new AbilityAttribute().setItemTicks(150).setModel(new ModelCube()).setColor("00CED1").setSize(3, 1, 1).setDamage(15) );
	public static AbilityItem SAMEHADASHOTEI = new AbilityItem(new AbilityAttribute().addEffects(EffectType.USER, new PotionEffect(MobEffects.RESISTANCE, 10, 100), new PotionEffect(MobEffects.SLOWNESS, 10, 100)));
	public static AbilityItem SOSHARK = new AbilityItem(new AbilityAttribute().setItemTicks(200).addTasks(Tasks.soshark));
	public static AbilityItem MURASAME = new AbilityItem(new AbilityAttribute().setItemTicks(250).setModel(new ModelCube()).setColor("00CED1").setSize(1.8, 1.4, 1.4).setDamage(15).setItemRepeater());
	public static AbilityItem KARAKUSAGAWARASEIKEN = new AbilityItem(new AbilityAttribute().setItemTicks(400).addTasks(Tasks.karakusagawaraseiken));
	
	public static AbilityItem FRESHFIRE = new AbilityItem(new AbilityAttribute());
	public static AbilityItem MASTERNAIL = new AbilityItem(new AbilityAttribute());
	public static AbilityItem RADICALBEAM = new AbilityItem(new AbilityAttribute());
	public static AbilityItem COUPDEVENT = new AbilityItem(new AbilityAttribute());
	public static AbilityItem STRONGRIGHT = new AbilityItem(new AbilityAttribute());
	
	public static AbilityItem KENBUNSHOKUHAKI = new AbilityItem(new AbilityAttribute().setItemTicks(300).addTasks(Tasks.kenbunshokuhaki));
	public static AbilityItem BUSOSHOKUHAKI = new AbilityItem(new AbilityAttribute().setItemTicks(800).addTasks(Tasks.busoshokuhaki));
	public static AbilityItem HAOSHOKUHAKI = new AbilityItem(new AbilityAttribute().setItemTicks(1000).addTasks(Tasks.haohokuhaki));

	public static AbilityAttribute MILKYDIAL = new AbilityAttribute().setModel(new ModelCube()).setSize(1, 1, 1).setColor(Color.black).setEntityTicks(20).addTasks(Tasks.milkydial);
	public static AbilityAttribute AXEDIAL = new AbilityAttribute().setModel(new ModelCube()).setSize(1.5, 0.4, 6).setEntityTicks(100).setColor("F3E5AB").setDamage(5).setSpeed(10);
	
	//public static AbilityItem DEBUG_ITEM = (AbilityItem) new AbilityItem(new AbilityAttribute("DEBUG ITEM").setItemCanBeCharged(20).addTasks(Tasks.debug)).setCreativeTab(Values.isDebug ? CreativeTabs.COMBAT : null);

}
