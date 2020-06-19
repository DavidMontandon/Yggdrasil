package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator;

import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension.MuspelheimChunkGenerator;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class MuspelheimCaveCarver extends CaveWorldCarver{
	private final float radiusScale;
	
	public MuspelheimCaveCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49929_1_, int p_i49929_2_) {
		super(p_i49929_1_, p_i49929_2_);
        this.radiusScale = 1.2f;
	}

    @Override
    protected int generateCaveStartY(Random random) {
        return random.nextInt(random.nextInt(MuspelheimChunkGenerator.SEA_LEVEL) + 8);
    }
	
    protected boolean func_225556_a_(IChunk chunk, Function<BlockPos, Biome> biomeFunc, BitSet carvingMask, Random rand, BlockPos.Mutable mutable, BlockPos.Mutable p_225556_6_, BlockPos.Mutable p_225556_7_, int p_225556_8_, int p_225556_9_, int p_225556_10_, int x, int z, int p_225556_13_, int y, int p_225556_15_, AtomicBoolean p_225556_16_) {
        int i = p_225556_13_ | p_225556_15_ << 4 | y << 8;
        if (carvingMask.get(i)) {
            return false;
        } else {
            carvingMask.set(i);
            mutable.setPos(x, y, z);
            boolean noAdjacentBlock = true;
            for (Direction dir : Direction.values()) {
                if (dir == Direction.DOWN) continue;
                mutable.move(dir);
                if (this.doesAdjacentBlockPreventCarving(chunk.getBlockState(mutable), mutable.getY() <= 10)) {
                    noAdjacentBlock = false;
                }
                mutable.move(dir, -1);
                if (!noAdjacentBlock) {
                    break;
                }
            }
            if (this.isCarvable(chunk.getBlockState(mutable)) && noAdjacentBlock) {
                BlockState blockstate;
                if (y <= 10) {
                    blockstate = BlockInit.MUSPELHEIM_ASH.get().getDefaultState();
                } else {
                    blockstate = CAVE_AIR;
                }

                chunk.setBlockState(mutable, blockstate, false);
                return true;
            } else {
                return false;
            }
        }
    }

    protected boolean doesAdjacentBlockPreventCarving(BlockState state, boolean miasmaHeight) {
        if (miasmaHeight && state.getBlock() == BlockInit.MUSPELHEIM_ASH.get()) return false;
        Material material = state.getMaterial();
        return material == Material.WATER || material == Material.LAVA || miasmaHeight && material == Material.AIR;
    }

    @Override
    protected boolean isCarvable(BlockState state) {
        if (state.getBlock() == Blocks.BEDROCK) return false;

        Material material = state.getMaterial();
        return (material == Material.ROCK || material == Material.EARTH || material == Material.ORGANIC)
                && material != Material.WATER && material != Material.LAVA;
    }

    @Override
    protected boolean canCarveBlock(BlockState state, BlockState aboveState) {
        if (state.getBlock() == Blocks.BEDROCK) return false;

        Material material = state.getMaterial();
        Material aboveMaterial = aboveState.getMaterial();
        return (material == Material.ROCK || material == Material.EARTH || material == Material.ORGANIC)
                && material != Material.WATER && material != Material.LAVA
                && aboveMaterial != Material.WATER && aboveMaterial != Material.LAVA;
    }

    @Override
    protected float generateCaveRadius(Random random) {
        return super.generateCaveRadius(random) * this.radiusScale;
    }

    
}
