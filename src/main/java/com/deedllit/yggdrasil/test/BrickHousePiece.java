package com.deedllit.yggdrasil.test;

import java.util.Random;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.StructurePiecesInit;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class BrickHousePiece {
	/*
	public static class Piece extends TemplateStructurePiece {
		
		public Piece(TemplateManager templateMgr, CompoundNBT nbt) {
			super(Yggdrasil.BRICK_HOUSE_PIECE, nbt);
			this.setupTemplate(templateMgr);
		}

		public Piece(TemplateManager templateMgr, ResourceLocation resLoc, BlockPos blockPos, Rotation rot, int offsetY) {
			super(Yggdrasil.BRICK_HOUSE_PIECE, 0);
			this.templatePosition = new BlockPos(blockPos.getX(), blockPos.getY() - offsetY, blockPos.getZ());
			this.setupTemplate(templateMgr);
		}

		private void setupTemplate(TemplateManager templateMgr) {
	         Template template = templateMgr.getTemplateDefaulted(Yggdrasil.HOUSE_LOC);
	         PlacementSettings placementsettings = (new PlacementSettings())
	        		 	.setRotation(Rotation.NONE)
	        		 	.setMirror(Mirror.NONE)
	        		 	.setCenterOffset(BlockPos.ZERO)
	        		 	.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
	         this.setup(template, this.templatePosition, placementsettings);
		}
			
		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn,
				MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn) {

			
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE).setCenterOffset(BlockPos.ZERO).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
			BlockPos blockpos1 = this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(3, 0, 0)));
			int strucHeight = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
			this.templatePosition = this.templatePosition.add(0, strucHeight, 0);
			
			return super.create(worldIn, chunkGeneratorIn, randomIn, mutableBoundingBoxIn, chunkPosIn);
		}
		

		
		
		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
			// empty, don't think I needed this for such a simple example? 
		}
	}
*/
}
