package com.davidmontandon.yggdrasil.world.dimensions.muspelheim.generator;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MuspelheimVolcanoTopLayerSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public MuspelheimVolcanoTopLayerSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
        this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, Blocks.LAVA.getDefaultState(), 
        		config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
		
	}

	private void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState under,
			BlockState underWaterMaterial, int seaLevel) {

        BlockState blockstate = top;
        BlockState blockstate1 = under;
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        int i = -1;
        int j = (int)(noise / 3.0D + 8.0D + random.nextDouble() * 0.25D);
        int k = x & 15;
        int l = z & 15;

        for(int i1 = startHeight; i1 >= 0; --i1) {
            blockpos$mutableblockpos.setPos(k, i1, l);
            BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutableblockpos);
            if (blockstate2.isAir()) {
                i = -1;
            } else if (blockstate2.getBlock() == defaultBlock.getBlock()) {
                if (i == -1) {
                    if (j <= 0) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                    } else if (i1 >= seaLevel - 4 && i1 <= seaLevel + 1) {
                        blockstate = top;
                        blockstate1 = under;
                    }

                    if (i1 < seaLevel && (blockstate == null || blockstate.isAir())) {
                        if (biomeIn.getTemperature(blockpos$mutableblockpos.setPos(x, i1, z)) < 0.15F) {
                            blockstate = Blocks.ICE.getDefaultState();
                        } else {
                            blockstate = defaultFluid;
                        }

                        blockpos$mutableblockpos.setPos(k, i1, l);
                    }

                    i = j;
                    if (i1 >= seaLevel - 1) {
                        chunkIn.setBlockState(blockpos$mutableblockpos, blockstate, false);
                    } else if (i1 < seaLevel - 7 - j) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                        chunkIn.setBlockState(blockpos$mutableblockpos, under, false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutableblockpos, blockstate1, false);
                    }
                } else if (i > 0) {
                    --i;
                    chunkIn.setBlockState(blockpos$mutableblockpos, blockstate1, false);
                    if (i == 0 && blockstate1.getBlock() == Blocks.SAND && j > 1) {
                        i = random.nextInt(4) + Math.max(0, i1 - 63);
                        blockstate1 = blockstate1.getBlock() == Blocks.RED_SAND ? Blocks.RED_SANDSTONE.getDefaultState() : Blocks.SANDSTONE.getDefaultState();
                    }
                }
            }
        }		
		
	}

}
