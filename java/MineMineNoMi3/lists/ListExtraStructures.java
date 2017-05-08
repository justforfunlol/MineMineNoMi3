package MineMineNoMi3.lists;

import MineMineNoMi3.items.BellyPouch;
import WyPI.modules.WyMathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ListExtraStructures
{
	
	public static void buildLargeShip(int posX, int posY, int posZ, World world, String faction)
	{
		String toSpawn1;
		String toSpawn2;
		String toSpawnCpt;
		int x1 = 0, x2 = 0, x3 = 0;
		
		Item swordToSpawn;
		if(faction.equals("marineLargeShip"))
		{
			toSpawn1 = ID.PROJECT_ID+".Marine";
			toSpawn2 = ID.PROJECT_ID+".Marine with Gun";
			toSpawnCpt = ID.PROJECT_ID+".Marine";
			swordToSpawn = ListMisc.MarineSword;
			x1 = 13;
			x2 = 6;
			x3 = 10;
		}
		else
		{
			toSpawn1 = ID.PROJECT_ID+".Pirate";
			toSpawn2 = ID.PROJECT_ID+".Pirate with Gun";	
			toSpawnCpt = ID.PROJECT_ID+".Pirate Captain";
			swordToSpawn = ListMisc.PirateCutlass;
			x1 = 16;
			x2 = 9;
			x3 = 13;
		}
		
		world.setBlockState(new BlockPos(posX + 10, posY + 2, posZ + 27), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(5).getDefaultState() );
		world.setBlockState(new BlockPos(posX + 14, posY + 2, posZ + 32), ListMisc.CustomSpawner.setSpawnerMob(toSpawn2).setSpawnerLimit(5).getDefaultState() );
		
		world.setBlockState(new BlockPos(posX + 12, posY + 8, posZ + 17), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(5).getDefaultState() );
		world.setBlockState(new BlockPos(posX + 12, posY + 8, posZ + 11), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(5).getDefaultState() );

		world.setBlockState(new BlockPos(posX + 14, posY + 8, posZ + 42), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(5).getDefaultState() );
		world.setBlockState(new BlockPos(posX + 8, posY + 8, posZ + 42), ListMisc.CustomSpawner.setSpawnerMob(toSpawnCpt).setSpawnerLimit(1).getDefaultState() );
		
		TileEntityChest chest1 = new TileEntityChest();
		world.setTileEntity(new BlockPos(posX + x1, posY + 2, posZ + 39), chest1);
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 100)
		{ 
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Bullets, (int) WyMathHelper.instance().randomWithRange(5, 10), 0));	
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Bullets, (int) WyMathHelper.instance().randomWithRange(1, 5), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 45)
		{
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(swordToSpawn, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));	
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Flintlock, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));	
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 20)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.KairosekiBullets, (int) WyMathHelper.instance().randomWithRange(1, 5), 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 60)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BOAT, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 5)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Box1, 1, 0));
		
		TileEntityChest chest2 = new TileEntityChest();
		world.setTileEntity(new BlockPos(posX + x2, posY + 2, posZ + 39), chest2);
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 100)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BREAD, (int) WyMathHelper.instance().randomWithRange(1, 3), 0));	
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BREAD, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 55)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BAKED_POTATO, (int) WyMathHelper.instance().randomWithRange(0, 5), 0));	
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.APPLE, (int) WyMathHelper.instance().randomWithRange(0, 2), 0));	
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 20)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Cola, (int) WyMathHelper.instance().randomWithRange(0, 3), 0));	
			if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
				chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.COOKED_PORKCHOP, (int) WyMathHelper.instance().randomWithRange(1, 2), 0));	
			else
				chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.COOKED_RABBIT, (int) WyMathHelper.instance().randomWithRange(1, 2), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 10)
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Cola, (int) WyMathHelper.instance().randomWithRange(0, 5), 0));	
		
		TileEntityChest chest3 = new TileEntityChest();
		world.setTileEntity(new BlockPos(posX + x3, posY + 2, posZ + 42), chest3);
		
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 75)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 35)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 25)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BlackMetal, (int) WyMathHelper.instance().randomWithRange(1, 2), 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 70)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.KairosekiBullets, (int) WyMathHelper.instance().randomWithRange(5, 10), 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BOAT, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 10)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Box1, 1, 0));
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 10)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.UltraCola, 1, 0));
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 5)
			chest3.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Box3, 1, 0));

	}
	
	public static void buildSmallShip(int posX, int posY, int posZ, World world, String faction)
	{
		String toSpawn1;
		String toSpawn2;
		Item swordToSpawn;
		if(faction.equals("marineShip"))
		{
			toSpawn1 = ID.PROJECT_ID+".Marine";
			toSpawn2 = ID.PROJECT_ID+".Marine with Gun";
			swordToSpawn = ListMisc.MarineSword;
		}
		else
		{
			toSpawn1 = ID.PROJECT_ID+".Pirate";
			toSpawn2 = ID.PROJECT_ID+".Pirate with Gun";	
			swordToSpawn = ListMisc.PirateCutlass;
		}
		
		world.setBlockState(new BlockPos(posX + 10, posY + 2, posZ + 32), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(5).getDefaultState());
		world.setBlockState(new BlockPos(posX + 10, posY + 2, posZ + 43), ListMisc.CustomSpawner.setSpawnerMob(toSpawn2).setSpawnerLimit(5).getDefaultState());
		world.setBlockState(new BlockPos(posX + 10, posY + 7, posZ + 45), ListMisc.CustomSpawner.setSpawnerMob(toSpawn1).setSpawnerLimit(2).getDefaultState());

		world.setBlockState(new BlockPos(posX + 12, posY + 2, posZ + 32), Blocks.TORCH.getDefaultState());
		world.setBlockState(new BlockPos(posX + 12, posY + 2, posZ + 38), Blocks.TORCH.getDefaultState());
		world.setBlockState(new BlockPos(posX + 12, posY + 2, posZ + 43), Blocks.TORCH.getDefaultState());
		
		TileEntityChest chest1 = new TileEntityChest();
		world.setTileEntity(new BlockPos(posX + 11, posY + 2, posZ + 25), chest1);
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 100)
		{
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Bullets, (int) WyMathHelper.instance().randomWithRange(5, 10), 0));	
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Bullets, (int) WyMathHelper.instance().randomWithRange(1, 5), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 45)
		{
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(swordToSpawn, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));	
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Flintlock, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));	
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 45)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 15)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.BellyPouch, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.KairosekiBullets, (int) WyMathHelper.instance().randomWithRange(1, 5), 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BOAT, 1, 0));	
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 5)
			chest1.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Box1, 1, 0));
	
		TileEntityChest chest2 = new TileEntityChest();
		world.setTileEntity(new BlockPos(posX + 8, posY + 2, posZ + 25), chest2);
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 100)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BREAD, (int) WyMathHelper.instance().randomWithRange(1, 3), 0));	
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BREAD, (int) WyMathHelper.instance().randomWithRange(0, 1), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 45)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.BAKED_POTATO, (int) WyMathHelper.instance().randomWithRange(0, 5), 0));	
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.APPLE, (int) WyMathHelper.instance().randomWithRange(0, 2), 0));	
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 10)
		{
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Cola, (int) WyMathHelper.instance().randomWithRange(0, 3), 0));	
			if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
				chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.COOKED_PORKCHOP, (int) WyMathHelper.instance().randomWithRange(0, 2), 0));	
			else
				chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(Items.COOKED_RABBIT, (int) WyMathHelper.instance().randomWithRange(0, 2), 0));
		}
		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 10)
			chest2.setInventorySlotContents((int) WyMathHelper.instance().randomWithRange(0, 26), new ItemStack(ListMisc.Cola, (int) WyMathHelper.instance().randomWithRange(0, 5), 0));	
		
		world.setBlockState(new BlockPos(posX + 11, posY + 2, posZ + 24), Blocks.AIR.getDefaultState());
		world.setBlockState(new BlockPos(posX + 8, posY + 2, posZ + 24), Blocks.AIR.getDefaultState());
		
		world.setBlockState(new BlockPos(posX + 11, posY + 2, posZ + 22), Blocks.AIR.getDefaultState());
		world.setBlockState(new BlockPos(posX + 8, posY + 2, posZ + 22), Blocks.AIR.getDefaultState());
		world.setBlockState(new BlockPos(posX + 11, posY + 2, posZ + 21), Blocks.AIR.getDefaultState());
		world.setBlockState(new BlockPos(posX + 8, posY + 2, posZ + 21), Blocks.AIR.getDefaultState());
		
	}


}
