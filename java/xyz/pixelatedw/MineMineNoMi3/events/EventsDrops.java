package xyz.pixelatedw.MineMineNoMi3.events;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EventsDrops
{
 
	@SubscribeEvent	
	public void onTossedItem(ItemTossEvent event)
	{		
		Item i = event.entityItem.getEntityItem().getItem();
		
		/*if(i instanceof AbilityItem && !(i == ListMisc.Biseto || i == ListMisc.MarineSword || i == ListMisc.Flintlock || i == ListMisc.PirateCutlass || i == ListMisc.Scissors || i == ListMisc.Pipe 
				|| i == ListMisc.Jitte || i == ListMisc.GoldenBo || i == ListMisc.Kikoku || i == ListMisc.Kiribachi || i == ListMisc.Hook || i == ListMisc.Yoru || i == ListMisc.Umbrella 
				|| i == ListAbilities.HAOSHOKUHAKI || i == ListAbilities.BUSOSHOKUHAKI  || i == ListAbilities.KENBUNSHOKUHAKI || i == ListAbilities.DIALAXE || i == ListAbilities.DIALBREATH
				|| i == ListAbilities.DIALIMPACT || i == ListAbilities.DIALMILKY || i == ListAbilities.DIALREJECT || i == ListAbilities.DIALFIRE))
		{
			event.setCanceled(true);			
			if(event.getPlayer() instanceof EntityPlayer)
				event.getPlayer().inventory.addItemStackToInventory(new ItemStack(i));
		}*/
	}
	 
	@SubscribeEvent	
	public void onBreak(BreakEvent event)
	{	
		/*if(MainConfig.allowDFtoDrop_actual && (event.getState().getBlock() == Blocks.LEAVES || event.getState().getBlock() == Blocks.LEAVES2))
		{
			Random rand = new Random();
			double chance = rand.nextInt(100000) + rand.nextDouble();

			if( 1/chance <= MainConfig.rateDFDrops_actual )
			{
				ItemStack df = new ItemStack(Values.devilfruits.get(rand.nextInt(Values.devilfruits.size())));
				event.getPlayer().inventory.addItemStackToInventory(df);
			} 
		}*/
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{	
			EntityPlayer player = ((EntityPlayer)event.entityLiving);
			
			for(int i = 0; i < Values.abilities.size(); i++)
				WyHelper.removeStackFromInventory(player, new ItemStack(Values.abilities.get(i)));
			
			WyHelper.removeStackFromInventory(player, new ItemStack(ListMisc.CharacterCreator));

			/*player.inventory.deleteStack(new ItemStack(ListAbilities.SORU));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.TEKKAI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.GEPPO));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.SHIGAN));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.KAMIE));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.RANKYAKU));	
			
			player.inventory.deleteStack(new ItemStack(ListAbilities.UCHIMIZU));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.YARINAMI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.SAMEHADASHOTEI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.SOSHARK));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.MURASAME));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.KARAKUSAGAWARASEIKEN));	
			
			player.inventory.deleteStack(new ItemStack(ListAbilities.FRESHFIRE));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.MASTERNAIL));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.RADICALBEAM));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.COUPDEVENT));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.STRONGRIGHT));	
			
			player.inventory.deleteStack(new ItemStack(ListAbilities.BUSOSHOKUHAKI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.KENBUNSHOKUHAKI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.HAOSHOKUHAKI));*/
		}
	}
}
