package com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension;

import java.util.BitSet;
import java.util.List;
import java.util.ListIterator;

import com.deedllit.yggdrasil.world.dimensions.nifelheim.config.NifelheimGenSettings;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.carver.ConfiguredCarver;

//CTRL SHIFT + T for original setting
//EndChunkGenerator
//NetherChuckGenerator
//OverworldChuckGenerator

public class MuspelheimChunkGenerator extends NoiseChunkGenerator<MuspelheimGenSettings> {
	
    public static final int SURFACE_LEVEL = 50;

    public static final int MIN_CAVE_HEIGHT = 20;
    public static final int MAX_CAVE_HEIGHT = 40;

    public static final int SURFACE_CAVE_BOUNDARY = MAX_CAVE_HEIGHT + 12;

    public static final int SEA_LEVEL = SURFACE_LEVEL + 2;
	
	private static final float[] field_222576_h = Util.make(new float[25], (p_222575_0_) -> {
		for (int i = -2; i <= 2; ++i) {
			for (int j = -2; j <= 2; ++j) {
				float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 0.2F);
				p_222575_0_[i + 2 + (j + 2) * 5] = f;
			}
		}

	});
	private final OctavesNoiseGenerator depthNoise;
	private final boolean isAmplified;

	public MuspelheimChunkGenerator(IWorld worldIn, BiomeProvider provider, MuspelheimGenSettings settingsIn) {
		/*
		super(worldIn, provider, 4, 8, 256, settingsIn, true);
		this.randomSeed.skip(2620);
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 15, 0);
		this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
		*/
	}

	@SuppressWarnings("unused")
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = (double) 684.412F;
		double d1 = (double) 684.412F;
		double d2 = 8.555149841308594D;
		double d3 = 4.277574920654297D;
		int i = -10;
		int j = 3;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, (double) 684.412F, (double) 684.412F, 8.555149841308594D,
				4.277574920654297D, 3, -10);
	}

	@SuppressWarnings("unused")
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		double d0 = 8.5D;
		double d1 = ((double) p_222545_5_ - (8.5D + p_222545_1_ * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D
				/ p_222545_3_;
		if (d1 < 0.0D) {
			d1 *= 4.0D;
		}

		return d1;
	}

	@SuppressWarnings("unused")
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		double[] adouble = new double[2];
		float f = 0.0F;
		float f1 = 0.0F;
		float f2 = 0.0F;
		int i = 2;
		int j = this.getSeaLevel();
		float f3 = this.biomeProvider.getNoiseBiome(noiseX, j, noiseZ).getDepth();

		for (int k = -2; k <= 2; ++k) {
			for (int l = -2; l <= 2; ++l) {
				Biome biome = this.biomeProvider.getNoiseBiome(noiseX + k, j, noiseZ + l);
				float f4 = biome.getDepth();
				float f5 = biome.getScale();
				if (this.isAmplified && f4 > 0.0F) {
					f4 = 1.0F + f4 * 2.0F;
					f5 = 1.0F + f5 * 4.0F;
				}

				float f6 = field_222576_h[k + 2 + (l + 2) * 5] / (f4 + 2.0F);
				if (biome.getDepth() > f3) {
					f6 /= 2.0F;
				}

				f += f5 * f6;
				f1 += f4 * f6;
				f2 += f6;
			}
		}

		f = f / f2;
		f1 = f1 / f2;
		f = f * 0.9F + 0.1F;
		f1 = (f1 * 4.0F - 1.0F) / 8.0F;
		adouble[0] = (double) f1 + this.getNoiseDepthAt(noiseX, noiseZ);
		adouble[1] = (double) f;
		return adouble;
	}

	private double getNoiseDepthAt(int noiseX, int noiseZ) {
		double d0 = this.depthNoise.getValue((double) (noiseX * 200), 10.0D, (double) (noiseZ * 200), 1.0D, 0.0D, true)
				* 65535.0D / 8000.0D;
		if (d0 < 0.0D) {
			d0 = -d0 * 0.3D;
		}

		d0 = d0 * 3.0D - 2.0D;
		if (d0 < 0.0D) {
			d0 = d0 / 28.0D;
		} else {
			if (d0 > 1.0D) {
				d0 = 1.0D;
			}

			d0 = d0 / 40.0D;
		}

		return d0;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
		return super.getPossibleCreatures(creatureType, pos);
	}

	public int getGroundHeight() {
		return this.world.getSeaLevel() + 1;
	}

    public int getSeaLevel() {
        return SEA_LEVEL;
    }
}