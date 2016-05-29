package MineMineNoMi3;

import java.util.Random;

import MineMineNoMi3.Lists.ListMisc;
import WyPI.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MainWorldGen implements IWorldGenerator 
{
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}	
	
	private void generateSurface(World world, Random random, int i, int j) 
	{
		this.addOreSpawn(ListMisc.KairosekiOre, world, random, i, j, 16, 16, 4 + random.nextInt(3), 30, 15, 50);	
				
		this.addStructureSpawn(WyPI.SchematicHelper.get("marineShip"), world, random, i, j, 32, 32, 5);
		this.addStructureSpawn(WyPI.SchematicHelper.get("pyrateShip"), world, random, i, j, 32, 32, 5);
	}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		int diffBtwnMinMaxY = maxY - minY;
		
		for(int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(posX, posY, posZ));
			if(block == ListMisc.KairosekiOre)
				if(biome.getBiomeName().equals("Ocean") || biome.getBiomeName().equals("Deep Ocean") || biome.getBiomeName().equals("Beach"))
					new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
			else
				new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	 
	private void addStructureSpawn(Schematic s, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int rarity)
	{
		//for(int x = 0; x < rarity; x++)
		//{
		if(world.rand.nextInt(100) <= rarity)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = random.nextInt(128);
			int posZ = blockZPos + random.nextInt(maxZ);			
			BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(posX, posY, posZ));
				
			if(s.getName().equals("marine_ship1"))
				if((biome.getBiomeName().equals("Ocean") || biome.getBiomeName().equals("Deep Ocean")) && checkForShipSpawn(s, world, posX, posY, posZ))
					s.build(new BlockPos(posX, posY, posZ), world);
				
		}	
	}

	
	private boolean checkForShipSpawn(Schematic s, World world, int posX, int posY, int posZ)
	{
		
		for(int i = 0; i < s.getWidth(); i++)
		for(int j = 0; j < s.getHeight(); j++)
		for(int k = 0; k < s.getLength(); k++)
		{
			if( world.getBlockState(new BlockPos(posX, posY, posZ).add(i, j, k)) == Blocks.AIR.getDefaultState() || world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.WATER.getDefaultState() || world.getBlockState(new BlockPos(posX + i, posY + j, posZ + k)) == Blocks.FLOWING_WATER.getDefaultState())
			{
				if( world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.WATER.getDefaultState() || world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.FLOWING_WATER.getDefaultState() )
				{
					if( world.getBlockState(new BlockPos(posX, posY + 1, posZ)) == Blocks.AIR.getDefaultState()) 
						return true;
					else return false;
				}
				else return false;
			}
		}		
		return false;
	}
		
}
