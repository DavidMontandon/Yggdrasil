package com.davidmontandon.yggdrasil.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.davidmontandon.yggdrasil.util.noise.OpenSimplexNoise;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class TestDig extends Feature<NoFeatureConfig> {

	protected long seed;
	private static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
	protected static OpenSimplexNoise noiseGen;
	protected static OpenSimplexNoise noiseGen2;

	
	public void setSeed(long seed)
	{
		if (this.seed != seed)
		{
			this.seed = seed;
		}
	}
	
	public TestDig(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos);

		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				for(int y = 15; y < 241; y++) {
					mutableBlockPos.setPos(pos).move(x, y, z);

					
					double noise1 = noiseGen.eval(mutableBlockPos.getX() * 0.02D, 
							mutableBlockPos.getZ() * 0.02D, 
							mutableBlockPos.getY() * 0.04D);

					double noise2 = noiseGen2.eval(mutableBlockPos.getX() * 0.02D, 
												mutableBlockPos.getZ() * 0.02D, 
												mutableBlockPos.getY() * 0.04D);
					
					double finalNoise = noise1 * noise1 + noise2 * noise2;
					
					if(finalNoise < 0.0009f) {
						//carveAtBlock( worldIn , mutableBlockPos )  ;
						//dig(worldIn, mutableBlockPos);
					}
				}
			}
		}
		
		return false ;
	}
	
	private static void dig(IWorld world, BlockPos position) {
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(position);
		BlockState blockState;

		for(int x = 0; x < 14; x++) {
			for(int z = 0; z < 11; z++) {

				blockState = world.getBlockState(mutableBlockPos.setPos(position).move(x, 0, z));
				carveAtBlock(world, mutableBlockPos);
				
			}
		}
		
	}
	
	private static void carveAtBlock(IWorld world, BlockPos blockPos) {
		world.setBlockState(blockPos, CAVE_AIR, 3);
	}
	

}
