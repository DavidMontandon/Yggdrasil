package com.deedllit.yggdrasil.world.feature.tree;

import net.minecraft.block.BlockState;

public class YggdrasilBigTree extends YggdrasilTreeBase {

    public static class Builder extends BuilderBase<YggdrasilBigTree.Builder, YggdrasilBigTree>
    {    	
    	
        public Builder()
        {
        	this.minHeight = 5 ; 
        	this.maxHeight = 12 ; 
        }

        @Override
        public YggdrasilBigTree create() {
        	return new YggdrasilBigTree(this.log, this.leaves, this.minHeight, this.maxHeight) ; 
        }
        
      	
    }

	
    protected YggdrasilBigTree(BlockState log, BlockState leaves, int minHeight, int maxHeight) {
		super(log, leaves, minHeight, maxHeight);
	}

}
