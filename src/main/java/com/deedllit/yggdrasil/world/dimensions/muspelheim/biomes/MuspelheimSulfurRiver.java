package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public class MuspelheimSulfurRiver extends Biome {

	public MuspelheimSulfurRiver() {
		super(new Biome.Builder()		
				.precipitation(RainType.NONE)
				.waterColor(0x906B9F)
				.waterFogColor(0x6E5651)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_ASH_SULFUR_GRAVEL)
				.category(Category.RIVER)
				.downfall(0.0f)
				.scale(0.1f)
				.temperature(2.0f)
				.depth(-1.0f)
				.parent(null)) ;
		
		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);
		MuspelheimDefaultBiomeFeatures.addSedimentDisks(this);
	}

	@Override
	public Biome getRiver() {
		return ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_sulfur_river")) ; 
	}

	
}
