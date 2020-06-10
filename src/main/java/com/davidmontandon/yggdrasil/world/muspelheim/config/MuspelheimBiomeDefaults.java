package com.davidmontandon.yggdrasil.world.muspelheim.config;

import javax.annotation.Nullable;

import com.davidmontandon.yggdrasil.world.biome.general.ConfigurableBiome;

import net.minecraft.world.biome.Biome;

public abstract class MuspelheimBiomeDefaults extends Biome implements ConfigurableBiome {

    private final float ridgeWeight;
    private final float densityScale;

    private final int grassColor;
    private final int foliageColor;
    private final int skyColor;

    private final float fogStart;
    private final float fogEnd;
    
	protected MuspelheimBiomeDefaults(Properties properties) {
		super(properties);
		
        this.ridgeWeight = properties.ridgeWeight;
        this.densityScale = properties.densityScale;

        this.grassColor = properties.grassColor;
        this.foliageColor = properties.foliageColor;
        this.skyColor = properties.skyColor;

        this.fogStart = properties.fogStart;
        this.fogEnd = properties.fogEnd;
	}
	
    @Override
    public int getGrassColor(double p_225528_1_, double p_225528_3_) {
        return grassColor;
    }
	
    @Override
    public int getFoliageColor() {
        return foliageColor;
    }

    public float getRidgeWeight() {
        return this.ridgeWeight;
    }

    public float getDensityScale() {
        return this.densityScale;
    }

    public int getSkyColor() {
        return this.skyColor;
    }

    public float getFogStart() {
        return this.fogStart;
    }

    public float getFogEnd() {
        return this.fogEnd;
    }

    public int getSkyColorByTemp(float temperature) {
        return this.skyColor;
    }
	
	public static class Properties extends Biome.Builder {
        private float ridgeWeight = 1.0F;
        private float densityScale = 1.0F;
        private int grassColor = 0x766B9E;
        private int foliageColor = 0x8F6DBC;
        private int skyColor = 0x171B32;

        private float fogStart = 20.0F;
        private float fogEnd = 140.0F;
		
        public Properties() {
	        super.precipitation(RainType.NONE);
	        super.downfall(0.0F);
	        super.temperature(2.0F);
	        super.waterColor(0x906B9F);
	        super.waterFogColor(0x6E5651);	
        }
      
        public Properties ridgeWeight(float ridgeWeight) {
            this.ridgeWeight = ridgeWeight;
            return this;
        }

        public Properties densityScale(float densityScale) {
            this.densityScale = densityScale;
            return this;
        }

        public Properties grassColor(int grassColor) {
            this.grassColor = grassColor;
            return this;
        }

        public Properties foliageColor(int foliageColor) {
            this.foliageColor = foliageColor;
            return this;
        }

        public Properties skyColor(int skyColor) {
            this.skyColor = skyColor;
            return this;
        }

        public Properties fog(float start, float end) {
            this.fogStart = start;
            this.fogEnd = end;
            return this;
        }

        @Override
        public Properties precipitation(RainType rainType) {
            super.precipitation(rainType);
            return this;
        }

        @Override
        public Properties category(Category category) {
            super.category(category);
            return this;
        }

        @Override
        public Properties depth(float depth) {
            super.depth(depth);
            return this;
        }

        @Override
        public Properties scale(float scale) {
            super.scale(scale);
            return this;
        }

        @Override
        public Properties temperature(float temperature) {
            super.temperature(temperature);
            return this;
        }

        @Override
        public Properties downfall(float downfall) {
            super.downfall(downfall);
            return this;
        }

        @Override
        public Properties waterColor(int waterColor) {
            super.waterColor(waterColor);
            return this;
        }

        @Override
        public Properties waterFogColor(int waterFogColor) {
            super.waterFogColor(waterFogColor);
            return this;
        }

        @Override
        public Properties parent(@Nullable String parent) {
            super.parent(parent);
            return this;
        }
        
	}
        
}
