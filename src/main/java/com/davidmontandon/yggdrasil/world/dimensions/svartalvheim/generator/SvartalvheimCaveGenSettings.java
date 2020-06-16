package com.davidmontandon.yggdrasil.world.dimensions.svartalvheim.generator;

import net.minecraft.world.gen.GenerationSettings;

public class SvartalvheimCaveGenSettings extends GenerationSettings {
   public int getBedrockFloorHeight() {
      return 0;
   }

   public int getBedrockRoofHeight() {
      return 255; //127
   }
}