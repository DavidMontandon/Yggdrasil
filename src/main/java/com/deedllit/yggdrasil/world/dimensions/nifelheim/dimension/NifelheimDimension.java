package com.deedllit.yggdrasil.world.dimensions.nifelheim.dimension;

import com.deedllit.yggdrasil.common.biome.BiomeLayers;
import com.deedllit.yggdrasil.common.biome.cavern.CavernousBiome;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.generator.NifelheimBiomeLayerType;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IRenderHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class NifelheimDimension extends Dimension {
    public NifelheimDimension(World world, DimensionType type) {
        super(world, type, 0.0F);

        float baseLight = 0.06F;
        for (int i = 0; i <= 15; ++i) {
            float alpha = 1.0F - i / 15.0F;
            float brightness = (1.0F - alpha) / (alpha * 10.0F + 1.0F);
            this.lightBrightnessTable[i] = (float) (Math.pow(brightness, 2.5F) * 3.0F) + baseLight;
        }
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        long seed = this.world.getSeed();

        BiomeLayers<Biome> surfaceLayers = NifelheimBiomeLayerType.SURFACE.make(seed);
        BiomeLayers<CavernousBiome> undergroundLayers = NifelheimBiomeLayerType.UNDERGROUND.make(seed);

        return null ; 
        //return new YggdrasilChuckGenerator(this.world, surfaceLayers, undergroundLayers, YggdrasilChuckGenerator.Config.createDefault());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunk, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }

    @Override
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        return SleepResult.BED_EXPLODES;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
        return true;
    }


    @Override
    public float getLightBrightness(int p_227174_1_) {
        return super.getLightBrightness(p_227174_1_);
    }

    @Override
    public void getLightmapColors(float partialTicks, float sunBrightness, float skyLight, float blockLight, Vector3f colors) {

    	//TODO
    	
    }

    @Override
    public boolean isDaytime() {
        return false;
    }

    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return null;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
    	//todo
    	return null ;
    }

    public Vec3d getSkyColor(BlockPos cameraPos, float partialTicks) {

    	//todo
    	return null ;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.5F;
    }

    @Override
    public void calculateInitialWeather() {
    }

    @Override
    public void updateWeather(Runnable defaultLogic) {
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
    	return false ; 
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public double getVoidFogYFactor() {
        return 1.0;
    }

    @Nullable
    @Override
    public IRenderHandler getSkyRenderer() {
    	return null ;
    }
}
