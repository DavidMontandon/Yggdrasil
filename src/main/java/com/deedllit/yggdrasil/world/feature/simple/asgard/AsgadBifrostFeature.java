package com.deedllit.yggdrasil.world.feature.simple.asgard;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class AsgadBifrostFeature extends Feature<NoFeatureConfig> {
	   private static final BlockStateMatcher IS_GRASS = BlockStateMatcher.forBlock(Blocks.GRASS_BLOCK);
	   
	   private final BlockState base = Blocks.COBBLESTONE.getDefaultState();
	   private final BlockState portal = Blocks.GOLD_BLOCK.getDefaultState();

	   private final BlockState [] rainbow = {
			   Blocks.RED_TERRACOTTA.getDefaultState(),
			   Blocks.ORANGE_TERRACOTTA.getDefaultState(),
			   Blocks.YELLOW_TERRACOTTA.getDefaultState(),
			   Blocks.GREEN_TERRACOTTA.getDefaultState(),
			   Blocks.BLUE_TERRACOTTA.getDefaultState(),
			   Blocks.PURPLE_TERRACOTTA.getDefaultState(),
			   Blocks.PINK_TERRACOTTA.getDefaultState()
	   };

	   public AsgadBifrostFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49887_1_) {
	      super(p_i49887_1_);
	   }

	   	   
	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
	      for(pos = pos.up(); worldIn.isAirBlock(pos) && pos.getY() > 2; pos = pos.down()) {
	         ;
	      }

	      if (!IS_GRASS.test(worldIn.getBlockState(pos))) {
	         return false;
	      } else {
	    	  
	    	  int dir = rand.nextInt(4) ; 	    	  
	    	  
	    	  for(int x = 0 ; x <= 6 ; x++) {
		    	  for(int y = 0 ; y <= 6 ; y++) {
	                  worldIn.setBlockState(pos.add(x , 1 , y), this.base, 2);
		    	  }
	    	  }
	    	  
	    	  //rainbow steps (0 to 13) + base 3 
	    	  for(int x = 0 ; x <= 6 ; x++) {
		    	  for(int y = 0 ; y <= 16 ; y++) {
		    		  
		    		  
		    		  int l = Math.min(y/2, 6) ; 
		    		  
		    		  //south
		    		  worldIn.setBlockState(pos.add(x , 2 + l , 6+y), this.rainbow[6-x], 2);		    			  
		    		  
		    		  /*
		    		  switch(dir) {
		    		  case 0:
			    		  worldIn.setBlockState(pos.add(x , 2+y , 6), this.gold, 2);		    			  
			    		  break ;
		    		  case 1:
			    		  worldIn.setBlockState(pos.add(6 , 2+y , x), this.gold, 2);		    			  
			    		  break ;
		    		  case 2:
			    		  worldIn.setBlockState(pos.add(-x , 2+y , 6), this.gold, 2);		    			  
			    		  break ;
		    		  default:
			    		  worldIn.setBlockState(pos.add(6 , 2+y , -x), this.gold, 2);		    			  
			    		  break ;
			    		  
		    		  }
		    		  */
		    	  }
	    	  }
	    	  
    		 //portal
	    	  
	    	  //y = 2+7
	    	  //z = 14+6
	    	  
	    	  for(int x = 1 ; x <= 5 ; x++ ) {
		    	  for(int y = 0 ; y <= 6 ; y++) {
		    		  

		    		  if(y == 0 || y == 6 || x == 1 || x == 5) 
		    			  worldIn.setBlockState(pos.add(x , 9+y , 20), this.portal, 2);		    			  		    		  	
		    			  
		    		  
		    		  
		    		  
		    	  }
	    	  }
		    		  
	    	  
	    	  
	    	  /*
	         for(int i = -2; i <= 2; ++i) {
	            for(int j = -2; j <= 2; ++j) {
	               if (worldIn.isAirBlock(pos.add(i, -1, j)) && worldIn.isAirBlock(pos.add(i, -2, j))) {
	                  return false;
	               }
	            }
	         }

	         for(int l = -1; l <= 0; ++l) {
	            for(int l1 = -2; l1 <= 2; ++l1) {
	               for(int k = -2; k <= 2; ++k) {
	                  worldIn.setBlockState(pos.add(l1, l, k), this.sandstone, 2);
	               }
	            }
	         }

	         worldIn.setBlockState(pos, this.water, 2);

	         for(Direction direction : Direction.Plane.HORIZONTAL) {
	            worldIn.setBlockState(pos.offset(direction), this.water, 2);
	         }

	         for(int i1 = -2; i1 <= 2; ++i1) {
	            for(int i2 = -2; i2 <= 2; ++i2) {
	               if (i1 == -2 || i1 == 2 || i2 == -2 || i2 == 2) {
	                  worldIn.setBlockState(pos.add(i1, 1, i2), this.sandstone, 2);
	               }
	            }
	         }

	         worldIn.setBlockState(pos.add(2, 1, 0), this.sandSlab, 2);
	         worldIn.setBlockState(pos.add(-2, 1, 0), this.sandSlab, 2);
	         worldIn.setBlockState(pos.add(0, 1, 2), this.sandSlab, 2);
	         worldIn.setBlockState(pos.add(0, 1, -2), this.sandSlab, 2);

	         for(int j1 = -1; j1 <= 1; ++j1) {
	            for(int j2 = -1; j2 <= 1; ++j2) {
	               if (j1 == 0 && j2 == 0) {
	                  worldIn.setBlockState(pos.add(j1, 4, j2), this.sandstone, 2);
	               } else {
	                  worldIn.setBlockState(pos.add(j1, 4, j2), this.sandSlab, 2);
	               }
	            }
	         }

	         for(int k1 = 1; k1 <= 3; ++k1) {
	            worldIn.setBlockState(pos.add(-1, k1, -1), this.sandstone, 2);
	            worldIn.setBlockState(pos.add(-1, k1, 1), this.sandstone, 2);
	            worldIn.setBlockState(pos.add(1, k1, -1), this.sandstone, 2);
	            worldIn.setBlockState(pos.add(1, k1, 1), this.sandstone, 2);
	         }
			*/
	    	  
	         return true;
	      }
	   }
	}