package com.deedllit.yggdrasil.world.feature.tree;

import net.minecraft.block.BlockState;

public class YggdrasilWeirdTree extends YggdrasilTreeBase {

    public static class Builder extends BuilderBase<YggdrasilWeirdTree.Builder, YggdrasilWeirdTree>
    {    	
    	
        public Builder()
        {
        	this.minHeight = 5 ; 
        	this.maxHeight = 12 ; 
        }

        @Override
        public YggdrasilWeirdTree create() {
        	return new YggdrasilWeirdTree(this.log, this.leaves, this.minHeight, this.maxHeight) ; 
        }
        
      	
    }

	
    protected YggdrasilWeirdTree(BlockState log, BlockState leaves, int minHeight, int maxHeight) {
		super(log, leaves, minHeight, maxHeight);
	}

}
