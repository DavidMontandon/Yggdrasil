package com.davidmontandon.yggdrasil.world.muspelheim.dimension;


import net.minecraft.block.BlockState;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

public class MuspelheimDimension extends Dimension {
	
	public MuspelheimDimension(World world, DimensionType type) {		
		super(world, type, 0.0f);
		
		for (int i = 0; i <= 15; ++i) {
		    this.lightBrightnessTable[i] = i / 20.0F + 0.25F;
		}
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		
		return new MuspelheimChunkGenerator( world, new MuspelheimBiomeProvider(), new MuspelheimGenSettings() ) ;
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
	      for(int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
	          for(int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
	             BlockPos blockpos = this.findSpawn(i, j, checkValid);
	             if (blockpos != null) {
	                return blockpos;
	             }
	          }
	       }

	       return null;
	}
	
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
	      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(posX, 0, posZ);
	      Biome biome = this.world.getBiome(blockpos$mutable);
	      BlockState blockstate = biome.getSurfaceBuilderConfig().getTop();
	      if (checkValid && !blockstate.getBlock().isIn(BlockTags.VALID_SPAWN)) {
	         return null;
	      } else {
	         Chunk chunk = this.world.getChunk(posX >> 4, posZ >> 4);
	         int i = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, posX & 15, posZ & 15);
	         if (i < 0) {
	            return null;
	         } else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, posX & 15, posZ & 15) > chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, posX & 15, posZ & 15)) {
	            return null;
	         } else {
	            for(int j = i + 1; j >= 0; --j) {
	               blockpos$mutable.setPos(posX, j, posZ);
	               BlockState blockstate1 = this.world.getBlockState(blockpos$mutable);
	               if (!blockstate1.getFluidState().isEmpty()) {
	                  break;
	               }

	               if (blockstate1.equals(blockstate)) {
	                  return blockpos$mutable.up().toImmutable();
	               }
	            }

	            return null;
	         }
	      }
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		
      float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
      f = MathHelper.clamp(f, 0.0F, 1.0F);
      int color = 0;
      float f1 = ((color >> 16) & 0xFF) * 255;
      float f2 = ((color >> 8) & 0xFF) * 255;
      float f3 = ((color >> 0) & 0xFF) * 255;
      f1 = f1 * (f * 0.0F + 0.15F);
      f2 = f2 * (f * 0.0F + 0.15F);
      f3 = f3 * (f * 0.0F + 0.15F);
      return new Vec3d((double)f1, (double)f2, (double)f3);
		
	}

    @Override
    public boolean isNether() {
    	return false;
    }
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {		
		return true;
	}
	
	@Override
    public MusicTicker.MusicType getMusicType() {
    	return null;
    }
	
	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}
	
    @Override
    public boolean isSkyColored() {
    	return true;
    }
	
	@Override
	public boolean hasSkyLight() {
		return false;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}
    
	@Override
    public float getCloudHeight() {
		return -1;
    }
	
    @Override
    public boolean canDoLightning(Chunk chunk) {
    	return false;
    }


    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
    	return false;
    }
	
    
    
}
