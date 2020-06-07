package com.davidmontandon.yggdrasil.world.feature.structure;

import java.util.function.Function;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.feature.structure.piece.YggdrasilTreePieces;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class YggdrasilTreeStructure extends ScatteredStructure<NoFeatureConfig> { public YggdrasilTreeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	protected int getSeedModifier() {
		return 14357618;
	}
	
	@Override
	public IStartFactory getStartFactory() {
		return null;
	}
	
	@Override
	public String getStructureName() {
		return Yggdrasil.MOD_ID + ":treetest";
	}
	
	@Override
	public int getSize() {
		return 1;
	}

    @Override
    protected int getBiomeFeatureDistance(ChunkGenerator<?> generator) {
        return 16;
    }

    @Override
    protected int getBiomeFeatureSeparation(ChunkGenerator<?> generator) {
        return 8;
    }

    public static class Start extends StructureStart {


        public Start(Structure<?> p_i225876_1_, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox p_i225876_4_,
				int p_i225876_5_, long p_i225876_6_) {
			super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
		}

		@Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            int i = chunkX * 16;
            int j = chunkZ * 16;
            BlockPos blockpos = new BlockPos(i, 90, j);
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            YggdrasilTreePieces.addTowerPieces(templateManagerIn, blockpos, rotation, this.components);
            this.recalculateStructureSize();
        }


    }
    
}

