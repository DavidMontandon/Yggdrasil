package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

public enum MuspelheimAddIslandLayer implements IBishopTransformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int x, int southEast, int p_202792_4_, int p_202792_5_, int p_202792_6_) {
	      if (!MuspelheimLayerUtil.isShallowOcean(p_202792_6_) || MuspelheimLayerUtil.isShallowOcean(p_202792_5_) && MuspelheimLayerUtil.isShallowOcean(p_202792_4_) && MuspelheimLayerUtil.isShallowOcean(x) && MuspelheimLayerUtil.isShallowOcean(southEast)) {
	         if (!MuspelheimLayerUtil.isShallowOcean(p_202792_6_) && (MuspelheimLayerUtil.isShallowOcean(p_202792_5_) || MuspelheimLayerUtil.isShallowOcean(x) || MuspelheimLayerUtil.isShallowOcean(p_202792_4_) || MuspelheimLayerUtil.isShallowOcean(southEast)) && context.random(5) == 0) {
	            if (MuspelheimLayerUtil.isShallowOcean(p_202792_5_)) {
	               return p_202792_6_ == MuspelheimLayerUtil.FOREST ? MuspelheimLayerUtil.FOREST : p_202792_5_;
	            }

	            if (MuspelheimLayerUtil.isShallowOcean(x)) {
	               return p_202792_6_ == MuspelheimLayerUtil.FOREST ? MuspelheimLayerUtil.FOREST : x;
	            }

	            if (MuspelheimLayerUtil.isShallowOcean(p_202792_4_)) {
	               return p_202792_6_ == MuspelheimLayerUtil.FOREST ? MuspelheimLayerUtil.FOREST : p_202792_4_;
	            }

	            if (MuspelheimLayerUtil.isShallowOcean(southEast)) {
	               return p_202792_6_ == MuspelheimLayerUtil.FOREST ? MuspelheimLayerUtil.FOREST : southEast;
	            }
	         }

	         return p_202792_6_;
	      } else {
	         int i = 1;
	         int j = MuspelheimLayerUtil.PLAINS;
	         if (!MuspelheimLayerUtil.isShallowOcean(p_202792_5_) && context.random(i++) == 0) {
	            j = p_202792_5_;
	         }

	         if (!MuspelheimLayerUtil.isShallowOcean(p_202792_4_) && context.random(i++) == 0) {
	            j = p_202792_4_;
	         }

	         if (!MuspelheimLayerUtil.isShallowOcean(x) && context.random(i++) == 0) {
	            j = x;
	         }

	         if (!MuspelheimLayerUtil.isShallowOcean(southEast) && context.random(i++) == 0) {
	            j = southEast;
	         }

	         if (context.random(3) == 0) {
	            return j;
	         } else {
	            return j == MuspelheimLayerUtil.FOREST ? MuspelheimLayerUtil.FOREST : p_202792_6_;
	         }
	      }
	   }
	}
